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
public class Pemasok {
    
   private String idPemasok;
   private String namaPemasok;
   private String alamat;
   private String kontak;
   
   Koneksi koneksi = new Koneksi();

    public String getIdPemasok() {
        return idPemasok;
    }

    public void setIdPemasok(String idPemasok) {
        this.idPemasok = idPemasok;
    }

    public String getNamaPemasok() {
        return namaPemasok;
    }

    public void setNamaPemasok(String namaPemasok) {
        this.namaPemasok = namaPemasok;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
   
   
    public void simpanDataPemasok() {
        //inisialisasi query untuk insert kedalam database
        String sql = ("INSERT INTO pemasok (namaPemasok, alamat, kontak) "
                + " VALUES ('" + getNamaPemasok()+ "', '" + getAlamat()+ "' "
                + ", '" + getKontak()+ "')");

        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan\n" + ex);
        }

    }
    
    public void ubahDataPemasok() {
        //inisialisasi query untuk update kedalam database
        String sql = "UPDATE pemasok SET namaPemasok = '" + getNamaPemasok() + "'"
                + ", alamat = '" + getAlamat() + "'"
                + ", kontak = '" + getKontak()+"'" 
                +" WHERE idPemasok = '" + getIdPemasok() + "'";
        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah\n" + ex);
        }

    }
    
    public void hapusDataPemasok() {
        //inisialisasi query untuk update kedalam database
        String sql = "DELETE FROM pemasok WHERE idPemasok = '" + getIdPemasok()+ "'";
        try {
            //inisialisasi preparedStatement
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.execute();
            //pemberitahuan jika data berhasil disimpan
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus\n" + ex);
        }
    }
}
