/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class UserPanelController implements Initializable {

    @FXML
    private Label br;
    @FXML
    private BorderPane bp;
    @FXML
    private Button btn_acc;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn5;
    @FXML
    private Button btn4;
    @FXML
    private AnchorPane contenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void goToHome(MouseEvent event) {
        bp.setCenter(contenu);
    }
    private void inscrire(MouseEvent event) {
        loadPage("/view/inscription.fxml");
    }
    private void modifierFormation(MouseEvent event) {
        loadPage("Formation");
    }
    
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UserPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
            
        }

    @FXML
    private void inscrire(javafx.scene.input.MouseEvent event) {
    }

    @FXML
    private void inscrire(ActionEvent event) {
    }
}
