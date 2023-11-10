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
                String query="INSERT INTO producto (nombre_producto,cantidad,precio) VALUES(?,?,?)";
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
            String query="SELECT * FROM producto";
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
    public static void eliminarProductoDB(int id){
        Conexion conexion=new Conexion();
        PreparedStatement ps;
        try (Connection connection=conexion.getConnectionDB()){
            String query="DELETE FROM producto WHERE id_producto=?";
            ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se ha eliminado correctamente");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void actualizarProductos(ProductoModelo pm){
        Conexion conexion=new Conexion();
        PreparedStatement ps;
        try (Connection connection= conexion.getConnectionDB()){

    if(pm.getOption()==1){
        String query="UPDATE producto SET nombre_producto=? WHERE id_producto=?";
        ps=connection.prepareStatement(query);

        ps.setString(1,pm.getNombreProducto());
        ps.setInt(2,pm.getId());

    }
    else if(pm.getOption()==2){
        String query="UPDATE producto SET cantidad=? WHERE id_producto=?";
        ps=connection.prepareStatement(query);

                ps.setDouble(1,pm.getCantidad());
                ps.setInt(2,pm.getId());
        ps.executeUpdate();
            }
    else if(pm.getOption()==3){
        String query="UPDATE producto SET precio=? WHERE id_producto=?";
        ps=connection.prepareStatement(query);

        ps.setDouble(1,pm.getPrecio());
        ps.setInt(2,pm.getId());
        ps.executeUpdate();
    }

        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
