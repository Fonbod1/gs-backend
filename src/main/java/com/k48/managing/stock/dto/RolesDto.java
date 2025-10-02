package com.k48.managing.stock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.k48.managing.stock.dto.UtilisateurDto;
import com.k48.managing.stock.model.Roles;
import lombok.Data;

@Data
public class RolesDto {

    private Integer id;
    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateur;

    // Explicit getter for id
    public Integer getId() {
        return this.id;
    }

    // Explicit getter for roleName
    public String getRoleName() {
        return this.roleName;
    }

    // Explicit getter for utilisateur (added to fix your error)
    public UtilisateurDto getUtilisateur() {
        return this.utilisateur;
    }

    // Manual builder pattern:
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String roleName;
        private UtilisateurDto utilisateur;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        public Builder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder utilisateur(UtilisateurDto utilisateur) {
            this.utilisateur = utilisateur;
            return this;
        }

        public RolesDto build() {
            RolesDto dto = new RolesDto();
            dto.id = this.id;
            dto.roleName = this.roleName;
            dto.utilisateur = this.utilisateur;
            return dto;
        }
    }

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) return null;
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) return null;
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
        roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateur()));
        return roles;
    }
}
