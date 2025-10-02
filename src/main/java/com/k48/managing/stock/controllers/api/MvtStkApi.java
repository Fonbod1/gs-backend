package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.MvtStkDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.k48.managing.stock.controllers.api.ArticleApi.APP_ROOT;

@Tag(name = "Mouvements de Stock", description = "Gestion des mouvements de stock (entrée, sortie, correction)")
public interface MvtStkApi {

    @GetMapping(APP_ROOT + "/mvtstk/stockreel/{idArticle}")
    @Operation(summary = "Consulter le stock réel d’un article")
    @ApiResponse(responseCode = "200", description = "Quantité de stock retournée avec succès")
    BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(APP_ROOT + "/mvtstk/filter/article/{idArticle}")
    @Operation(summary = "Lister les mouvements de stock d’un article")
    @ApiResponse(responseCode = "200", description = "Liste des mouvements de stock retournée avec succès")
    List<MvtStkDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

    @PostMapping(APP_ROOT + "/mvtstk/entree")
    @Operation(summary = "Enregistrer une entrée de stock")
    @ApiResponse(responseCode = "200", description = "Entrée de stock enregistrée")
    MvtStkDto entreeStock(@RequestBody MvtStkDto dto);

    @PostMapping(APP_ROOT + "/mvtstk/sortie")
    @Operation(summary = "Enregistrer une sortie de stock")
    @ApiResponse(responseCode = "200", description = "Sortie de stock enregistrée")
    MvtStkDto sortieStock(@RequestBody MvtStkDto dto);

    @PostMapping(APP_ROOT + "/mvtstk/correctionpos")
    @Operation(summary = "Enregistrer une correction de stock positive")
    @ApiResponse(responseCode = "200", description = "Correction positive enregistrée")
    MvtStkDto correctionStockPos(@RequestBody MvtStkDto dto);

    @PostMapping(APP_ROOT + "/mvtstk/correctionneg")
    @Operation(summary = "Enregistrer une correction de stock négative")
    @ApiResponse(responseCode = "200", description = "Correction négative enregistrée")
    MvtStkDto correctionStockNeg(@RequestBody MvtStkDto dto);
}
