package co.com.cesde.tienda.dao;


import co.com.cesde.tienda.conexion.Conexion;
import co.com.cesde.tienda.modelo.ClienteModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDao {
    public static void crearClienteDB(ClienteModelo cm){
        Conexion conexion=new Conexion();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="INSERT INTO clientes (nombre,apellido,correo,contrasena,id_cliente) VALUES(?,?,?,?,?)";
            ps= connection.prepareStatement(query);
            ps.setString(1,cm.getNombre());
            ps.setString(2,cm.getApellido());
            ps.setString(3,cm.getCorreo());
            ps.setString(4,cm.getContrasena());
            ps.setInt(5,cm.getId());
            ps.executeUpdate();


        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static ArrayList<ClienteModelo> consultarClienteDB(){
        Conexion conexion=new Conexion();
        ArrayList<ClienteModelo>clientes=new ArrayList<>();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="SELECT * FROM clientes";
            ps= connection.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                ClienteModelo cliente=new ClienteModelo();

                cliente.setId(rs.getInt("id_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContrasena(rs.getString("contrasena"));

                clientes.add(cliente);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return clientes;
    }    public static ClienteModelo consultarClienteIdDB(int id){
        Conexion conexion=new Conexion();
        ClienteModelo cliente=new ClienteModelo();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="SELECT * FROM clientes WHERE id_cliente=?";
            ps= connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setContrasena(rs.getString("contrasena"));

            }

        }catch(SQLException e){
            System.out.println(e);
        }
        return cliente;
    }
    public static void eliminarClienteDB(int id){
        Conexion conexion=new Conexion();
        PreparedStatement ps;
        try (Connection connection=conexion.getConnectionDB()){
            String query="DELETE FROM clientes WHERE id_cliente=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se ha eliminado correctamente");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
