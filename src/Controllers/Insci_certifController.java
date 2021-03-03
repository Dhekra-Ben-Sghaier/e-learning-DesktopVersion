 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import entity.Quiz;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.QuizDao;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
public class Insci_certifController implements Initializable {

    @FXML
    private TextField nomField;
    @FXML
    private TextField descField;
    @FXML
    private TextField domainefield;
    @FXML
    private Button btnInscrip;
    

        @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void InscriptionCertificat(ActionEvent event) {
        btnInscrip.setOnAction((ActionEvent event1) -> {
            Quiz f = new Quiz (nomField.getText(), descField.getText(),domainefield.getText());
            QuizDao quizdao = QuizDao.getInstance();
            quizdao.insert(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Personne insérée avec succés!");
            alert.show();
            //titleField.setText("");
            descField.setText("");
            System.out.println("ok");
        });
    }
    
}
