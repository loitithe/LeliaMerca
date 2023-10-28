import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOfertasSemanales extends JFrame implements ActionListener {

    private ArrayList<Producto> listaOfertas;
    private JTextField cantidadComprar;
    private JButton btnComprar;
    private JButton btnCancelar;
    private JPanel panelOfertas, panelCarrito;
    private JLabel lblPrecio, lblTotal;
    private JTextArea areaCesta;
    private JScrollPane scrollPane;
    private AplicacionUsuario app;
    private String tipoUsuario;
    private double totalPrecio;

    public VentanaOfertasSemanales(AplicacionUsuario app, String tipoUsuario) {
        this.app = app;
        this.tipoUsuario = tipoUsuario;
        // Configuración básica de la ventana
        setTitle("Ofertas Semanales");
        this.setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        // Panel superior para seleccionar el tipo de cliente
        JPanel panelTipoCliente = new JPanel();
        JLabel labelTipoCliente = new JLabel("Cliente " + tipoUsuario);
        panelTipoCliente.add(labelTipoCliente);

        // Panel central para mostrar las ofertas
        listaOfertas = new ArrayList<>();
        generarOfertas();

        panelOfertas = new JPanel(new GridLayout(listaOfertas.size(), listaOfertas.size()));
        for (Producto producto : listaOfertas) {
            JButton btn_producto = new JButton(producto.getNombre());
            lblPrecio = new JLabel(producto.getDescripcion() + " : " + producto.getPrecio() + " $ /kg");
            if (producto.getNombre().equals("manzanas")) {
                ImageIcon icono = new ImageIcon("LeliaMerca/src/productosImg/manzanas.png");
                btn_producto.setIcon(icono);
            }
            panelOfertas.add(btn_producto);
            panelOfertas.add(lblPrecio);
            System.out.println(producto.getImagen());
        }
        panelPrincipal.add(panelOfertas, BorderLayout.CENTER);

        panelCarrito = new JPanel();
        areaCesta = new JTextArea("PEDIDO ACTUAL");
        scrollPane = new JScrollPane(areaCesta);

        panelPrincipal.add(scrollPane, BorderLayout.EAST);

        lblTotal = new JLabel("Total 0.00 $");

        // Panel inferior para la cantidad a comprar y botones
        JPanel panelInferior = new JPanel();

        JLabel labelCantidad = new JLabel("Cantidad a comprar:");
        cantidadComprar = new JTextField(5);
        btnComprar = new JButton("Comprar");
        btnCancelar = new JButton("Cancelar");

        btnComprar.addActionListener(this);
        btnCancelar.addActionListener(this);

        panelInferior.add(labelCantidad);
        panelInferior.add(cantidadComprar);
        panelInferior.add(btnComprar);
        panelInferior.add(btnCancelar);

        panelPrincipal.add(panelTipoCliente, BorderLayout.NORTH);
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        add(panelPrincipal);

    }

    private void generarOfertas() {
        listaOfertas
                .add(new Producto("Manzanas", 2.99, "Manzanas frescas de temporada.", new ImageIcon("manzanas.avif")));
        listaOfertas.add(new Producto("Arroz Integral", 3.49, "Arroz integral de alta calidd.",
                new ImageIcon("arroz_integral.jpg")));
        listaOfertas.add(new Producto("Pollo Entero", 6.99, "Pollo entero fresco.", new ImageIcon("pollo_entero.jpg")));
        listaOfertas.add(
                new Producto("Pasta de Tomate", 1.99, "Pasta de tomate casera.", new ImageIcon("pasta_tomate.jpg")));
        listaOfertas.add(new Producto("Leche Desnatada", 2.29, "Leche desnatada sin lactosa.",
                new ImageIcon("leche_desnatada.jpg")));
        listaOfertas.add(
                new Producto("Cereal de Avena", 4.79, "Cereal de avena orgánico.", new ImageIcon("cereal_avena.jpg")));
        listaOfertas.add(
                new Producto("Salmon Fresco", 9.99, "Filetes de salmón fresco.", new ImageIcon("salmon_fresco.jpg")));
        listaOfertas.add(
                new Producto("Yogur Natural", 0.99, "Yogur natural sin azúcar.", new ImageIcon("yogur_natural.jpg")));
        listaOfertas.add(
                new Producto("Pan Integral", 2.49, "Pan integral recién horneado.", new ImageIcon("pan_integral.jpg")));
        listaOfertas.add(new Producto("Aceite de Oliva", 5.99, "Aceite de oliva virgen extra.",
                new ImageIcon("aceite_oliva.jpg")));
        listaOfertas
                .add(new Producto("Huevos (docena)", 2.49, "Docena de huevos frescos.", new ImageIcon("huevos.jpg")));
        listaOfertas.add(new Producto("Cebollas", 1.29, "Cebollas orgánicas.", new ImageIcon("cebollas.jpg")));
        listaOfertas
                .add(new Producto("Pimiento Rojo", 1.99, "Pimiento rojo fresco.", new ImageIcon("pimiento_rojo.jpg")));
        listaOfertas.add(new Producto("Lechuga Iceberg", 0.99, "Lechuga iceberg crujiente.",
                new ImageIcon("lechuga_iceberg.jpg")));
        listaOfertas.add(new Producto("Papas", 2.79, "Papas de la temporada.", new ImageIcon("papas.jpg")));
        listaOfertas.add(new Producto("Atún enlatado", 1.49, "Atún enlatado de alta calidad.",
                new ImageIcon("atun_enlatado.jpg")));
        listaOfertas.add(new Producto("Galletas de Chocolate", 3.29, "Galletas de chocolate premium.",
                new ImageIcon("galletas_chocolate.jpg")));
        listaOfertas
                .add(new Producto("Café Molido", 4.99, "Café molido de Colombia.", new ImageIcon("cafe_molido.jpg")));
        listaOfertas.add(new Producto("Fresas", 2.99, "Fresas frescas de la región.", new ImageIcon("fresas.jpg")));
        listaOfertas.add(new Producto("Mantequilla", 2.49, "Mantequilla de calidad superior.",
                new ImageIcon("mantequilla.jpg")));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        for (Producto producto : listaOfertas) {
            if (btn.getName() == producto.getNombre()) {
                double precioProducto = Double.parseDouble(cantidadComprar.getText())*producto.getPrecio();
                areaCesta.append(producto.getNombre() + "\t" + cantidadComprar + "\t" + precioProducto);
                totalPrecio+=precioProducto;
            }
        }

        if (btn == btnComprar) {

        }
        if (btn == btnCancelar) {
            this.dispose();
            app.mostrarVentanaPrincipal(tipoUsuario);
        }
    }

}
