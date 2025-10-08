package com.k48.managing.stock.service.auth;

import com.k48.managing.stock.dto.UtilisateurDto;
import com.k48.managing.stock.model.auth.ExtendedUser;
import com.k48.managing.stock.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Safely get user
        UtilisateurDto utilisateur = service.findByEmail(email);
        if (utilisateur == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Safely build authorities
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (utilisateur.getRoles() != null) {
            utilisateur.getRoles().forEach(role -> {
                if (role.getRoleName() != null) {
                    authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
                }
            });
        }

        // Safely get entreprise ID
        Integer idEntreprise = utilisateur.getEntreprise() != null ? utilisateur.getEntreprise().getId() : null;

        return new ExtendedUser(
                utilisateur.getEmail(),
                utilisateur.getMoteDePasse(),
                idEntreprise,
               // null
                authorities
        );
    }
}




/*
package com.k48.managing.stock.service.auth;
import java.util.ArrayList;
import java.util.List;

import com.k48.managing.stock.dto.UtilisateurDto;
import com.k48.managing.stock.model.auth.ExtendedUser;
import com.k48.managing.stock.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private UtilisateurService service;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UtilisateurDto utilisateur = service.findByEmail(email);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        utilisateur.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));

        return new ExtendedUser(utilisateur.getEmail(), utilisateur.getMoteDePasse(), utilisateur.getEntreprise().getId(), authorities);
    }
}

 */