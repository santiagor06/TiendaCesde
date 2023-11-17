package co.com.cesde.tienda.dao;

import co.com.cesde.tienda.conexion.Conexion;
import co.com.cesde.tienda.modelo.ClienteModelo;
import co.com.cesde.tienda.modelo.CompraModelo;
import co.com.cesde.tienda.modelo.ProductoModelo;
import co.com.cesde.tienda.service.ClienteService;
import co.com.cesde.tienda.service.ProductoService;

import java.sql.*;
import java.util.ArrayList;

public class CompraDao {
    public static void crearCompraDB(CompraModelo compraModelo){
        Conexion conexion=new Conexion();
        try(Connection connection= conexion.getConnectionDB()){
            PreparedStatement ps;
            String query="INSERT INTO compra (id_cliente,id_producto,cantidad_compra) VALUES(?,?,?)";
            ps= connection.prepareStatement(query);
            ps.setInt(1,compraModelo.getCliente().getId());
            ps.setInt(2,compraModelo.getProducto().getId());
            ps.setFloat(3,compraModelo.getCantidad());
            ps.executeUpdate();

            System.out.println("Su compra se ha realizado exitosamente");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static ArrayList<CompraModelo> consultarComprasDB() {
        Conexion conexion = new Conexion();
            ArrayList<CompraModelo> compras = new ArrayList<>();
        try (Connection connection = conexion.getConnectionDB()) {
            PreparedStatement ps;
            String query = "SELECT * FROM compra";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ClienteService cs=new ClienteService();
            ProductoService productoService=new ProductoService();
            while (rs.next()) {

                CompraModelo compra = new CompraModelo();
                compra.setCantidad(rs.getInt("id_compra"));
                ClienteModelo cliente=cs.consultarclienteId(rs.getInt("id_cliente"));
                ProductoModelo producto=productoService.consultarProductoId(rs.getInt("id_producto"));
                compra.setCliente(cliente);
                compra.setProducto(producto);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return compras;
    }    public static CompraModelo consultarComprasIdDB(int id) {
        Conexion conexion = new Conexion();
            CompraModelo compra= new CompraModelo();
        try (Connection connection = conexion.getConnectionDB()) {
            PreparedStatement ps;
            String query = "SELECT * FROM compra WHERE id_compra=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            ClienteService cs=new ClienteService();
            ProductoService productoService=new ProductoService();
            while (rs.next()) {

                compra.setCantidad(rs.getInt("id_compra"));
                ClienteModelo cliente=cs.consultarclienteId(rs.getInt("id_cliente"));
                ProductoModelo producto=productoService.consultarProductoId(rs.getInt("id_producto"));
                compra.setCliente(cliente);
                compra.setProducto(producto);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return compra;
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
