package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.model.Category;
import java.util.List;

public class CategoryDto {

    private Integer id;
    private String code;
    private String designation;
    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articles;

    // ===== Constructors =====
    public CategoryDto() {}

    public CategoryDto(Integer id, String code, String designation, Integer idEntreprise, List<ArticleDto> articles) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.idEntreprise = idEntreprise;
        this.articles = articles;
    }

    // ===== Getters and Setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    public List<ArticleDto> getArticles() { return articles; }
    public void setArticles(List<ArticleDto> articles) { this.articles = articles; }

    // ===== Mapper: Entity → DTO =====
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDto(
                category.getId(),
                category.getCode(),
                category.getDesignation(),
                category.getIdEntreprise(),
                null // We ignore articles to avoid infinite recursion
        );
    }

    // ===== Mapper: DTO → Entity =====
    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        category.setIdEntreprise(categoryDto.getIdEntreprise());
        return category;
    }
}
