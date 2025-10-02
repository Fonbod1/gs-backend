package com.k48.managing.stock.dto;
import com.k48.managing.stock.model.CommandeFournisseur;
import com.k48.managing.stock.model.EtatCommande;

import java.time.Instant;
import java.util.List;

public class CommandeFournisseurDto {

    private Integer id;
    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;
    private FournisseurDto fournisseur;
    private Integer idEntreprise;
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    // ===== Getters & Setters =====
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Instant getDateCommande() { return dateCommande; }
    public void setDateCommande(Instant dateCommande) { this.dateCommande = dateCommande; }

    public EtatCommande getEtatCommande() { return etatCommande; }
    public void setEtatCommande(EtatCommande etatCommande) { this.etatCommande = etatCommande; }

    public FournisseurDto getFournisseur() { return fournisseur; }
    public void setFournisseur(FournisseurDto fournisseur) { this.fournisseur = fournisseur; }

    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }

    public List<LigneCommandeFournisseurDto> getLigneCommandeFournisseurs() {
        return ligneCommandeFournisseurs;
    }
    public void setLigneCommandeFournisseurs(List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs) {
        this.ligneCommandeFournisseurs = ligneCommandeFournisseurs;
    }

    // ===== Mapping methods =====
    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur) {
        if (commandeFournisseur == null) {
            return null;
        }
        CommandeFournisseurDto dto = new CommandeFournisseurDto();
        dto.setId(commandeFournisseur.getId());
        dto.setCode(commandeFournisseur.getCode());
        dto.setDateCommande(commandeFournisseur.getDateCommande());
        dto.setEtatCommande(commandeFournisseur.getEtatCommande());
        dto.setFournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()));
        dto.setIdEntreprise(commandeFournisseur.getIdEntreprise());
        return dto;
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeFournisseur entity = new CommandeFournisseur();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setDateCommande(dto.getDateCommande());
        entity.setEtatCommande(dto.getEtatCommande());
        entity.setFournisseur(FournisseurDto.toEntity(dto.getFournisseur()));
        entity.setIdEntreprise(dto.getIdEntreprise());
        return entity;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
