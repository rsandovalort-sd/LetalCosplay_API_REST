package com.example.letalCosplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.letalCosplay.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
