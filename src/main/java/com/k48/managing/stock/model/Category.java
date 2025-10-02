package com.k48.managing.stock.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category extends AbstractEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;

    // ===== Constructors =====
    public Category() {}

    public Category(String code, String designation, Integer idEntreprise, List<Article> articles) {
        this.code = code;
        this.designation = designation;
        this.idEntreprise = idEntreprise;
        this.articles = articles;
    }

    // ===== Getters & Setters =====
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }
    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
