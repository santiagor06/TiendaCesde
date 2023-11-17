package co.com.cesde.tienda.service;

import co.com.cesde.tienda.dao.ClienteDao;
import co.com.cesde.tienda.dao.ProductoDao;
import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteService  {
    static Scanner sc=new Scanner(System.in);
     public void crearCliente(ClienteModelo cm){
         System.out.println("Ingrese el id del cliente");
         int id=sc.nextInt();
        System.out.println("Ingrese el nombre del Cliente");
        String nombre=sc.next();
        System.out.println("Ingrese el apellido del Cliente");
        String apellido=sc.next();
        System.out.println("Ingrese el correo del Cliente");
        String correo=sc.next();
        System.out.println("Ingrese el contraseña del Cliente");
        String contrasena=sc.next();
        cm.setId(id);
        cm.setNombre(nombre);
        cm.setApellido(apellido);
        cm.setCorreo(correo);
        cm.setContrasena(contrasena);
        ClienteDao.crearClienteDB(cm);
    }
    public ArrayList<ClienteModelo> consultarCliente(){
         return ClienteDao.consultarClienteDB();
    }
    public ClienteModelo consultarclienteId(int id){
         return ClienteDao.consultarClienteIdDB(id);
    }
    public void eliminarCliente(){
        System.out.println("Ingrese el id que desea eliminar");
        int id=sc.nextInt();
        ClienteDao.eliminarClienteDB(id);
    }
    public void actualizarCliente(ClienteModelo cm){
        System.out.println("Indique el id que desea actualizar");
        int id=sc.nextInt();
        cm.setId(id);

        System.out.println("Seleccione una opcion:\n1.Actualizar Nombre\n2.Actuaizar Apellido\n3.Actualizar Correo");
        int opc= sc.nextInt();
        cm.setOption(opc);
        if(opc==1){
            System.out.println("Ingrese el nuevo nombre del cliente");
            String newName=sc.next();
            cm.setNombre(newName);

        } else if (opc==2) {
            System.out.println("Ingrese el apellido del cliente");
            String newApellido=sc.next();
            cm.setApellido(newApellido);
        }else if (opc==3) {
            System.out.println("Ingrese el correo del cliente");
            String newCorreo=sc.next();
            cm.setCorreo(newCorreo);
        }else System.out.println("Seleccione una opcion valida");


    }
}
