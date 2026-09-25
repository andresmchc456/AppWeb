package edu.ucaldas.miPrimerAppWeb.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Estudiante {

    private Long id;

    private String nombre;

    private String apellido;

    private String correo;

    private String programa;

    private String semestre;
}
