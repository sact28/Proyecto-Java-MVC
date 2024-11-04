
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPeliculas extends Conexion {

    public boolean agregar(Peliculas peli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO pelicula (titulo, genero, director, fecha) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getGenero());
            ps.setString(3, peli.getDirector());
            ps.setDate(4, new Date(peli.getFecha().getTime()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificar(Peliculas peli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE pelicula SET genero=?, director=?, fecha=? WHERE titulo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, peli.getGenero());
            ps.setString(2, peli.getDirector());
            ps.setDate(3, new Date(peli.getFecha().getTime()));
            ps.setString(4, peli.getTitulo()); // Usa título como identificador
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Peliculas peli) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM pelicula WHERE titulo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, peli.getTitulo()); // Usa título como identificador
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean buscar(Peliculas peli) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM pelicula WHERE titulo=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, peli.getTitulo()); 
            rs = ps.executeQuery();

            if (rs.next()) {
                peli.setTitulo(rs.getString("titulo"));
                peli.setGenero(rs.getString("genero"));
                peli.setDirector(rs.getString("director"));
                peli.setFecha(rs.getDate("fecha"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}