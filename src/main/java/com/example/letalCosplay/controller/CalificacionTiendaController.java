package com.example.letalCosplay.controller;


import com.example.letalCosplay.model.CalificacionTienda;
import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.model.User;
import com.example.letalCosplay.repository.IUserRepository;
import com.example.letalCosplay.service.CalificacionTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionTiendaController {

    private CalificacionTiendaService calificacionTiendaService;

    private final IUserRepository userRepository;


    public CalificacionTiendaController(CalificacionTiendaService calificacionTiendaService, IUserRepository userRepository) {
        this.calificacionTiendaService = calificacionTiendaService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity <List<CalificacionTienda>> obtenerTodos(){
        return ResponseEntity.ok(calificacionTiendaService.obtenerTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionTienda> obtenerPorId(@PathVariable Long id){
        return calificacionTiendaService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users/{userId}/calificaciones")
    public ResponseEntity<CalificacionTienda> guardar(@PathVariable Long userId, @RequestBody CalificacionTienda calificacionTienda) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado"));
        calificacionTienda.setUser(user);
        CalificacionTienda saved = calificacionTiendaService.guardar(calificacionTienda);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/users/{userId}/calificaciones/{calificacionId}")
    public ResponseEntity<CalificacionTienda> actualizar(@PathVariable Long userId,
                                                         @PathVariable Long calificacionId,
                                                         @RequestBody CalificacionTienda calificacionActualizada) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado"));

        CalificacionTienda calificacion = calificacionTiendaService.buscarPorId(calificacionId)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));


        calificacion.setNombre(calificacionActualizada.getNombre());
        calificacion.setDescripcion(calificacionActualizada.getDescripcion());
        calificacion.setEstrellas(calificacionActualizada.getEstrellas());

        return ResponseEntity.ok(calificacionTiendaService.guardar(calificacion));
    }

    @DeleteMapping("/users/{userId}/calificaciones/{calificacionId}")
    public ResponseEntity<String> eliminar(@PathVariable Long userId,
                                           @PathVariable Long calificacionId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        calificacionTiendaService.eliminar(calificacionId);
        return ResponseEntity.ok("Calificación eliminada");
    }





}
