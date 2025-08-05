package dao;

import modelo.Vuelo;
import util.Config;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para la entidad Vuelo.
 * Contiene la lógica para interactuar con la tabla 'vuelos'.
 */
public class VueloDAO {

    /**
     * Inserta un nuevo vuelo en la base de datos.
     * @param vuelo el objeto Vuelo a insertar.
     */
    public void agregarVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (id_aerolinea, origen, destino, fecha, hora, capacidad_total, espacio_disponible, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vuelo.getIdAerolinea());
            stmt.setString(2, vuelo.getOrigen());
            stmt.setString(3, vuelo.getDestino());
            stmt.setDate(4, Date.valueOf(vuelo.getFecha()));
            stmt.setTime(5, Time.valueOf(vuelo.getHora()));
            stmt.setInt(6, vuelo.getCapacidadTotal());
            stmt.setInt(7, vuelo.getEspacioDisponible());
            stmt.setDouble(8, vuelo.getPrecio());
            stmt.executeUpdate();
            System.out.println("Vuelo agregado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar vuelo: " + e.getMessage());
        }
    }

    /**
     * Obtiene todos los vuelos de la base de datos.
     * @return una lista de objetos Vuelo.
     */
    public List<Vuelo> obtenerTodosLosVuelos() {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT * FROM vuelos";
        try (Connection conn = Config.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setId(rs.getInt("id"));
                vuelo.setIdAerolinea(rs.getInt("id_aerolinea"));
                vuelo.setOrigen(rs.getString("origen"));
                vuelo.setDestino(rs.getString("destino"));
                vuelo.setFecha(rs.getDate("fecha").toLocalDate());
                vuelo.setHora(rs.getTime("hora").toLocalTime());
                vuelo.setCapacidadTotal(rs.getInt("capacidad_total"));
                vuelo.setEspacioDisponible(rs.getInt("espacio_disponible"));
                vuelo.setPrecio(rs.getDouble("precio"));
                vuelos.add(vuelo);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener vuelos: " + e.getMessage());
        }
        return vuelos;
    }
    
    /**
     * Actualiza la información de un vuelo existente.
     * @param vuelo el objeto Vuelo con los datos actualizados.
     */
    public void actualizarVuelo(Vuelo vuelo) {
        String sql = "UPDATE vuelos SET id_aerolinea = ?, origen = ?, destino = ?, fecha = ?, hora = ?, capacidad_total = ?, espacio_disponible = ?, precio = ? WHERE id = ?";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, vuelo.getIdAerolinea());
            stmt.setString(2, vuelo.getOrigen());
            stmt.setString(3, vuelo.getDestino());
            stmt.setDate(4, Date.valueOf(vuelo.getFecha()));
            stmt.setTime(5, Time.valueOf(vuelo.getHora()));
            stmt.setInt(6, vuelo.getCapacidadTotal());
            stmt.setInt(7, vuelo.getEspacioDisponible());
            stmt.setDouble(8, vuelo.getPrecio());
            stmt.setInt(9, vuelo.getId());
            stmt.executeUpdate();
            System.out.println("Vuelo actualizado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar vuelo: " + e.getMessage());
        }
    }

    /**
     * Elimina un vuelo de la base de datos.
     * @param id el ID del vuelo a eliminar.
     */
    public void eliminarVuelo(int id) {
        String sql = "DELETE FROM vuelos WHERE id = ?";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Vuelo eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar vuelo: " + e.getMessage());
        }
    }
}
