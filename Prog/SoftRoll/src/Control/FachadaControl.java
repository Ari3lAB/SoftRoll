package Control;

import DAO.Producto;
import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public class FachadaControl {

    ControlAcceso acceso;
    ControlOrden control;
    ControlMenu menu;

    private static FachadaControl single_instance = null;

    private FachadaControl() {
        acceso = ControlAcceso.getInstance();
        control = ControlOrden.getInstance();
        menu = ControlMenu.getInstance();
    }

    public static FachadaControl getInstance() {
        if (single_instance == null) {
            single_instance = new FachadaControl();
        }

        return single_instance;
    }

    public boolean Acceder(String user, String pass) {
        return acceso.Acceder(user, pass);
    }

    public ArrayList<Producto> BuscarProducto(CharSequence busqueda) {
        return menu.BuscarProducto(busqueda);
    }

    public ArrayList OrdenesActivas() {
        return control.ObtenerOrdenesActivas();
    }

}
