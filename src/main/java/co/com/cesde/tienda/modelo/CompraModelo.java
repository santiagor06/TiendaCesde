package co.com.cesde.tienda.modelo;

public class CompraModelo {
    int id;
    ProductoModelo producto;
    ClienteModelo cliente;
    int cantidad;

    public CompraModelo() {
    }

    public CompraModelo(int id, ProductoModelo producto, ClienteModelo cliente, int cantidad) {
        this.id = id;
        this.producto = producto;
        this.cliente = cliente;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductoModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductoModelo producto) {
        this.producto = producto;
    }

    public ClienteModelo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModelo cliente) {
        this.cliente = cliente;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
