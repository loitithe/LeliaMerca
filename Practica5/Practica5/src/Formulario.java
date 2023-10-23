import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

import java.awt.*;

public class Formulario extends JFrame {

    JPanel panelContenedor, panelProcesarFrase, panelButtonProcesar, panelBotones, panelFrase;
    GridLayout gl;
    JLabel lblIntroduceFrase, lblProcesarFrase, lblNumeroLetras, lblNumeroPalabras, lblInvertirFrase,
            lblSepararPalabras, lblPrimeraPosicionVocal;
    JTextField txtIntroduceFrase, txtNumLetras, txtNumPalabras, txtInvertirFrase, txtSepararPalabras,
            txtPrimeraPosicionVocal;
    Font fuenteTitulo, fuenteSecundaria;
    JButton btnProcesarFrase, btnLimpiar, btnSalir;
    GridBagConstraints c;
    GridBagLayout gbl;

    public Formulario() {
        initComponents();
        setVisible(true);
        setSize(new Dimension(800, 500));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {

    }

}
