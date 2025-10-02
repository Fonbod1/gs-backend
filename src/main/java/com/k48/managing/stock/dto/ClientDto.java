package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.model.Client;

import java.util.List;

public class ClientDto {

    private Integer id;
    private String nom;
    private String prenom;
    private AdresseDto adresse;
    private String photo;
    private String mail;
    private String numTel;
    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    // Getters and setters

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

    public List<CommandeClientDto> getCommandeClients() { return commandeClients; }
    public void setCommandeClients(List<CommandeClientDto> commandeClients) { this.commandeClients = commandeClients; }

    // Manual Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ClientDto dto = new ClientDto();

        public Builder id(Integer id) {
            dto.setId(id);
            return this;
        }

        public Builder nom(String nom) {
            dto.setNom(nom);
            return this;
        }

        public Builder prenom(String prenom) {
            dto.setPrenom(prenom);
            return this;
        }

        public Builder adresse(AdresseDto adresse) {
            dto.setAdresse(adresse);
            return this;
        }

        public Builder photo(String photo) {
            dto.setPhoto(photo);
            return this;
        }

        public Builder mail(String mail) {
            dto.setMail(mail);
            return this;
        }

        public Builder numTel(String numTel) {
            dto.setNumTel(numTel);
            return this;
        }

        public Builder idEntreprise(Integer idEntreprise) {
            dto.setIdEntreprise(idEntreprise);
            return this;
        }

        public ClientDto build() {
            return dto;
        }
    }

    // Mapping methods

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();
    }

    public static Client toEntity(ClientDto dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(dto.getAdresse()));
        client.setPhoto(dto.getPhoto());
        client.setMail(dto.getMail());
        client.setNumTel(dto.getNumTel());
        client.setIdEntreprise(dto.getIdEntreprise());
        return client;
    }
}
