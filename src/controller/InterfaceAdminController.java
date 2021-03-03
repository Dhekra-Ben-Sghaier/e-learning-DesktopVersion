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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class InterfaceAdminController implements Initializable {

    @FXML
    private BorderPane Bpadmin;
    @FXML
    private Button gererP;
    @FXML
    private Button gererF;
    @FXML
    private Button gererR;
    @FXML
    private Button gererC;
    @FXML
    private Label gererOC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
    }   
    @FXML
    private void supprimer(MouseEvent event) {
        loadPage("/view/affetsupp.fxml");
    }
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UserPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Bpadmin.setCenter(root);
            
        }

    
}
