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

    /**
     * Propiedades del producto
     * 
     * @param nombre
     * @param precio
     * @param descripcion
     * @param imagen
     * @param cantidad
     * @param precioTotal
     * @param descuento
     */
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

    /**
     * Devuelve el nombre del producto
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio del producto
     * 
     * @return
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     * 
     * @param precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la descripcion del producto
     * 
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del producto
     * 
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la imagen del producto
     * 
     * @return
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * Establece la descripcion del producto
     * 
     * @param imagen
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    /**
     * Devuelve la cantidad del producto
     * 
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad del producto
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve el descuento del producto
     * 
     * @return
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Establece el descuento del producto
     * 
     * @param descuento
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Devuelve el precioTotal del producto
     * 
     * @return
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece el precio total del producto
     * 
     * @param precioTotal
     */
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
