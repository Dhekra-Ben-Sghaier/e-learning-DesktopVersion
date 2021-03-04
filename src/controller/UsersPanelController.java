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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class UsersPanelController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Label br;
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
    @FXML
    private Button btn_auth;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btn_auth.setOnAction(event -> {

            try {
                Parent page2 = FXMLLoader.load(getClass().getResource("/view/interfaceAdmin.fxml"));
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InscriptionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    private void goToHome(MouseEvent event) {
        bp.setCenter(contenu);
    }

    @FXML
    private void inscrire(MouseEvent event) {
        loadPage("/view/inscription.fxml");
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
}
