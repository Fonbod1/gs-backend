package com.k48.managing.stock.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "article")
public class Article extends AbstractEntity {

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;

    // ===== Getters =====
    public String getCodeArticle() { return codeArticle; }
    public String getDesignation() { return designation; }
    public BigDecimal getPrixUnitaireHt() { return prixUnitaireHt; }
    public BigDecimal getTauxTva() { return tauxTva; }
    public BigDecimal getPrixUnitaireTtc() { return prixUnitaireTtc; }
    public String getPhoto() { return photo; }
    public Integer getIdEntreprise() { return idEntreprise; }
    public Category getCategory() { return category; }
    public List<LigneVente> getLigneVentes() { return ligneVentes; }
    public List<LigneCommandeClient> getLigneCommandeClients() { return ligneCommandeClients; }
    public List<LigneCommandeFournisseur> getLigneCommandeFournisseurs() { return ligneCommandeFournisseurs; }
    public List<MvtStk> getMvtStks() { return mvtStks; }

    // ===== Setters =====
    public void setCodeArticle(String codeArticle) { this.codeArticle = codeArticle; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setPrixUnitaireHt(BigDecimal prixUnitaireHt) { this.prixUnitaireHt = prixUnitaireHt; }
    public void setTauxTva(BigDecimal tauxTva) { this.tauxTva = tauxTva; }
    public void setPrixUnitaireTtc(BigDecimal prixUnitaireTtc) { this.prixUnitaireTtc = prixUnitaireTtc; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }
    public void setCategory(Category category) { this.category = category; }
    public void setLigneVentes(List<LigneVente> ligneVentes) { this.ligneVentes = ligneVentes; }
    public void setLigneCommandeClients(List<LigneCommandeClient> ligneCommandeClients) { this.ligneCommandeClients = ligneCommandeClients; }
    public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseur> ligneCommandeFournisseurs) { this.ligneCommandeFournisseurs = ligneCommandeFournisseurs; }
    public void setMvtStks(List<MvtStk> mvtStks) { this.mvtStks = mvtStks; }
}
