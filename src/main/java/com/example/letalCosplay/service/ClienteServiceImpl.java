package com.example.letalCosplay.service;
import java.util.List;
import java.util.Optional;

import com.example.letalCosplay.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.letalCosplay.model.Cliente;
import com.example.letalCosplay.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private FacturaRepository facturaRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository, FacturaRepository facturaRepository) {
        this.clienteRepository = clienteRepository;
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return List.of();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente asignarFactura(Long clienteId, Long facturaId) {
        return null;
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return Optional.ofNullable(clienteRepository.findById(id).orElse(null));
    }
}
