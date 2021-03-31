/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recformation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.RecformationDao;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifforController implements Initializable {

    @FXML
    private TextField mdfr;
    @FXML
    private TextField mdnm;
    @FXML
    private TextArea mdds;
    @FXML
    private Button vld;
    @FXML
    private Label id;
    
    private Recformation Recformation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOpublic void initialize(URL url, ResourceBundle rb) {
        // TODObt_modif.setOnAction(event -> {
            vld.setOnAction(event -> {
              Recformation f = new Recformation(Integer.parseInt(id.getText()),mdfr.getText(), mdnm.getText(), mdds.getText());
           RecformationDao fdao = RecformationDao.getInstance();
            
            
           fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Reclamation modifiée avec succés!");
            alert.show();
        });
    }
        public void setRecnote(Recformation a){
        this.Recformation= a;
        id.setText(""+a.getId_formation());
       mdfr.setText(a.getFormation());
       mdnm.setText(a.getNom_formateur());
       mdds.setText(a.getDescription());
       
    }    
    
}
        
    

