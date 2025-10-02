package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.model.LigneCommandeClient;

import java.math.BigDecimal;

public class LigneCommandeClientDto {

    private Integer id;
    private ArticleDto article;

    @JsonIgnore
    private CommandeClientDto commandeClient;

    private BigDecimal quantite;
    private BigDecimal prixUnitaire;
    private Integer idEntreprise;

    // ===== Getters =====
    public Integer getId() { return id; }
    public ArticleDto getArticle() { return article; }
    public CommandeClientDto getCommandeClient() { return commandeClient; }
    public BigDecimal getQuantite() { return quantite; }
    public BigDecimal getPrixUnitaire() { return prixUnitaire; }
    public Integer getIdEntreprise() { return idEntreprise; }

    // ===== Setters =====
    public void setId(Integer id) { this.id = id; }
    public void setArticle(ArticleDto article) { this.article = article; }
    public void setCommandeClient(CommandeClientDto commandeClient) { this.commandeClient = commandeClient; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }
    public void setPrixUnitaire(BigDecimal prixUnitaire) { this.prixUnitaire = prixUnitaire; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    // ===== Manual Builder =====
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final LigneCommandeClientDto dto = new LigneCommandeClientDto();
        public Builder id(Integer id) { dto.id = id; return this; }
        public Builder article(ArticleDto article) { dto.article = article; return this; }
        public Builder commandeClient(CommandeClientDto commandeClient) { dto.commandeClient = commandeClient; return this; }
        public Builder quantite(BigDecimal quantite) { dto.quantite = quantite; return this; }
        public Builder prixUnitaire(BigDecimal prixUnitaire) { dto.prixUnitaire = prixUnitaire; return this; }
        public Builder idEntreprise(Integer idEntreprise) { dto.idEntreprise = idEntreprise; return this; }
        public LigneCommandeClientDto build() { return dto; }
    }

    // ===== Mapping: Entity → DTO =====
    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
        if (ligneCommandeClient == null) return null;
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }

    // ===== Mapping: DTO → Entity =====
    public static LigneCommandeClient toEntity(LigneCommandeClientDto dto) {
        if (dto == null) return null;
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(dto.getId());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(dto.getArticle()));
        ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
        ligneCommandeClient.setQuantite(dto.getQuantite());
        ligneCommandeClient.setIdEntreprise(dto.getIdEntreprise());
        return ligneCommandeClient;
    }
}
