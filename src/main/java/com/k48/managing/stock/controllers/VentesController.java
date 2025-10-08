package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.VentesApi;
import com.k48.managing.stock.dto.VentesDto;
import com.k48.managing.stock.service.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VentesController implements VentesApi {

    private final VentesService ventesService;

    @Autowired
    public VentesController(VentesService ventesService) {
        this.ventesService = ventesService;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public VentesDto save(@RequestBody VentesDto dto) {
        return ventesService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public VentesDto findById(Integer id) {
        return ventesService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public VentesDto findByCode(String code) {
        return ventesService.findByCode(code);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<VentesDto> findAll() {
        return ventesService.findAll();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        ventesService.delete(id);
    }
}
