/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ariel AB
 */
public class ControlDB {

    private Conexion connect;
    private static ControlDB single_instance = null;

    private ControlDB() {
        try {
            connect = new Conexion();
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible crear conexión con base de datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static ControlDB getInstance() {
        if (single_instance == null) {
            single_instance = new ControlDB();
        }

        return single_instance;
    }

    public void AgregarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) throws SQLException {
        Statement s = connect.conn.createStatement();
        s.executeUpdate(
                "insert into orden (Clientes_idClientes,Usuarios_idUsuarios,FechaOrden,Estado,PagoFinal)"
                + "values('" + idCliente + "','" + idUsuario + "','" + ObtenerTiempo() + "','" + Estado + "','" + PagoFinal + ")");

    }

    public String ObtenerTiempo() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = format.format(date);
        return currentDateTime;
    }

    public void AgregarDetalle(int idOrden, int idProducto, int cantidad, String Notas) throws SQLException {
        Statement s = connect.conn.createStatement();
        s.executeUpdate(
                "insert into detalleorden (Orden_idOrden,Productos_idProductos,Cantidad,Notas)"
                + "values('" + idOrden + "','" + idProducto + "'," + cantidad + ",'" + Notas + "')");
    }

    public ArrayList ObtenerProductos() throws SQLException {
        String query = "select * from productos";
        ArrayList<Producto> productos = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            productos.add(
                    new Producto(rs.getInt("idProductos"), rs.getString("NombreProducto"), rs.getFloat("Precio"), rs.getInt("Categorías_idCategorias"), rs.getBoolean("Promocion")));
        }
        return productos;
    }

    public ArrayList ObtenerUsuarios() throws SQLException {
        String query = "select * from Usuarios";
        ArrayList<Usuario> usuarios = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            usuarios.add(
                    new Usuario(rs.getInt("idUsuarios"), rs.getString("Nombre"), rs.getString("Password"), rs.getBoolean("Admin")));
        }
        return usuarios;
    }

    public ArrayList ObtenerOrdenesActivas() throws SQLException {
        String query = "select * from orden  where Estado = 'activa'";
        ArrayList<Orden> ordenesActivas = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            ordenesActivas.add(
                    new Orden(rs.getInt("idOrden"), rs.getInt("Clientes_idClientes"), rs.getInt("Usuarios_idUsuarios"), rs.getString("FechaOrden"), rs.getString("Estado")));
        }
        return ordenesActivas;
    }
}
