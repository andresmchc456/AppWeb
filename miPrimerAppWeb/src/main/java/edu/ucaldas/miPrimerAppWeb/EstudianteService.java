//Recibe las peticiones HTTP del protocolo (GET, POST, PUT, DELETE) y llama al servicio para obtener la respuesta.

package edu.ucaldas.miPrimerAppWeb;

import edu.ucaldas.miPrimerAppWeb.modelo.Estudiante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>(Arrays.asList(
            new Estudiante(1L, "JUAN FELIPE", "ARIAS VALENCIA", "juan.arias55366@ucaldas.edu.co",
                    "Ingenieria en informatica", "8"),
            new Estudiante(2L, "ESTIVEN", "BELTRAN ARIAS", "estiven.beltran61776@ucaldas.edu.co",
                    "Ingenieria en informatica", "8"),
            new Estudiante(3L, "Maria Cristina", "Buitrago Acuña", "maria.buitrago39157@ucaldas.edu.co",
                    "Ingenieria en informatica", "8"),
            new Estudiante(4L, "SANTIAGO", "CARDONA BERNAL", "santiago.cardona56652@ucaldas.edu.co",
                    "Ingenieria en informatica", "8")));

    private Long contadorId = 5L;

    // 1. GET: Obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return this.estudiantes;
    }

    // 2. GET BY ID: Obtener un estudiante por ID
    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable Long id) {
        return estudiantes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // 3. POST: Crear nuevo estudiante
    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante nuevoEstudiante) {
        nuevoEstudiante.setId(contadorId++);
        this.estudiantes.add(nuevoEstudiante);
        return nuevoEstudiante;
    }

    // 4. PUT: Actualizar estudiante por ID
    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante datosNuevos) {
        Optional<Estudiante> opt = estudiantes.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        if (opt.isPresent()) {
            Estudiante e = opt.get();
            e.setNombre(datosNuevos.getNombre());
            e.setApellido(datosNuevos.getApellido());
            if (datosNuevos.getCorreo() != null) {
                e.setCorreo(datosNuevos.getCorreo());
            }
            e.setPrograma(datosNuevos.getPrograma());
            e.setSemestre(datosNuevos.getSemestre());
            return e;
        }
        return null;
    }

    // 5. DELETE: Eliminar estudiante por ID
    @DeleteMapping("/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        boolean eliminado = estudiantes.removeIf(e -> e.getId().equals(id));
        if (eliminado) {
            return "Estudiante eliminado exitosamente.";
        }
        return "Estudiante no encontrado.";
    }
}
