import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaOfertasSemanales extends JFrame implements ActionListener {

        private JLabel northLabel;
        private JLabel southLabel;
        private JSpinner spinner;
        private JList<String> eastList;
        private DefaultListModel<String> listModel;
        private JButton addButton,deleteButton;
        private ArrayList<JButton> buttons;
        private JButton button_producto = new JButton();
        private AplicacionUsuario app;
        private JPanel centerPanel, southPanel, eastPanel,northPanel;
        private Producto pPulsado = null;
        private String tipoUsuario;
        private JLabel ticketLabel;
        private JLabel totalLabel;

        public VentanaOfertasSemanales(AplicacionUsuario app, String tipoUsuario) {
                super("OFERTAS DE ESTA SEMANA");
                this.tipoUsuario = tipoUsuario;
                buttons = new ArrayList<>();
                this.app = app; // referían a la app principal
                // Configuración del JFrame
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setSize(600, 400);
                //Panel Norte
                northPanel = new JPanel();
                northLabel = new JLabel();
                northLabel.setText("Selecciona un producto, elije la cantidad y anade al carrito");
                northPanel.add(northLabel);
                add(northPanel,BorderLayout.NORTH);

                // Panel Centro
                centerPanel = new JPanel(new GridLayout(5, 5));
                buttons = new ArrayList<>();
                add(centerPanel, BorderLayout.CENTER);

                // Panel Sur
                southPanel = new JPanel(new GridLayout(1, 4));
                southLabel = new JLabel("");
                southLabel.setForeground(Color.RED);
                SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
                spinner = new JSpinner(spinnerModel);

                addButton = new JButton("Añadir al carrito");
                addButton.addActionListener(this);

                deleteButton = new JButton("Eliminar del carrito");
                deleteButton.addActionListener(this);

                southPanel.add(southLabel);
                southPanel.add(new JLabel("Cantidad:"));
                southPanel.add(spinner);
                southPanel.add(addButton);
                southPanel.add(deleteButton);
                add(southPanel, BorderLayout.SOUTH);

                // Panel Este
                listModel = new DefaultListModel<>();
                eastList = new JList<>(listModel);

                // Panel con la lista y la etiqueta de precio total
                eastPanel = new JPanel(new BorderLayout());
                eastPanel.add(new JScrollPane(eastList), BorderLayout.CENTER);

                // Etiqueta para mostrar el precio total
                totalLabel = new JLabel("Precio total: $0.00");
                eastPanel.add(totalLabel, BorderLayout.SOUTH);

                // Etiqueta "Ticket" encima de la lista
                ticketLabel = new JLabel("Ticket");
                eastPanel.add(ticketLabel, BorderLayout.NORTH);

                // Agregar paneles al contenedor principal
                add(eastPanel, BorderLayout.EAST);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                JButton button_pulsado = (JButton) e.getSource();

                // Buscar el producto asociado al botón pulsado
                for (Producto producto : app.listaOfertas) {
                        if (button_pulsado == producto.getButton_producto()) {
                                pPulsado = producto;
                                break; // Salir del bucle si se encontró el producto
                        }
                }

                // Verificar si se encontró el producto antes de realizar acciones
                if (pPulsado != null) {
                        southLabel.setText(pPulsado.getNombre());

                        int quantity = (int) spinner.getValue();
                        if (button_pulsado.equals(addButton) && quantity != 0) {
                                pPulsado.setCantidad(quantity);
                                descuentoCliente(tipoUsuario, pPulsado);
                                pPulsado.setPrecioTotal(pPulsado.getPrecio() * quantity);
                                listModel.addElement(pPulsado.toString());
                                spinner.setValue(1);
                                actualizarPrecioTotal(); // Actualizar la etiqueta de precio total
                                
                        }
                } else {
                        // Manejar el caso en el que no se encontró el producto asociado al botón
                        System.out.println("Error: No se encontró un producto asociado al botón pulsado.");
                }
        }

        public void agregarBoton(JButton button_articulo2) {
                buttons.add(button_articulo2);
        }

        public void agregarBotonesAlCenterPanel() {
                for (JButton button : buttons) {
                        centerPanel.add(button);
                }
                revalidate(); // Actualizar el layout
                repaint(); // Repintar la ventana
        }

        public void descuentoCliente(String tipoUsuario, Producto p) {
                switch (tipoUsuario) {
                        case "esporadico":
                                System.out.println(tipoUsuario);
                                break;
                        case "club":
                                System.out.println(tipoUsuario);
                                p.setDescuento(0.03);
                                break;
                        case "premium":
                                System.out.println(tipoUsuario);
                                p.setDescuento(0.05);
                                break;
                        case "cupon":
                                p.setDescuento(1);
                                break;
                        default:
                                break;
                }
        }

        private void actualizarPrecioTotal() {
                double precioTotal = 0;
                for (int i = 0; i < listModel.size(); i++) {
                        String[] partes = listModel.elementAt(i).split(":");
                        precioTotal += Double.parseDouble(partes[1].trim());
                }
                totalLabel.setText("Precio total: $" + String.format("%.2f", precioTotal));
        }
}
