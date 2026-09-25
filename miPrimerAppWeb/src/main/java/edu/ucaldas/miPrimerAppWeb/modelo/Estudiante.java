//Es la clase entidad que define la estructura del estudiante (id, nombre, apellido, correo, programa, semestre).

package edu.ucaldas.miPrimerAppWeb.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Estudiante {

    private Long id;
    private String nombre;
    private String apellido;

    @JsonProperty("email")
    private String correo;

    private String programa;
    private String semestre;

    // Constructor vacío
    public Estudiante() {
    }

    // Constructor con todos los campos
    public Estudiante(Long id, String nombre, String apellido, String correo, String programa, String semestre) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.programa = programa;
        this.semestre = semestre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
