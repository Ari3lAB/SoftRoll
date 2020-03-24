/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private static final String URLSTRING = "jdbc:mysql://localhost:3306/softrolldb";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Connection conn = null;
    
    try {
        conn = DriverManager.getConnection(URLSTRING,USERNAME,PASSWORD);
        System.out.println("Conectado");
    }   catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
}
