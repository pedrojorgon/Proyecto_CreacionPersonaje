package Controlador.CRUD;

import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase para insertar objetos en la base de datos.
 * @author Pedro.JorGon
 */
public class InsertsBD {

    /**
     * Inserta un nuevo personaje en la base de datos.
     * @param idUsuario int Id del Usuario.
     * @param nombre String Nombre del personaje.
     * @param idCasco int Id de la imagen del casco.
     * @param idPecho int Id de la imagen del pecho.
     * @param idPiernas int Id de la imagen de las piernas.
     * @return int InfoError.Ok o InfoError.FALLO_CONSULTA.
     */
    public static int nuevoPersonaje(int idUsuario, String nombre, int idCasco, int idPecho, int idPiernas) {
        Connection con = GestorConexion.getConexion();
        try {
            String sql = "INSERT INTO personajes (idUsuario, nombre, idCasco, idPecho, idPiernas) " +
                    "VALUES (?, ?, ?, ? ,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ps.setString(2, nombre);
            ps.setInt(3, idCasco);
            ps.setInt(4, idPecho);
            ps.setInt(5, idPiernas);
            ps.executeUpdate();
            ps.close();
            return InfoError.OK;
        } catch (SQLException sqle) {
            return InfoError.FALLO_CONSULTA;
        }
    }
}
