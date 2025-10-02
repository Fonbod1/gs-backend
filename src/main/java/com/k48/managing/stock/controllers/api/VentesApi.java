package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.VentesDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.k48.managing.stock.utils.Constants.VENTES_ENDPOINT;

@Tag(name = "Ventes", description = "Gestion des ventes")
public interface VentesApi {

    @PostMapping(VENTES_ENDPOINT + "/create")
    @Operation(summary = "Créer ou modifier une vente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vente créée/modifiée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données de vente invalides")
    })
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping(VENTES_ENDPOINT + "/{idVente}")
    @Operation(summary = "Rechercher une vente par ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vente trouvée"),
            @ApiResponse(responseCode = "404", description = "Vente non trouvée avec cet ID")
    })
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(VENTES_ENDPOINT + "/{codeVente}")
    @Operation(summary = "Rechercher une vente par code")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vente trouvée"),
            @ApiResponse(responseCode = "404", description = "Vente non trouvée avec ce code")
    })
    VentesDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(VENTES_ENDPOINT + "/all")
    @Operation(summary = "Lister toutes les ventes")
    @ApiResponse(responseCode = "200", description = "Liste des ventes retournée")
    List<VentesDto> findAll();

    @DeleteMapping(VENTES_ENDPOINT + "/delete/{idVente}")
    @Operation(summary = "Supprimer une vente par ID")
    @ApiResponse(responseCode = "200", description = "Vente supprimée avec succès")
    void delete(@PathVariable("idVente") Integer id);
}
