package DAO;

/**
 *
 * @author Ariel AB
 */
public class Cliente {

    private int id;
    private String nombre;
    private String telefono;
    private String direccion;

    public Cliente(int id, String nombre, String telefono, String direccion) {
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.id = id;
    }

    public Cliente(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
