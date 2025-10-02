package com.k48.managing.stock.dto;

public class ChangerMotDePasseUtilisateurDto {

    private Integer id;  // Assuming you want an ID field

    private String motDePasse;
    private String confirmMotDePasse;

    // Constructor, Getters, and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Other getters and setters for motDePasse, confirmMotDePasse
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getConfirmMotDePasse() {
        return confirmMotDePasse;
    }

    public void setConfirmMotDePasse(String confirmMotDePasse) {
        this.confirmMotDePasse = confirmMotDePasse;
    }
}
