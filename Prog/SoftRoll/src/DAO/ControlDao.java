package DAO;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ariel AB
 */
public class ControlDao {

    public static int USUARIOACTIVO;
    private static ControlDao single_instance = null;
    Menu menu;
    ArrayList<Usuario> usuarios;
    ArrayList<Cliente> clientes;

    private ControlDao() {
        this.menu = new Menu(GenerarMenu());
        this.usuarios = ObtenerUsuarios();
        this.clientes = ObtenerClientes();
    }

    public static ControlDao getInstance() {
        if (single_instance == null) {
            single_instance = new ControlDao();
        }

        return single_instance;
    }

    public boolean PedirAcceso(String usuario, String pass) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombre().equals(usuario)) {
                if (usuarios.get(i).getContra().equals(pass)) {
                    USUARIOACTIVO = usuarios.get(i).getId();

                    return true;
                } else {
                    Component panel = new JPanel();
                    JOptionPane.showMessageDialog(panel, "Contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

        }
        Component panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public ArrayList GenerarMenu() {
        ArrayList productos = null;
        try {
            productos = new ArrayList(ControlDB.getInstance().ObtenerProductos());

        } catch (Exception e) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener menú: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return productos;
    }

    public ArrayList ObtenerUsuarios() {
        ArrayList listausuarios = null;
        try {
            listausuarios = new ArrayList(ControlDB.getInstance().ObtenerUsuarios());

        } catch (Exception e) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener usuarios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listausuarios;
    }

    public ArrayList<Cliente> ObtenerClientes() {
        ArrayList listaClientes = null;
        try {
            listaClientes = new ArrayList(ControlDB.getInstance().ObtenerClientes());

        } catch (Exception e) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener clientes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaClientes;
    }

    public int AgregarCliente(String nombre, String telefono, String direccion) {
        int idCliente = 0;
        try {
            idCliente = ControlDB.getInstance().AgregarCliente(nombre, telefono, direccion);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (idCliente == 0) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Ocurrió un error al ingresar la orden", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idCliente;
    }

    public int AgregarCliente(String nombre, String telefono) {
        int idCliente = 0;
        try {
            idCliente = ControlDB.getInstance().AgregarCliente(nombre, telefono);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar nuevo cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (idCliente == 0) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Ocurrió un error al ingresar nuevo cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idCliente;
    }

    public int BuscarCliente(String telefono) {
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)) {
                return cliente.getId();
            }
        }
        return 0;
    }

    public int BuscarAgregarCliente(String nombre, String telefono, String direccion) {
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(telefono)) {
                return cliente.getId();
            }
        }
        return AgregarCliente(nombre, telefono, direccion);
    }

    public int IngresarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) {
        int idOrden = 0;
        try {
            idOrden = ControlDB.getInstance().AgregarOrden(idCliente, idUsuario, Estado, PagoFinal);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (idOrden == 0) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Ocurrió un error al ingresar la orden", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idOrden;
    }

    public int IngresarOrden(int idCliente, int idUsuario, String Estado) {
        int idOrden = 0;
        try {
            idOrden = ControlDB.getInstance().AgregarOrden(idCliente, idUsuario, Estado);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (idOrden == 0) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Ocurrió un error al ingresar la orden", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return idOrden;
    }

    public void IngresarDetallesOrden(ArrayList<DetalleOrden> DetallesOrden) {

        for (DetalleOrden detalleOrden : DetallesOrden) {
            try {
                ControlDB.getInstance().AgregarDetalle(detalleOrden.getIdOrden(), detalleOrden.getIdProducto(), detalleOrden.getCantidad(), detalleOrden.getNotas());
            } catch (SQLException ex) {
                Component panel = new JPanel();
                JOptionPane.showMessageDialog(panel, "Imposible ingresar detalle de orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    public ArrayList BuscarOrdenesActivas() {
        ArrayList ordenes = new ArrayList();
        try {
            ordenes = ControlDB.getInstance().ObtenerOrdenesActivas();
            return ordenes;
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener ordenes activas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ordenes;
    }

    public void CancelarOrden(int idOrden) {
        try {
            ControlDB.getInstance().CancelarOrden(idOrden);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible cancelar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
