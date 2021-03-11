/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.OffreTravail;
import Services.TravailService;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author skander
 */
public class Ajout_Post_TravailController implements Initializable {

    @FXML
    private TextField Champ_Nom_Soc;
    @FXML
    private TextField Champ_Adresse_Mail;
    @FXML
    private TextField Champ_Adresse;
    @FXML
    private ComboBox<String> Champ_Niveau_Etude;
    @FXML
    private ComboBox<String> Champ_Certificat;
    @FXML
    private TextField Champ_Desc;
    @FXML
    private Button Retour_Acceuil_Ajout;
    @FXML
    private Button Btn_pub_travail;
    @FXML
    private ComboBox<String> Champ_Type_Contrat;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list_ne = FXCollections.observableArrayList("Secondaire", "Bac", "Bac+1", "Bac+2", "Bac+3", "bac+4", "Bac+5");
        Champ_Niveau_Etude.setItems(list_ne);
        ObservableList<String> list_Certificat = FXCollections.observableArrayList("Angalais", "Français", "Mecanique", "Electrique", "Informatique", "Office");
        Champ_Certificat.setItems(list_Certificat);
         ObservableList<String> list_Type_Contrat = FXCollections.observableArrayList("CDI","CDD");
        Champ_Type_Contrat.setItems(list_Type_Contrat);
    }    

    @FXML
    private void Retour_Ajout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Accueil_Ajout_Post.fxml")));
        Parent root = loader.load();
        Accueil_Ajout_PostController OAStage = loader.getController();
        Scene scene = Retour_Acceuil_Ajout.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Ajout_travail(ActionEvent event) throws ParseException {
         if ((Champ_Nom_Soc.getText().equals("")) || (Champ_Adresse_Mail.getText().equals("")) || (Champ_Adresse.getText().equals("")) || (Champ_Niveau_Etude.getValue().equals("")) || (Champ_Certificat.getValue().equals("")) ||  (Champ_Desc.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("S'il vous plait rempli tous les champs");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            String Nom_SocS = Champ_Nom_Soc.getText();
            String Adresse_MailS = Champ_Adresse_Mail.getText();
            String AdresseS = Champ_Adresse.getText();
            String Niveau_EtudeS = Champ_Niveau_Etude.getValue();
            String CertificatS = Champ_Certificat.getValue();
            String DescS = Champ_Desc.getText(); 
            String Date_pubb = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            Date Date_pubS = new SimpleDateFormat("yyyyMMdd_HHmmss").parse(Date_pubb);
            String Type_contratS = Champ_Type_Contrat.getValue();
            OffreTravail SS = new OffreTravail(Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS, Niveau_EtudeS, CertificatS, Type_contratS);
            Services.TravailService su = new TravailService();
            su.ajouter_Offe_Travail(SS);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout confirmé");
            alert.setHeaderText("Confirmation");
            alert.setContentText("le code de votre publication est:***"/*+SS.getId_Stage()*/);
            Optional<ButtonType> result = alert.showAndWait();
        }
    }
    
}
