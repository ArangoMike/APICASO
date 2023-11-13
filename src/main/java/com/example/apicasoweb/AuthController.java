package com.example.apicasoweb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para el registro de usuario
    @PostMapping("/register")
    public String registerUser(@RequestBody UserM user) {
        userRepository.save(user);
        return "Usuario registrado exitosamente";
    }

    // Método para la autenticación
    @PostMapping("/login")
    public String loginUser(@RequestBody UserM user) {
        UserM existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Autenticación satisfactoria";
        } else {
            return "Error en la autenticación";
        }
    }
}
