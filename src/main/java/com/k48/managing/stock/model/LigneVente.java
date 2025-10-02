package com.k48.managing.stock.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    // ===== Getters =====
    public Ventes getVente() {
        return vente;
    }

    public Article getArticle() {
        return article;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    // ===== Setters =====
    public void setVente(Ventes vente) {
        this.vente = vente;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}
