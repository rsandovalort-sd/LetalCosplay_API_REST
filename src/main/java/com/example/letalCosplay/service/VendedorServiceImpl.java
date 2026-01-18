package com.example.letalCosplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.letalCosplay.model.Vendedor;
import com.example.letalCosplay.repository.VendedorRepository;

@Service
@Transactional
public class VendedorServiceImpl implements IVendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Override
    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    @Override
    public Vendedor guardar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }
}
