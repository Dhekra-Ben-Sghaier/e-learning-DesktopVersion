package controller;

import entity.Inscription_certificat;
import entity.Quizz;
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


public class Modifier_inscriController implements Initializable {
    ObservableList<String> list =FXCollections.observableArrayList("Info", "Design", "PNL");

    //FXML
    @FXML
    private TextField nomUtilisateur;
    @FXML
    private TextField nomField;
    @FXML
    private Label label;
    @FXML
    private Button btnModif;
    @FXML
    private Label id_inscri;
    //NON FXML
    private Inscription_certificat p;
    private TextField idField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //label.setText(s);
    }   
    
    public void setNomUtilisateurEtNomQuiz(Inscription_certificat f, Quizz q){
        this.p = f;
        id_inscri.setText(""+f.getId());
        nomUtilisateur.setText(f.getNomUtilisateur());
        nomField.setText(q.getNom());
    }

    public void setInscriptionCertificat(Inscription_certificat f){
        this.p = f;
        id_inscri.setText(""+f.getId());
        nomUtilisateur.setText(f.getNomUtilisateur());
        nomField.setText(""+f.getNom());
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
            Inscription_certificat f = new Inscription_certificat(Integer.parseInt(id_inscri.getText()),nomUtilisateur.getText(), nomField.getText() );
            Inscription_certificatDao fdao = Inscription_certificatDao.getInstance();
            
            
            fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Certtif modifiée avec succés!");
            alert.show();
            nomUtilisateur.setText("");
            nomField.setText("");
           
    }
    
}
