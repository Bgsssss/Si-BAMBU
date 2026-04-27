/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.Koneksi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Bagas Saputra
 */
public class Kasir {

    private String namaPembeli;
    private String jumlahBarang;
    private String totalBelanja;
    private LocalDate tglTransaksi;

    Koneksi koneksi = new Koneksi();

    public LocalDate getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(LocalDate tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getNamaPembeli() {
        return namaPembeli;
    }

    public void setNamaPembeli(String namaPembeli) {
        this.namaPembeli = namaPembeli;
    }

    public String getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(String jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getTotalBelanja() {
        return totalBelanja;
    }

    public void setTotalBelanja(String totalBelanja) {
        this.totalBelanja = totalBelanja;
    }

    public void simpanDataTransaksi() {
        String sql = "INSERT INTO transaksi (namaPembeli, tglTransaksi, jmlBarang, total) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement eksekusi = koneksi.getConnect().prepareStatement(sql);

            eksekusi.setString(1, getNamaPembeli());

            eksekusi.setDate(2, java.sql.Date.valueOf(getTglTransaksi()));

            eksekusi.setInt(3, Integer.parseInt(getJumlahBarang()));
            eksekusi.setDouble(4, Double.parseDouble(getTotalBelanja()));

            eksekusi.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan\n" + ex.getMessage());
        }

    }
}
