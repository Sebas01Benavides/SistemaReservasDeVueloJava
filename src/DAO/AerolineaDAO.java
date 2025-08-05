package dao;

import Modelo.Aerolinea;
import util.Config;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para la entidad Aerolinea.
 * Contiene la lógica para interactuar con la tabla 'aerolineas'.
 */
public class AerolineaDAO {

    /**
     * Inserta una nueva aerolínea en la base de datos.
     * @param aerolinea el objeto Aerolinea a insertar.
     */
    public void agregarAerolinea(Aerolinea aerolinea) {
        String sql = "INSERT INTO aerolineas (nombre) VALUES (?)";
        try (Connection conn = Config.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aerolinea.getNombre());
            stmt.executeUpdate();
            System.out.println("Aerolínea agregada exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al agregar aerolínea: " + e.getMessage());
        }
    }

    /**
     * Obtiene todas las aerolíneas de la base de datos.
     * @return una lista de objetos Aerolinea.
     */
    public List<Aerolinea> obtenerTodasLasAerolineas() {
        List<Aerolinea> aerolineas = new ArrayList<>();
        String sql = "SELECT * FROM aerolineas";
        try (Connection conn = Config.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aerolinea aerolinea = new Aerolinea();
                aerolinea.setId(rs.getInt("id"));
                aerolinea.setNombre(rs.getString("nombre"));
                aerolineas.add(aerolinea);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener aerolíneas: " + e.getMessage());
        }
        return aerolineas;
    }
}
