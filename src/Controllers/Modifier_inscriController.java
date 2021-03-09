/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import entity.Inscription_certificat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import service.Inscription_certificatDao;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
public class Modifier_inscriController implements Initializable {
    ObservableList<String> list =FXCollections.observableArrayList("Info", "Design", "PNL");


    @FXML
    private TextField nomUtilisateur;
    @FXML
    private TextField nomField;
    @FXML
    private TextField descField;
    @FXML
    private ComboBox<String> comb;
    @FXML
    private Label label;
    @FXML
    private Button btnModif;
    
    private Inscription_certificat p;
    private TextField idField;
    @FXML
    private Label id_inscri;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comb.setItems(list);
        String s = comb.getSelectionModel().getSelectedItem(); 
        //label.setText(s);
    }    

    public void setInscriptionCertificat(Inscription_certificat f){
        this.p = f;
        id_inscri.setText(""+f.getId());
        nomUtilisateur.setText(f.getNomUtilisateur());
        nomField.setText(""+f.getNom());
        descField.setText(f.getDescription());
        comb.setValue(f.getDomaine());
    }
    @FXML
    private void Select(ActionEvent event) {
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
            Inscription_certificat f = new Inscription_certificat(Integer.parseInt(id_inscri.getText()),nomUtilisateur.getText(), nomField.getText(), descField.getText() , comb.getValue() );
            Inscription_certificatDao fdao = Inscription_certificatDao.getInstance();
            
            
            fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Certtif modifiée avec succés!");
            alert.show();
            nomUtilisateur.setText("");
            nomField.setText("");
            descField.setText("");
    }
    
}
