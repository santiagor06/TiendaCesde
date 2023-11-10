package co.com.cesde.tienda.userInterface;

import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.service.ClienteService;


import java.util.Scanner;

public class UICliente {
    static Scanner sc=new Scanner(System.in);
    public static void  showMenu(){
        boolean flag=true;
        ClienteService cs=new ClienteService();
        ClienteModelo cm=new ClienteModelo();

        do {
            System.out.println("Se encuentra en el modelo de Cliente");

            System.out.println("Seleccione una opcion:\n1. Crear\n2. Leer\n3. Actualizar\n4. Eliminar\n5. Salir");
            int opc= sc.nextInt();
            switch (opc){
                case 1:
                    cs.crearCliente(cm);
                    break;
                case 2:
                    cs.consultarCliente();
                    break;
                case 3:
                    break;
                case 4:
                    cs.eliminarCliente();

                    break;
                case 5:
                    flag=false;
                    break;
            }
        }while(flag);
    }
}
