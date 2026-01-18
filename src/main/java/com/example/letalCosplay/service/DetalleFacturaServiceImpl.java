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

    public DetalleFacturaServiceImpl(DetalleFacturaRepository detalleFacturaRepository) {
        this.detalleFacturaRepository = detalleFacturaRepository;
    }

    @Override
    public List<DetalleFactura> listarPorFactura(Long facturaId) {
        return detalleFacturaRepository.findByFactura(facturaId);
    }

    @Override
    public DetalleFactura buscarPorId(Long id) {
        return detalleFacturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalles de factura no encontrados"));
    }

    @Override
    public void eliminar(Long id) {
        if (!detalleFacturaRepository.existsById(id)) {
            throw new RuntimeException("Detalle no existe");
        }
        detalleFacturaRepository.deleteById(id);
    }

    @Override
    public DetalleFactura guardar(DetalleFactura detalleFactura) {
        if (detalleFactura.getFactura() == null) {
            throw new RuntimeException("El detalle debe estar asociado a una factura");
        }
        if (detalleFactura.getProducto() == null) {
            throw new RuntimeException("El detalle debe tener un producto");
        }
        return detalleFacturaRepository.save(detalleFactura);
    }
}
