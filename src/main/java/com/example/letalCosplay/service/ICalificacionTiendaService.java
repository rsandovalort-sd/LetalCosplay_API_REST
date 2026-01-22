package com.example.letalCosplay.service;

import com.example.letalCosplay.model.CalificacionTienda;
import com.example.letalCosplay.model.DetalleFactura;
import com.example.letalCosplay.model.Producto;
import com.example.letalCosplay.model.User;

import java.util.List;
import java.util.Optional;

public interface ICalificacionTiendaService {

//    List<CalificacionTienda> listarPorCalificacion(Long calificacionId);

    List<CalificacionTienda> obtenerTodos();

    Optional<CalificacionTienda> buscarPorId(Long id);

    void eliminar(Long id);

    CalificacionTienda actualizar(Long id, CalificacionTienda calificacionTienda);

    CalificacionTienda guardar(CalificacionTienda calificacionTienda);


}
