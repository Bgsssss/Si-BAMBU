/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Koneksi {
    private static Connection conn;
    
    public static Connection getConnect() throws SQLException{
        if(conn==null){
            try {
                String url = "jdbc:mysql://localhost:3306/dbtokodesktop";
                String username = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                conn = DriverManager.getConnection(url, username, password);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connect Database Gagal");
            }
        }
        return conn;
    }
}
