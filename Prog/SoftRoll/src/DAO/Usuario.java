
package DAO;

/**
 *
 * @author Ariel AB
 */
public class Usuario {  
    private int id;
    private String nombre;
    private String contra;
    private boolean adminstrador;

    public Usuario(int id, String nombre, String contra, boolean admin) {
        this.id = id;
        this.nombre = nombre;
        this.contra = contra;
        this.adminstrador = admin;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    
}
