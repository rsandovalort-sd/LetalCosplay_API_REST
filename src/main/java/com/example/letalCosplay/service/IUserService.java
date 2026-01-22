package com.example.letalCosplay.service;
import java.util.List;
import java.util.Optional;
import com.example.letalCosplay.model.User;
import com.example.letalCosplay.model.Factura;

public interface IUserService {


    List<User> obtenerTodos();

    Optional<User> buscarPorId(Long id);

    User guardarUser(User User);

    User actualizarUser(Long id, User userActualizado);

    void eliminarUser(Long id);

    User asignarFactura(Long userId, Long facturaId);

    List<Factura> obtenerFacturasPorUser(Long userId);

}
