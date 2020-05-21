package DAO;

import java.awt.Component;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                + "values('" + nombre + "','" + telefono + "','" + direccion + "');";
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
                = "insert into clientes(Nombre,Numero)"
                + "values('" + nombre + "','" + telefono + "');";
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

    public String ObtenerNombreCliente(int id) throws SQLException {
        String nombreCliente = "NoName";
        String query = "select Nombre from clientes where idClientes = " + id + "";
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);
        if (rs.next()) {
            nombreCliente = rs.getString(1);
        }
        return nombreCliente;

    }

    public ArrayList ObtenerOrdenVenta(int idOrden) throws SQLException {
        ArrayList ventas;
        ventas = new ArrayList();
        String query = "select productos.NombreProducto, productos.Precio, detalleorden.Cantidad "
                + "from productos "
                + "join detalleorden "
                + "on productos.idProductos = detalleorden.Productos_idProductos "
                + "where detalleorden.Orden_idOrden =" + idOrden;
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);
        while (rs.next()) {
            ventas.add(
                    new Venta(rs.getString("NombreProducto"), rs.getDouble("Precio"), rs.getInt("Cantidad")));
        }
        return ventas;
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

    public void VenderOrden(int idOrden, float pagoFinal) throws SQLException {
        Statement s = connect.conn.createStatement();
        String query = "update orden set Estado = 'Pagada', PagoFinal = " + pagoFinal + " where idOrden = '" + idOrden + "';";
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

    public ArrayList ObtenerOrdenesPagadas(String FechaInicio, String FechaFin) throws SQLException {
        String query = "select o.idOrden, usuarios.Nombre, o.FechaOrden, o.PagoFinal "
                + "FROM orden o "
                + "join usuarios "
                + "on  o.Usuarios_idUsuarios = usuarios.idUsuarios "
                + "where FechaOrden between '" + FechaInicio + " 00:00:00' and '" + FechaFin + " 23:59:59' "
                + "and o.Estado = 'Pagada' "
                + "order by FechaOrden";
        ArrayList<Orden> ordenesPagadas = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            ordenesPagadas.add(
                    new Orden(rs.getInt("idOrden"), rs.getString("Nombre"), rs.getString("FechaOrden"), rs.getFloat("PagoFinal")));
        }
        return ordenesPagadas;
    }

    public ArrayList ObtenerOrdenesPeriodo(String FechaInicio, String FechaFin) throws SQLException {
        String query = "select o.idOrden, usuarios.Nombre, o.FechaOrden, o.Estado \n"
                + "FROM orden o\n"
                + "join usuarios\n"
                + "on  o.Usuarios_idUsuarios = usuarios.idUsuarios\n"
                + "where FechaOrden between '" + FechaInicio + " 00:00:00' and '" + FechaFin + " 23:59:59'\n"
                + "order by FechaOrden";
        ArrayList<Orden> ordenesPagadas = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            ordenesPagadas.add(
                    new Orden(rs.getInt("idOrden"), rs.getString("Nombre"), rs.getString("FechaOrden"), rs.getString("Estado")));
        }
        return ordenesPagadas;
    }

    public ArrayList ObtenerProducots() throws SQLException {
        String query = "select idProductos,NombreProducto,Precio, categorias.NombreCategoria\n"
                + "from productos\n"
                + "join categorias\n"
                + "on productos.Categorías_idCategorias = categorias.idCategorias\n"
                + "order by NombreCategoria";
        ArrayList<Producto> productos = new ArrayList();
        Statement s = connect.conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        while (rs.next()) {
            productos.add(
                    new Producto(rs.getInt("idProductos"), rs.getString("NombreProducto"), rs.getFloat("Precio"), rs.getString("NombreCategoria")));
        }
        return productos;
    }
}
