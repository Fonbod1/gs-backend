package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.EntrepriseApi;
import com.k48.managing.stock.dto.EntrepriseDto;
import com.k48.managing.stock.service.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
public class EntrepriseController implements EntrepriseApi {

    private final EntrepriseService entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
   // @PreAuthorize("hasRole('ADMIN')")
    public EntrepriseDto save(@Valid @RequestBody EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
