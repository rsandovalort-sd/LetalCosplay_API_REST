package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.Proveedor;

public interface IProveedorService {

    List<Proveedor> listar();

    Proveedor guardar(Proveedor proveedor);

    Proveedor buscarPorId(Long id);

    Proveedor actualizar(Long id, Proveedor proveedor);

    void eliminar(Long id);
}
