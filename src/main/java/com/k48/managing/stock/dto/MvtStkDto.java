package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.MvtStk;
import com.k48.managing.stock.model.SourceMvtStk;
import com.k48.managing.stock.model.TypeMvtStk;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MvtStkDto {

    private Integer id;

    @JsonProperty("dateMvt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    private Instant dateMvt;

    @JsonProperty("quantite")
    private BigDecimal quantite;

    @JsonProperty("article")
    private ArticleDto article;

    @JsonProperty("typeMvt")
    private TypeMvtStk typeMvt;

    @JsonProperty("sourceMvt")
    private SourceMvtStk sourceMvt;

    @JsonProperty("idEntreprise")
    private Integer idEntreprise;

    // Convert from entity to DTO
    public static MvtStkDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) return null;
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

    // Convert from DTO to entity
    public static MvtStk toEntity(MvtStkDto dto) {
        if (dto == null) return null;
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
