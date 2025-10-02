package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.ClientDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.k48.managing.stock.controllers.api.ArticleApi.APP_ROOT;

@Tag(name = "Clients", description = "Operations related to client management")
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/clients/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Créer un client", description = "Permet d'enregistrer ou de modifier un client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client créé/modifié avec succès"),
            @ApiResponse(responseCode = "400", description = "Les données du client ne sont pas valides")
    })
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/clients/{idClient}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Rechercher un client par ID", description = "Retourne un client à partir de son identifiant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Aucun client trouvé avec cet ID")
    })
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = APP_ROOT + "/clients/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Lister tous les clients", description = "Retourne la liste de tous les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients")
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
    @Operation(summary = "Supprimer un client", description = "Permet de supprimer un client par ID")
    @ApiResponse(responseCode = "200", description = "Client supprimé avec succès")
    void delete(@PathVariable("idClient") Integer id);
}
