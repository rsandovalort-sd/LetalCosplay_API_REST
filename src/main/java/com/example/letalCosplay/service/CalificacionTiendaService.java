package com.example.letalCosplay.service;

import com.example.letalCosplay.model.CalificacionTienda;
import com.example.letalCosplay.model.Producto;
import com.example.letalCosplay.repository.CalificacionTiendaRepository;
import com.example.letalCosplay.repository.IUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CalificacionTiendaService implements ICalificacionTiendaService{

    private final CalificacionTiendaRepository calificacionTiendaRepository;
    private final IUserRepository userRepository;

    public CalificacionTiendaService(CalificacionTiendaRepository calificacionTiendaRepository, IUserRepository userRepository) {
        this.calificacionTiendaRepository = calificacionTiendaRepository;
        this.userRepository = userRepository;
    }


//    @Override
//    public List<CalificacionTienda> listarPorCalificacion(Long calificacionId) {
//        return calificacionTiendaRepository.findAll();
//    }

    @Override
    public List<CalificacionTienda> obtenerTodos() {
        return calificacionTiendaRepository.findAll();
    }

    @Override
    public Optional<CalificacionTienda> buscarPorId(Long id) {
        return Optional.of(calificacionTiendaRepository.findById(id).orElseThrow(() -> new RuntimeException("Calificacion no encontrada")));

    }

    @Override
    public CalificacionTienda guardar(CalificacionTienda calificacionTienda) {
        return calificacionTiendaRepository.save(calificacionTienda);
    }

    @Override
    public CalificacionTienda actualizar(Long calificacionId, CalificacionTienda calificacionTienda) {
        CalificacionTienda calificacionNueva = calificacionTiendaRepository
                .findById(calificacionId)
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));

        calificacionNueva.setNombre(calificacionTienda.getNombre());
        calificacionNueva.setDescripcion(calificacionTienda.getDescripcion());
        calificacionNueva.setEstrellas(calificacionTienda.getEstrellas());

        return calificacionTiendaRepository.save(calificacionNueva);
    }

    public List<CalificacionTienda> listarPorUsuario(Long userId) {
        return calificacionTiendaRepository.findByUserId(userId);
    }

    @Override
    public void eliminar(Long id) {
        if (!calificacionTiendaRepository.existsById(id)) {
            throw new RuntimeException("Calificación no existe");
        }
        calificacionTiendaRepository.deleteById(id);

    }


}
