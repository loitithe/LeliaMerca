import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VentanaArticulos extends JFrame implements ActionListener {
    private static JPanel panel_secciones, panel_opciones, panel_ofertas;
    private BorderLayout bl;
    private static JComboBox cBox_conocenos, cBox_consejos, cBox_actualidad, cBox_atCliente, cBox_cuidemosPlaneta;

    private static String[] secciones_array = new String[] { "Platos preparados", "Despensa",
            "Mascotas",
            "Bebé",
            "Cuidado del hogar",
            "Cuidado personal",
            "Bebidas y bodega",
            "Congelados",
            "Refrigerados" };

    private static String[] opcion_conocenos = new String[] { "Conocemos", "Modelo", "Historia", "Memoria anual",
            "Sala de prensa" };

    private static String[] opcion_consejos = new String[] { "Alimentacion", "Perfumeria", "Hogar", "Mascotas",
            "Revistas" };

    private static String[] opcion_actualidad = new String[] { "Actualidad" };

    private static String[] opcion_atencionCliente = new String[] { "Atencion al cliente" };

    private static String[] opcion_cuidemosPlaneta = new String[] { "Cuidemos del planeta" };

    private static JButton seccion, oferta, cancelButton;

    private static Font fuente_principal = new Font("TimesRoman", Font.BOLD, 13);

    private static Color color_secciones = new Color(25, 76, 25);
    private static Color color_menu = new Color(94, 199, 85);
    private static AplicacionUsuario app;
    private static String tipoUsuario;

    public VentanaArticulos(AplicacionUsuario app,String tipoUsuario) {
        super("LeliaMerca");
        this.app=app;
        this.tipoUsuario=tipoUsuario;
        initComponents();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents() {
        bl = new BorderLayout(3, 3);
        setLayout(bl);
        panel_secciones = new JPanel(new GridLayout(secciones_array.length, 1));

        panel_opciones = new JPanel(new GridLayout(1, 5));
        secciones(secciones_array);
        panelOpciones();

        panel_ofertas = new JPanel(new GridLayout(1, 3));
        cancelButton = new JButton("Cancelar ");
        cancelButton.addActionListener(this);

        add(cancelButton, bl.SOUTH);
        add(panel_opciones, bl.NORTH);
        add(panel_secciones, bl.WEST);

    }

    public static void ofertas() {
        oferta = new JButton("OFERTAS SEMANALES");
        oferta = new JButton("CUPONES");
        oferta = new JButton("ARTICULOS");

    }

    public static void secciones(String[] secciones) {
        for (String nombre_seccion : secciones) {
            seccion = new JButton(nombre_seccion);
            seccion.setFont(fuente_principal);
            seccion.setBackground(color_secciones);
            seccion.setForeground(Color.WHITE);
            panel_secciones.add(seccion);
        }
    }

    public static void panelOpciones() {
        cBox_conocenos = new JComboBox<>(opcion_conocenos);
        cBox_conocenos.setBackground(color_menu);
        cBox_actualidad = new JComboBox<>(opcion_actualidad);
        cBox_actualidad.setBackground(color_menu);
        cBox_consejos = new JComboBox<>(opcion_consejos);
        cBox_consejos.setBackground(color_menu);
        cBox_actualidad = new JComboBox<>(opcion_actualidad);
        cBox_actualidad.setBackground(color_menu);
        cBox_atCliente = new JComboBox<>(opcion_atencionCliente);
        cBox_atCliente.setBackground(color_menu);
        panel_opciones.add(cBox_conocenos);
        panel_opciones.add(cBox_actualidad);
        panel_opciones.add(cBox_consejos);
        panel_opciones.add(cBox_actualidad);
        panel_opciones.add(cBox_atCliente);
        panel_opciones.add(panel_secciones);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button_pulsado = (JButton) e.getSource();

        if (button_pulsado.equals(cancelButton)) {
            app.mostrarVentanaPrincipal(tipoUsuario);
            dispose();
        }
    }

}
