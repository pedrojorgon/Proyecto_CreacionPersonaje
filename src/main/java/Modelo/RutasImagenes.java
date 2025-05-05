package Modelo;

import java.io.File;

public class RutasImagenes {

    private static File rutaImagenes = new File("src/main/java/Imagenes");
    private static File[] imagenes = rutaImagenes.listFiles();

    public static File[] getImagenes() {
        return imagenes;
    }
}
