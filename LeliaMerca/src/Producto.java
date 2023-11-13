import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Producto {
    private String nombre;
    private double precio;
    private String descripcion;
    private ImageIcon imagen;
    private int cantidad;
    private double precioTotal;
    private double descuento;
    private JButton button_producto;
    private String format = "%-10.10s (%d uds):\t%.2f ";

    public Producto() {
    }

    public Producto(String nombre, double precio, String descripcion, ImageIcon imagen, int cantidad,
            double precioTotal, double descuento) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        double precioConDescuento = precioTotal * (1 - getDescuento());
        this.precioTotal = precioConDescuento;
    }

    @Override
    public String toString() {
        return String.format(format, this.getNombre(), this.getCantidad(),
                this.getPrecioTotal());
    }

    public JButton getButton_producto() {
        return button_producto;
    }

    public String getFormat() {
        return format;
    }

    public void setButton_producto(JButton button_producto) {
        this.button_producto = button_producto;
    }

    public void setFormat(String format) {
        this.format = format;
    }

}
