package com.example.letalCosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.letalCosplay.model.DetalleFactura;
import com.example.letalCosplay.service.DetalleFacturaServiceImpl;

@RestController
@RequestMapping("/detalles-factura")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaServiceImpl detalleFacturaService;

    @GetMapping("/factura/{facturaId}")
    public List<DetalleFactura> listarPorFactura(@PathVariable Long facturaId) {
        return detalleFacturaService.listarPorFactura(facturaId);
    }

    @GetMapping("/{id}")
    public DetalleFactura buscarPorId(@PathVariable Long id) {
        return detalleFacturaService.buscarPorId(id);
    }

    @PostMapping("/crear")
    public DetalleFactura guardar(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.guardar(detalleFactura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detalleFacturaService.eliminar(id);
    }
}
