//package com.example.letalCosplay.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.letalCosplay.model.Vendedor;
//import com.example.letalCosplay.service.VendedorServiceImpl;
//
//@RestController
//@RequestMapping("/vendedores")
//public class VendedorController {
//
//    @Autowired
//    private VendedorServiceImpl vendedorService;
//
//    public VendedorController(VendedorServiceImpl vendedorService) {
//        this.vendedorService = vendedorService;
//    }
//
//    @GetMapping
//    public List<Vendedor> listar() {
//        return vendedorService.listar();
//    }
//
//    @PostMapping ("/crear")
//    public Vendedor guardar(@RequestBody Vendedor vendedor) {
//        return vendedorService.guardar(vendedor);
//    }
//
//    @GetMapping("/{id}")
//    public Vendedor buscarPorId(@PathVariable Long id) {
//        return vendedorService.buscarPorId(id);
//    }
//
//    @PutMapping("/actualizar/{id}")
//    public Vendedor actualizar(
//            @PathVariable Long id,
//            @RequestBody Vendedor vendedor) {
//        return vendedorService.actualizar(id, vendedor);
//    }
//
//    @DeleteMapping("/eliminar/{id}")
//    public void eliminar(@PathVariable Long id) {
//        vendedorService.eliminar(id);
//    }
//}
