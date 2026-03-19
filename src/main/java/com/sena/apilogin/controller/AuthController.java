package com.sena.apilogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.apilogin.model.Usuario;
import com.sena.apilogin.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 🔐 LOGIN
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

    // 📋 LISTAR USUARIOS
    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // ➕ CREAR USUARIO
    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 🔍 BUSCAR POR ID
    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // ✏️ ACTUALIZAR USUARIO
    @PutMapping("/usuarios/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existente = usuarioRepository.findById(id).orElse(null);

        if (existente != null) {
            existente.setUsuario(usuario.getUsuario());
            existente.setPassword(usuario.getPassword());
            return usuarioRepository.save(existente);
        }
        return null;
    }

    // ❌ ELIMINAR USUARIO
    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado";
    }
}