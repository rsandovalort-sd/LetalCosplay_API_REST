//package com.example.letalCosplay.service;
//
//import com.example.letalCosplay.model.Vendedor;
//import com.example.letalCosplay.repository.VendedorRepository;
//import com.example.letalCosplay.service.IVendedorService;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class VendedorServiceImpl implements IVendedorService {
//
//    private final VendedorRepository vendedorRepository;
//
//    public VendedorServiceImpl(VendedorRepository vendedorRepository) {
//        this.vendedorRepository = vendedorRepository;
//    }
//
//    @Override
//    public List<Vendedor> listar() {
//        return vendedorRepository.findAll();
//    }
//
//    @Override
//    public Vendedor guardar(Vendedor vendedor) {
//
//        if (vendedor.getNombre() == null) {
//            throw new RuntimeException("El nombre del vendedor es obligatorio");
//        }
//
//        if (vendedor.getCorreo() == null) {
//            throw new RuntimeException("El correo es obligatorio");
//        }
//
//        return vendedorRepository.save(vendedor);
//    }
//
//    @Override
//    public Vendedor buscarPorId(Long id) {
//        return vendedorRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
//    }
//
//    @Override
//    public Vendedor actualizar(Long id, Vendedor vendedor) {
//
//        Vendedor vendedorExistente = buscarPorId(id);
//
//        vendedorExistente.setNombre(vendedor.getNombre());
//        vendedorExistente.setNit(vendedor.getNit());
//        vendedorExistente.setTelefono(vendedor.getTelefono());
//        vendedorExistente.setDireccion(vendedor.getDireccion());
//        vendedorExistente.setCorreo(vendedor.getCorreo());
//
//        return vendedorRepository.save(vendedorExistente);
//    }
//
//    @Override
//    public void eliminar(Long id) {
//        Vendedor vendedor = buscarPorId(id);
//        vendedorRepository.delete(vendedor);
//    }
//}
