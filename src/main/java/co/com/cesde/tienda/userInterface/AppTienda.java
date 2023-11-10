package co.com.cesde.tienda.userInterface;

import java.util.Scanner;

public class AppTienda {
    static Scanner sc=new Scanner(System.in);
    public static void menuApp(){
        boolean flag=true;
        do{
            System.out.println("Bienvendio");
            System.out.println("Seleccione un modelo:\n1. Producto\n2. Cliente\n3. Compra\n4. Salir");
            int opc=sc.nextInt();
            switch (opc){
                case 1:
                    UIProducto.showMenu();
                    break;
                case 2:
                    UICliente.showMenu();
                    break;
                case 3:
                    break;
                case 4:
                    flag=false;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
            }

        }while(flag);
    }
}
