package Controlador.UTIL;

/**
 * @author Pedro.jorgon
 */

public class InfoError {
    
    public static final int OK = 0;
    public static final int FALLO_DRIVER = 1;
    public static final int FALLO_CONEXION = 2;
    public static final int FALLO_CERRAR_CONEXION = 3;
    public static final int FALLO_CONSULTA = 4;
    public static final int USUARIO_NO_ENCONTRADO = 5;
    public static final int PERSONAJE_NO_ENCONTRADO = 6;

    private static final String[] MENSAJE = {
            "Correcto",
            "Error al conectar con la base de datos. Fallo en el conector",
            "Error al conectar con la base de datos",
            "No se pudo cerrar la conexión",
            "Error al recoger los datos",
            "No se encontró el usuario",
            "No se encontró el personaje"
    };

    public static String getMensaje(int codigo){
        return MENSAJE[codigo];
    }
    
}
