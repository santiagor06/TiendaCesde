package co.com.cesde.tienda.dao;

import co.com.cesde.tienda.conexion.Conexion;
import co.com.cesde.tienda.modelo.ProductoModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDao {
    public static void crearProductoDB(ProductoModelo pm){
        Conexion conexion=new Conexion();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            try {
                String query="INSERT INTO productos (nombre_producto,cantidad,precio) VALUES(?,?,?)";
                ps=connection.prepareStatement(query);
                ps.setString(1,pm.getNombreProducto());
                ps.setDouble(2,pm.getCantidad());
                ps.setDouble(3,pm.getPrecio());
                ps.executeUpdate();
                System.out.println("Se registro correctamente");
            }catch (SQLException e){}
        }catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void consultarProductoDB(){
        Conexion conexion=new Conexion();
        PreparedStatement ps;
        try(Connection connection=conexion.getConnectionDB()) {
            String query="SELECT * FROM productos";
            ps=connection.prepareStatement(query);
            ResultSet rs;
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id_producto")+",Nombre: "+ rs.getString("nombre_producto")+",Cantidad: "+rs.getDouble("cantidad"));
            }


        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
