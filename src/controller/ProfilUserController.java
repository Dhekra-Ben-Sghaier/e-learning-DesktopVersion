/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import static controller.InscrireApprenantController.hashPassword;
import dao.Operation;
import entity.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ProfilUserController implements Initializable {

    @FXML
    private Tab compte;
    @FXML
    private Tab photo;
    @FXML
    private JFXTabPane profilUser;
    
    private Personne personne;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField nomUser;
    @FXML
    private JFXPasswordField mdp_act;
    @FXML
    private JFXPasswordField mdp_new;
    @FXML
    private JFXPasswordField mdp_conf;
    @FXML
    private Button btn_sauv;
    @FXML
    private Button btn_info;
    
    private int id;
    @FXML
    private Label lab_id;
    @FXML
    private Label lab_user;
    @FXML
    private Label lab_mdp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            Parent node= FXMLLoader.load(getClass().getResource("/view/compte.fxml"));
//            
//            compte.setContent(node);
//            
//        } catch (IOException ex) {
//            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
//        }
  btn_info.setOnAction(event -> {

            Operation info=new Operation();
            
            info.updateInfo(nom.getText(), prenom.getText(), email.getText(), nomUser.getText(), Integer.parseInt(lab_id.getText()));
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Informations sauvegardés!");
            alert.show();
        });
   btn_sauv.setOnAction(event -> {

            Operation info=new Operation();
            int count=0;
           String password=info.isPassword(lab_user.getText());
                if(BCrypt.checkpw(mdp_act.getText(),password)){
                    count=1;
                }
                 if (mdp_new.getText().equals(mdp_conf.getText()) && count ==1){
                   Operation o =new Operation();
                   o.update(hashPassword(mdp_new.getText()), Integer.parseInt(lab_id.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Votre mdp a été changé avec succés!");
        alert.show();
              
               
                 } if(count != 1){
                      lab_mdp.setText("Mot de passe incorrect");
                 } if (mdp_new.getText().equals(mdp_conf.getText())==false) {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ces mots de passe ne correspondent pas. Veuillez réessayer.!");
        alert.show();
             }
           
        });
        
        
    }    
    
  
     //rec infos user
     public void setPersonne(Personne a){
        this.personne= a;
       lab_user.setText(a.getLogin());
       nom.setText(a.getNom());
       prenom.setText(a.getPrenom());
       email.setText(a.getEmail());
       nomUser.setText(a.getLogin());
        
    }
      public void setId(int a){
        this.id= a;
        lab_id.setText(a+"");
      
        
    }
}
