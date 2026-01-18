package com.example.letalCosplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.letalCosplay.model.DetalleFactura;
import com.example.letalCosplay.repository.DetalleFacturaRepository;

@Service
@Transactional
public class DetalleFacturaServiceImpl implements IDetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> listar() {
        return detalleFacturaRepository.findAll();
    }

    @Override
    public DetalleFactura guardar(DetalleFactura detalleFactura) {
        return detalleFacturaRepository.save(detalleFactura);
    }
}
