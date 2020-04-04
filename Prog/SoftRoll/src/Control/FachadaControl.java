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
    
    public int AgregarOrden(int idCliente, int idUsuario, String Estado, float PagoFinal) {
        return control.AgregarOrden(idCliente, idUsuario, Estado, PagoFinal);
    }
    
    public int AgregarOrden(int idCliente, int idUsuario, String Estado) {
        return control.AgregarOrden(idCliente, idUsuario, Estado);
    }
    
    public void AgregarDetalleOrden(ArrayList detallesOrden) {
        control.AgregarDetalleOrden(detallesOrden);
    }
    
    public void CancelarOrden(int idOrden) {
        control.CancelarOrden(idOrden);
    }
    
    public int BuscarAgregarCliente(String Nombre, String telefono) {
        return control.BuscarAgregarCliente(Nombre, telefono);
    }
    
    public int BuscarAgregarCliente(String Nombre, String telefono, String direccion) {
        return control.BuscarAgregarCliente(Nombre, telefono, direccion);
    }
}
