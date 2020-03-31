package DAO;

/**
 *
 * @author Ariel AB
 */
public class Producto {

    private int id;
    private String nombre;
    private float precio;
    private int categoría;
    private boolean promo;

    public Producto(int id, String nombre, float precio, int categoría, boolean promo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoría = categoría;
        this.promo = promo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCategoría() {
        return categoría;
    }

    public void setCategoría(int categoría) {
        this.categoría = categoría;
    }

}
