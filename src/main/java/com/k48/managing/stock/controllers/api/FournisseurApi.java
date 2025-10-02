package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.FournisseurDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.k48.managing.stock.utils.Constants.FOURNISSEUR_ENDPOINT;

@Tag(name = "Fournisseurs", description = "Gestion des fournisseurs")
public interface FournisseurApi {

    @PostMapping(FOURNISSEUR_ENDPOINT + "/create")
    @Operation(summary = "Créer un fournisseur", description = "Créer ou mettre à jour un fournisseur")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fournisseur enregistré avec succès"),
            @ApiResponse(responseCode = "400", description = "Données du fournisseur invalides")
    })
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/{idFournisseur}")
    @Operation(summary = "Rechercher un fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fournisseur trouvé"),
            @ApiResponse(responseCode = "404", description = "Aucun fournisseur trouvé avec cet ID")
    })
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FOURNISSEUR_ENDPOINT + "/all")
    @Operation(summary = "Lister tous les fournisseurs")
    @ApiResponse(responseCode = "200", description = "Liste des fournisseurs")
    List<FournisseurDto> findAll();

    @DeleteMapping(FOURNISSEUR_ENDPOINT + "/delete/{idFournisseur}")
    @Operation(summary = "Supprimer un fournisseur par ID")
    @ApiResponse(responseCode = "200", description = "Fournisseur supprimé avec succès")
    void delete(@PathVariable("idFournisseur") Integer id);
}
