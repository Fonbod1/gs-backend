package com.k48.managing.stock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {

    @Column(name = "adresse1")
    private String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codepostale")
    private String codePostale;

    @Column(name = "pays")
    private String pays;

    // ===== Explicit Getters =====
    public String getAdresse1() { return adresse1; }
    public String getAdresse2() { return adresse2; }
    public String getVille() { return ville; }
    public String getCodePostale() { return codePostale; }
    public String getPays() { return pays; }

    // ===== Explicit Setters =====
    public void setAdresse1(String adresse1) { this.adresse1 = adresse1; }
    public void setAdresse2(String adresse2) { this.adresse2 = adresse2; }
    public void setVille(String ville) { this.ville = ville; }
    public void setCodePostale(String codePostale) { this.codePostale = codePostale; }
    public void setPays(String pays) { this.pays = pays; }
}
