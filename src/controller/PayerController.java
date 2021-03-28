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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.FormationDao;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

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
    @FXML
    private TextField idField;
    @FXML
    private TextField numCarteField;
    @FXML
    private TextField codeConfidField;

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
       
          if("".equals(idField.getText()) || "".equals(numCarteField.getText()) || "".equals(codeConfidField.getText())){
                    verifField();
                } 
          else {
        Formation f = new Formation();
        FormationDao fdao = FormationDao.getInstance();
        fdao.insertAchat(1,Integer.parseInt(idLab.getText()));
          }
       
     

    }
    public void verifField(){
        
        if("".equals(idField.getText())){
                    idField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                } 
                if("".equals(numCarteField.getText())){
                numCarteField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(codeConfidField.getText())){
                codeConfidField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }

        } 
    @FXML
    private void verifId(MouseEvent event) {
    }

    @FXML
    private void verifCarte(MouseEvent event) {
    }

    @FXML
    private void verifCode(MouseEvent event) {
    }
    
}
