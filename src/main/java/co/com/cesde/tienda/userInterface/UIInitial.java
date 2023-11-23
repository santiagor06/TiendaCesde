package co.com.cesde.tienda.userInterface;

import java.util.Scanner;

public class UIInitial {
    static Scanner  scanner=new Scanner(System.in);
    public static void showMenu(){
        boolean flag=true;
        do{
            System.out.println("Bienvenido!!");
            System.out.println("Seleccione una opcion:\n1 .Admin\n2 .Cliente\n3 .Salir");
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    AppTienda.menuApp();
                    break;
                case 2:
                    UILogin.showMenu();
                    break;
                case 3:
                    flag=false;
                default:
                    System.out.println("Seleccione una opcion valida");

            }

        }while(flag);
    }

}
