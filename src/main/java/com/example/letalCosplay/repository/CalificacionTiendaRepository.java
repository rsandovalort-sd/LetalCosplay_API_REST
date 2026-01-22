package com.example.letalCosplay.repository;

import com.example.letalCosplay.model.CalificacionTienda;
import com.example.letalCosplay.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionTiendaRepository extends JpaRepository<CalificacionTienda, Long> {

    List<CalificacionTienda> findByUserId(Long userId);
}
