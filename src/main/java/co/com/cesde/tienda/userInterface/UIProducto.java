package co.com.cesde.tienda.userInterface;

import co.com.cesde.tienda.modelo.ProductoModelo;
import co.com.cesde.tienda.service.ProductoService;

import java.util.Scanner;

public class UIProducto {
    static Scanner sc=new Scanner(System.in);

    public static void  showMenu(){
        boolean flag=true;
        ProductoService ps=new ProductoService();


        do {
            System.out.println("Se encuentra en el modelo de Producto");

            System.out.println("Seleccione una opcion:\n1. Crear\n2. Leer\n3. Actualizar\n4. Eliminar\n5. Salir");
            int opc= sc.nextInt();
            switch (opc){
                case 1:
                    ps.crearProducto();
                    break;
                case 2:
                    ps.consultarProducto();
                    break;
                case 3:
                    ps.actualizarProducto();
                    break;
                case 4:
                    ps.eliminarProducto();
                    break;
                case 5:
                    flag=false;
                    break;
            }
        }while(flag);
    }
}
