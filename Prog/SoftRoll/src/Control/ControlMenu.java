package Control;

import java.util.ArrayList;
import DAO.ControlDao;
import DAO.Producto;

/**
 *
 * @author Ariel AB
 */
public class ControlMenu {

    ArrayList<Producto> menu;
    private static ControlMenu single_instance = null;
    ControlDao dao;

    private ControlMenu() {
        dao = ControlDao.getInstance();
        ObtenerMenu();
    }

    public static ControlMenu getInstance() {
        if (single_instance == null) {
            single_instance = new ControlMenu();
        }

        return single_instance;
    }

    public ArrayList ObtenerMenu() {
        menu = dao.GenerarMenu();
        return menu;

    }

    public ArrayList<Producto> BuscarProducto(CharSequence busqueda) {
        ArrayList resultados = new ArrayList();
        for (Producto producto : menu) {
            if (producto.getNombre().toLowerCase().contains(busqueda.toString().toLowerCase())) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

}
