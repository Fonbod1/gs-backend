package com.k48.managing.stock.controllers.api;

import com.flickr4java.flickr.FlickrException;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.k48.managing.stock.controllers.api.ArticleApi.APP_ROOT;

@Tag(name = "Photos", description = "Gestion de l'enregistrement des photos via Flickr")
public interface PhotoApi {

    @PostMapping(APP_ROOT + "/save/{id}/{title}/{context}")
    @Operation(
            summary = "Enregistrer une photo",
            description = "Cette méthode permet d'enregistrer une photo pour un article, client, fournisseur, etc. selon le contexte"
    )
    @ApiResponse(responseCode = "200", description = "Photo enregistrée avec succès")
    Object savePhoto(
            @PathVariable("context") String context,
            @PathVariable("id") Integer id,
            @RequestPart("file") MultipartFile photo,
            @PathVariable("title") String title
    ) throws IOException, FlickrException;
}
