/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.Kasir;
import view.viewKasir;


public class controllerKasir {

    private Kasir kasir;
    private viewKasir vK;

    public controllerKasir(viewKasir vK) {
        this.vK = vK;
    }

    public void simpanTransaksi() {
        kasir = new Kasir();
        kasir.setNamaPembeli(vK.getNamaPembeli().getText());
        kasir.setTglTransaksi(LocalDate.now());
        kasir.setJumlahBarang(vK.getJumlahBarang().getText());
        kasir.setTotalBelanja(vK.getTotal().getText());

        kasir.simpanDataTransaksi();

        for (int i = 0; i < vK.getTabelKasir().getRowCount(); i++) {
            String idBarang = vK.getTabelKasir().getValueAt(i, 0).toString();
            int qty = Integer.parseInt(vK.getTabelKasir().getValueAt(i, 3).toString());

            Barang barang = new Barang();
            barang.kurangiStok(idBarang, qty);
            System.out.println("ID: " + idBarang + " | QTY: " + qty);
        }
        
    }

    public void bayar() {
        int total = Integer.parseInt(vK.getTotal().getText());
        int bayar = Integer.parseInt(vK.getBayar().getText());

        int kembali = bayar - total;
        vK.getKembali().setText(String.valueOf(kembali));
    }

    public void resetForm() {
        vK.getNamaBarang().setText("");
        vK.getHargaBarang().setText("");
        vK.getJmlBeli().setValue(1);
        vK.getLabelTotalHarga().setText("0");
        vK.getNamaPembeli().setText("");
        vK.getTotal().setText("0");
        vK.getJumlahBarang().setText("");
        vK.getBayar().setText("");
        vK.getKembali().setText("");

        DefaultTableModel model = (DefaultTableModel) vK.getTabelKasir().getModel();
        model.setRowCount(0);
    }

    public void controlButtonBayar() {
        vK.getTombolSelesai().setEnabled(false);
        vK.getTombolBayar().setEnabled(true);
        vK.getTombolBatalTransaksi().setEnabled(true);
        vK.getTombolTambahBarang().setEnabled(true);
    }

    public void controlButtonSelesai() {
        vK.getTombolSelesai().setEnabled(true);
        vK.getTombolBayar().setEnabled(false);
        vK.getTombolBatalTransaksi().setEnabled(false);
        vK.getTombolTambahBarang().setEnabled(false);
    }
}
