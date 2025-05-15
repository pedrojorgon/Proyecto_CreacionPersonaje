package Modelo;

import java.io.File;

public class RutasImagenesCascos {

    private static File rutaImagenes = new File("src/main/java/Imagenes/Cascos");
    private static File[] imagenes = rutaImagenes.listFiles();

    public static File[] getImagenes() {
        return imagenes;
    }
}
