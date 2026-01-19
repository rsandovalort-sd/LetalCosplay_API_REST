package com.example.letalCosplay.model;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigInteger telefono;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(BigInteger telefono, String email, String password) {
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getTelefono() {
        return telefono;
    }

    public void setTelefono(BigInteger telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
