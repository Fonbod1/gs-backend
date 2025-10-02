package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.MvtStk;
import com.k48.managing.stock.model.SourceMvtStk;
import com.k48.managing.stock.model.TypeMvtStk;

import java.math.BigDecimal;
import java.time.Instant;

public class MvtStkDto {

    private Integer id;
    private Instant dateMvt;
    private BigDecimal quantite;
    private ArticleDto article;
    private TypeMvtStk typeMvt;
    private SourceMvtStk sourceMvt;
    private Integer idEntreprise;

    // ===== Manual Builder =====
    public static class Builder {
        private final MvtStkDto instance = new MvtStkDto();

        public Builder id(Integer id) { instance.id = id; return this; }
        public Builder dateMvt(Instant dateMvt) { instance.dateMvt = dateMvt; return this; }
        public Builder quantite(BigDecimal quantite) { instance.quantite = quantite; return this; }
        public Builder article(ArticleDto article) { instance.article = article; return this; }
        public Builder typeMvt(TypeMvtStk typeMvt) { instance.typeMvt = typeMvt; return this; }
        public Builder sourceMvt(SourceMvtStk sourceMvt) { instance.sourceMvt = sourceMvt; return this; }
        public Builder idEntreprise(Integer idEntreprise) { instance.idEntreprise = idEntreprise; return this; }

        public MvtStkDto build() { return instance; }
    }

    public static Builder builder() { return new Builder(); }

    // ===== Getters & Setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Instant getDateMvt() { return dateMvt; }
    public void setDateMvt(Instant dateMvt) { this.dateMvt = dateMvt; }

    public BigDecimal getQuantite() { return quantite; }
    public void setQuantite(BigDecimal quantite) { this.quantite = quantite; }

    public ArticleDto getArticle() { return article; }
    public void setArticle(ArticleDto article) { this.article = article; }

    public TypeMvtStk getTypeMvt() { return typeMvt; }
    public void setTypeMvt(TypeMvtStk typeMvt) { this.typeMvt = typeMvt; }

    public SourceMvtStk getSourceMvt() { return sourceMvt; }
    public void setSourceMvt(SourceMvtStk sourceMvt) { this.sourceMvt = sourceMvt; }

    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    // ===== Conversion Methods =====
    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStkDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
                .sourceMvt(mvtStk.getSourceMvt())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
        mvtStk.setSourceMvt(dto.getSourceMvt());
        mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }
}
