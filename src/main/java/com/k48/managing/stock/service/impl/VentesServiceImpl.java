package com.k48.managing.stock.service.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.k48.managing.stock.dto.ArticleDto;
import com.k48.managing.stock.dto.LigneVenteDto;
import com.k48.managing.stock.dto.MvtStkDto;
import com.k48.managing.stock.dto.VentesDto;
import com.k48.managing.stock.exceptions.EntityNotFoundException;
import com.k48.managing.stock.exceptions.ErrorCodes;
import com.k48.managing.stock.exceptions.InvalidEntityException;
import com.k48.managing.stock.exceptions.InvalidOperationException;
import com.k48.managing.stock.model.*;
import com.k48.managing.stock.repository.ArticleRepository;
import com.k48.managing.stock.repository.LigneVenteRepository;
import com.k48.managing.stock.repository.VentesRepository;
import com.k48.managing.stock.service.MvtStkService;
import com.k48.managing.stock.service.VentesService;
import com.k48.managing.stock.validators.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

    private final ArticleRepository articleRepository;
    private final VentesRepository ventesRepository;
    private final LigneVenteRepository ligneVenteRepository;
    private final MvtStkService mvtStkService;

    @Autowired
    public VentesServiceImpl(ArticleRepository articleRepository, VentesRepository ventesRepository,
                             LigneVenteRepository ligneVenteRepository, MvtStkService mvtStkService) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.mvtStkService = mvtStkService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        // Validate vente DTO
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide: {}", errors);
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        // Ensure ligneVentes exists
        if (dto.getLigneVentes() == null || dto.getLigneVentes().isEmpty()) {
            log.error("La vente doit contenir au moins une ligne de vente");
            throw new InvalidEntityException(
                    "La vente doit contenir au moins une ligne de vente",
                    ErrorCodes.VENTE_NOT_VALID
            );
        }

        // Validate articles exist
        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVentes().forEach(ligne -> {
            if (ligne.getArticle() == null || ligne.getArticle().getId() == null) {
                articleErrors.add("Article manquant dans une ligne de vente");
            } else {
                Optional<Article> article = articleRepository.findById(ligne.getArticle().getId());
                if (article.isEmpty()) {
                    articleErrors.add("Aucun article avec l'ID " + ligne.getArticle().getId() + " trouvé dans la BDD");
                }
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("Un ou plusieurs articles n'ont pas été trouvés: {}", articleErrors);
            throw new InvalidEntityException(
                    "Un ou plusieurs articles n'ont pas été trouvés dans la BDD",
                    ErrorCodes.VENTE_NOT_VALID,
                    articleErrors
            );
        }

        // Save vente
        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        // Save lignes de vente and update stock
        dto.getLigneVentes().forEach(ligneDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneDto);
            ligneVente.setVente(savedVentes);

            // Ensure article and idEntreprise are set
            ligneVente.setArticle(articleRepository.findById(ligneDto.getArticle().getId()).orElse(null));
            ligneVente.setIdEntreprise(savedVentes.getIdEntreprise());

            ligneVenteRepository.save(ligneVente);
            updateMvtStk(ligneVente);
        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune vente n'a été trouvée dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a été trouvée avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVenteId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une vente ...",
                    ErrorCodes.VENTE_ALREADY_IN_USE);
        }
        ventesRepository.deleteById(id);
    }

    private void updateMvtStk(LigneVente lig) {
        if (lig == null || lig.getArticle() == null || lig.getIdEntreprise() == null) {
            log.warn("Impossible de mettre à jour le stock: LigneVente ou Article ou IdEntreprise est null");
            return;
        }
        MvtStkDto mvtStkDto = MvtStkDto.builder()
                .article(ArticleDto.fromEntity(lig.getArticle()))
                .dateMvt(Instant.now())
                .typeMvt(TypeMvtStk.SORTIE)
                .sourceMvt(SourceMvtStk.VENTE)
                .quantite(lig.getQuantite())
                .idEntreprise(lig.getIdEntreprise())
                .build();
        mvtStkService.sortieStock(mvtStkDto);
    }
}




/*
package com.k48.managing.stock.service.impl;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.k48.managing.stock.dto.ArticleDto;
import com.k48.managing.stock.dto.LigneVenteDto;
import com.k48.managing.stock.dto.MvtStkDto;
import com.k48.managing.stock.dto.VentesDto;
import com.k48.managing.stock.exceptions.EntityNotFoundException;
import com.k48.managing.stock.exceptions.ErrorCodes;
import com.k48.managing.stock.exceptions.InvalidEntityException;
import com.k48.managing.stock.exceptions.InvalidOperationException;
import com.k48.managing.stock.model.*;
import com.k48.managing.stock.repository.ArticleRepository;
import com.k48.managing.stock.repository.LigneVenteRepository;
import com.k48.managing.stock.repository.VentesRepository;
import com.k48.managing.stock.service.MvtStkService;
import com.k48.managing.stock.service.VentesService;
import com.k48.managing.stock.validators.VentesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

    private ArticleRepository articleRepository;
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private MvtStkService mvtStkService;

    @Autowired
    public VentesServiceImpl(ArticleRepository articleRepository, VentesRepository ventesRepository,
                             LigneVenteRepository ligneVenteRepository, MvtStkService mvtStkService) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.mvtStkService = mvtStkService;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        List<String> errors = VentesValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Ventes n'est pas valide");
            throw new InvalidEntityException("L'objet vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'ID " + ligneVenteDto.getArticle().getId() + " n'a ete trouve dans la BDD");
            }
        });

        if (!articleErrors.isEmpty()) {
            log.error("One or more articles were not found in the DB, {}", errors);
            throw new InvalidEntityException("Un ou plusieurs articles n'ont pas ete trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVentes);
            ligneVenteRepository.save(ligneVente);
            updateMvtStk(ligneVente);
        });

        return VentesDto.fromEntity(savedVentes);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            log.error("Ventes ID is NULL");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun vente n'a ete trouve dans la BDD", ErrorCodes.VENTE_NOT_FOUND));
    }

    @Override
    public VentesDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente CODE is NULL");
            return null;
        }
        return ventesRepository.findVentesByCode(code)
                .map(VentesDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune vente client n'a ete trouve avec le CODE " + code, ErrorCodes.VENTE_NOT_VALID
                ));
    }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll().stream()
                .map(VentesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente ID is NULL");
            return;
        }
        List<LigneVente> ligneVentes = ligneVenteRepository.findAllByVenteId(id);
        if (!ligneVentes.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer une vente ...",
                    ErrorCodes.VENTE_ALREADY_IN_USE);
        }
        ventesRepository.deleteById(id);
    }

    private void updateMvtStk(LigneVente lig) {
        MvtStkDto mvtStkDto = MvtStkDto.builder()
                .article(ArticleDto.fromEntity(lig.getArticle()))
                .dateMvt(Instant.now())
                .typeMvt(TypeMvtStk.SORTIE)
                .sourceMvt(SourceMvtStk.VENTE)
                .quantite(lig.getQuantite())
                .idEntreprise(lig.getIdEntreprise())
                .build();
        mvtStkService.sortieStock(mvtStkDto);
    }
} */