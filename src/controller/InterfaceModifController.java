/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.AppDao;
import entity.Apprenant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class InterfaceModifController implements Initializable {
 ObservableList<String> centreInteret=FXCollections.observableArrayList("cv1","cd2","cd3");
    @FXML
    private TextField txt_cin;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_user;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_prenom;
    @FXML
    private ComboBox<String> cb_cinteret;
    @FXML
    private PasswordField txt_mdp;
    private Apprenant apprenant;
    @FXML
    private Label id_lab;
    @FXML
    private Button bt_modif;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cb_cinteret.setItems(centreInteret);
         bt_modif.setOnAction(event -> {

              Apprenant f = new Apprenant(Integer.parseInt(id_lab.getText()), txt_cin.getText(), txt_nom.getText(), txt_prenom.getText(), txt_email.getText(), txt_mdp.getText(), txt_user.getText(), cb_cinteret.getValue());
           AppDao fdao = AppDao.getInstance();
            
            
           fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Apprenant modifiée avec succés!");
            alert.show();
        });
        
    } 
    // recuperer les donnés de la table view apprneants
    public void setApprenant(Apprenant a){
        this.apprenant= a;
        id_lab.setText(""+a.getId());
       txt_cin.setText(a.getCin());
       txt_nom.setText(a.getNom());
       txt_prenom.setText(a.getPrenom());
       txt_email.setText(a.getEmail());
       txt_mdp.setText(a.getMdp());
       txt_user.setText(a.getLogin());
      cb_cinteret.setValue(a.getCd());
        
    }

    
    
}
