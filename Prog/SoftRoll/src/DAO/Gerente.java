package DAO;

/**
 *
 * @author Ariel AB
 */
public class Gerente extends Usuario{

    public Gerente(String idGerente, String nombre, String contra) {
        super(nombre, contra);
        this.idGerente = idGerente;
    }
    private String idGerente;

    public String getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(String idGerente) {
        this.idGerente = idGerente;
    }
    
}
