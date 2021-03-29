/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.RecnoteDao;
import entity.Recnote;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    @FXML
    private DatePicker champ_date;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        envoyer.setOnAction(event -> {
            LocalDate Datee = champ_date.getValue();
            java.sql.Date d = java.sql.Date.valueOf(Datee);
            String dd = new SimpleDateFormat("yyyy-MM-dd").format(d);
                    
           Recnote r = new Recnote(Examen.getText(), /*Date.getText()*/ dd ,nomformateur.getText(),description.getText());

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
