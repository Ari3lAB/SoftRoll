package DAO;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ariel AB
 */
public class ControlDao {

    private static ControlDao single_instance = null;
    Menu menu;
    ArrayList<Usuario> usuarios;

    private ControlDao() {
        this.menu = new Menu(GenerarMenu());
        this.usuarios = ObtenerUsuarios();
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

    public void IngresarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) {
        try {
            ControlDB.getInstance().AgregarOrden(idCliente, idUsuario, Estado, PagoFinal);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
}
