import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JPanel contentPane, panel_opciones;
    private JLabel etiquetaMenuPrincipal;
    private JButton btnVerOfertasSemanales, btnVerCupones, btnVerArticulos, btnCancelar;
    private GridLayout gl;
    private BorderLayout bl;
    private AplicacionUsuario app;
    private String tipoUsuario;
    private Color color_usuario;

    public VentanaPrincipal(AplicacionUsuario app, String tipoUsuario) {
        this.app = app;
        this.tipoUsuario = tipoUsuario;
        colorVentana();
        gl = new GridLayout(3, 1, 20, 20);
        bl = new BorderLayout();
        setTitle("LELIAMERCA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500);
        contentPane = new JPanel();
        contentPane.setBackground(color_usuario);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        bl.setVgap(20);
        bl.setHgap(20);
        contentPane.setLayout(bl);

        setLocationRelativeTo(null);
        setResizable(false);

        etiquetaMenuPrincipal = new JLabel("Menú de usuario:");
        etiquetaMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 16));
        etiquetaMenuPrincipal.setBounds(10, 24, 147, 14);
        contentPane.add(etiquetaMenuPrincipal, BorderLayout.NORTH);

        panel_opciones = new JPanel(gl);

        btnVerOfertasSemanales = new JButton("OFERTAS SEMANALES");
        btnVerOfertasSemanales.setForeground(Color.WHITE);
        btnVerOfertasSemanales.setBackground(color_usuario);
        btnVerOfertasSemanales.setBounds(71, 64, 153, 23);
        btnVerOfertasSemanales.addActionListener(this);
        panel_opciones.add(btnVerOfertasSemanales);

        btnVerCupones = new JButton("CUPONES");
        btnVerCupones.setForeground(Color.WHITE);
        btnVerCupones.setBackground(color_usuario);
        btnVerCupones.setBounds(71, 98, 153, 23);
        btnVerCupones.addActionListener(this);
        panel_opciones.add(btnVerCupones);

        btnVerArticulos = new JButton("ARTICULOS");
        btnVerArticulos.setForeground(Color.WHITE);

        btnVerArticulos.setBackground(color_usuario);
        btnVerArticulos.setBounds(71, 132, 153, 23);
        btnVerArticulos.addActionListener(this);
        panel_opciones.add(btnVerArticulos);

        contentPane.add(panel_opciones, BorderLayout.CENTER);
        btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(183, 227, 116, 23);
        btnCancelar.addActionListener(this);
        contentPane.add(btnCancelar, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton_pulsado = (JButton) e.getSource();

        if (boton_pulsado == btnCancelar) {
            app.mostrarVentanaInicioSesion();
            this.dispose();
        }
        if (boton_pulsado == btnVerOfertasSemanales) {
            app.mostrarVentanaOfertasSemanales(tipoUsuario);
            this.dispose();
        }
        if (boton_pulsado == btnVerCupones) {
            app.mostrarVentanaCupones(tipoUsuario);
            this.dispose();
        }
        if (boton_pulsado == btnVerArticulos) {
            app.mostrarVentanaVerArticulos(tipoUsuario);
            this.dispose();
        }
    }

    public Color colorVentana() {
        tipoUsuario = tipoUsuario.toLowerCase();

        switch (tipoUsuario) {
            case "esporadico":
                color_usuario = new Color(97, 120, 244);

                break;
            case "premium":
                color_usuario = new Color(220, 134, 16);
                break;
            case "club":
                color_usuario = new Color(243, 100, 80);
                break;
            default:
                break;
        }

        return color_usuario;

    }
}
