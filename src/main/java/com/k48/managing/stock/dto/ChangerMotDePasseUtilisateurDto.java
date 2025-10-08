package com.k48.managing.stock.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangerMotDePasseUtilisateurDto {

    private Integer id;

    private String motDePasse;

    private String nouveauMotDePasse;

    private String confirmationMotDePasse;

}