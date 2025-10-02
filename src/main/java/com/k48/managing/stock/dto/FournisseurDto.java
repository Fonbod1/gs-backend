package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.model.Fournisseur;
import java.util.List;

public class FournisseurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numTel;
    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandeFournisseurDto> commandeFournisseurs;

    // ===== Constructors =====
    public FournisseurDto() {}

    public FournisseurDto(Integer id, String nom, String prenom, AdresseDto adresse,
                          String photo, String mail, String numTel, Integer idEntreprise) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.photo = photo;
        this.mail = mail;
        this.numTel = numTel;
        this.idEntreprise = idEntreprise;
    }

    // ===== Getters & Setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public AdresseDto getAdresse() { return adresse; }
    public void setAdresse(AdresseDto adresse) { this.adresse = adresse; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }

    public String getNumTel() { return numTel; }
    public void setNumTel(String numTel) { this.numTel = numTel; }

    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    public List<CommandeFournisseurDto> getCommandeFournisseurs() { return commandeFournisseurs; }
    public void setCommandeFournisseurs(List<CommandeFournisseurDto> commandeFournisseurs) {
        this.commandeFournisseurs = commandeFournisseurs;
    }

    // ===== Mapping Methods =====
    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        FournisseurDto dto = new FournisseurDto();
        dto.setId(fournisseur.getId());
        dto.setNom(fournisseur.getNom());
        dto.setPrenom(fournisseur.getPrenom());
        dto.setAdresse(AdresseDto.fromEntity(fournisseur.getAdresse()));
        dto.setPhoto(fournisseur.getPhoto());
        dto.setMail(fournisseur.getMail());
        dto.setNumTel(fournisseur.getNumTel());
        dto.setIdEntreprise(fournisseur.getIdEntreprise());
        return dto;
    }

    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setMail(dto.getMail());
        fournisseur.setNumTel(dto.getNumTel());
        fournisseur.setIdEntreprise(dto.getIdEntreprise());
        return fournisseur;
    }
}
