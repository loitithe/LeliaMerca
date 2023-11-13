import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCupon extends JFrame {
    private JButton[] botones;
    private int intentos = 2;
    private AplicacionUsuario app;
    private String tipoUsuario;

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class CuponListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            if (intentos >= 1) {
                if (boton == botones[7]) {
                    JOptionPane.showMessageDialog(null, "¡Felicidades! Has ganado una compra gratis.");
                    app.mostrarVentanaPrincipal("cupon");
                    dispose();
                } else {
                    intentos--;
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
