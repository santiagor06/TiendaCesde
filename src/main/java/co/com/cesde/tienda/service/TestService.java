package co.com.cesde.tienda.service;

import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.modelo.ProductoModelo;
import co.com.cesde.tienda.userInterface.UICompra;

import java.util.ArrayList;

public class TestService {
    public static void main(String[] args) {
        ProductoService ps=new ProductoService();
        ClienteService cs=new ClienteService();
        CompraService cm=new CompraService();
        ProductoModelo producto=ps.consultarProductoId(2);
        ClienteModelo cliente=cs.consultarclienteId(1000894076);
        UICompra.showMenu(cliente);


    }
}
