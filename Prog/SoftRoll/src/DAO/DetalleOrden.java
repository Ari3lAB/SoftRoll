package DAO;

/**
 *
 * @author Ariel AB
 */
public class DetalleOrden {

    private int id;
    private int idOrden;
    private int idProducto;
    private int cantidad;
    private String notas;

    public DetalleOrden(int idOrden, int idProducto, int cantidad, String notas) {
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.notas = notas;
    }

    public DetalleOrden(int id, int idOrden, int idProducto, int cantidad, String notas) {
        this.id = id;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.notas = notas;
    }

    public DetalleOrden(int id, int idOrden, int idProducto, int cantidad) {
        this.id = id;
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

}
