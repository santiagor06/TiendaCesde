package co.com.cesde.tienda.userInterface;

import java.util.Scanner;

public class UILogin {
    static Scanner sc=new Scanner(System.in);
    public static void showMenu(){
        boolean flag=true;
        do{
            System.out.println("Ingrese su correo");
            String email=sc.next();
            System.out.println("Ingrese su contraseña");
            String password=sc.next();

        }while(flag);

    }
}
