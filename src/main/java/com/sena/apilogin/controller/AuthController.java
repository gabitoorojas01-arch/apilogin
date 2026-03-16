package com.sena.apilogin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        if (usuario.getUsuario().equals("admin") && usuario.getPassword().equals("1234")) {
            return "Autenticación satisfactoria";
        } else {
            return "Error en la autenticación";
        }

    }

}