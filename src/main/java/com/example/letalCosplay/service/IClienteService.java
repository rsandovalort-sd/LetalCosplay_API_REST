package com.example.letalCosplay.service;

import java.util.List;
import java.util.Optional;

import com.example.letalCosplay.model.Cliente;
import com.example.letalCosplay.model.Factura;

public interface IClienteService {

    List<Cliente> obtenerTodos();

    Optional<Cliente> buscarPorId(Long id);

    Cliente guardarCliente(Cliente cliente);

    Cliente asignarFactura(Long clienteId, Long facturaId);

    Cliente actualizarCliente(Long id, Cliente clienteActualizado);

    void eliminarCliente(Long id);

    List<Factura> obtenerFacturasPorCliente(Long clienteId);
}
