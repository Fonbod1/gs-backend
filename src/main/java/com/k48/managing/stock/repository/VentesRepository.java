package com.k48.managing.stock.repository;
import java.util.Optional;

import com.k48.managing.stock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

    Optional<Ventes> findVentesByCode(String code);
}