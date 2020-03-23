package DAO;

/**
 *
 * @author Ariel AB
 */
public class Cajero extends Usuario{

    public Cajero(String idCajero, String nombre, String contra) {
        super(nombre, contra);
        this.idCajero = idCajero;
    }
    private String idCajero;

    public String getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(String idCajero) {
        this.idCajero = idCajero;
    }
    
}
