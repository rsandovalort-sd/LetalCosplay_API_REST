package com.example.letalCosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.letalCosplay.model.DetalleFactura;
import com.example.letalCosplay.service.DetalleFacturaServiceImpl;

@RestController
@RequestMapping("/detalles-factura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaServiceImpl detalleFacturaService;

    @GetMapping
    public List<DetalleFactura> listar() {
        return detalleFacturaService.listar();
    }

    @PostMapping
    public DetalleFactura guardar(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.guardar(detalleFactura);
    }
}
