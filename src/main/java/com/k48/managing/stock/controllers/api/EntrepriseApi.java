package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.EntrepriseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.k48.managing.stock.utils.Constants.ENTREPRISE_ENDPOINT;

@Tag(name = "Entreprises", description = "Gestion des entreprises")
public interface EntrepriseApi {

    @PostMapping(ENTREPRISE_ENDPOINT + "/create")
    @Operation(summary = "Créer une entreprise", description = "Permet d'enregistrer ou de modifier une entreprise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entreprise enregistrée avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données de l'entreprise sont invalides")
    })
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(ENTREPRISE_ENDPOINT + "/{idEntreprise}")
    @Operation(summary = "Rechercher une entreprise par ID", description = "Retourne une entreprise en fonction de son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entreprise trouvée"),
            @ApiResponse(responseCode = "404", description = "Aucune entreprise trouvée avec cet ID")
    })
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);

    @GetMapping(ENTREPRISE_ENDPOINT + "/all")
    @Operation(summary = "Lister toutes les entreprises", description = "Retourne la liste de toutes les entreprises")
    @ApiResponse(responseCode = "200", description = "Liste des entreprises")
    List<EntrepriseDto> findAll();

    @DeleteMapping(ENTREPRISE_ENDPOINT + "/delete/{idEntreprise}")
    @Operation(summary = "Supprimer une entreprise", description = "Supprime une entreprise à partir de son ID")
    @ApiResponse(responseCode = "200", description = "Entreprise supprimée avec succès")
    void delete(@PathVariable("idEntreprise") Integer id);
}
