package DAO;

import java.util.List;

/**
 *
 * @author Ariel AB
 */
public class Menu {

    public Menu(List<Producto> productos) {
        this.productos = productos;
    }

    private List<Producto> productos;

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

}
