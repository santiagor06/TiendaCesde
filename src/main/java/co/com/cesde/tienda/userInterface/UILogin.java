package co.com.cesde.tienda.userInterface;

import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.service.ClienteService;

import java.util.ArrayList;
import java.util.Scanner;

public class UILogin {
    static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        boolean flag=true;
        do{
            System.out.println("Seleccione una opcion:");
            System.out.println("1. Registrarse\n2. Iniciar Sesion\n3. Salir");
            int opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    ClienteService clienteService=new ClienteService();
                    clienteService.crearCliente();
                    break;
                case 2:
                    authCliente();
                    break;
                case 3:
                    flag=false;
                default:
                    System.out.println("Seleccione una opcion valida");
            }
        }while(flag);

    }
    private static void authCliente(){
        System.out.println("Ingrese su correo");
        String email=sc.next();
        System.out.println("Ingrese su contraseña");
        String password=sc.next();
        ClienteService cs=new ClienteService();
        ArrayList<ClienteModelo>clientes=cs.consultarCliente();
        for (int i=0;i<clientes.size();i++){
            String passClient=clientes.get(i).getContrasena();
            String emailClient=clientes.get(i).getCorreo();
            if(passClient.equals(password) && emailClient.equals(email)){
                UICompra.showMenu(clientes.get(i));
                return;
            }

        }
        System.out.println("Credenciales incorrectas ");
    }

}
