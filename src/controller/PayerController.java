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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class PayerController implements Initializable {

    @FXML
    private Button btnPay;
    @FXML
    private Label idLab;
    @FXML
    private Label titleLab;
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
        idLab.setText(""+f.getId());
        titleLab.setText(f.getTitle());
        descLab.setText(f.getDescription());
        prixLab.setText(""+f.getPrix()+" DT ");
      
    }
    
    @FXML
    private void payer(MouseEvent event) {
        Formation f = new Formation();
        FormationDao fdao = FormationDao.getInstance();
        fdao.insertAchat(1,Integer.parseInt(idLab.getText()));


    }
    
}
