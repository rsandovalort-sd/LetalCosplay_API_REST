package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.Factura;

public interface IFacturaService {


    List<Factura> listar();

    Factura buscarPorId(Long id);

    Factura guardar(Long userId, Factura factura);

    void eliminar(Long id);
}
