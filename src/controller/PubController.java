/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Const.user_pwd;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



/**
 * FXML Controller class
 *
 * @author hp
 */
public class PubController implements Initializable {
    private TextField username ;
    private PasswordField Password ;
    @FXML
    private Button btn;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        private void login(ActionEvent event) {
          String user;
        user = username.getText();
          String pwd = Password.getText();
          if (user.trim().equalsIgnoreCase(user_pwd.user) && pwd.trim().equalsIgnoreCase(user_pwd.pwd)) 
                  { System.out.println("Succès");
                  } else{ System.out.println("failed");
                          } 
          System.out.println("PubController.login()");
        } 
        
    }    
    

