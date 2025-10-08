package com.k48.managing.stock.repository;
import java.util.List;
import java.util.Optional;

import com.k48.managing.stock.model.CommandeClient;
import com.k48.managing.stock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

    List<CommandeClient> findAllByFournisseurId(Integer id);
}