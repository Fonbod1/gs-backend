package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.CommandeFournisseurDto;
import com.k48.managing.stock.dto.LigneCommandeFournisseurDto;
import com.k48.managing.stock.model.EtatCommande;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.k48.managing.stock.utils.Constants.*;

@Tag(name = "Commandes Fournisseurs", description = "Gestion des commandes fournisseurs")
public interface CommandeFournisseurApi {

    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_ENDPOINT)
    @Operation(summary = "Créer une commande fournisseur", description = "Créer ou modifier une commande fournisseur")
    @ApiResponse(responseCode = "200", description = "Commande fournisseur enregistrée avec succès")
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/etat/{idCommande}/{etatCommande}")
    @Operation(summary = "Mettre à jour l'état d'une commande fournisseur")
    CommandeFournisseurDto updateEtatCommande(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("etatCommande") EtatCommande etatCommande
    );

    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    @Operation(summary = "Mettre à jour la quantité d'un article dans la commande fournisseur")
    CommandeFournisseurDto updateQuantiteCommande(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande,
            @PathVariable("quantite") BigDecimal quantite
    );

    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/fournisseur/{idCommande}/{idFournisseur}")
    @Operation(summary = "Changer le fournisseur d'une commande")
    CommandeFournisseurDto updateFournisseur(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idFournisseur") Integer idFournisseur
    );

    @PatchMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    @Operation(summary = "Mettre à jour l'article dans une ligne de commande fournisseur")
    CommandeFournisseurDto updateArticle(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande,
            @PathVariable("idArticle") Integer idArticle
    );

    @DeleteMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/article/{idCommande}/{idLigneCommande}")
    @Operation(summary = "Supprimer un article d'une commande fournisseur")
    CommandeFournisseurDto deleteArticle(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande
    );

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT)
    @Operation(summary = "Rechercher une commande fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande trouvée"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT)
    @Operation(summary = "Rechercher une commande fournisseur par code")
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT)
    @Operation(summary = "Lister toutes les commandes fournisseurs")
    @ApiResponse(responseCode = "200", description = "Liste des commandes fournisseurs")
    List<CommandeFournisseurDto> findAll();

    @GetMapping(COMMANDE_FOURNISSEUR_ENDPOINT + "/lignesCommande/{idCommande}")
    @Operation(summary = "Lister toutes les lignes d'une commande fournisseur")
    List<LigneCommandeFournisseurDto> findAllLignesCommandesFournisseurByCommandeFournisseurId(
            @PathVariable("idCommande") Integer idCommande
    );

    @DeleteMapping(DELETE_COMMANDE_FOURNISSEUR_ENDPOINT)
    @Operation(summary = "Supprimer une commande fournisseur")
    @ApiResponse(responseCode = "200", description = "Commande supprimée avec succès")
    void delete(@PathVariable("idCommandeFournisseur") Integer id);
}
