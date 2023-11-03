package co.com.cesde.tienda.conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConexion {

    public static void main(String[] args) {

        Conexion conexion = new Conexion();

        try(Connection connect = conexion.getConnectionDB()){


        }catch (SQLException e ){
            System.out.println(e);
        }




    }
}
