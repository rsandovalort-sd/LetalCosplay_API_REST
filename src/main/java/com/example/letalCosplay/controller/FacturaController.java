package com.example.letalCosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.service.FacturaServiceImpl;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;


    @GetMapping
    public List<Factura> listar() {
        return facturaService.listar();
    }

    @GetMapping("/{id}")
    public Factura buscarPorId(@PathVariable Long id) {
        return facturaService.buscarPorId(id);
    }

    @PostMapping("/crear/{clienteId}/{vendedorId}")
    public Factura guardar(
            @PathVariable Long clienteId,
            @PathVariable Long vendedorId,
            @RequestBody Factura factura) {

        return facturaService.guardar(clienteId, vendedorId, factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
    }
}
