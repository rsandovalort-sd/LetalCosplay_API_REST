package com.example.letalCosplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.repository.FacturaRepository;

@Service
@Transactional
public class FacturaServiceImpl implements IFacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listar() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura guardar(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura buscarPorId(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }
}
