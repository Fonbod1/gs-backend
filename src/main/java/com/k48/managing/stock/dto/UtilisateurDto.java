package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.Utilisateur;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class UtilisateurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private Instant dateDeNaissance;
    private String motDePasse;   // ✅ corrected spelling
    private AdresseDto adresse;
    private String photo;
    private EntrepriseDto entreprise;
    private List<RolesDto> roles;

    // ===== GETTERS & SETTERS =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Instant getDateDeNaissance() { return dateDeNaissance; }
    public void setDateDeNaissance(Instant dateDeNaissance) { this.dateDeNaissance = dateDeNaissance; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; } // ✅ added setter

    public AdresseDto getAdresse() { return adresse; }
    public void setAdresse(AdresseDto adresse) { this.adresse = adresse; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public EntrepriseDto getEntreprise() { return entreprise; }
    public void setEntreprise(EntrepriseDto entreprise) { this.entreprise = entreprise; }

    public List<RolesDto> getRoles() { return roles; }
    public void setRoles(List<RolesDto> roles) { this.roles = roles; }

    // ===== BUILDER ENTRY POINT =====
    public static Builder builder() {
        return new Builder();
    }

    // ===== MANUAL BUILDER =====
    public static class Builder {
        private final UtilisateurDto dto = new UtilisateurDto();

        public Builder id(Integer id) { dto.id = id; return this; }
        public Builder nom(String nom) { dto.nom = nom; return this; }
        public Builder prenom(String prenom) { dto.prenom = prenom; return this; }
        public Builder email(String email) { dto.email = email; return this; }
        public Builder dateDeNaissance(Instant dateDeNaissance) { dto.dateDeNaissance = dateDeNaissance; return this; }
        public Builder motDePasse(String motDePasse) { dto.motDePasse = motDePasse; return this; } // ✅ corrected
        public Builder adresse(AdresseDto adresse) { dto.adresse = adresse; return this; }
        public Builder photo(String photo) { dto.photo = photo; return this; }
        public Builder entreprise(EntrepriseDto entreprise) { dto.entreprise = entreprise; return this; }
        public Builder roles(List<RolesDto> roles) { dto.roles = roles; return this; }

        public UtilisateurDto build() {
            return dto;
        }
    }

    // ===== MAPPER: ENTITY -> DTO =====
    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse()) // ✅ corrected
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(utilisateur.getRoles() != null
                        ? utilisateur.getRoles().stream()
                        .map(RolesDto::fromEntity)
                        .collect(Collectors.toList())
                        : null)
                .build();
    }

    // ===== MAPPER: DTO -> ENTITY =====
    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotDePasse(dto.getMotDePasse()); // ✅ corrected
        utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
        utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        utilisateur.setPhoto(dto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));

        return utilisateur;
    }
}
