package com.example.letalCosplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.letalCosplay.model.Proveedor;
import com.example.letalCosplay.repository.ProveedorRepository;

@Service
@Transactional
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private final ProveedorRepository proveedorRepository;

    public ProveedorServiceImpl(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        if (proveedor.getNombre() == null) {
            throw new RuntimeException("El nombre del proveedor es obligatorio");
        }
        if (proveedor.getNit() == null) {
            throw new RuntimeException("El NIT es obligatorio");
        }

        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor buscarPorId(Long id) {
        return proveedorRepository.findById((id)).orElse(null);
    }

    @Override
    public Proveedor actualizar(Long id, Proveedor proveedor) {
        Proveedor proveedorExistente = buscarPorId(id);
        proveedorExistente.setNombre(proveedor.getNombre());
        proveedorExistente.setNit(proveedor.getNit());
        return proveedorRepository.save(proveedorExistente);
    }

    @Override
    public void eliminar(Long id) {
        proveedorRepository.deleteById((id));
    }
}
