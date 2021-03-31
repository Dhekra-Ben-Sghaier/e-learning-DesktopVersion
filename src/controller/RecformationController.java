/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.RecformationDao;
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

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RecformationController implements Initializable {

    @FXML
    private TextField idfr;
    @FXML
    private TextField idfor;
    @FXML
    private TextArea iddes;
    @FXML
    private Button idenv;
    @FXML
    private TextField mailfor;
    @FXML
    private Label labid;
    private int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idenv.setOnAction(event -> {
           Recformation r = new Recformation(mailfor.getText(),idfr.getText(),idfor.getText(),iddes.getText());

           RecformationDao rdao = RecformationDao.getInstance();
            rdao.insert(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Réclamation insérée avec succés!");
        alert.show();
       
        });
    
    }  
    
     public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
      public void setEmail(String a){
       
        mailfor.setText(a);
      

         
    }
}
