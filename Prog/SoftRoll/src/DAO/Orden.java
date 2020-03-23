package DAO;

/**
 *
 * @author Ariel AB
 */
public class Orden {
    private String id;
    private Usuario user;
    private Cliente cliente;
    private String fecha;
    private String estado;
    private float pagoTotal;
    private short descuento;    

    public Orden(String id, Usuario user, Cliente cliente, String fecha, String estado, float pagoTotal, short descuento) {
        this.id = id;
        this.user = user;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.pagoTotal = pagoTotal;
        this.descuento = descuento;
    }

    public Orden(String id, Usuario user, Cliente cliente, String fecha, String estado) {
        this.id = id;
        this.user = user;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getPagoTotal() {
        return pagoTotal;
    }

    public void setPagoTotal(float pagoTotal) {
        this.pagoTotal = pagoTotal;
    }

    public short getDescuento() {
        return descuento;
    }

    public void setDescuento(short descuento) {
        this.descuento = descuento;
    }
    
}
