package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.FournisseurApi;
import com.k48.managing.stock.dto.FournisseurDto;
import com.k48.managing.stock.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public FournisseurDto save(@RequestBody  FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
