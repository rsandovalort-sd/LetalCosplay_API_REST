package com.example.letalCosplay.repository;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letalCosplay.model.Vendedor;

@Entity
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {


}
