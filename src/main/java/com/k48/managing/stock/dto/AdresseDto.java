package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.Adresse;

public class AdresseDto {

    private String adresse1;
    private String adresse2;
    private String ville;
    private String codePostale;
    private String pays;

    // ===== Getters =====
    public String getAdresse1() { return adresse1; }
    public String getAdresse2() { return adresse2; }
    public String getVille() { return ville; }
    public String getCodePostale() { return codePostale; }
    public String getPays() { return pays; }

    // ===== Builder entry point =====
    public static Builder builder() {
        return new Builder();
    }

    // ===== Manual Builder class =====
    public static class Builder {
        private final AdresseDto dto = new AdresseDto();

        public Builder adresse1(String adresse1) { dto.adresse1 = adresse1; return this; }
        public Builder adresse2(String adresse2) { dto.adresse2 = adresse2; return this; }
        public Builder ville(String ville) { dto.ville = ville; return this; }
        public Builder codePostale(String codePostale) { dto.codePostale = codePostale; return this; }
        public Builder pays(String pays) { dto.pays = pays; return this; }

        public AdresseDto build() {
            return dto;
        }
    }

    // ===== Mapping: Entity -> DTO =====
    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostale(adresse.getCodePostale())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    // ===== Mapping: DTO -> Entity =====
    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }
}
