/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField descField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField diffField;
    @FXML
    private TextField certifField;
    @FXML
    private Button btnAjout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajouterFormation(ActionEvent event) {
        
        btnAjout.setOnAction((ActionEvent event1) -> {
            Formation f = new Formation(Integer.parseInt(idField.getText()), titleField.getText(), descField.getText(), Float.parseFloat(prixField.getText()), diffField.getText());
            FormationDao fdao = FormationDao.getInstance();
            fdao.insert(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Personne insérée avec succés!");
            alert.show();
            titleField.setText("");
            descField.setText("");
        });
    }
    
}
