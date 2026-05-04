/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pemasok;
import view.viewPemasok;

/**
 *
 * @author Bagas Saputra
 */
public class controllerPemasok {

    private Pemasok pemasok;
    private viewPemasok vP;

    public controllerPemasok(viewPemasok vP) {
        this.vP = vP;
    }

    public void deleteForm() {
        vP.getIdPemasok().setText("");
        vP.getNamaPemasok().setText("");
        vP.getAlamat().setText("");
        vP.getKontak().setText("");
    }

    public void controlButton() {
        vP.getTombolTambah().setEnabled(true);
        vP.getTombolEdit().setEnabled(false);
        vP.getTombolHapus().setEnabled(false);
        vP.getTombolBatal().setEnabled(true);
    }

    public void controlButton2() {
        vP.getTombolTambah().setEnabled(false);
        vP.getTombolEdit().setEnabled(true);
        vP.getTombolHapus().setEnabled(true);
        vP.getTombolBatal().setEnabled(true);
    }

    public void simpanData() {
        pemasok = new Pemasok();
        pemasok.setNamaPemasok(vP.getNamaPemasok().getText());
        pemasok.setAlamat(vP.getAlamat().getText());
        pemasok.setKontak(vP.getKontak().getText());

        pemasok.simpanDataPemasok();
        deleteForm();
    }

    public void ubahData() {
        pemasok = new Pemasok();
        pemasok.setIdPemasok(vP.getIdPemasok().getText());
        pemasok.setNamaPemasok(vP.getNamaPemasok().getText());
        pemasok.setAlamat(vP.getAlamat().getText());
        pemasok.setKontak(vP.getKontak().getText());
        
        pemasok.ubahDataPemasok();
        deleteForm();
        controlButton();
    }

    public void hapusData() {
        pemasok = new Pemasok();
        pemasok.setIdPemasok(vP.getIdPemasok().getText());

        pemasok.hapusDataPemasok();
        deleteForm();
        controlButton();
    }
}
