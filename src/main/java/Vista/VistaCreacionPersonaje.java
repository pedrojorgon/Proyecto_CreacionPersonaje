package Vista;

import Modelo.RutasImagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
    private File[] imagenes = RutasImagenes.getImagenes();
    private int contadorCasco = 0;
    private int contadorPecho = 1;
    private int contadorPiernas = 2;



    public VistaCreacionPersonaje() {

        panelPersonaje.setLayout(null);

        añadirImagen(imagenes[contadorCasco].getPath(), imagenCasco);
        añadirImagen(imagenes[contadorPecho].getPath(), imagenPecho);
        añadirImagen(imagenes[contadorPiernas].getPath(), imagenPiernas);

        imagenCasco.setBounds(170, 0, 250, 250);
        imagenPecho.setBounds(100, 110, 250, 250);
        imagenPiernas.setBounds(141, 240, 250, 350);

        buttonCascoAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        buttonCascoSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPechoAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPechoSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPiernasAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPiernasSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void añadirImagen(String ruta, JLabel lbl) {
        ImageIcon icono = new ImageIcon(ruta);
        Image iconoAjustado = icono.getImage();
        lbl.setIcon(new ImageIcon(iconoAjustado));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VistaCreacionPersonaje");
        frame.setContentPane(new VistaCreacionPersonaje().VentanaCreacion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
