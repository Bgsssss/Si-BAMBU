/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Barang;
import view.viewBarang;


public class controllerBarang {
    private Barang barang;
    private viewBarang vB;
    
    public controllerBarang(viewBarang vB){
        this.vB = vB;
    }
    
    public void deleteForm(){
       vB.getIdBarang().setText("");
       vB.getNamaBarang().setText("");
       vB.getKategori().setSelectedItem("");
       vB.getModal().setText("");
       vB.getHargaJual().setText("");
       vB.getStok().setValue(0);
    }
    
    public void controlButton(){
        vB.getTombolTambah().setEnabled(true);
        vB.getTombolEdit().setEnabled(false);
        vB.getTombolHapus().setEnabled(false);
        vB.getTombolBatal().setEnabled(true);
    }
    
    public void controlButton2(){
        vB.getTombolTambah().setEnabled(false);
        vB.getTombolEdit().setEnabled(true);
        vB.getTombolHapus().setEnabled(true);
        vB.getTombolBatal().setEnabled(true);
    }
    
    public void simpanData(){
        barang = new Barang();
        barang.setNamaBarang(vB.getNamaBarang().getText());
        barang.setKategori(vB.getKategori().getSelectedItem().toString());
        barang.setModal(vB.getModal().getText());
        barang.setHargaJual(vB.getHargaJual().getText());
        barang.setStok(Integer.parseInt(vB.getStok().getValue().toString()));
        
        barang.simpanDataBarang();
        deleteForm();
    }
    
    public void ubahData(){
        barang = new Barang();
        barang.setIdBarang(vB.getIdBarang().getText());
        barang.setNamaBarang(vB.getNamaBarang().getText());
        barang.setKategori(vB.getKategori().getSelectedItem().toString());
        barang.setModal(vB.getModal().getText());
        barang.setHargaJual(vB.getHargaJual().getText());
        barang.setStok(Integer.parseInt(vB.getStok().getValue().toString()));
        
        barang.ubahDataBarang();
        deleteForm();
        controlButton();
    }
    
    public void hapusData(){
        barang = new Barang();
        barang.setIdBarang(vB.getIdBarang().getText());
        
        barang.hapusDataBarang();
        deleteForm();
        controlButton();
    }
}
