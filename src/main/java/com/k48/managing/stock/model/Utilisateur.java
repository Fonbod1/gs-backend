package com.k48.managing.stock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends AbstractEntity implements Serializable {

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "datedenaissance")
    private Instant dateDeNaissance;

    @Column(name = "motdepasse", nullable = false)
    private String motDePasse;  // Corrected spelling here

    @Embedded
    private Adresse adresse;

    @Column(name = "photo")
    private String photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identreprise")
    private Entreprise entreprise;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Roles> roles;

    // ===== Explicit Getters =====
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public Instant getDateDeNaissance() { return dateDeNaissance; }
    public String getMotDePasse() { return motDePasse; }  // Updated method name
    public Adresse getAdresse() { return adresse; }
    public String getPhoto() { return photo; }
    public Entreprise getEntreprise() { return entreprise; }
    public List<Roles> getRoles() { return roles; }

    // ===== Explicit Setters =====
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setEmail(String email) { this.email = email; }
    public void setDateDeNaissance(Instant dateDeNaissance) { this.dateDeNaissance = dateDeNaissance; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }  // Updated method name
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }
    public void setPhoto(String photo) { this.photo = photo; }
    public void setEntreprise(Entreprise entreprise) { this.entreprise = entreprise; }
    public void setRoles(List<Roles> roles) { this.roles = roles; }
}
