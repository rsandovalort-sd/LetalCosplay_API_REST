package com.example.letalCosplay.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letalCosplay.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {


}
