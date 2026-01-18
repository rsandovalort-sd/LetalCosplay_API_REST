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
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor buscarPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor actualizar(Integer id, Proveedor proveedor) {
        proveedor.setIdProveedor(id);
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void eliminar(Integer id) {
        proveedorRepository.deleteById(id);
    }
}
