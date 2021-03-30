package controller;

import entity.Inscription_certificat;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;
import service.Inscription_certificatDao;



public class Insci_certifController implements Initializable {
    
    //FXML
    @FXML
    private TextField nomField;
    @FXML
    private TextField descField;
    @FXML
    private Button btnInscrip;
    @FXML
    private TextField nomUtilisateur;
    @FXML
    private Label label;
    @FXML
    private ComboBox <String> comb;
    //NON FXML
    ObservableList<String> list =FXCollections.observableArrayList("Info", "Design", "PNL");
    
     
    
    
    private boolean champsValides(){
        String champs1 = this.nomUtilisateur.getText();
        String champs2 = this.nomField.getText();
        String champs3 = this.descField.getText();
        
        if( champs1.trim().isEmpty()
                || champs2.trim().isEmpty()
                || champs3.trim().isEmpty()
                 
                
          ){
                Notifications.create()
                        .title("Question")
                        //.darkStyle()
                        .position(Pos.CENTER)
                        .text("Remplir tous les champs")
                        .showError();
            
                return false;
           }
        else 
            {
                return true;
           
            }      
    
    }
    

        @Override
    public void initialize(URL url, ResourceBundle rb) {
            comb.setItems(list);
             
        
    }    
    @FXML
    private void Select(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem(); 
        label.setText(s);
        
    }
    
    
    @FXML
    private void InscriptionCertificat(ActionEvent event) {
         
        
        

        boolean valid =champsValides();
        if(valid){
            //enregistrer
            System.out.println("Sauvgarder question");
        }
        else{
        }
        
        
        btnInscrip.setOnAction((ActionEvent event1) -> {
            Inscription_certificat f = new Inscription_certificat (nomUtilisateur.getText(),nomField.getText(), descField.getText(),comb.getValue());
            Inscription_certificatDao inscri_dao = Inscription_certificatDao.getInstance();
            inscri_dao.insert(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Personne inscrite avec succés!");
            alert.show();
            nomUtilisateur.setText("");
            nomField.setText("");            
            descField.setText("");
            comb.setValue("list");
            System.out.println("ok");
        });
    }
   }
   
