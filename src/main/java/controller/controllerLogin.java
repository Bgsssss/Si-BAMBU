/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.bumbu.mainAppAdm;
import com.bumbu.mainApp;
import database.Koneksi;
import view.viewLogin;


public class controllerLogin {
    private viewLogin vL;
    
    public controllerLogin(viewLogin vL){
        this.vL = vL;
    }
    
    public void loginAdmin(){
        String sql = "SELECT * FROM user WHERE username='"+vL.getUsername().getText()+"' AND "
            + "password='"+vL.getPassword().getText()+"' AND (level='admin' OR level='super admin')";
    try {
        Statement stat = (Statement) Koneksi.getConnect().createStatement();
        ResultSet res = stat.executeQuery(sql);

        if (res.next()){
            String roleDariDB = res.getString("level"); // ambil dari kolom level di tabel user
            JOptionPane.showMessageDialog(null, "Login Sukses");
            vL.dispose();

            mainAppAdm main = new mainAppAdm(roleDariDB); // kirim role asli, bukan dari combobox
            main.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Username atau Password Salah");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "ERROR");
    }
    }
    
    public void loginKasir(){
        String sql = "SELECT * FROM user WHERE username='"+vL.getUsername().getText()+"' AND "
                + "password='"+vL.getPassword().getText()+"' AND level='kasir'";
        try {
            Statement stat = (Statement) Koneksi.getConnect().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            if (res.next()){
                JOptionPane.showMessageDialog(null, "Login Sukses");
                vL.dispose();
                
                mainApp main = new mainApp();
                main.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
    }
}
