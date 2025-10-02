package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.Article;
import java.math.BigDecimal;

public class ArticleDto {

    private Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;
    private Integer idEntreprise;

    // ===== Getters =====
    public Integer getId() { return id; }
    public String getCodeArticle() { return codeArticle; }
    public String getDesignation() { return designation; }
    public BigDecimal getPrixUnitaireHt() { return prixUnitaireHt; }
    public BigDecimal getTauxTva() { return tauxTva; }
    public BigDecimal getPrixUnitaireTtc() { return prixUnitaireTtc; }
    public String getPhoto() { return photo; }
    public CategoryDto getCategory() { return category; }
    public Integer getIdEntreprise() { return idEntreprise; }

    // ===== Setters =====
    public void setId(Integer id) { this.id = id; }
    public void setCodeArticle(String codeArticle) { this.codeArticle = codeArticle; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setPrixUnitaireHt(BigDecimal prixUnitaireHt) { this.prixUnitaireHt = prixUnitaireHt; }
    public void setTauxTva(BigDecimal tauxTva) { this.tauxTva = tauxTva; }
    public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc) { this.prixUnitaireTtc = prixUnitaireTtc; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setCategory(CategoryDto category) { this.category = category; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    // ===== Mapper: Entity → DTO =====
    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        }
        ArticleDto dto = new ArticleDto();
        dto.setId(article.getId());
        dto.setCodeArticle(article.getCodeArticle());
        dto.setDesignation(article.getDesignation());
        dto.setPhoto(article.getPhoto());
        dto.setPrixUnitaireHt(article.getPrixUnitaireHt());
        dto.setPrixUnitaireTtc(article.getPrixUnitaireTtc());
        dto.setTauxTva(article.getTauxTva());
        dto.setIdEntreprise(article.getIdEntreprise());
        dto.setCategory(CategoryDto.fromEntity(article.getCategory()));
        return dto;
    }

    // ===== Mapper: DTO → Entity =====
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPhoto(articleDto.getPhoto());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setIdEntreprise(articleDto.getIdEntreprise());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        return article;
    }
}
