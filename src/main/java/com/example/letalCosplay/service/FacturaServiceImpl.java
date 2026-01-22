package com.example.letalCosplay.service;

import com.example.letalCosplay.model.*;
import com.example.letalCosplay.repository.IUserRepository;
import com.example.letalCosplay.repository.FacturaRepository;
import com.example.letalCosplay.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class FacturaServiceImpl implements IFacturaService {

    private final FacturaRepository facturaRepository;
    private final IUserRepository userRepository;
    private final ProductoRepository productoRepository;

    public FacturaServiceImpl(
            FacturaRepository facturaRepository,
            IUserRepository userRepository,
            ProductoRepository productoRepository
    ) {
        this.facturaRepository = facturaRepository;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Factura> listar() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura buscarPorId(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public Factura guardar(Long userId, Factura factura) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        factura.setUser(user);
        factura.setFecha(LocalDate.now());

        if (factura.getDetalles() == null) {
            throw new RuntimeException("La factura debe tener al menos un detalle");
        }

        BigDecimal total = new BigDecimal("0");

        for (DetalleFactura detalle : factura.getDetalles()) {

            Producto producto = productoRepository.findById(
                    detalle.getProducto().getIdProducto()
            ).orElseThrow(() -> new RuntimeException("Producto no existe"));

            if (producto.getStock() < detalle.getCantidadVendida()) {
                throw new RuntimeException(
                        "No hay stock del producto: " + producto.getNombre()
                );
            }
            producto.setStock(
                    producto.getStock() - detalle.getCantidadVendida()
            );

            detalle.setFactura(factura);
            detalle.setProducto(producto);
            detalle.setPrecioUnitario(producto.getPrecio_compra());

            BigDecimal subtotal = detalle.getPrecioUnitario()
                    .multiply(BigDecimal.valueOf(detalle.getCantidadVendida()));

            total = total.add(subtotal);
        }

        if (factura.getValorEnvio() != null) {
            total = total.add(factura.getValorEnvio());
        }

        factura.setTotal(total);

        return facturaRepository.save(factura);
    }

    @Override
    public void eliminar(Long id) {
        if (!facturaRepository.existsById(id)) {
            throw new RuntimeException("Factura no encontrada");
        }
        facturaRepository.deleteById(id);
    }
}
