package com.k48.managing.stock.controllers.api;
import com.k48.managing.stock.dto.ArticleDto;
import com.k48.managing.stock.dto.LigneCommandeClientDto;
import com.k48.managing.stock.dto.LigneCommandeFournisseurDto;
import com.k48.managing.stock.dto.LigneVenteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "articles", description = "API for operations on articles")
public interface ArticleApi {

    String APP_ROOT = "/api"; // Assuming APP_ROOT is defined elsewhere, e.g., in a constants file

    @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save an article", description = "This method allows you to save or modify an article.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The created/modified article object",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class)) }),
            @ApiResponse(responseCode = "400", description = "The article object is not valid",
                    content = @Content)
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find an article by ID", description = "This method allows you to find an article by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The article was found in the database",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class)) }),
            @ApiResponse(responseCode = "404", description = "No article exists in the database with the provided ID",
                    content = @Content)
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find an article by CODE", description = "This method allows you to find an article by its CODE.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The article was found in the database",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ArticleDto.class)) }),
            @ApiResponse(responseCode = "404", description = "No article exists in the database with the provided CODE",
                    content = @Content)
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Return the list of articles", description = "This method allows you to find and return the list of existing articles in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of articles / An empty list",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class, subTypes = {ArticleDto.class})) })
    })
    List<ArticleDto> findAll();

    @GetMapping(value = APP_ROOT + "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get sales history for an article", description = "Finds the sales history for a specific article.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sales history found")
    })
    List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get customer order history for an article", description = "Finds the customer order history for a specific article.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Customer order history found")
    })
    List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get supplier order history for an article", description = "Finds the supplier order history for a specific article.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Supplier order history found")
    })
    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

    @GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Filter articles by category", description = "Finds all articles belonging to a specific category.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of articles for the category")
    })
    List<ArticleDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @Operation(summary = "Delete an article", description = "This method allows you to delete an article by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The article has been deleted",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Article not found", content = @Content)
    })
    void delete(@PathVariable("idArticle") Integer id);

}