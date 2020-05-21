package Control;

/**
 *
 * @author Ariel AB
 */
import DAO.ControlDao;
import java.util.ArrayList;
import DAO.Venta;

public class ControlOrden {

    ControlDao dao;

    private static ControlOrden single_instance = null;

    private ControlOrden() {
        dao = ControlDao.getInstance();
    }

    public static ControlOrden getInstance() {
        if (single_instance == null) {
            single_instance = new ControlOrden();
        }

        return single_instance;
    }

    public int AgregarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) {
        return dao.IngresarOrden(idCliente, idUsuario, Estado, PagoFinal);
    }

    public int AgregarOrden(int idCliente, int idUsuario, String Estado) {
        return dao.IngresarOrden(idCliente, idUsuario, Estado);
    }

    public void AgregarDetalleOrden(ArrayList DetallesOrden) {
        dao.IngresarDetallesOrden(DetallesOrden);
    }

    public void CancelarOrden(int idOrden) {
        dao.CancelarOrden(idOrden);
    }

    public int BuscarAgregarCliente(String Nombre, String telefono) {
        int idCliente = dao.BuscarCliente(telefono);
        if (idCliente == 0) {
            idCliente = dao.AgregarCliente(Nombre, telefono);
        }
        return idCliente;
    }

    public int BuscarAgregarCliente(String Nombre, String telefono, String direccion) {
        int idCliente = dao.BuscarCliente(telefono);
        if (idCliente == 0) {
            idCliente = dao.AgregarCliente(Nombre, telefono, direccion);
        }
        return idCliente;
    }

    public ArrayList ObtenerOrdenesActivas() {
        return dao.BuscarOrdenesActivas();
    }

    public ArrayList ObtenerOrdenesPagadas(String fechaInicio, String fechaFin) {
        return dao.BuscarOrdenesPagadas(fechaInicio, fechaFin);
    }

    public ArrayList ObtenerOrdenesPeriodo(String fechaInicio, String fechaFin) {
        return dao.BuscarOrdenesPeriodo(fechaInicio, fechaFin);
    }

    public ArrayList ObtenerProductos() {
        return dao.BuscarProductos();
    }

    public ArrayList obtenerVenta(int idOrden) {
        return dao.BuscarVenta(idOrden);
    }

    public float calcularTotal(int idOrden) {
        float total = 0;
        ArrayList<Venta> ventas = dao.BuscarVenta(idOrden);
        for (Venta venta : ventas) {
            total += (venta.getPrecio() * venta.getCantidad());
        }
        return total;
    }

    public void ingresarVenta(int idOrden, float total) {
        dao.IngresarVenta(idOrden, total);
    }

}
