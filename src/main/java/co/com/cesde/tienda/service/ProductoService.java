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
    public void eliminarProducto(){
        System.out.println("Ingrese el id que desea eliminar");
        int id=sc.nextInt();
        ProductoDao.eliminarProductoDB(id);
    }
    public void actualizarProducto(ProductoModelo pm){
        System.out.println("Indique el id que desea actualizar");
        int id=sc.nextInt();
        pm.setId(id);

        System.out.println("Seleccione una opcion:\n1.Actualizar Nombre\n2.Actuaizar Cantidad\n3.Actualizar Precio");
        int opc= sc.nextInt();
        pm.setOption(opc);
        if(opc==1){
            System.out.println("Ingrese el nuevo nombre del producto");
            String newName=sc.next();
            pm.setNombreProducto(newName);

        } else if (opc==2) {
            System.out.println("Ingrese la cantidad del producto");
            double newCantidad=sc.nextDouble();
            pm.setCantidad(newCantidad);
        }else if (opc==3) {
            System.out.println("Ingrese la cantidad del producto");
            double newPrecio=sc.nextDouble();
            pm.setCantidad(newPrecio);
        }else System.out.println("Seleccione una opcion valida");

        ProductoDao.actualizarProductos(pm);
    }
}
