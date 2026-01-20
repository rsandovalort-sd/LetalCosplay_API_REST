package com.example.letalCosplay.service;

import com.example.letalCosplay.model.User;
import com.example.letalCosplay.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //    public User registerUser(User user) {
//        User userLogin = new User();
//        userLogin.setUsername(user.getUsername());
//        userLogin.setPassword(passwordEncoder.encode(user.getPassword()));
//        // Encriptar la contraseña
//        return userRepository.save(userLogin);
//    }
    // Validar campos obligatorios
    public User registerUser(User user) {
        // Validar campos obligatorios
        if (user.getNombre() == null || user.getPassword() == null ||
                user.getNombre() == null || user.getApellido() == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }

        // Verificar si el usuario ya existe
        if (userRepository.findByUsername(user.getNombre()) != null) {
            throw new RuntimeException("El nombre de usuario ya existe");
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getPassword(), new ArrayList<>());
    }


}
