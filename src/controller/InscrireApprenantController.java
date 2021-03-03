/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class InscrireApprenantController implements Initializable {
    ObservableList<String> centreInteret=FXCollections.observableArrayList("cv1","cd2","cd3");
    @FXML
    private Button btn_add;
    @FXML
    private ComboBox<String> cd;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField nomuser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cd.setItems(centreInteret);
       btn_add.setOnAction(event -> {
            
            Apprenant p = new Apprenant(nom.getText(), prenom.getText(),email.getText(),mdp.getText(),nomuser.getText(),cd.getValue(),"Apprenant");
           AppDao pdao = AppDao.getInstance();
            pdao.insert(p);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        nom.setText("");
        prenom.setText("");
        email.setText("");
        mdp.setText("");
        nomuser.setText("");
        cd.setValue("Centres d'intérêt");
        });
    }    
 
}
