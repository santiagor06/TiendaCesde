package co.com.cesde.tienda.userInterface;

import java.util.Scanner;

public class UIAuth {
    static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        boolean flag=true;
        do{
            System.out.println("Bienvenido a la tienda cesde!!\nSeleccione una opcion\n1. Admin\n2. Cliente\n3. Salir");
            int opc=sc.nextInt();
            switch (opc){
                case 1:
                    authAdmin();
                    break;
                case 2:
                    break;
            }
        }while (flag);
    }
    private static void authAdmin(){
        boolean flag=true;
        do{
            System.out.println("Ingrese su correo");
            String correo=sc.next();
            System.out.println("Ingrese su contraseña");
            String contrasena=sc.next();

        }while(flag);

    }
}
