package com.example.letalCosplay.controller;

import com.example.letalCosplay.model.Cliente;
import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.service.IClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodos() {
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable Long id,
            @RequestBody Cliente cliente) {

        Cliente clienteAtualizado = clienteService.actualizarCliente(id, cliente);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{clienteId}/facturas/{facturaId}")
    public ResponseEntity<Cliente> asignarFactura(
            @PathVariable Long clienteId,
            @PathVariable Long facturaId) {

        Cliente cliente = clienteService.asignarFactura(clienteId, facturaId);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{clienteId}/facturas")
    public ResponseEntity<List<Factura>> obtenerFacturasPorCliente(
            @PathVariable Long clienteId) {

        List<Factura> facturas = clienteService.obtenerFacturasPorCliente(clienteId);
        return ResponseEntity.ok(facturas);
    }
}

