package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.Ventes;
import java.time.Instant;
import java.util.List;

public class VentesDto {

    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private List<LigneVenteDto> ligneVentes;
    private Integer idEntreprise;

    // ===== Getters & Setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Instant getDateVente() { return dateVente; }
    public void setDateVente(Instant dateVente) { this.dateVente = dateVente; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public List<LigneVenteDto> getLigneVentes() { return ligneVentes; }
    public void setLigneVentes(List<LigneVenteDto> ligneVentes) { this.ligneVentes = ligneVentes; }

    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    // ===== Builder =====
    public static class Builder {
        private final VentesDto dto = new VentesDto();

        public Builder id(Integer id) { dto.id = id; return this; }
        public Builder code(String code) { dto.code = code; return this; }
        public Builder dateVente(Instant dateVente) { dto.dateVente = dateVente; return this; }
        public Builder commentaire(String commentaire) { dto.commentaire = commentaire; return this; }
        public Builder ligneVentes(List<LigneVenteDto> ligneVentes) { dto.ligneVentes = ligneVentes; return this; }
        public Builder idEntreprise(Integer idEntreprise) { dto.idEntreprise = idEntreprise; return this; }

        public VentesDto build() { return dto; }
    }

    public static Builder builder() {
        return new Builder();
    }

    // ===== Mapper: Entity → DTO =====
    public static VentesDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VentesDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    // ===== Mapper: DTO → Entity =====
    public static Ventes toEntity(VentesDto dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(dto.getCode()); // ✅ fixed: should use dto.getCode(), not ventes.getCode()
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdEntreprise(dto.getIdEntreprise());
        return ventes;
    }
}
