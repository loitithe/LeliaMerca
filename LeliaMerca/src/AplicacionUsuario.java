import javax.swing.JFrame;

public class AplicacionUsuario {

    private VentanaPrincipal ventanaPrincipal;
    private VentanaArticulos ventanaArticulos;
    private VentanaInicioSesion ventanaInicioSesion;
    private VentanaOfertasSemanales ventanaOfertasSemanales;

    public void ejecutar() {
        mostrarVentanaInicioSesion();
    }

    public void cancelar() {
        System.exit(1);
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
    }

    public void mostrarVentanaOfertasSemanales(String tipoUsuario) {
        ventanaOfertasSemanales = new VentanaOfertasSemanales(this, tipoUsuario);
        ventanaOfertasSemanales.setSize(1200, 800);
        ventanaOfertasSemanales.setVisible(true);
        ventanaOfertasSemanales.setResizable(false);
        ventanaOfertasSemanales.setLocationRelativeTo(null);
        ventanaOfertasSemanales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarVentanaCupones(String nombreUsuario) {
    }

    public void mostrarVentanaVerArticulos(String nombreUsuario) {
        ventanaArticulos = new VentanaArticulos();
        ventanaArticulos.setSize(800, 800);
        ventanaArticulos.setVisible(true);
        ventanaArticulos.setResizable(false);
        ventanaArticulos.setLocationRelativeTo(null);
    }

}
