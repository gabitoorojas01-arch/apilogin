package com.sena.apilogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.apilogin.model.Usuario;
import com.sena.apilogin.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        System.out.println("Usuario recibido: " + usuario.getUsuario());
        System.out.println("Password recibido: " + usuario.getPassword());

        Usuario user = usuarioRepository
                .findByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword());

        if (user != null) {
            return "Autenticación satisfactoria";
        } else {
            return "Error en la autenticación";
        }
    }
}