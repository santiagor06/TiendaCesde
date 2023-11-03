package co.com.cesde.tienda.service;

import co.com.cesde.tienda.modelo.ProductoModelo;

public class TestService {
    public static void main(String[] args) {
        ProductoService ps=new ProductoService();
        ProductoModelo pm=new ProductoModelo();
        ps.eliminarProducto();
    }
}
