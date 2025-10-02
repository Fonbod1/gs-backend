package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.model.Entreprise;
import java.util.List;

public class EntrepriseDto {

    private Integer id;
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String steWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    // ===== GETTERS =====
    public Integer getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public AdresseDto getAdresse() { return adresse; }
    public String getCodeFiscal() { return codeFiscal; }
    public String getPhoto() { return photo; }
    public String getEmail() { return email; }
    public String getNumTel() { return numTel; }
    public String getSteWeb() { return steWeb; }
    public List<UtilisateurDto> getUtilisateurs() { return utilisateurs; }

    // ===== BUILDER ENTRY POINT =====
    public static Builder builder() {
        return new Builder();
    }

    // ===== NEW: toBuilder() to modify existing instance =====
    public Builder toBuilder() {
        return new Builder()
                .id(this.id)
                .nom(this.nom)
                .description(this.description)
                .adresse(this.adresse)
                .codeFiscal(this.codeFiscal)
                .photo(this.photo)
                .email(this.email)
                .numTel(this.numTel)
                .steWeb(this.steWeb)
                .utilisateurs(this.utilisateurs);
    }

    // ===== MANUAL BUILDER =====
    public static class Builder {
        private final EntrepriseDto dto = new EntrepriseDto();

        public Builder id(Integer id) { dto.id = id; return this; }
        public Builder nom(String nom) { dto.nom = nom; return this; }
        public Builder description(String description) { dto.description = description; return this; }
        public Builder adresse(AdresseDto adresse) { dto.adresse = adresse; return this; }
        public Builder codeFiscal(String codeFiscal) { dto.codeFiscal = codeFiscal; return this; }
        public Builder photo(String photo) { dto.photo = photo; return this; }
        public Builder email(String email) { dto.email = email; return this; }
        public Builder numTel(String numTel) { dto.numTel = numTel; return this; }
        public Builder steWeb(String steWeb) { dto.steWeb = steWeb; return this; }
        public Builder utilisateurs(List<UtilisateurDto> utilisateurs) { dto.utilisateurs = utilisateurs; return this; }

        public EntrepriseDto build() { return dto; }
    }

    // ===== MAPPER: ENTITY -> DTO =====
    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .steWeb(entreprise.getSteWeb())
                .build();
    }

    // ===== MAPPER: DTO -> ENTITY =====
    public static Entreprise toEntity(EntrepriseDto dto) {
        if (dto == null) {
            return null;
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setId(dto.getId());
        entreprise.setNom(dto.getNom());
        entreprise.setDescription(dto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        entreprise.setCodeFiscal(dto.getCodeFiscal());
        entreprise.setPhoto(dto.getPhoto());
        entreprise.setEmail(dto.getEmail());
        entreprise.setNumTel(dto.getNumTel());
        entreprise.setSteWeb(dto.getSteWeb());

        return entreprise;
    }
}
