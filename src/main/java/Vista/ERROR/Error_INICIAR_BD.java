package Vista.ERROR;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa la vista en caso de error al no poder conectarse con la base de datos
 * o en caso de que se cierre la conexión de la misma durante la ejecución del programa.
 * <p>
 * La clase muestra un mensaje de error y una disculpa al usuario.
 *
 * @author Pedro Jorlar González
 */

public class Error_INICIAR_BD extends JFrame {

    public Error_INICIAR_BD() {
        // Propiedades de la ventana
        setTitle("Error de Conexión");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Etiqueta de error
        JLabel errorMessage = new JLabel("No se puede acceder a la aplicación.", SwingConstants.CENTER);
        errorMessage.setFont(new Font("Arial", Font.BOLD, 16));

        // Etiqueta de disculpas
        JLabel apologyMessage = new JLabel("Lo sentimos por los inconvenientes.", SwingConstants.CENTER);
        apologyMessage.setFont(new Font("Arial", Font.PLAIN, 14));

        // Añaddor etiquetas al panel
        panel.add(errorMessage, BorderLayout.CENTER);
        panel.add(apologyMessage, BorderLayout.SOUTH);

        // Añadir panel a la ventana
        add(panel);
    }
}