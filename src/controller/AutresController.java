/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import service.Operation;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AutresController implements Initializable {

   
    @FXML
    private Button suiv;
    @FXML
    private Button cont;
    @FXML
    private BorderPane bpautre;
    @FXML
    private Label labid;
    private int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bpautre.setCenter(root);}
     private void  loadPageSuiv(String page,int n){
         Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             SuivreReclamationController cont = loader.<SuivreReclamationController>getController();
           Operation oper=new Operation();
           String emailuser=oper.recEmailUser(n);
           cont.setId(n);
           cont.setEmail(emailuser);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bpautre.setCenter(parent);}

    @FXML
    private void suivre(ActionEvent event) {
        loadPageSuiv("/view/Suivrereclamation.fxml",Integer.parseInt(labid.getText()));
    }

    @FXML
    private void contacter(ActionEvent event) {
        loadPage("/view/Mail.fxml");
    }
      
     public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
      
    
}
