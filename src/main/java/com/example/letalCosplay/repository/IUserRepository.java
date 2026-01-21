package com.example.letalCosplay.repository;

import com.example.letalCosplay.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByCorreo(String correo);
}
