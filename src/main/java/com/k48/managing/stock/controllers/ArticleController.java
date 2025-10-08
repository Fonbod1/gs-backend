package com.k48.managing.stock.controllers;

import com.k48.managing.stock.controllers.api.ArticleApi;
import com.k48.managing.stock.dto.ArticleDto;
import com.k48.managing.stock.dto.LigneCommandeClientDto;
import com.k48.managing.stock.dto.LigneCommandeFournisseurDto;
import com.k48.managing.stock.dto.LigneVenteDto;
//import com.k48.managing.stock.service.ArticleService;
import com.k48.managing.stock.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ArticleDto save(@RequestBody ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
        return articleService.findHistoriqueVentes(idArticle);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
        return articleService.findHistoriqueCommandeClient(idArticle);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
        return articleService.findHistoriqueCommandeFournisseur(idArticle);
    }

    @Override
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<ArticleDto> findAllArticleByIdCategory(Integer idCategory) {
        return articleService.findAllArticleByIdCategory(idCategory);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
