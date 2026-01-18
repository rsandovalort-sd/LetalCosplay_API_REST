package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.DetalleFactura;

public interface IDetalleFacturaService {

    List<DetalleFactura> listar();

    DetalleFactura guardar(DetalleFactura detalleFactura);
}
