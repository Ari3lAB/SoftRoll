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

    private ControlMenu() {
        
    }

    public static ControlMenu getInstance() {
        if (single_instance == null) {
            single_instance = new ControlMenu();
        }

        return single_instance;
    }

    ControlDao dao = ControlDao.getInstance();

    public ArrayList ObtenerMenu() {
        menu = dao.GenerarMenu();

        return menu;
    }

    public ArrayList<Producto> BuscarProducto(CharSequence busqueda) {
        ArrayList resultados = new ArrayList();
        for (Producto producto : menu) {
            if (producto.getNombre().contains(busqueda)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

}
