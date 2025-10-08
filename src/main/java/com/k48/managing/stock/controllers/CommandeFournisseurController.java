package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.CommandeFournisseurApi;
import com.k48.managing.stock.dto.CommandeFournisseurDto;
import com.k48.managing.stock.dto.LigneCommandeFournisseurDto;
import com.k48.managing.stock.model.EtatCommande;
import com.k48.managing.stock.service.CommandeFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private final CommandeFournisseurService commandeFournisseurService;

    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto) {
        return commandeFournisseurService.save(dto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CommandeFournisseurDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
        return commandeFournisseurService.updateEtatCommande(idCommande, etatCommande);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CommandeFournisseurDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
        return commandeFournisseurService.updateQuantiteCommande(idCommande, idLigneCommande, quantite);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CommandeFournisseurDto updateFournisseur(Integer idCommande, Integer idFournisseur) {
        return commandeFournisseurService.updateFournisseur(idCommande, idFournisseur);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CommandeFournisseurDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
        return commandeFournisseurService.updateArticle(idCommande, idLigneCommande, idArticle);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CommandeFournisseurDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
        return commandeFournisseurService.deleteArticle(idCommande, idLigneCommande);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CommandeFournisseurDto findById(Integer id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurService.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(Integer idCommande) {
        return commandeFournisseurService.findAllLignesCommandesFournisseurByCommandeFournisseurId(idCommande);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        commandeFournisseurService.delete(id);
    }
}
