/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bagas Saputra
 */
public class Signup {
    private String username;
    private String password;
    private String level;
    
    Koneksi koneksi = new Koneksi();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public void daftarAkun(){
        String sql = "INSERT INTO user (username, password, level) VALUES "
                + "('"+getUsername()+"', '"+getPassword()+"', '"+getLevel()+"')";
        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Signup Berhasil");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Signup Gagal\n"+ex);            
        }
    }
}
