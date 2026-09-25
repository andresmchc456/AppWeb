package edu.ucaldas.miPrimerAppWeb;

import edu.ucaldas.miPrimerAppWeb.modelo.Estudiante;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController("api")
public class EstudianteService {

    private List<Estudiante> estudiantes = new ArrayList<>(Arrays.asList(
        new Estudiante(1L, "JUAN FELIPE", "ARIAS VALENCIA", "juan.arias55366@ucaldas.edu.co", "Ingenieria en informatica", "8"),
        new Estudiante(2L,"ESTIVEN", "BELTRAN ARIAS", "estiven.beltran61776@ucaldas.edu.co", "Ingenieria en informatica", "8"),
            new Estudiante(3L,"Maria Cristina", "Buitrago Acuña", "maria.buitrago39157@ucaldas.edu.co", "Ingenieria en informatica", "8"),
        new Estudiante(4L, "SANTIAGO", "CARDONA BERNAL", "santiago.cardona56652@ucaldas.edu.co", "Ingenieria en informatica", "8")
    ));

    @GetMapping("/estudiantes")
    public List<Estudiante> estudiantes() {
        return this.estudiantes;
    }

    @PostMapping("/estudiantes")
    public List<Estudiante> hello() {
        return this.estudiantes;
    }


}
