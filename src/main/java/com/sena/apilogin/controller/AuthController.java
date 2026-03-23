package com.sena.apilogin.controller;

import com.sena.apilogin.model.Usuario;
import com.sena.apilogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioRepository repo;

    // 🔹 LISTAR
    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    // 🔹 BUSCAR
    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {

        Optional<Usuario> usuario = repo.findById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(404).body("❌ Usuario no encontrado");
        }
    }

    // 🔹 CREAR
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Usuario usuario) {

        Optional<Usuario> existe = repo.findByUsuario(usuario.getUsuario());

        if (existe.isPresent()) {
            return ResponseEntity.badRequest().body("❌ Usuario ya existe");
        }

        repo.save(usuario);
        return ResponseEntity.ok("✅ Usuario creado");
    }

    // 🔹 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario datos) {

        Optional<Usuario> usuario = repo.findByUsuario(datos.getUsuario());

        if (usuario.isPresent()) {

            if (usuario.get().getPassword().equals(datos.getPassword())) {
                return ResponseEntity.ok("✅ Login exitoso");
            } else {
                return ResponseEntity.status(401).body("❌ Contraseña incorrecta");
            }

        } else {
            return ResponseEntity.status(404).body("❌ Usuario no existe");
        }
    }

    // 🔹 ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Usuario datos) {

        Optional<Usuario> usuario = repo.findById(id);

        if (usuario.isPresent()) {

            Usuario u = usuario.get();

            Optional<Usuario> existe = repo.findByUsuario(datos.getUsuario());

            if (existe.isPresent() && !existe.get().getId().equals(id)) {
                return ResponseEntity.badRequest().body("❌ El usuario ya está en uso");
            }

            u.setUsuario(datos.getUsuario());
            u.setPassword(datos.getPassword());

            repo.save(u);

            return ResponseEntity.ok("✅ Usuario actualizado");

        } else {
            return ResponseEntity.status(404).body("❌ Usuario no encontrado");
        }
    }

    // 🔹 ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("❌ Usuario no existe");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("✅ Usuario eliminado");
    }
}