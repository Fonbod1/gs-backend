package com.k48.managing.stock.controllers.api;

import com.k48.managing.stock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import static com.k48.managing.stock.utils.Constants.APP_ROOT;

@Tag(name = "Categories", description = "Endpoints for category management")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enregistrer une categorie", description = "Cette methode permet d'enregistrer ou modifier une categorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet category cree / modifie"),
            @ApiResponse(responseCode = "400", description = "L'objet category n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une categorie par ID", description = "Cette methode permet de chercher une categorie par son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La categorie a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucune categorie n'existe dans la BDD avec l'ID fourni")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer idCategory);

    @GetMapping(value = APP_ROOT + "/categories/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher une categorie par CODE", description = "Cette methode permet de chercher une categorie par son CODE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La categorie a ete trouve dans la BDD"),
            @ApiResponse(responseCode = "404", description = "Aucune categorie n'existe dans la BDD avec le CODE fourni")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String codeCategory);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Renvoi la liste des categories", description = "Cette methode permet de renvoyer la liste des categories dans la BDD")
    @ApiResponse(responseCode = "200", description = "La liste des categories / Une liste vide")
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @Operation(summary = "Supprimer une categorie", description = "Cette methode permet de supprimer une categorie par ID")
    @ApiResponse(responseCode = "200", description = "La categorie a ete supprimee")
    void delete(@PathVariable("idCategory") Integer id);

}
