package com.example.letalCosplay.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;


    private LocalDate fecha;
    private BigDecimal valorEnvio;

    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles;

    // getters y setters


    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(BigDecimal valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public BigDecimal getTotal(BigDecimal total) {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
