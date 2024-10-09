package org.example.kebab.DAO;

import org.example.kebab.utiles.Alerta;
import org.example.kebab.Clases.Productos;
import org.example.kebab.utiles.Conectar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductosDAO {
    public static ArrayList<Productos> mostrarProductos(){
        ArrayList<Productos> listaPoductos= new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection connection = Conectar.conectar()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idGenerado = rs.getInt("id_producto");
                String nombrePlato = rs.getString("nombrePlato");
                int precioPlato = rs.getInt("precioPlato");
                String nombreBebida = rs.getString("nombreBebida");
                int precioBebida = rs.getInt("precioBebida");
                boolean patatas = rs.getBoolean("patatas");
                Productos productos = new Productos(idGenerado,nombrePlato,precioPlato,nombreBebida,precioBebida,patatas);
                listaPoductos.add(productos);
            }
        }catch (Exception e){
            Alerta.alertaError(e.getMessage());
        }
        return  listaPoductos;
    }
    public static double buscarPrecioPlato(String nombrePlato){
        double precioPlato= 0;
        String sql = "SELECT * FROM productos";
        try (Connection connection = Conectar.conectar()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombrePlato2 = rs.getString("nombrePlato");
                if (nombrePlato.equals(nombrePlato2)) {
                    precioPlato = rs.getDouble("precioPlato");

                }
            }
        }catch (Exception e){
            Alerta.alertaError(e.getMessage());
        }
        return  precioPlato;
    }
    public static double buscarPrecioBebida(String nombreBebida){
        double precioBebida= 0;
        String sql = "SELECT * FROM productos";
        try (Connection connection = Conectar.conectar()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreBebida2 = rs.getString("nombreBebida");
                if (nombreBebida.equals(nombreBebida2)) {
                    precioBebida = rs.getDouble("precioBebida");

                }
            }
        }catch (Exception e){
            Alerta.alertaError(e.getMessage());
        }
        return  precioBebida;
    }

}
