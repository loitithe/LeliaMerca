import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class VentanaCupon extends JFrame {
    private JButton[] botones;
    private int intentos = 3;
    private int numeroBotonGanador;
    private AplicacionUsuario app;
    private String tipoUsuario;
    private Random random;

    public VentanaCupon(AplicacionUsuario app, String tipoUsuario) {
        super("Cupones");
        this.app = app;
        this.tipoUsuario = tipoUsuario;

        setLayout(new GridLayout(2, 4));

        // Crear botones con interrogantes
        botones = new JButton[8];
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("?");
            botones[i].addActionListener(new CuponListener());
            add(botones[i]);
        }
        random = new Random();
        numeroBotonGanador = random.nextInt(botones.length);

        // Crear temporizador para cambiar colores
        Timer timer = new Timer(400, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarColorAleatorio();
            }
        });

        // Iniciar temporizador
        timer.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void cambiarColorAleatorio() {
        Random rand = new Random();
        
        // Aplicar color aleatorio a cada botón
        for (JButton button : botones) {
            Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            button.setBackground(randomColor);
        }
    }

    private class CuponListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            if (intentos > 0) {
                intentos--;
                if (boton == botones[numeroBotonGanador]) {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Has ganado una compra gratis.");
                    app.mostrarVentanaOfertasSemanales("cupon");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Lo siento, este cupón no tiene descuento.\nTe quedan " + intentos + " intentos.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Lo siento, te has quedado sin intentos.");
                app.mostrarVentanaPrincipal(tipoUsuario);
                dispose();

            }

        }
    }
}