package com.example.letalCosplay.service;

import com.example.letalCosplay.model.Factura;
import com.example.letalCosplay.model.User;
import com.example.letalCosplay.repository.FacturaRepository;
import com.example.letalCosplay.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private final IUserRepository userRepository;
    private final FacturaRepository facturaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository, FacturaRepository facturaRepository) {
        this.userRepository = userRepository;
        this.facturaRepository = facturaRepository;
    }

    // Validar campos obligatorios
    public User registerUser(User user) {
        // Validar campos obligatorios
        if (user.getCorreo() == null || user.getPassword() == null ||
                user.getCorreo() == null || user.getApellido() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }

        // Verificar si el usuario ya existe
        if (userRepository.findByCorreo(user.getCorreo()) != null) {
            throw new RuntimeException("El correo de usuario ya existe");
        }

        User newUser = new User();
        newUser.setNombre(user.getNombre());
        newUser.setApellido(user.getApellido());
        newUser.setTelefono(user.getTelefono());
        newUser.setCorreo(user.getCorreo());
        newUser.setDireccion(user.getDireccion());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRol(user.getRol());

        return userRepository.save(newUser);
    }

    // Métdo de carga de usuario implementado desde UserDetailsService
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        User user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getPassword(), new ArrayList<>());
    }


    @Override
    public List<User> obtenerTodos() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> buscarPorId(Long id) {
        return Optional.of(userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
    }

    @Override
    public User guardarUser(User User) {
        return null;
    }


    @Override
    public User actualizarUser(Long id, User userActualizado) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setNombre(userActualizado.getNombre());
        user.setApellido(userActualizado.getApellido());
        user.setTelefono(userActualizado.getTelefono());
        user.setDireccion(userActualizado.getDireccion());
//        user.setPassword(userActualizado.getPassword());


        return userRepository.save(user);
    }

    @Override
    public void eliminarUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        userRepository.deleteById(id);

    }

    @Override
    public User asignarFactura(Long userId, Long facturaId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Factura factura = facturaRepository.findById(facturaId).orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        factura.setUser(user);

        facturaRepository.save(factura);

        return user;
    }

    @Override
    public List<Factura> obtenerFacturasPorUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return user.getFacturas();
    }
}
