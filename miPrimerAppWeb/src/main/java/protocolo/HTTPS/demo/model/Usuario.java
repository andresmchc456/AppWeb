//Es la clase entidad que define la estructura del usuario (id, nombre, correo).

package protocolo.HTTPS.demo.model;

public class Usuario {
    private Long id;
    private String nombre;
    private String correo;

    // Constructor vacío (requerido por Spring Boot para convertir JSON a Java)
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(Long id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
