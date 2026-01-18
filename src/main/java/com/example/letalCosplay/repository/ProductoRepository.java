package com.example.letalCosplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letalCosplay.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}
