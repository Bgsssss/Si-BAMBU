/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Signup;
import view.viewSignup;

public class controllerSignup {
    private viewSignup vS;
    private Signup signup;
    
    public controllerSignup(viewSignup vS){
        this.vS = vS;
    }
    
    public void signup(){
        signup = new Signup();
        
        signup.setUsername(vS.getUsername().getText());
        signup.setPassword(vS.getPassword().getText());
        signup.setLevel(vS.getLevel().getSelectedItem().toString());
        
        signup.daftarAkun();
    }
}
