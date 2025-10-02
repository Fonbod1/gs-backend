package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.CommandeFournisseur;
import com.k48.managing.stock.model.LigneCommandeFournisseur;

import java.math.BigDecimal;

public class LigneCommandeFournisseurDto {

    private Integer id;
    private ArticleDto article;
    private CommandeFournisseur commandeFournisseur;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    // ===== Getters =====
    public Integer getId() {
        return id;
    }

    public ArticleDto getArticle() {
        return article;
    }

    public CommandeFournisseur getCommandeFournisseur() {
        return commandeFournisseur;
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
    public void setId(Integer id) {
        this.id = id;
    }

    public void setArticle(ArticleDto article) {
        this.article = article;
    }

    public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
        this.commandeFournisseur = commandeFournisseur;
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

    // ===== Manual Builder Pattern =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final LigneCommandeFournisseurDto dto = new LigneCommandeFournisseurDto();

        public Builder id(Integer id) {
            dto.id = id;
            return this;
        }

        public Builder article(ArticleDto article) {
            dto.article = article;
            return this;
        }

        public Builder commandeFournisseur(CommandeFournisseur commandeFournisseur) {
            dto.commandeFournisseur = commandeFournisseur;
            return this;
        }

        public Builder quantite(BigDecimal quantite) {
            dto.quantite = quantite;
            return this;
        }

        public Builder prixUnitaire(BigDecimal prixUnitaire) {
            dto.prixUnitaire = prixUnitaire;
            return this;
        }

        public Builder idEntreprise(Integer idEntreprise) {
            dto.idEntreprise = idEntreprise;
            return this;
        }

        public LigneCommandeFournisseurDto build() {
            return dto;
        }
    }

    // ===== Mapper: Entity → DTO =====
    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur entity) {
        if (entity == null) return null;

        return builder()
                .id(entity.getId())
                .article(ArticleDto.fromEntity(entity.getArticle()))
                .quantite(entity.getQuantite())
                .prixUnitaire(entity.getPrixUnitaire())
                .idEntreprise(entity.getIdEntreprise())
                .build();
    }

    // ===== Mapper: DTO → Entity =====
    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto) {
        if (dto == null) return null;

        LigneCommandeFournisseur entity = new LigneCommandeFournisseur();
        entity.setId(dto.getId());
        entity.setArticle(ArticleDto.toEntity(dto.getArticle()));
        entity.setQuantite(dto.getQuantite());
        entity.setPrixUnitaire(dto.getPrixUnitaire());
        entity.setIdEntreprise(dto.getIdEntreprise());
        return entity;
    }
}
