package Controlador.Conexion;

import java.sql.Connection;

/**
 * Clase encargada de crear conexiones la base de datos.
 * @author Pedro Jorlar González
 */

public class CrearConn {
    private static final String DB_NAME = "creacionPersonaje";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    public static boolean crearConexion() {
        int estadoConexion = GestorConexion.crearConexion(DB_NAME, DB_USER, DB_PASSWORD);
        return estadoConexion == 0;
    }
    public static Connection conn() {
        int estadoConexion = GestorConexion.crearConexion(DB_NAME, DB_USER, DB_PASSWORD);
        if(estadoConexion == 0) return GestorConexion.getConexion();
        else return null;
    }
}
