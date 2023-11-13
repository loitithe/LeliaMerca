import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AplicacionUsuario {

        private VentanaPrincipal ventanaPrincipal;
        private VentanaArticulos ventanaArticulos;
        private VentanaInicioSesion ventanaInicioSesion;
        private VentanaOfertasSemanales ventanaOfertasSemanales;
        private VentanaCupon ventanaCupon;
        ArrayList<Producto> listaOfertas;
        private Random random;
        private Producto[] array_productos;
        private String tipoUsuario;
        public void ejecutar() {
                listaArticulos();
                mostrarVentanaInicioSesion();
                for (Producto p : listaOfertas) {
                        System.out.println(p.getImagen().getDescription());
                }
        }

        public void cancelar() {
                System.exit(1);
        }
        public void setTipoUsuario(String tipoUsuario){
                this.tipoUsuario=tipoUsuario;
        }

        public void mostrarVentanaPrincipal(String tipoUsuario) {
                ventanaPrincipal = new VentanaPrincipal(this, tipoUsuario);
                ventanaPrincipal.setSize(600, 500);
                ventanaPrincipal.setVisible(true);
                ventanaPrincipal.setResizable(false);
                ventanaPrincipal.setLocationRelativeTo(null);
                ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void mostrarVentanaInicioSesion() {
                ventanaInicioSesion = new VentanaInicioSesion(this);
                ventanaInicioSesion.setSize(600, 400);
                ventanaInicioSesion.setVisible(true);
                ventanaInicioSesion.setResizable(false);
                ventanaInicioSesion.setLocationRelativeTo(null);
                ventanaInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public void btnVerOfertasSemanales(String nombreUsuario) {

        }

        public void btnVerCupones(String nombreUsuario) {
                mostrarVentanaCupones(nombreUsuario);
        }

        public void mostrarVentanaOfertasSemanales(String tipoUsuario) {
                ventanaOfertasSemanales = new VentanaOfertasSemanales(this, tipoUsuario);
                ventanaOfertasSemanales.setSize(1200, 800);
                ventanaOfertasSemanales.setVisible(true);
                ventanaOfertasSemanales.setResizable(false);
                ventanaOfertasSemanales.setLocationRelativeTo(null);
                ventanaOfertasSemanales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                for (Producto p : listaOfertas) {
                        JButton button_articulo = new JButton(p.getNombre());
                        button_articulo.setName(p.getNombre());
                        System.out.println("asdasd"+p.getImagen());
                        button_articulo.setIcon(p.getImagen());
                        button_articulo.addActionListener(ventanaOfertasSemanales);
                        p.setButton_producto(button_articulo);
                        ventanaOfertasSemanales.agregarBoton(button_articulo);
                }
                ventanaOfertasSemanales.agregarBotonesAlCenterPanel();
        }

        public void mostrarVentanaCupones(String tipoUsuario) {
                ventanaCupon = new VentanaCupon(this,tipoUsuario);
               

        }

        public void mostrarVentanaVerArticulos(String nombreUsuario) {
                ventanaArticulos = new VentanaArticulos();
                ventanaArticulos.setSize(800, 800);
                ventanaArticulos.setVisible(true);
                ventanaArticulos.setResizable(false);
                ventanaArticulos.setLocationRelativeTo(null);
        }

        public ArrayList<Producto> listaArticulos() {
                listaOfertas = new ArrayList<Producto>();
                try {

                        listaOfertas.add(
                                        new Producto("Salsa de Tomate", 1.99, "Salsa de tomate casera.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/salsa_tomate.jpeg"),
                                                        0,
                                                        0, 0));
                        listaOfertas.add(new Producto("Manzanas", 2.99, "Manzanas frescas de temporada.",
                                        new ImageIcon("LeliaMerca/src/productosImg/manzanas.jpeg"), 0,
                                        0, 0));
                        listaOfertas.add(new Producto("Arroz Integral", 3.49, "Arroz integral de alta calidd.",
                                        new ImageIcon("LeliaMerca/src/productosImg/arroz_integral.jpeg"), 0, 0, 0));
                        listaOfertas.add(
                                        new Producto("Pollo Entero", 6.99, "Pollo entero fresco.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/pollo_entero.jpeg"),
                                                        0, 0, 0));
                        listaOfertas.add(new Producto("Leche Desnatada", 2.29, "Leche desnatada sin lactosa.",
                                        new ImageIcon("LeliaMerca/src/productosImg/leche_desnatada.jpeg"), 0, 0, 0));
                        listaOfertas.add(new Producto("Cereal de Avena", 4.79, "Cereal de avena orgánico.",
                                        new ImageIcon("LeliaMerca/src/productosImg/cereal_avena.jpeg"), 0,
                                        0, 0));
                        listaOfertas.add(
                                        new Producto("Salmon Fresco", 9.99, "Filetes de salmón fresco.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/salmon_fresco.jpeg"),
                                                        0,
                                                        0, 0));
                        listaOfertas.add(
                                        new Producto("Yogur Natural", 0.99, "Yogur natural sin azúcar.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/yogur_natural.jpeg"),
                                                        0,
                                                        0, 0));
                        listaOfertas.add(
                                        new Producto("Pan Integral", 2.49, "Pan integral recién horneado.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/pan_integral.jpeg"),
                                                        0, 0, 0));
                        listaOfertas.add(new Producto("Aceite de Oliva", 5.99, "Aceite de oliva virgen extra.",
                                        new ImageIcon("LeliaMerca/src/productosImg/aceite_oliva.jpeg"), 0, 0, 0));
                        listaOfertas
                                        .add(new Producto("Huevos (docena)", 2.49, "Docena de huevos frescos.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/huevos.jpeg"), 0,
                                                        0, 0));
                        listaOfertas.add(new Producto("Cebollas", 1.29, "Cebollas orgánicas.",
                                        new ImageIcon("LeliaMerca/src/productosImg/cebollas.jpeg"), 0, 0, 0));
                        listaOfertas
                                        .add(new Producto("Pimiento Rojo", 1.99, "Pimiento rojo fresco.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/primiento_rojo.jpeg"),
                                                        0,
                                                        0, 0));
                        listaOfertas.add(new Producto("Lechuga Iceberg", 0.99, "Lechuga iceberg crujiente.",
                                        new ImageIcon("LeliaMerca/src/productosImg/lechuga_iceberg.jpeg"), 0, 0, 0));
                        listaOfertas.add(new Producto("Patatas", 2.79, "Papas de la temporada.",
                                        new ImageIcon("LeliaMerca/src/productosImg/patatas.jpeg"), 0, 0, 0));
                        listaOfertas.add(new Producto("Atún enlatado", 1.49, "Atún enlatado de alta calidad.",
                                        new ImageIcon("LeliaMerca/src/productosImg/atun_enlatado.jpeg"), 0, 0, 0));
                        listaOfertas.add(new Producto("Galletas de Chocolate", 3.29, "Galletas de chocolate premium.",
                                        new ImageIcon("LeliaMerca/src/productosImg/galletas_chocolate.jpeg"), 0, 0, 0));
                        listaOfertas
                                        .add(new Producto("Café Molido", 4.99, "Café molido de Colombia.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/cafe_molido.jpeg"), 0,
                                                        0, 0));
                        listaOfertas.add(
                                        new Producto("Fresas", 2.99, "Fresas frescas de la región.",
                                                        new ImageIcon("LeliaMerca/src/productosImg/fresas.jpeg"), 0, 0,
                                                        0));
                        listaOfertas.add(new Producto("Mantequilla", 2.49, "Mantequilla de calidad superior.",
                                        new ImageIcon("LeliaMerca/src/productosImg/mantequilla.jpeg"), 0, 0, 0));

                } catch (Exception e) {
                        e.printStackTrace();
                }
                return listaOfertas;

        }

        public Producto[] ofertasRandom() {
                Random random = new Random();
                array_productos = new Producto[10];
                for (int i = 0; i < array_productos.length; i++) {
                        int num = random.nextInt(listaOfertas.size());
                        Producto producto = listaOfertas.get(num);
                        JButton button_articulo = new JButton();
                        button_articulo.setIcon(producto.getImagen());
                        producto.setButton_producto(button_articulo);
                        array_productos[i] = producto;
                }
                return array_productos;
        }

        public Producto identificaButton(JButton pulsado) {
                if (pulsado != null) {
                        for (Producto p : listaOfertas) {
                                // Comparar referencias de objetos JButton, ya que los nombres pueden ser nulos
                                if (pulsado == p.getButton_producto()) {
                                        return p;
                                }
                        }
                }
                return null; // Retornar null si no se encontró el producto asociado al botón
        }

}
