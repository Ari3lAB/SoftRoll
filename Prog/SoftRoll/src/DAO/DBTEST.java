package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ariel AB
 */
public class DBTEST {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DRIVER = "org.gjt.mm.mysql.Driver";
    private static final String URLSTRING = "jdbc:mysql://localhost:3306/softrolldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URLSTRING, USERNAME, PASSWORD);
            System.out.println("Conectado");
            conn.close();
            System.out.println("Desconectado");
        } catch (SQLException ex) {
            System.err.println(ex);
        }

//        try {
//            ControlDB.getInstance().AgregarOrden(1, 2, "Activa", (float) 100.00);
//            System.out.println("Conectado");
//            conn.close();
//            System.out.println("Desconectado");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//        System.out.println(ControlDB.getInstance().ObtenerTiempo());
//
//        try {
//            System.out.println(ControlDB.getInstance().ObtenerProductos().toString());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            System.out.println(ControlDB.getInstance().ObtenerUsuarios().toString());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }
}
