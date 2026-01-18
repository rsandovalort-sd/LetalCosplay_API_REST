package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.Vendedor;

public interface IVendedorService {

    List<Vendedor> listar();

    Vendedor guardar(Vendedor vendedor);
}
