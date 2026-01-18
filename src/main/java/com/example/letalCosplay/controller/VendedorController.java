package com.example.letalCosplay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.letalCosplay.model.Vendedor;
import com.example.letalCosplay.service.VendedorServiceImpl;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorServiceImpl vendedorService;

    @GetMapping
    public List<Vendedor> listar() {
        return vendedorService.listar();
    }

    @PostMapping
    public Vendedor guardar(@RequestBody Vendedor vendedor) {
        return vendedorService.guardar(vendedor);
    }
}
