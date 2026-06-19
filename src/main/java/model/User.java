/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class User {

    private String idUser;
    private String username;
    private String password;
    private String level;

    Koneksi koneksi = new Koneksi();

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

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

    public void tambahDataUser() {
        String sql = "INSERT INTO user (username, password, level) VALUES (?, ?, ?)";
        try {
            Connection conn = Koneksi.getConnect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.username);
            pstmt.setString(2, this.password);
            pstmt.setString(3, this.level);

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menambahkan data: " + ex.getMessage());
        }
    }

    public void ubahDataUser() {
        //inisialisasi query untuk update kedalam database
        String sql = "UPDATE user SET username = '" + getUsername() + "'"
                + ", password = '" + getPassword() + "'"
                + ", level = '" + getLevel() + "' WHERE idUser = '" + getIdUser() + "'";
        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah\n" + ex);
        }

    }

    public void hapusDataUser() {
        //inisialisasi query untuk update kedalam database
        String sql = "DELETE FROM user WHERE idUser = '" + getIdUser() + "'";
        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus\n" + ex);
        }
    }
}
