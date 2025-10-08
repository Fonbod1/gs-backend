package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.UtilisateurApi;
import com.k48.managing.stock.dto.ChangerMotDePasseUtilisateurDto;
import com.k48.managing.stock.dto.UtilisateurDto;
import com.k48.managing.stock.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public UtilisateurDto save(@RequestBody UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto) {
        return utilisateurService.changerMotDePasse(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
