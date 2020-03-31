/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;

/**
 *
 * @author Ariel AB
 */
public class Conexion {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URLSTRING = "jdbc:mysql://localhost:3306/softrolldb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    Connection conn;

    public Conexion() throws SQLException {
        conn = DriverManager.getConnection(URLSTRING, USERNAME, PASSWORD);
        System.out.println("Conectado");
    }

}
