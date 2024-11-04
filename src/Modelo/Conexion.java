
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection con = null;

    private final String base = "proyecto";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private final String user = "root";
    private final String password = "admin";

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver JDBC. " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error: No se pudo establecer la conexión a la base de datos. " + e.getMessage());
        }
        return con;
    }
}