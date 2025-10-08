package com.k48.managing.stock.model.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

public class ExtendedUser extends User {

    private Integer idEntreprise;

    // Constructor without authorities
    public ExtendedUser(String username, String password, Integer idEntreprise) {
        super(username, password, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        this.idEntreprise = idEntreprise;
    }

    // Constructor with authorities (fallback to default if null)
    public ExtendedUser(String username, String password, Integer idEntreprise,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password,
                authorities != null ? authorities : Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        this.idEntreprise = idEntreprise;
    }

    public Integer getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(Integer idEntreprise) {
        this.idEntreprise = idEntreprise;
    }
}



/*
package com.k48.managing.stock.model.auth;
import org.springframework.security.core.userdetails.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class ExtendedUser extends User {
    @Getter
    @Setter
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
}

 */