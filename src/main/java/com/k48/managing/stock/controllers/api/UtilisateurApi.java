package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.ChangerMotDePasseUtilisateurDto;
import com.k48.managing.stock.dto.UtilisateurDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.k48.managing.stock.utils.Constants.UTILISATEUR_ENDPOINT;

@Tag(name = "Utilisateurs", description = "Gestion des utilisateurs")
public interface UtilisateurApi {

    @PostMapping(UTILISATEUR_ENDPOINT + "/create")
    @Operation(summary = "Créer ou modifier un utilisateur", description = "Permet d'enregistrer ou modifier un utilisateur")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur enregistré/modifié avec succès"),
            @ApiResponse(responseCode = "400", description = "Données utilisateur invalides")
    })
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @PostMapping(UTILISATEUR_ENDPOINT + "/update/password")
    @Operation(summary = "Changer le mot de passe d'un utilisateur")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Mot de passe modifié avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides pour changement de mot de passe")
    })
    UtilisateurDto changerMotDePasse(@RequestBody ChangerMotDePasseUtilisateurDto dto);

    @GetMapping(UTILISATEUR_ENDPOINT + "/{idUtilisateur}")
    @Operation(summary = "Rechercher un utilisateur par ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur trouvé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé avec cet ID")
    })
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(UTILISATEUR_ENDPOINT + "/find/{email}")
    @Operation(summary = "Rechercher un utilisateur par email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Utilisateur trouvé"),
            @ApiResponse(responseCode = "404", description = "Utilisateur non trouvé avec cet email")
    })
    UtilisateurDto findByEmail(@PathVariable("email") String email);

    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    @Operation(summary = "Lister tous les utilisateurs")
    @ApiResponse(responseCode = "200", description = "Liste des utilisateurs")
    List<UtilisateurDto> findAll();

    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idUtilisateur}")
    @Operation(summary = "Supprimer un utilisateur par ID")
    @ApiResponse(responseCode = "200", description = "Utilisateur supprimé avec succès")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
