package DAO;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public int AgregarCliente(String nombre, String telefono, String direccion) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query
                = "insert into clientes(Nombre,Numero,Direccion)"
                + "values('" + nombre + "','" + telefono + "','" + direccion + ");";
        s.executeUpdate(query);
        ResultSet rs = s.executeQuery("Select LAST_INSERT_ID();");
        if (rs.next()) {
            int idCliente = rs.getInt(1);
            return idCliente;
        }
        return 0;
    }

    public int AgregarCliente(String nombre, String telefono) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query
                = "insert into clientes(Nombre,Numero,Direccion)"
                + "values('" + nombre + "','" + telefono + ");";
        s.executeUpdate(query);
        ResultSet rs = s.executeQuery("Select LAST_INSERT_ID();");
        if (rs.next()) {
            int idCliente = rs.getInt(1);
            return idCliente;
        }
        return 0;
    }

    public ArrayList ObtenerClientes() throws SQLException {
        String query = "select * from Clientes";
        ArrayList<Cliente> clientes = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            clientes.add(
                    new Cliente(rs.getInt("idClientes"), rs.getString("Nombre"), rs.getString("Numero"), rs.getString("Direccion")));
        }
        return clientes;
    }

    public int AgregarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query
                = "insert into orden (Clientes_idClientes,Usuarios_idUsuarios,FechaOrden,Estado,PagoFinal)"
                + "values('" + idCliente + "','" + idUsuario + "','" + ObtenerTiempo() + "','" + Estado + "','" + PagoFinal + ");";
        s.executeUpdate(query);
        ResultSet rs = s.executeQuery("Select LAST_INSERT_ID();");
        if (rs.next()) {
            int idOrden = rs.getInt(1);
            return idOrden;
        }
        return 0;
    }

    public int AgregarOrden(int idCliente, int idUsuario, String Estado) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query
                = "insert into orden (Clientes_idClientes,Usuarios_idUsuarios,FechaOrden,Estado)"
                + "values('" + idCliente + "','" + idUsuario + "','" + ObtenerTiempo() + "','" + Estado + "');";
        s.executeUpdate(query);
        ResultSet rs = s.executeQuery("Select LAST_INSERT_ID();");
        if (rs.next()) {
            int idOrden = rs.getInt(1);
            return idOrden;
        }
        return 0;
    }

    public void CancelarOrden(int idOrden) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query = "update orden set Estado = 'Cancelada' where idOrden = '" + idOrden + "';";
        s.executeUpdate(query);
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
