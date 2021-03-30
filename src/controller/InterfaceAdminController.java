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
    private Button home;
    @FXML
    private Button gererForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         // go to home
           home.setOnAction(event -> {
               Parent page1;
             try {
                page1 = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Brainovation");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
  
        });
         
         
         //home
    }   
    @FXML
    private void supprimer(MouseEvent event) {
        loadPage("/view/affetsupp.fxml");
    }
     @FXML
    private void gererformateur(MouseEvent event) {
          loadPage("/view/gererFormateur.fxml");
    }
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Bpadmin.setCenter(root);
            
        }

    @FXML
    private void listerForm(ActionEvent event) {
        loadPage("/view/TableForm.fxml");
    }

   

    
}
