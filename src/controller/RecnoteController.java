/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.RecnoteDao;
import entity.Recnote;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RecnoteController implements Initializable {

    @FXML
    private TextField nomformateur;
    @FXML
    private TextArea description;
    @FXML
    private TextField Date;
    @FXML
    private TextField Examen;
    @FXML
    private Button envoyer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        envoyer.setOnAction(event -> {
           Recnote r = new Recnote(Examen.getText(), Date.getText(),nomformateur.getText(),description.getText());

           RecnoteDao rdao = RecnoteDao.getInstance();
            rdao.insert(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Réclamation insérée avec succés!");
        alert.show();
       
        });
        

    }    
    
}
