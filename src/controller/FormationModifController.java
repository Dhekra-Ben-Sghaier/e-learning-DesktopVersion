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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationModifController implements Initializable {

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
    private Button btnModif;
    
    private Formation formation;
    @FXML
    private Label idLab;
    @FXML
    private Button btnCours;
    @FXML
    private TextField cours;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    public void setFormation(Formation f){
        this.formation = f;
        idLab.setText(""+f.getId());
        titleField.setText(f.getTitle());
        descField.setText(f.getDescription());
        prixField.setText(""+f.getPrix());
        diffField.setText(f.getDifficulte());
    }
    
    @FXML
    private void modifierFormation(ActionEvent event) {
        Formation f = new Formation(Integer.parseInt(idLab.getText()), titleField.getText(), descField.getText(), Float.parseFloat(prixField.getText()), diffField.getText());
            FormationDao fdao = FormationDao.getInstance();
            
            
           fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Formation modifiée avec succés!");
            alert.show();
            titleField.setText("");
            descField.setText("");
    }

    @FXML
    private void ajoutPdf(ActionEvent event) {
    }
    
}
