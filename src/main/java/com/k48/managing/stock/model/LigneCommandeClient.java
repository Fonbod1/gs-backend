package com.k48.managing.stock.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    // ===== Getters =====
    public Article getArticle() {
        return article;
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
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
    public void setArticle(Article article) {
        this.article = article;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
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
