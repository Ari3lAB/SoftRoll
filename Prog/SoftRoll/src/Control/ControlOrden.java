package Control;

/**
 *
 * @author Ariel AB
 */
import DAO.ControlDao;
import java.util.ArrayList;

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

    public void AgregarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) {
        dao.IngresarOrden(idCliente, idUsuario, Estado, PagoFinal);
    }

    public void AgregarDetalleOrden(ArrayList DetallesOrden) {
        dao.IngresarDetallesOrden(DetallesOrden);
    }

    public ArrayList ObtenerOrdenesActivas() {
        return dao.BuscarOrdenesActivas();
    }

}
