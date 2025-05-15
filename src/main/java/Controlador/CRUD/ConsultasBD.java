package Controlador.CRUD;

import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase para las consultas en la baase de datos.
 *
 * @author Pedro.JorGon
 */
public class ConsultasBD {

    /**
     * Consulta el Id más alto de una tabla.
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
                    } else {
                        error = InfoError.PERSONAJE_NO_ENCONTRADO;
                    }
                    return -1;
                } else {
                    error = InfoError.OK;
                    return res;
                }
            } else {
                if (tabla.equals("usuarios")) {
                    error = InfoError.USUARIO_NO_ENCONTRADO;
                } else {
                    error = InfoError.PERSONAJE_NO_ENCONTRADO;
                }
                return -1;
            }
        } catch (SQLException sqle) {
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }
}
