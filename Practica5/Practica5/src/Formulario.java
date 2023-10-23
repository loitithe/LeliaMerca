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
    Container container;
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
        c = new GridBagConstraints();
        gbl = new GridBagLayout();
        container = this.getContentPane();
        container.setLayout(gbl);

        fuenteTitulo = new Font("Arial", Font.BOLD, 20);
        fuenteSecundaria = new Font("arial", Font.BOLD, 14);

        // primera fila
        lblIntroduceFrase = new JLabel("Introduce una frase");
        lblIntroduceFrase.setFont(fuenteTitulo);
        // c.gridx = 0;
        // c.gridy = 0;
        container.add(lblIntroduceFrase, colocaConstraints(0, 0, 0, 0, 0, 0, 0));
        txtIntroduceFrase = new JTextField("");

        // c.gridx = 1;
        // c.gridy = 0;
        container.add(txtIntroduceFrase, colocaConstraints(1, 0, 0, 0, 0, 0, 0));

    }

    public GridBagConstraints colocaConstraints(int gx, int gy, int gw, int gh, double wx, double wy, int fill) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gx; // coordenadas
        c.gridy = gy; // coordenadas
        c.gridwidth = gw; // celdas de ancho
        c.gridheight = gh; // celdas de alto
        c.weightx = wx; // gestion de espacio disponible 0-1
        c.weighty = wy; // gestion de espacio disponible 0-1
        c.fill = fill; // rellenar
        return c;

    }

}
