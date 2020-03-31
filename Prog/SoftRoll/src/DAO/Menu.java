package DAO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariel AB
 */
public class Menu {

    private ArrayList productos;

    public Menu(List<Producto> productos) {
        this.productos = new ArrayList(productos);
    }

    public List<Producto> getProductos() {
        return productos;
    }

}
