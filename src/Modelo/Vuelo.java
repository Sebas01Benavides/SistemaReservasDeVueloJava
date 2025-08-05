package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * POJO para la entidad Vuelo.
 * Representa la estructura de la tabla 'vuelos'.
 */
public class Vuelo {
    private int id;
    private int idAerolinea;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private int capacidadTotal;
    private int espacioDisponible;
    private double precio;

    public Vuelo() {}

    public Vuelo(int id, int idAerolinea, String origen, String destino, LocalDate fecha, LocalTime hora, int capacidadTotal, int espacioDisponible, double precio) {
        this.id = id;
        this.idAerolinea = idAerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidadTotal = capacidadTotal;
        this.espacioDisponible = espacioDisponible;
        this.precio = precio;
    }

    // Getters y Setters de forma explícita
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdAerolinea() {
        return this.idAerolinea;
    }
    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }
    public String getOrigen() {
        return this.origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return this.destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public LocalDate getFecha() {
        return this.fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public LocalTime getHora() {
        return this.hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    public int getCapacidadTotal() {
        return this.capacidadTotal;
    }
    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }
    public int getEspacioDisponible() {
        return this.espacioDisponible;
    }
    public void setEspacioDisponible(int espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }
    public double getPrecio() {
        return this.precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
