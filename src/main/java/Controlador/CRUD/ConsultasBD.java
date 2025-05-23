package Controlador.CRUD;

import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;
import Modelo.Objetos.Personaje;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Clase para las consultas en la baase de datos.
 *
 * @author Pedro.JorGon
 */
public class ConsultasBD {

    /**
     * Consulta el Id más alto de una tabla.
     *
     * @param tabla String Tabla a consultar.
     * @return int Id máximo.
     */
    public static int idMaximo(String tabla) {
        Connection conn = GestorConexion.getConexion();
        int error;
        try {
            String sql = "SELECT MAX(id) id FROM ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tabla);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int res = rs.getInt("id");
                if (res == 0) {
                    if (tabla.equals("usuarios")) {
                        error = InfoError.USUARIO_NO_ENCONTRADO;
                        System.err.printf(InfoError.getMensaje(error));
                    } else {
                        error = InfoError.PERSONAJE_NO_ENCONTRADO;
                        System.err.printf(InfoError.getMensaje(error));
                    }
                    return -1;
                } else {
                    error = InfoError.OK;
                    System.out.printf(InfoError.getMensaje(error));
                    return res;
                }
            } else {
                if (tabla.equals("usuarios")) {
                    error = InfoError.USUARIO_NO_ENCONTRADO;
                    System.err.printf(InfoError.getMensaje(error));
                } else {
                    error = InfoError.PERSONAJE_NO_ENCONTRADO;
                    System.err.printf(InfoError.getMensaje(error));
                }
                return -1;
            }
        } catch (SQLException sqle) {
            error = InfoError.FALLO_CONSULTA;
            System.err.printf(InfoError.getMensaje(error));
            return -1;
        }
    }

    /**
     * Devuelve un objeto Personaje de la base de datos.
     *
     * @param idPersonaje Id del personaje.
     * @return Personaje o null.
     */
    public static Personaje leerPersonaje(int idUsuario, int idPersonaje) {
        Connection conn = GestorConexion.getConexion();
        int error;
        try {
            String sql = "SELECT nombre, fecha_creacion, id_casco, id_pecho, id_piernas FROM personajes " +
                    "WHERE id_usuario = ? AND id_personaje = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPersonaje);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                LocalDate fecha = rs.getDate("fecha_creacion").toLocalDate();
                int idCasco = rs.getInt("id_casco");
                int idPecho = rs.getInt("id_pecho");
                int idPiernas = rs.getInt("id_piernas");
                error = InfoError.OK;
                System.out.printf(InfoError.getMensaje(error));
                return new Personaje(idUsuario, idPersonaje, nombre, fecha, idCasco, idPecho, idPiernas);
            } else {
                error = InfoError.PERSONAJE_NO_ENCONTRADO;
                System.err.printf(InfoError.getMensaje(error));
                return null;
            }
        } catch (SQLException sqle) {
            error = InfoError.FALLO_CONSULTA;
            System.err.printf(InfoError.getMensaje(error));
            return null;
        }
    }
}
