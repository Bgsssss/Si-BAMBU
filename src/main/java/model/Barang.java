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
public class Barang {
    private String idBarang;
    private String namaBarang;
    private String kategori;
    private String modal;
    private String hargaJual;
    private int stok;

    Koneksi koneksi = new Koneksi();

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public String getHargaJual() {
        return hargaJual;
    }

    public void setHargaJual(String hargaJual) {
        this.hargaJual = hargaJual;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void simpanDataBarang() {
        //inisialisasi query untuk insert kedalam database
        String sql = ("INSERT INTO barang (namaBarang, kategori, modal, hargaJual, stok) "
                + " VALUES ('" + getNamaBarang() + "', '" + getKategori() + "' "
                + ", '" + getModal() + "', '" + getHargaJual() + "', '" + getStok() + "')");

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

    public void ubahDataBarang() {
        //inisialisasi query untuk update kedalam database
        String sql = "UPDATE barang SET namaBarang = '" + getNamaBarang() + "'"
                + ", kategori = '" + getKategori() + "'"
                + ", modal = '" + getModal() + "'"
                + ", hargaJual = '" + getHargaJual() + "'"
                + ", stok = '" + getStok() + "' WHERE idBarang = '" + getIdBarang() + "'";
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

    public void hapusDataBarang() {
        //inisialisasi query untuk update kedalam database
        String sql = "DELETE FROM barang WHERE idBarang = '" + getIdBarang() + "'";
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

    public void kurangiStok(String idBarang,int jumlahBeli) {
        String sql = "UPDATE barang SET stok = stok - ? WHERE idBarang = ? AND stok >= ?";
        try {
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);
            eksekusi.setInt(1, jumlahBeli);
            eksekusi.setString(2, idBarang);
            eksekusi.setInt(3, jumlahBeli);
            
            int affected = eksekusi.executeUpdate();

            if (affected == 0) {
                JOptionPane.showMessageDialog(null, "Stok tidak cukup!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
