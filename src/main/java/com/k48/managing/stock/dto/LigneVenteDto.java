package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.LigneVente;
import java.math.BigDecimal;

public class LigneVenteDto {

    private Integer id;
    private VentesDto vente;
    private ArticleDto article;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    // ===== Getters =====
    public Integer getId() { return id; }
    public VentesDto getVente() { return vente; }
    public ArticleDto getArticle() { return article; }
    public BigDecimal getQuantite() { return quantite; }
    public BigDecimal getPrixUnitaire() { return prixUnitaire; }
    public Integer getIdEntreprise() { return idEntreprise; }

    // ===== Setters =====
    public void setId(Integer id) { this.id = id; }
    public void setVente(VentesDto vente) { this.vente = vente; }
    public void setArticle(ArticleDto article) { this.article = article; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
    public void setPrixUnitaire(BigDecimal prixUnitaire) { this.prixUnitaire = prixUnitaire; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    // ===== Manual Builder =====
    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private final LigneVenteDto dto = new LigneVenteDto();

        public Builder id(Integer id) { dto.id = id; return this; }
        public Builder vente(VentesDto vente) { dto.vente = vente; return this; }
        public Builder article(ArticleDto article) { dto.article = article; return this; }
        public Builder quantite(BigDecimal quantite) { dto.quantite = quantite; return this; }
        public Builder prixUnitaire(BigDecimal prixUnitaire) { dto.prixUnitaire = prixUnitaire; return this; }
        public Builder idEntreprise(Integer idEntreprise) { dto.idEntreprise = idEntreprise; return this; }

        public LigneVenteDto build() { return dto; }
    }

    // ===== Mapper: Entity → DTO =====
    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) return null;
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VentesDto.fromEntity(ligneVente.getVente()))
                .article(ArticleDto.fromEntity(ligneVente.getArticle()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    // ===== Mapper: DTO → Entity =====
    public static LigneVente toEntity(LigneVenteDto dto) {
        if (dto == null) return null;
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(dto.getId());
        ligneVente.setVente(VentesDto.toEntity(dto.getVente()));
        ligneVente.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneVente.setQuantite(dto.getQuantite());
        ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
        ligneVente.setIdEntreprise(dto.getIdEntreprise());
        return ligneVente;
    }
}
