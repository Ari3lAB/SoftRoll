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
    ArrayList<Movimiento> movimientos;
    Caja caja;

    private ControlDao() {
        this.menu = new Menu(GenerarMenu());
        this.usuarios = ObtenerUsuarios();
        this.clientes = ObtenerClientes();
        obtenerMovimientos();
        iniciarCaja();
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
            if (cliente.getTelefono().equals(null)) {
            } else {
                if (cliente.getTelefono().equals(telefono)) {
                    return cliente.getId();
                }
            }
        }
        return 0;
    }

    public String BuscarNombreCliente(int id) {
        String nombreCliente = null;
        try {
            nombreCliente = ControlDB.getInstance().ObtenerNombreCliente(id);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible ingresar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nombreCliente;
    }

    public int BuscarAgregarCliente(String nombre, String telefono, String direccion) {
        for (Cliente cliente : clientes) {
            if (cliente.getTelefono().equals(null)) {
            } else {
                if (cliente.getTelefono().equals(telefono)) {
                    return cliente.getId();
                }
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

    public ArrayList BuscarOrdenesPagadas(String fechaInicio, String fechaFinal) {
        ArrayList ordenes = new ArrayList();
        try {
            ordenes = ControlDB.getInstance().ObtenerOrdenesPagadas(fechaInicio, fechaFinal);
            return ordenes;
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener ordenes activas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ordenes;
    }

    public ArrayList BuscarOrdenesPeriodo(String fechaInicio, String fechaFinal) {
        ArrayList ordenes = new ArrayList();
        try {
            ordenes = ControlDB.getInstance().ObtenerOrdenesPeriodo(fechaInicio, fechaFinal);
            return ordenes;
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener ordenes activas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ordenes;
    }

    public ArrayList BuscarProductos() {
        ArrayList ordenes = new ArrayList();
        try {
            ordenes = ControlDB.getInstance().ObtenerProductos();
            return ordenes;
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener ordenes activas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ordenes;
    }

    public ArrayList BuscarVenta(int id) {
        ArrayList ventas = new ArrayList();
        try {
            ventas = ControlDB.getInstance().ObtenerOrdenVenta(id);
            return ventas;
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible obtener de venta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return ventas;
    }

    public void IngresarVenta(int idOrden, float pagoFinal) {
        try {
            ControlDB.getInstance().VenderOrden(idOrden, pagoFinal);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible cancelar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void CancelarOrden(int idOrden) {
        try {
            ControlDB.getInstance().CancelarOrden(idOrden);
        } catch (SQLException ex) {
            Component panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Imposible cancelar orden: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void obtenerMovimientos() {
        try {
            movimientos = ControlDB.getInstance().ObtenerMovimientosDelDia();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList obtenerMovimientosDelDia() {
        try {
            return movimientos = ControlDB.getInstance().ObtenerMovimientosDelDia();
        } catch (SQLException ex) {
            Logger.getLogger(ControlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void iniciarCaja() {
        float saldoInicial = 0;
        float saldoActual = 0;
        boolean cajaCerrada = false;

        if (movimientos.isEmpty()) {
            caja = new Caja(false);
        }
        if (!movimientos.isEmpty()) {
            for (Movimiento movimiento : movimientos) {
                if (movimiento.getTipo().equals("Apertura")) {
                    saldoInicial = movimiento.getCantidad();
                    saldoActual += saldoInicial;
                    cajaCerrada = false;
                }
                if (movimiento.getTipo().equals("Deposito")) {
                    saldoActual += movimiento.getCantidad();
                }
                if (movimiento.getTipo().equals("Retiro")) {
                    saldoActual -= movimiento.getCantidad();
                }
                if (movimiento.getTipo().equals("Cierre")) {
                    saldoInicial = 0;
                    saldoActual = 0;
                    cajaCerrada = true;
                }
            }

            if (cajaCerrada == true) {
                caja = new Caja(false);
            } else {
                caja = new Caja(saldoInicial, saldoActual, true);
            }
        }
    }

    public boolean obtenerEstadoCaja() {
        return caja.isCajaAbierta();
    }

    public Caja getCaja() {
        return caja;
    }
    
    public void abrirCaja(float deposito) {
        try {
            ControlDB.getInstance().AbrirCaja(deposito);
            caja.setCajaAbierta(true);
            caja.setSaldoInicial(deposito);
            caja.setSaldoActual(deposito);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void depositarEnCaja(float deposito) {
        try {
            ControlDB.getInstance().DepositarEnCaja(deposito);
            caja.setSaldoActual(caja.getSaldoActual() + deposito);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarCaja() {
        try {
            ControlDB.getInstance().CerrarCaja(caja);
        } catch (SQLException ex) {
            Logger.getLogger(ControlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
