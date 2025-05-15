package Controlador.CRUD;

import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdMaximoBD {

    public static int idMaximo() {
        Connection conn = GestorConexion.getConexion();
        try {
            String sql = "SELECT MAX(id) id FROM clientes";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int res = rs.getInt("id");
                if (res == 0) {
                    error = InfoError.CLIENTE_NO_ENCONTRADO;
                    return -1;
                } else {
                    error = InfoError.OK;
                    return res;
                }
            } else {
                error = InfoError.CLIENTE_NO_ENCONTRADO;
                return -1;
            }
        } catch (SQLException sqle) {
            error = InfoError.FALLO_CONSULTA;
            return -1;
        }
    }
}
