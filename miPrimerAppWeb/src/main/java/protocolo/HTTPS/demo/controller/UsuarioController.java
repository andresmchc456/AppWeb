//Recibe las peticiones HTTP del protocolo (GET, POST, PUT, DELETE) y llama al servicio para obtener la respuesta.
package protocolo.HTTPS.demo.controller;

import protocolo.HTTPS.demo.model.Usuario;
import protocolo.HTTPS.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // Ruta base: http://localhost:8080/api/usuarios
public class UsuarioController {

    // Inyectar de servicios y dependencias
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // 1. GET: Consultar/obtener todos los usuarios
    // Petición: GET http://localhost:8080/api/usuarios
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    // 2. POST: Crear un nuevo usuario
    // Petición: POST http://localhost:8080/api/usuarios
    @PostMapping
    public Usuario creacionUsuario(@RequestBody Usuario nuevoUsuario) {
        return usuarioService.guardarUsuario(nuevoUsuario);
    }

    // 3. PUT: Actualizar un usuario existente por ID
    // Petición: PUT http://localhost:8080/api/usuarios/1
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        return usuarioService.actualizarUsuario(id, usuarioActualizado);
    }

    // 4. DELETE: Eliminar un usuario por ID
    // Petición: DELETE http://localhost:8080/api/usuarios/1
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        return usuarioService.eliminarUsuario(id);
    }
}