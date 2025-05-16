package Controlador.CRUD;

import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;
import Modelo.Objetos.Personaje;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Clase para insertar objetos en la base de datos.
 * @author Pedro.JorGon
 */
public class InsertsBD {

    /**
     * Inserta un nuevo personaje en la base de datos.
     * @param id_usuario int Id del Usuario.
     * @param nombre String Nombre del personaje.
     * @param idCasco int Id de la imagen del casco.
     * @param idPecho int Id de la imagen del pecho.
     * @param idPiernas int Id de la imagen de las piernas.
     * @return int InfoError.Ok o InfoError.FALLO_CONSULTA.
     */
    public static int nuevoPersonaje(int id_usuario, int id_personaje, LocalDate fecha_creacion,
                                     String nombre, int idCasco, int idPecho, int idPiernas) {
        Connection con = GestorConexion.getConexion();
        try {
            String sql = "INSERT INTO personajes " +
                    "(id_usuario, id_personaje, fecha_creacion, nombre, idCasco, idPecho, idPiernas) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_personaje);
            ps.setDate(3, Date.valueOf(fecha_creacion));
            ps.setString(4, nombre);
            ps.setInt(5, idCasco);
            ps.setInt(6, idPecho);
            ps.setInt(7, idPiernas);
            ps.executeUpdate();
            ps.close();
            return InfoError.OK;
        } catch (SQLException sqle) {
            return InfoError.FALLO_CONSULTA;
        }
    }

    /**
     * Inserta un nuevo personaje en la base de datos.
     * @param personaje Personaje .
     * @return int InfoError.Ok o InfoError.FALLO_CONSULTA.
     */
    public static int nuevoPersonaje(Personaje personaje) {
        Connection con = GestorConexion.getConexion();
        try {
            String sql = "INSERT INTO personajes " +
                    "(id_usuario, id_personaje, fecha_creacion, nombre, idCasco, idPecho, idPiernas) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, personaje.getId_usuario());
            ps.setInt(2, personaje.getId_personaje());
            ps.setDate(3, Date.valueOf(personaje.getFecha_creacion()));
            ps.setString(4, personaje.getNombre());
            ps.setInt(5, personaje.getId_casco());
            ps.setInt(6, personaje.getId_pecho());
            ps.setInt(7, personaje.getId_piernas());
            ps.executeUpdate();
            ps.close();
            return InfoError.OK;
        } catch (SQLException sqle) {
            return InfoError.FALLO_CONSULTA;
        }
    }
}
