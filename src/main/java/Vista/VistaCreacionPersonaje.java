package Vista;

import Controlador.CRUD.ConsultasBD;
import Controlador.CRUD.InsertsBD;
import Controlador.Conexion.GestorConexion;
import Controlador.UTIL.InfoError;
import Modelo.Objetos.Personaje;
import Modelo.Rutas.RutasImagenesCascos;
import Modelo.Rutas.RutasImagenesPecheras;
import Modelo.Rutas.RutasImagenesPiernas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;

public class VistaCreacionPersonaje extends JPanel {

    private JPanel VentanaCreacion;
    private JButton buttonCascoAnterior;
    private JButton buttonPechoAnterior;
    private JButton buttonPiernasAnterior;
    private JButton buttonCascoSiguiente;
    private JButton buttonPechoSiguiente;
    private JButton buttonPiernasSiguiente;
    private JTextField txtNombrePersonaje;
    private JComboBox cbSeleccionPersonaje;
    private JButton buttonGuardar;
    private JPanel panelPersonaje;
    private JLabel imagenCasco;
    private JLabel imagenPecho;
    private JLabel imagenPiernas;
    private File[] imagenesCascos = RutasImagenesCascos.getImagenes();
    private File[] imagenesPecheras = RutasImagenesPecheras.getImagenes();
    private File[] imagenesPiernas = RutasImagenesPiernas.getImagenes();
    private int contadorCasco = 0;
    private int contadorPecho = 0;
    private int contadorPiernas = 0;


    public VistaCreacionPersonaje() {

        //Asigno el layout a null para añadir las imágenes flotando en él
        panelPersonaje.setLayout(null);

        //Añado las imágenes a los label con la imagen por defecto
        añadirImagen(imagenesCascos[contadorCasco].getPath(), imagenCasco);
        añadirImagen(imagenesPecheras[contadorPecho].getPath(), imagenPecho);
        añadirImagen(imagenesPiernas[contadorPiernas].getPath(), imagenPiernas);

        //Coloco los JLabel
        imagenCasco.setBounds(160, 0, 250, 250);
        imagenPecho.setBounds(100, 110, 250, 250);
        imagenPiernas.setBounds(141, 240, 250, 350);

        //Código botones
        buttonCascoAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorCasco == 0) {
                    contadorCasco = imagenesCascos.length - 1;
                    añadirImagen(imagenesCascos[contadorCasco].getPath(), imagenCasco);
                } else {
                    contadorCasco--;
                    añadirImagen(imagenesCascos[contadorCasco].getPath(), imagenCasco);
                }
            }
        });
        buttonCascoSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorCasco == imagenesCascos.length - 1) {
                    contadorCasco = 0;
                    añadirImagen(imagenesCascos[contadorCasco].getPath(), imagenCasco);
                } else {
                    contadorCasco++;
                    añadirImagen(imagenesCascos[contadorCasco].getPath(), imagenCasco);
                }
            }
        });
        buttonPechoAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorPecho == 0) {
                    contadorPecho = imagenesPecheras.length - 1;
                    añadirImagen(imagenesPecheras[contadorPecho].getPath(), imagenPecho);
                } else {
                    contadorPecho--;
                    añadirImagen(imagenesPecheras[contadorPecho].getPath(), imagenPecho);
                }
            }
        });
        buttonPechoSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorPecho == imagenesPecheras.length - 1) {
                    contadorPecho = 0;
                    añadirImagen(imagenesPecheras[contadorPecho].getPath(), imagenPecho);
                } else {
                    contadorPecho++;
                    añadirImagen(imagenesPecheras[contadorPecho].getPath(), imagenPecho);
                }
            }
        });
        buttonPiernasAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorPiernas == 0) {
                    contadorPiernas = imagenesPiernas.length - 1;
                    añadirImagen(imagenesPiernas[contadorPiernas].getPath(), imagenPiernas);
                } else {
                    contadorPiernas--;
                    añadirImagen(imagenesPiernas[contadorPiernas].getPath(), imagenPiernas);
                }
            }
        });
        buttonPiernasSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contadorPiernas == imagenesPiernas.length - 1) {
                    contadorPiernas = 0;
                    añadirImagen(imagenesPiernas[contadorPiernas].getPath(), imagenPiernas);
                } else {
                    contadorPiernas++;
                    añadirImagen(imagenesPiernas[contadorPiernas].getPath(), imagenPiernas);
                }
            }
        });
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePersonaje = txtNombrePersonaje.getText();
                Personaje p = new Personaje(1, 1, nombrePersonaje, LocalDate.now(), contadorCasco,
                        contadorPecho, contadorPiernas);
                System.out.println(InfoError.getMensaje(InsertsBD.nuevoPersonaje(p)));
            }
        });
    }

    /**
     * Coloca una imagen en un JLabel según una ruta proporcionada.
     * @param ruta String ruta de imagen.
     * @param lbl JLabel donde se coloca la imagen.
     */
    public static void añadirImagen(String ruta, JLabel lbl) {
        ImageIcon icono = new ImageIcon(ruta);
        Image iconoAjustado = icono.getImage();
        lbl.setIcon(new ImageIcon(iconoAjustado));
    }


    public static void mostrarVentanaPersonaje() {
        JFrame frame = new JFrame("VistaCreacionPersonaje");
        frame.setContentPane(new VistaCreacionPersonaje().VentanaCreacion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
