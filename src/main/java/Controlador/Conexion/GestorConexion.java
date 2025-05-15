package Controlador.Conexion;

import Controlador.UTIL.InfoError;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Pedro.jorgon
 */

public class GestorConexion {

    private static Connection conn = null;

    /**
     * Crea la conexión con la base de datos.
     * @param bd String nombre de la base de datos.
     * @param usr String usuario de la base de datos.
     * @param pass String contraseña del usuario.
     * @return int InfoError.OK, InfoError.FALLO_DRIVER o InfoError.FALLO_CONEXION.
     */
    public static int crearConexion(String bd, String usr, String pass) {
        try {
            System.out.print("Conectando a la base de datos...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+bd, usr, pass);
            return InfoError.OK;
        } catch (SQLException e) {
            e.printStackTrace();
            return InfoError.FALLO_DRIVER;
        } catch (Exception e) {
            e.printStackTrace();
            return InfoError.FALLO_CONEXION;
        }
    }

    public static Connection getConexion() {
        return conn;
    }

    /**
     * Cierra la conexión.
     * @return int InfoError.OK o InfoError.FALLO_CONEXION.
     */
    public static int cerrarConexion() {
        try {
            conn.close();
            return InfoError.OK;
        }
        catch (SQLException sqle) {
            return InfoError.FALLO_CERRAR_CONEXION;
        }
    }
}
