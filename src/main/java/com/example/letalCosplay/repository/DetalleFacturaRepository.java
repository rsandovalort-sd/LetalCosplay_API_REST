package com.example.letalCosplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letalCosplay.model.DetalleFactura;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {

    List<DetalleFactura> findByFactura(Long facturaId);
}
