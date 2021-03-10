/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
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
    private AnchorPane contenu;
    private Button btn_auth;
    @FXML
    private Button btn_cat;
    @FXML
    private Button btn_os;
    @FXML
    private Button btn_rec;
    @FXML
    private Button btn_pub;
    @FXML
    private Button btn_ct;
    @FXML
    private Button btn_conn;
    @FXML
    private Button btn_insc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btn_conn.setOnAction(event -> {

              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
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
        bp.setCenter(root);
         }
        bp.setCenter(root);
            
        }
    public void  loadhead(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UserPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setTop(root);
            
        }

}
