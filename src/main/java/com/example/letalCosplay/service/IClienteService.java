package com.example.letalCosplay.service;

import java.util.List;
import java.util.Optional;

import com.example.letalCosplay.model.Cliente;

public interface IClienteService {

    List<Cliente> obtenerTodos();

    Optional<Cliente> buscarPorId(Long id);

    Cliente guardarCliente(Cliente cliente);

    Cliente asignarFactura(Long clienteId, Long facturaId);

}
