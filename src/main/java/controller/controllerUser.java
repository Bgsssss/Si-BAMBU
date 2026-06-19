/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import view.viewUser;

public class controllerUser {

    private viewUser vU;
    private User user;

    public controllerUser(viewUser vU) {
        this.vU = vU;
    }

    public void tambahUser() {
        user = new User();
        user.setUsername(vU.getUsername().getText());
        user.setPassword(vU.getPassword().getText());
        user.setLevel(vU.getLevel().getSelectedItem().toString());

        user.tambahDataUser();
        deleteForm();
    }

    public void editUser() {
        user = new User();
        user.setIdUser(vU.getIdUser().getText());
        user.setUsername(vU.getUsername().getText());
        user.setPassword(vU.getPassword().getText());
        user.setLevel(vU.getLevel().getSelectedItem().toString());

        user.ubahDataUser();
        deleteForm();
    }

    public void deleteUser() {
        user = new User();
        user.setIdUser(vU.getIdUser().getText());

        user.hapusDataUser();
        deleteForm();
    }

    public void deleteForm() {
        vU.getIdUser().setText("");
        vU.getUsername().setText("");
        vU.getPassword().setText("");
        vU.getLevel().setSelectedItem("");
    }

    public void controlButton1() {
        vU.getTombolEdit().setEnabled(true);
        vU.getTombolDelete().setEnabled(true);
    }

    public void controlButton2() {
        vU.getTombolEdit().setEnabled(false);
        vU.getTombolDelete().setEnabled(false);
    }
}
