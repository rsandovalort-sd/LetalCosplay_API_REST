package com.example.letalCosplay.controller;


import com.example.letalCosplay.model.CalificacionTienda;
import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.model.User;
import com.example.letalCosplay.service.ICalificacionTiendaService;
import com.example.letalCosplay.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final IUserService userService;
    private final ICalificacionTiendaService calificacionTiendaService;

    public UserController(IUserService userService, ICalificacionTiendaService calificacionTiendaService) {
        this.userService = userService;
        this.calificacionTiendaService = calificacionTiendaService;
    }

    @GetMapping
    public ResponseEntity<List<User>> obtenerTodos(){
        return ResponseEntity.ok(userService.obtenerTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> obtenerPorId(@PathVariable Long id) {
        return userService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping("/crear")
//    public ResponseEntity<User> crearCliente(@RequestBody User user) {
//        User nuevoUser = userService.guardarUser(user);
//        return new ResponseEntity<>(nuevoUser, HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<User> actualizarUser(@PathVariable Long id, @RequestBody User user) {

        User userActualizado = userService.actualizarUser(id, user);
        return ResponseEntity.ok(userActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUser(@PathVariable Long id) {
        userService.eliminarUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/calificaciones")
    public ResponseEntity<CalificacionTienda> guardarCalificacion(
            @PathVariable Long userId,
            @RequestBody CalificacionTienda calificacion) {
        User user = userService.buscarPorId(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado"));
        calificacion.setUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(calificacionTiendaService.guardar(calificacion));
    }

    @GetMapping("/{userId}/calificaciones")
    public ResponseEntity<Optional<CalificacionTienda>> listarCalificaciones(@PathVariable Long userId) {
        Optional<CalificacionTienda> calificaciones = calificacionTiendaService.buscarPorId(userId);
        return ResponseEntity.ok(calificaciones);
    }

    @DeleteMapping("/{userId}/calificaciones/{calificacionId}")
    public ResponseEntity<String> eliminarCalificacion(@PathVariable Long userId,
                                                       @PathVariable Long calificacionId) {
        calificacionTiendaService.eliminar(calificacionId);
        return ResponseEntity.ok("Calificación eliminada");
    }

    @PostMapping("/{userId}/facturas/{facturaId}")
    public ResponseEntity<User> asignarFactura(
            @PathVariable Long userId,
            @PathVariable Long facturaId) {

        User user = userService.asignarFactura(userId, facturaId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/facturas")
    public ResponseEntity<List<Factura>> obtenerFacturasPorCliente(
            @PathVariable Long userId) {

        List<Factura> facturas = userService.obtenerFacturasPorUser(userId);
        return ResponseEntity.ok(facturas);
    }
}
