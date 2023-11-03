package co.com.cesde.tienda.service;

import co.com.cesde.tienda.dao.ProductoDao;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.util.Scanner;

public class ProductoService {
    Scanner sc=new Scanner(System.in);
    public void crearProducto(ProductoModelo pm){

        System.out.println("Ingrese el nombre del producto");
        String nombreProducto=sc.next();
        System.out.println("Ingrese la cantidad del producto");
        float cantidad=sc.nextFloat();
           System.out.println("Ingrese el precio del producto");
        float precio=sc.nextFloat();
        pm.setNombreProducto(nombreProducto);
        pm.setCantidad(cantidad);
        pm.setPrecio(precio);
        ProductoDao.crearProductoDB(pm);

    }
    public void consultarProducto(){
        ProductoDao.consultarProductoDB();
    }
}
