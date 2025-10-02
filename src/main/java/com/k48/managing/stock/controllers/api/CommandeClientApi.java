package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.CommandeClientDto;
import com.k48.managing.stock.dto.LigneCommandeClientDto;
import com.k48.managing.stock.model.EtatCommande;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.k48.managing.stock.controllers.api.ArticleApi.APP_ROOT;

@Tag(name = "Commandes Clients", description = "Gestion des commandes clients")
public interface CommandeClientApi {

    @PostMapping(APP_ROOT + "/commandesclients/create")
    @Operation(summary = "Créer une commande client", description = "Créer ou enregistrer une nouvelle commande client")
    @ApiResponse(responseCode = "200", description = "Commande client enregistrée avec succès")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @PatchMapping(APP_ROOT + "/commandesclients/update/etat/{idCommande}/{etatCommande}")
    @Operation(summary = "Mettre à jour l'état d'une commande")
    ResponseEntity<CommandeClientDto> updateEtatCommande(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("etatCommande") EtatCommande etatCommande
    );

    @PatchMapping(APP_ROOT + "/commandesclients/update/quantite/{idCommande}/{idLigneCommande}/{quantite}")
    @Operation(summary = "Mettre à jour la quantité d'un article dans la commande")
    ResponseEntity<CommandeClientDto> updateQuantiteCommande(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande,
            @PathVariable("quantite") BigDecimal quantite
    );

    @PatchMapping(APP_ROOT + "/commandesclients/update/client/{idCommande}/{idClient}")
    @Operation(summary = "Changer le client associé à une commande")
    ResponseEntity<CommandeClientDto> updateClient(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idClient") Integer idClient
    );

    @PatchMapping(APP_ROOT + "/commandesclients/update/article/{idCommande}/{idLigneCommande}/{idArticle}")
    @Operation(summary = "Mettre à jour l'article dans une ligne de commande")
    ResponseEntity<CommandeClientDto> updateArticle(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande,
            @PathVariable("idArticle") Integer idArticle
    );

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/article/{idCommande}/{idLigneCommande}")
    @Operation(summary = "Supprimer un article d'une commande client")
    ResponseEntity<CommandeClientDto> deleteArticle(
            @PathVariable("idCommande") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande
    );

    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
    @Operation(summary = "Rechercher une commande client par ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Commande trouvée"),
            @ApiResponse(responseCode = "404", description = "Commande non trouvée")
    })
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/filter/{codeCommandeClient}")
    @Operation(summary = "Rechercher une commande client par code")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    @Operation(summary = "Lister toutes les commandes clients")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @GetMapping(APP_ROOT + "/commandesclients/lignesCommande/{idCommande}")
    @Operation(summary = "Lister toutes les lignes d'une commande client")
    ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(
            @PathVariable("idCommande") Integer idCommande
    );

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    @Operation(summary = "Supprimer une commande client")
    @ApiResponse(responseCode = "200", description = "Commande supprimée avec succès")
    ResponseEntity<Void> delete(@PathVariable("idCommandeClient") Integer id);
}
