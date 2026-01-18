package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.Factura;

public interface IFacturaService {

    List<Factura> listar();

    Factura guardar(Factura factura);

    Factura buscarPorId(Integer id);
}
