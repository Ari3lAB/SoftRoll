package DAO;

/**
 *
 * @author Ariel AB
 */
public class Orden {

    private int id;
    private int user;
    private int cliente;
    private String nombreUsuario;
    private String nombreCliente;
    private String fecha;
    private String estado;
    private float pagoTotal;
    private short descuento;

    public Orden(int user, int cliente, String fecha, String estado, float pagoTotal, short descuento) {
        this.user = user;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
        this.pagoTotal = pagoTotal;
        this.descuento = descuento;
    }

    public Orden(int user, int cliente, String fecha, String estado) {
        this.user = user;
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Orden(int id, int idCliente, int idUser, String fecha, String estado, float pagoTotal, short descuento) {
        this.id = id;
        this.user = idUser;
        this.cliente = idCliente;
        this.fecha = fecha;
        this.estado = estado;
        this.pagoTotal = pagoTotal;
        this.descuento = descuento;
    }

    public Orden(int id, int idCliente, int idUser, String fecha, String estado) {
        this.id = id;
        this.user = user;
        this.cliente = idCliente;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Orden(int id, String nombreUsuario, String fecha, float pagoTotal) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.pagoTotal = pagoTotal;
    }

    public Orden(int id, String nombreUsuario, String fecha, String estado) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getCliente() {
        return cliente;
    }

    public String getNombreCliente() {
        return ControlDao.getInstance().BuscarNombreCliente(cliente);
    }

    public void setCliente(int cliente) {
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
