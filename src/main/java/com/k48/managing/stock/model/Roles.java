package com.k48.managing.stock.model;
import com.k48.managing.stock.model.AbstractEntity;
import com.k48.managing.stock.model.Utilisateur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {

    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;

    // ✅ Explicit getter for roleName (to avoid symbol errors in DTO)

    public String getRoleName() {
        return this.roleName;
    }

    // ✅ Explicit setter for roleName (fixes "cannot find setRoleName")
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // ✅ Explicit setter for utilisateur (from previous fix)
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
