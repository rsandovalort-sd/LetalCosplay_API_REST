package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.Producto;

public interface IProductoService {

    List<Producto> listar();

    Producto guardar(Producto producto);

    Producto buscarPorId(Integer id);

    Producto actualizar(Integer id, Producto producto);

    void eliminar(Integer id);
}
