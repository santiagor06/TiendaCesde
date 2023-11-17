package co.com.cesde.tienda.service;

import co.com.cesde.tienda.dao.CompraDao;
import co.com.cesde.tienda.dao.ProductoDao;
import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.modelo.CompraModelo;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.util.ArrayList;
import java.util.Scanner;

public class CompraService {
    Scanner sc=new Scanner(System.in);
    public void crearCompra(ProductoModelo pm, ClienteModelo cm){
        CompraModelo compraModelo=new CompraModelo();
        compraModelo.setCliente(cm);
        compraModelo.setProducto(pm);

        System.out.println("Ingrese la cantidad del producto");
        float cantidad=sc.nextFloat();

        if(cantidad>pm.getCantidad()) System.out.println("No hay la cantidad suficiente");
        else{

        compraModelo.setCantidad(cantidad);
        CompraDao.crearCompraDB(compraModelo);
        }

    }
    public ArrayList<CompraModelo> consultarCompras(){
        return CompraDao.consultarComprasDB();
    }
    public CompraModelo consultarComprasId(int id){
        return CompraDao.consultarComprasIdDB(id);
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
