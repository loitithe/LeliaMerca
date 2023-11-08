import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
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
        contentPane = new JPanel(new GridBagLayout());
        setContentPane(contentPane);
        GridBagConstraints c = new GridBagConstraints();

        lblUsuario = new JLabel("Usuario");
        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(lblUsuario, c);

        lblContrasena = new JLabel("Contrasena");
        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(lblContrasena, c);

        textoUsuario = new JTextField(10);
        c.gridx = 1;
        c.gridy = 0;
        contentPane.add(textoUsuario, c);

        textoContrasena = new JTextField(10);
        c.gridx = 1;
        c.gridy = 1;
        contentPane.add(textoContrasena, c);

        lblTipoUsuario = new JLabel("Tipo de usuario");
        c.gridx = 0;
        c.gridy = 2;
        contentPane.add(lblTipoUsuario, c);

        grupoTiposUsuario = new ButtonGroup();
        radio_clienteEsporadico = new JRadioButton("Esporadico");
        radio_clienteClub = new JRadioButton("Club");
        radio_clientePremium = new JRadioButton("Premium");
        radio_clienteClub.setSelected(true);
        grupoTiposUsuario.add(radio_clienteClub);
        grupoTiposUsuario.add(radio_clienteEsporadico);
        grupoTiposUsuario.add(radio_clientePremium);
        c.gridx = 0;
        c.gridy = 3;
        contentPane.add(radio_clienteClub, c);
        c.gridx = 1;
        c.gridy = 3;
        contentPane.add(radio_clienteEsporadico, c);
        c.gridx = 2;
        c.gridy = 3;
        contentPane.add(radio_clientePremium, c);

        btnIniciarSesion = new JButton("Inicio");
        btnIniciarSesion.addActionListener(this);
        c.gridx = 0;
        c.gridy = 4;
        contentPane.add(btnIniciarSesion, c);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(this);
        c.gridx = 1;
        c.gridy = 4;
        contentPane.add(btnCancelar, c);

    }

}
