/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recnote;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button formations;
    @FXML
    private Button autres;
    @FXML
    private AnchorPane contenu;
    @FXML
    private BorderPane bp;
    @FXML
    private Button Notes;
    @FXML
    private Button consulter;
 

    /**
     * Initializes the controller class.
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
  
           consulter.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/Consulter.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
           });
          
          autres.setOnAction(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/Autres.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
//            formations.setOnAction(event -> {
//
//            try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/view/Recformation.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
//            }
           
     
   // });  
    
     }
//    private void reclamer(MouseEvent event) {
//               loadPage("/view/Recnote.fxml");
//    }
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bp.setCenter(root);
            
        }

    @FXML
    private void reclamer(javafx.scene.input.MouseEvent event) {
        loadPage("/view/Recnote.fxml");
        
    }




    @FXML
    private void former(javafx.scene.input.MouseEvent event) {
          loadPage("/view/Recformation.fxml");
    }
    
        
   
    


    }


    
