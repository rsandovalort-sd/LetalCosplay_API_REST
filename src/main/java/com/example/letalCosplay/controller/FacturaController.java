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

    public FacturaController(FacturaServiceImpl facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listar() {
        return facturaService.listar();
    }

    @GetMapping("/{id}")
    public Factura buscarPorId(@PathVariable Long id) {
        return facturaService.buscarPorId(id);
    }

    @PostMapping("/crear/{userId}")
    public Factura guardar(
            @PathVariable Long userId,
            @RequestBody Factura factura) {

        return facturaService.guardar(userId, factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
    }
}
