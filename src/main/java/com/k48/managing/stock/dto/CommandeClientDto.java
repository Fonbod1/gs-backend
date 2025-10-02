package com.k48.managing.stock.dto;

import com.k48.managing.stock.model.CommandeClient;
import com.k48.managing.stock.model.EtatCommande;

import java.time.Instant;
import java.util.List;

public class CommandeClientDto {

    private Integer id;
    private String code;
    private Instant dateCommande;
    private EtatCommande etatCommande;
    private ClientDto client;
    private Integer idEntreprise;
    private List<LigneCommandeClientDto> ligneCommandeClients;

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Instant getDateCommande() { return dateCommande; }
    public void setDateCommande(Instant dateCommande) { this.dateCommande = dateCommande; }
    public EtatCommande getEtatCommande() { return etatCommande; }
    public void setEtatCommande(EtatCommande etatCommande) { this.etatCommande = etatCommande; }
    public ClientDto getClient() { return client; }
    public void setClient(ClientDto client) { this.client = client; }
    public Integer getIdEntreprise() { return idEntreprise; }
    public void setIdEntreprise(Integer idEntreprise) { this.idEntreprise = idEntreprise; }
    public List<LigneCommandeClientDto> getLigneCommandeClients() { return ligneCommandeClients; }
    public void setLigneCommandeClients(List<LigneCommandeClientDto> ligneCommandeClients) { this.ligneCommandeClients = ligneCommandeClients; }

    // Manual builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final CommandeClientDto dto = new CommandeClientDto();

        public Builder id(Integer id) {
            dto.setId(id);
            return this;
        }

        public Builder code(String code) {
            dto.setCode(code);
            return this;
        }

        public Builder dateCommande(Instant dateCommande) {
            dto.setDateCommande(dateCommande);
            return this;
        }

        public Builder etatCommande(EtatCommande etatCommande) {
            dto.setEtatCommande(etatCommande);
            return this;
        }

        public Builder client(ClientDto client) {
            dto.setClient(client);
            return this;
        }

        public Builder idEntreprise(Integer idEntreprise) {
            dto.setIdEntreprise(idEntreprise);
            return this;
        }

        public Builder ligneCommandeClients(List<LigneCommandeClientDto> ligneCommandeClients) {
            dto.setLigneCommandeClients(ligneCommandeClients);
            return this;
        }

        public CommandeClientDto build() {
            return dto;
        }
    }

    // From Entity
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) return null;

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                // You can set ligneCommandeClients similarly if you want
                .build();
    }

    // To Entity
    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) return null;

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setDateCommande(dto.getDateCommande());
        commandeClient.setEtatCommande(dto.getEtatCommande());
        commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
        commandeClient.setIdEntreprise(dto.getIdEntreprise());
        return commandeClient;
    }

    // Custom method
    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
