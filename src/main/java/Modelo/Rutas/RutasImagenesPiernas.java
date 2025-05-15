package Modelo.Rutas;

import java.io.File;

public class RutasImagenesPiernas {

    private static File rutaImagenes = new File("src/main/java/Imagenes/Piernas");
    private static File[] imagenes = rutaImagenes.listFiles();

    public static File[] getImagenes() {
        return imagenes;
    }
}
