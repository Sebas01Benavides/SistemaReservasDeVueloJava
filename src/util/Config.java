package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de configuración para la conexión a la base de datos.
 * Centraliza las credenciales para facilitar la portabilidad.
 */
public class Config {
    public static final String DB_URL = "jdbc:postgresql://localhost:5432/sistema_reservas";
    public static final String DB_USER = "app_user";
    public static final String DB_PASSWORD = "admin";

    /**
     * Obtiene una conexión a la base de datos.
     * @return Objeto Connection para la base de datos.
     * @throws SQLException si ocurre un error de conexión.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
