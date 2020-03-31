package Control;

/**
 *
 * @author Ariel AB
 */
import DAO.ControlDao;

public class ControlAcceso {

    private String usuario;
    private String pass;

    private static ControlAcceso single_instance = null;

    private ControlAcceso() {

    }

    public static ControlAcceso getInstance() {
        if (single_instance == null) {
            single_instance = new ControlAcceso();
        }

        return single_instance;
    }

    public boolean Acceder(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
        return OtorgarPermiso();
    }

    public boolean OtorgarPermiso() {
        return ControlDao.getInstance().PedirAcceso(usuario, pass);

    }
}
