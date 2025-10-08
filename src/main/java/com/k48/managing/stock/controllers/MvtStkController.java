package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.MvtStkApi;
import com.k48.managing.stock.dto.MvtStkDto;
import com.k48.managing.stock.service.MvtStkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MvtStkController implements MvtStkApi {

    private final MvtStkService service;

    @Autowired
    public MvtStkController(MvtStkService service) {
        this.service = service;
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public BigDecimal stockReelArticle(Integer idArticle) {
        return service.stockReelArticle(idArticle);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<MvtStkDto> mvtStkArticle(Integer idArticle) {
        return service.mvtStkArticle(idArticle);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MvtStkDto entreeStock(MvtStkDto dto) {
        return service.entreeStock(dto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MvtStkDto sortieStock(MvtStkDto dto) {
        return service.sortieStock(dto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MvtStkDto correctionStockPos(MvtStkDto dto) {
        return service.correctionStockPos(dto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public MvtStkDto correctionStockNeg(MvtStkDto dto) {
        return service.correctionStockNeg(dto);
    }
}
