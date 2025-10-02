package com.k48.managing.stock.model.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter  // Lombok will still generate getters for username, password, etc. (if needed)
@Setter
public class ExtendedUser extends User {

    private Integer idEntreprise;

    public ExtendedUser(String username, String password,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ExtendedUser(String username, String password, Integer idEntreprise,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.idEntreprise = idEntreprise;
    }

    // 🔥 Explicit getter ensures compiler always sees it
    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    // 🔥 Explicit setter ensures compiler always sees it
    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}
