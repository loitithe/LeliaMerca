import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class VentanaInicioSesion extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JLabel lblUsuario;
    private JLabel lblContrasena;
    private JTextField textoUsuario;
    private JTextField textoContrasena;
    private JLabel lblTipoUsuario;

    private ButtonGroup grupoTiposUsuario;
    private JRadioButton radio_clienteEsporadico, radio_clienteClub, radio_clientePremium;

    private JButton btnIniciarSesion;
    private JButton btnCancelar;
    private AplicacionUsuario app;
    private JPanel panelSur;

    public VentanaInicioSesion(AplicacionUsuario app) {
        this.app = app;
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        if (btn == btnIniciarSesion) {
            if (radioSeleccionado() != null) {
                String tipo = radioSeleccionado().getText();
                app.mostrarVentanaPrincipal(tipo);
                this.dispose();
            }

        }
        if (btn == btnCancelar) {
            this.dispose();
        }
    }

    public JRadioButton radioSeleccionado() {
        JRadioButton seleccionado = null;
        Enumeration<AbstractButton> botones = grupoTiposUsuario.getElements();
        while (botones.hasMoreElements()) {
            seleccionado = (JRadioButton) botones.nextElement();
            if (seleccionado.isSelected()) {
                seleccionado = seleccionado;
                break;

            }
        }
        return seleccionado;
    }

    public void initComponents() {
        contentPane = new JPanelFondo();
        setContentPane(contentPane);
        panelSur = new JPanel(new GridLayout(2, 10));
        lblUsuario = new JLabel("Usuario");

        lblContrasena = new JLabel("Contrasena");
        textoUsuario = new JTextField(10);
        textoContrasena = new JTextField(10);
        lblTipoUsuario = new JLabel("");
        grupoTiposUsuario = new ButtonGroup();
        radio_clienteEsporadico = new JRadioButton("Esporadico");
        radio_clienteClub = new JRadioButton("Club");
        radio_clientePremium = new JRadioButton("Premium");
        radio_clienteClub.setSelected(true);
        grupoTiposUsuario.add(radio_clienteClub);
        grupoTiposUsuario.add(radio_clienteEsporadico);
        grupoTiposUsuario.add(radio_clientePremium);

        btnIniciarSesion = new JButton("Inicio");
        btnIniciarSesion.addActionListener(this);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);

        panelSur.add(lblUsuario);
        panelSur.add(textoUsuario);
        panelSur.add(lblContrasena);
        panelSur.add(textoContrasena);
        panelSur.add(lblTipoUsuario);
        panelSur.add(radio_clienteClub, BorderLayout.SOUTH);
        panelSur.add(radio_clienteEsporadico, BorderLayout.SOUTH);
        panelSur.add(radio_clientePremium, BorderLayout.SOUTH);
        panelSur.add(btnIniciarSesion, BorderLayout.SOUTH);

        panelSur.add(btnCancelar, BorderLayout.SOUTH);

        contentPane.add(panelSur, BorderLayout.SOUTH);
    }

}

class JPanelFondo extends JPanel {
    private Image imagen;

    JPanelFondo() {
        setLayout(new BorderLayout());

    }

    @Override
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        imagen = t.getImage("LeliaMerca/src/productosImg/fondosupermarket.png");
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
