// Contiene la lógica de negocio y gestiona la lista en memoria RAM (donde se procesan los métodos de consulta, creación, modificación y eliminación).
package protocolo.HTTPS.demo.service;

import protocolo.HTTPS.demo.model.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    // Lista en memoria RAM que actúa como BD simulada
    private List<Usuario> listaUsuarios = new ArrayList<>();
    private Long contadorId = 1L; // Autoincremental para IDs: 1, 2, 3..

    // 1. OBTENER TODOS LOS USUARIOS (Lógica para GET)
    public List<Usuario> obtenerTodos() {
        return listaUsuarios;
    }

    // 2. CREAR UN NUEVO USUARIO (Lógica para POST)
    public Usuario guardarUsuario(Usuario nuevoUsuario) {
        nuevoUsuario.setId(contadorId++);
        listaUsuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }

    // 3. ACTUALIZAR UN USUARIO EXISTENTE (Lógica para PUT)
    public Usuario actualizarUsuario(Long id, Usuario datosNuevos) {
        Optional<Usuario> usuarioOptional = listaUsuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();

        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();
            usuarioExistente.setNombre(datosNuevos.getNombre());
            usuarioExistente.setCorreo(datosNuevos.getCorreo());
            return usuarioExistente;
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }

    // 4. ELIMINAR UN USUARIO (Lógica para DELETE)
    public String eliminarUsuario(Long id) {
        boolean eliminado = listaUsuarios.removeIf(u -> u.getId().equals(id));
        if (eliminado) {
            return "Usuario con ID " + id + " eliminado exitosamente.";
        } else {
            return "No se encontró el usuario con ID: " + id;
        }
    }
}
