/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.InscrireApprenantController.hashPassword;
import dao.SocDao;
import dao.ControleSaisie;
import entity.Societe;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class InscrireSocController implements Initializable {

    @FXML
    private TextField nom;
    
    @FXML
    private TextField email;
    @FXML
    private TextField txt_mdp;
    @FXML
    private TextField nomuser;
    @FXML
    private Button btn_add;
    @FXML
    private CheckBox check_af;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button btn_retour;
    @FXML
    private Label lab_email;
    @FXML
    private TextField adresse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btn_add.setOnAction(event -> {
      
           if(ControleSaisie.isNull(nom.getText())  || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(mdp.getText()) || ControleSaisie.isNull(nomuser.getText()))
           {
             Alert alerts = new Alert(Alert.AlertType.WARNING);
        alerts.setTitle("Warning");
        alerts.setHeaderText(null);
        alerts.setContentText("Veuillez remplir les champs!");
        alerts.show();
           }else {
             if(ControleSaisie.validemail(email.getText())== false){
                 lab_email.setText("Veuillez saisir une adresse email valide !");
             } 
             if(ControleSaisie.validemail(email.getText()) ){
               
                 
             
               Societe f = new Societe(email.getText(), hashPassword(mdp.getText()),nomuser.getText(),nom.getText());
            SocDao fdao = SocDao.getInstance();
            fdao.insert(f);
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Société insérée avec succés!");
        alert.show();
        
        nom.setText("");
        
        email.setText("");
        mdp.setText("");
        nomuser.setText("");
        
        lab_email.setText("");
       
             }
             
           }
        });
       // end inserer
       btn_retour.setOnAction(event -> {
             try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InscrireSocController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
  
        });
       //aff mdp
       txt_mdp.setVisible(false);
       check_af.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_value, Boolean newValue) -> {
       if(check_af.isSelected()){
           txt_mdp.setText(mdp.getText());
           txt_mdp.setVisible(true);
           mdp.setVisible(false);
           return;
           
       }
       mdp.setText(txt_mdp.getText());
       mdp.setVisible(true);
       txt_mdp.setVisible(false);
       
       });
       //end aff mdp
            
    }


       
    
}
