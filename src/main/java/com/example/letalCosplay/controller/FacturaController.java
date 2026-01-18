package com.example.letalCosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Factura buscarPorId(@PathVariable Integer id) {
        return facturaService.buscarPorId(id);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return facturaService.guardar(factura);
    }
}
