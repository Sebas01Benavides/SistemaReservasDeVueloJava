package modelo;

import java.sql.Timestamp;

/**
 * POJO para la entidad Reserva.
 * Representa la estructura de la tabla 'reservas'.
 */
public class Reserva {
    private int id;
    private int idUsuario;
    private int idVuelo;
    private Timestamp fechaReserva;
    private String estado;

    public Reserva() {}

    public Reserva(int id, int idUsuario, int idVuelo, Timestamp fechaReserva, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.fechaReserva = fechaReserva;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIdUsuario() {
        return this.idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdVuelo() {
        return this.idVuelo;
    }
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
    public Timestamp getFechaReserva() {
        return this.fechaReserva;
    }
    public void setFechaReserva(Timestamp fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    public String getEstado() {
        return this.estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
