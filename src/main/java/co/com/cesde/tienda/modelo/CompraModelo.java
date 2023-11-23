package co.com.cesde.tienda.modelo;

public class CompraModelo {
    int id;
    ClienteModelo cliente;
    ProductoModelo producto;
    float cantidad;
    double precioTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public ClienteModelo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModelo cliente) {
        this.cliente = cliente;
    }

    public ProductoModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductoModelo producto) {
        this.producto = producto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public CompraModelo() {
    }

    public CompraModelo(int id, ClienteModelo cliente, ProductoModelo producto, int cantidad) {
        this.id = id;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return
                "id compra:" + id +
                ",\n cliente: " + cliente +
                ",\n producto: " + producto.getNombreProducto() +
                ", cantidad: " + cantidad +
                ", Precio Total: "+ precioTotal;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
