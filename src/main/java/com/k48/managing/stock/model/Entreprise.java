package com.k48.managing.stock.model;

import com.k48.managing.stock.model.AbstractEntity;
import com.k48.managing.stock.model.Adresse;
import com.k48.managing.stock.model.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "entreprise")
public class Entreprise extends AbstractEntity {

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @Embedded
    private Adresse adresse;

    @Column(name = "codefiscal")
    private String codeFiscal;

    @Column(name = "photo")
    private String photo;

    @Column(name = "email")
    private String email;

    @Column(name = "numtel")
    private String numTel;

    @Column(name = "siteweb")
    private String steWeb;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

    // Explicit getters
    public String getNom() { return this.nom; }
    public String getDescription() { return this.description; }
    public Adresse getAdresse() { return this.adresse; }
    public String getCodeFiscal() { return this.codeFiscal; }
    public String getPhoto() { return this.photo; }
    public String getEmail() { return this.email; }
    public String getNumTel() { return this.numTel; }
    public String getSteWeb() { return this.steWeb; }
    public List<Utilisateur> getUtilisateurs() { return this.utilisateurs; }

    // Explicit setters
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    public void setCodeFiscal(String codeFiscal) { this.codeFiscal = codeFiscal; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setEmail(String email) { this.email = email; }
    public void setNumTel(String numTel) { this.numTel = numTel; }
    public void setSteWeb(String steWeb) { this.steWeb = steWeb; }
    public void setUtilisateurs(List<Utilisateur> utilisateurs) { this.utilisateurs = utilisateurs; }
}
