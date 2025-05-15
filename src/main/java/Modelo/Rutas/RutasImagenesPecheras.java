package Modelo.Rutas;

import java.io.File;

public class RutasImagenesPecheras {
    private static File rutaImagenes = new File("src/main/java/Imagenes/Pecheras");
    private static File[] imagenes = rutaImagenes.listFiles();

    public static File[] getImagenes() {
        return imagenes;
    }
}
