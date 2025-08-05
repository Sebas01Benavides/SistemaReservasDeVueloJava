package dao;

import modelo.Reserva;
import util.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para la entidad Reserva.
 * Contiene la lógica para interactuar con la tabla 'reservas'.
 */
public class ReservaDAO {

    /**
     * Inserta una nueva reserva en la base de datos.
     * @param reserva el objeto Reserva a insertar.
     */
    public void agregarReserva(Reserva reserva) {
        String sql = "INSERT INTO reservas (id_usuario, id_vuelo, estado) VALUES (?, ?, ?)";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, reserva.getIdUsuario());
            stmt.setInt(2, reserva.getIdVuelo());
            stmt.setString(3, reserva.getEstado());
            stmt.executeUpdate();

            // Opcional: Obtener el ID generado de la reserva
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reserva.setId(generatedKeys.getInt(1));
                }
            }
            System.out.println("Reserva agregada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar reserva: " + e.getMessage());
        }
    }
    
    /**
     * Obtiene todas las reservas de la base de datos.
     * @return una lista de objetos Reserva.
     */
    public List<Reserva> obtenerTodasLasReservas() {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection conn = Config.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                reserva.setIdUsuario(rs.getInt("id_usuario"));
                reserva.setIdVuelo(rs.getInt("id_vuelo"));
                reserva.setFechaReserva(rs.getTimestamp("fecha_reserva"));
                reserva.setEstado(rs.getString("estado"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }
        return reservas;
    }
}
