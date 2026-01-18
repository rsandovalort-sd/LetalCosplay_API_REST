package com.example.letalCosplay.service;

import java.util.List;

import com.example.letalCosplay.model.DetalleFactura;

public interface IDetalleFacturaService {

    List<DetalleFactura> listarPorFactura(Long facturaId);

    DetalleFactura buscarPorId(Long id);

    void eliminar(Long id);

    DetalleFactura guardar(DetalleFactura detalleFactura);
}
