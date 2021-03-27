/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationDetailsController implements Initializable {

    @FXML
    private Label titreLab;
    @FXML
    private Label descLab;
    @FXML
    private Label prixLab;
    private Formation formation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setFormation(Formation f){
        this.formation = f;
        titreLab.setText(f.getTitle());
        descLab.setText(f.getDescription());
        prixLab.setText(""+f.getPrix()+" DT ");
      
    }
    
}
