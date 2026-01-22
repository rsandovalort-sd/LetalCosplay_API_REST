//package com.example.letalCosplay.service;
//import java.util.List;
//import java.util.Optional;
//
//import com.example.letalCosplay.model.Factura;
//import com.example.letalCosplay.repository.FacturaRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.letalCosplay.model.Cliente;
//import com.example.letalCosplay.repository.ClienteRepository;
//
//@Service
//@Transactional
//public class ClienteServiceImpl implements IClienteService {
//
//    private final ClienteRepository clienteRepository;
//    private final FacturaRepository facturaRepository;
//
//    public ClienteServiceImpl(ClienteRepository clienteRepository, FacturaRepository facturaRepository) {
//        this.clienteRepository = clienteRepository;
//        this.facturaRepository = facturaRepository;
//    }
//
//    @Override
//    public List<Cliente> obtenerTodos() {
//        return clienteRepository.findAll();
//    }
//
//    @Override
//    public Cliente guardarCliente(Cliente cliente) {
//        return clienteRepository.save(cliente);
//    }
//
//    @Override
//    public Cliente asignarFactura(Long clienteId, Long facturaId) {
//        Cliente cliente = clienteRepository.findById(clienteId)
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
//
//        Factura factura = facturaRepository.findById(facturaId)
//                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
//
//        factura.setCliente(cliente);
//
//        facturaRepository.save(factura);
//
//        return cliente;
//    }
//
//    @Override
//    public Optional<Cliente> buscarPorId(Long id) {
//        return Optional.ofNullable(clienteRepository.findById(id).orElse(null));
//    }
//
//    @Override
//    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
//
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
//
//        cliente.setNombre(clienteActualizado.getNombre());
//        cliente.setCorreo(clienteActualizado.getCorreo());
//        cliente.setTelefono(clienteActualizado.getTelefono());
//
//        return clienteRepository.save(cliente);
//    }
//
//    @Override
//    public void eliminarCliente(Long id) {
//        if (!clienteRepository.existsById(id)) {
//            throw new RuntimeException("Cliente no encontrado");
//        }
//        clienteRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Factura> obtenerFacturasPorCliente(Long clienteId) {
//
//        Cliente cliente = clienteRepository.findById(clienteId)
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
//
//        return cliente.getFacturas();
//    }
//
//
//}
