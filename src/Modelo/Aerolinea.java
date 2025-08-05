package Modelo;
/**
 * POJO para la entidad Aerolinea.
 * Representa la estructura de la tabla 'aerolineas'.
 */
public class Aerolinea {
    private int id;
    private String nombre;

    public Aerolinea() {}

    public Aerolinea(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
