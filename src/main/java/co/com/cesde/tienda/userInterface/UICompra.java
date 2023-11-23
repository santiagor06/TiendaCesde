package co.com.cesde.tienda.userInterface;

import co.com.cesde.tienda.dao.ProductoDao;
import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.modelo.ProductoModelo;
import co.com.cesde.tienda.service.CompraService;
import co.com.cesde.tienda.service.ProductoService;

import java.util.ArrayList;
import java.util.Scanner;

public class UICompra {
    static Scanner sc=new Scanner(System.in);
   public static void showMenu(ClienteModelo cliente){
       boolean flag=true;
       ProductoService ps=new ProductoService();
       CompraService cs=new CompraService();
       ArrayList<ProductoModelo>productos=ps.consultarProducto();
       do {
           System.out.println("\n\n");
           System.out.println("Bienvendio "+ cliente.getNombre());
           System.out.println("Seleccione el producto que quiere comprar:");
           for (int i=0;productos.size()>i;i++){
               int index=i+1;
               System.out.println(index+" "+productos.get(i));
           }
           int lastIndex=productos.size()+1;
           System.out.println(lastIndex+" ."+"Salir");
           int opc=sc.nextInt();
           if(opc==lastIndex)return;

           ProductoModelo productoComprado=productos.get(opc-1);


           cs.crearCompra(productoComprado,cliente);


       }while (flag);
   }

}
