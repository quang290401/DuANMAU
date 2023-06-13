/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author forre
 */
public class ConnectionSQL {
    public static Connection GetConnetion() throws SQLException{
        String dbul = "jdbc:sqlserver://localhost:1433;databaseName=DuAnMau;user=sa"
                + ";password=quang@201;encrypt=true;trustServerCertificate=true";
        try {
            return DriverManager.getConnection(dbul);
        } catch (SQLException ex) {
         throw ex;
        }
       
    }
     public static void closeJDBC(Connection cone, PreparedStatement stm, ResultSet rs) {
           if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    
                }
            }
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                   
                }
            }
            if (cone != null) {
                try {
                    cone.close();
                } catch (SQLException ex) {
                   
                }
            }
    }

  
}
