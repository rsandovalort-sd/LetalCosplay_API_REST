package com.example.letalCosplay.controller;

import com.example.letalCosplay.JwtUtil;
import com.example.letalCosplay.dto.UserDto;
import com.example.letalCosplay.model.User;
import com.example.letalCosplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }

    @PostMapping("/loginConDTO")
    public ResponseEntity<String> loginConDTO(@RequestBody UserDto userDto) {
        UserDetails userDetails = userService.loadUserByUsername(userDto.getCorreo());
        if (userDetails != null && passwordEncoder.matches(userDto.getPassword(), userDetails.getPassword())) {
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }

    @GetMapping("/resource")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Este es un recurso protegido!");
    }
}
