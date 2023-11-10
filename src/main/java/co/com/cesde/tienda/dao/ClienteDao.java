package co.com.cesde.tienda.dao;


import co.com.cesde.tienda.conexion.Conexion;
import co.com.cesde.tienda.modelo.ClienteModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {
    public static void crearClienteDB(ClienteModelo cm){
        Conexion conexion=new Conexion();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="INSERT INTO cliente (nombre,apellido,correo,contrasena) VALUES(?,?,?,?)";
            ps= connection.prepareStatement(query);
            ps.setString(1,cm.getNombre());
            ps.setString(2,cm.getApellido());
            ps.setString(3,cm.getCorreo());
            ps.setString(4,cm.getContrasena());
            ps.executeUpdate();


        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void consultarClienteDB(){
        Conexion conexion=new Conexion();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="SELECT * FROM cliente";
            ps= connection.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id_cliente")+",Nombre: "+ rs.getString("nombre")+",Apellido: "+rs.getString("apellido")+" ,Correo: "+rs.getString("correo"));
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void eliminarClienteDB(int id){
        Conexion conexion=new Conexion();
        PreparedStatement ps;
        try (Connection connection=conexion.getConnectionDB()){
            String query="DELETE FROM cliente WHERE id_cliente=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se ha eliminado correctamente");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
