/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.InscrireApprenantController.hashPassword;
import service.Operation;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author benha
 */
public class ChangermdpController implements Initializable {

    @FXML
    private PasswordField mdp;
    @FXML
    private PasswordField cofirmMdp;
    @FXML
    private Button btn_valid;
    
    private int id;
    @FXML
    private Label lab_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          btn_valid.setOnAction(event -> {
             
             if (mdp.getText().equals(cofirmMdp.getText())){
                   Operation o =new Operation();
                   o.update(hashPassword(mdp.getText()), Integer.parseInt(lab_id.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Votre mdp a été changé avec succés!");
        alert.show();
        
             try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Brainovation");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ChangermdpController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
             }else {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ces mots de passe ne correspondent pas. Veuillez réessayer.!");
        alert.show();
             }
        });
    }    
     public void setId(int a){
        this.id= a;
        lab_id.setText(a+"");
      
        
    }
}
