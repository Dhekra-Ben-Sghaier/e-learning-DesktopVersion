/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import Entity.OffreStage;
import Services.StageService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * FXML Controller class
 *
 * @author skander
 */
public class Ajout_Post_StageController implements Initializable {

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
    private ComboBox<String> Champ_Duree_stage;
    @FXML
    private TextArea Champ_Desc;
    @FXML
    private Button Retour_Acceuil_Ajout;
    @FXML
    private Button Btn_pub_travail;
    @FXML
    private DatePicker Champ_Date_debut;
    @FXML
    private DatePicker Champ_Date_fin;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list_ne = FXCollections.observableArrayList("Secondaire", "Bac", "Bac+1", "Bac+2", "Bac+3", "bac+4", "Bac+5");
        Champ_Niveau_Etude.setItems(list_ne);
        ObservableList<String> list_Certificat = FXCollections.observableArrayList("Angalais", "Français", "Mecanique", "Electrique", "Informatique", "Office");
        Champ_Certificat.setItems(list_Certificat);
        ObservableList<String> list_Duree = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
        Champ_Duree_stage.setItems(list_Duree);
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
    private void Ajouter_stage(ActionEvent event) throws ParseException {
        if ((Champ_Nom_Soc.getText().equals("")) || (Champ_Adresse_Mail.getText().equals("")) || (Champ_Adresse.getText().equals("")) || (Champ_Niveau_Etude.getValue().equals("")) || (Champ_Certificat.getValue().equals("")) || (Champ_Duree_stage.getValue().equals("")) || (Champ_Desc.getText().equals(""))) {
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
            int Duree_stageS = Integer.parseInt(Champ_Duree_stage.getValue());
            String DescS = Champ_Desc.getText();
            LocalDate Date_debutS = Champ_Date_debut.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Champ_Date_fin.getValue();
            //Date Date_finS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_finn);      
            String Date_pubb = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            Date Date_pubS = new SimpleDateFormat("yyyyMMdd_HHmmss").parse(Date_pubb);
            java.sql.Date datedeb = java.sql.Date.valueOf(Date_debutS);
            java.sql.Date datef = java.sql.Date.valueOf(Date_finS);
            OffreStage SS = new OffreStage(Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS, Niveau_EtudeS, CertificatS, Duree_stageS, Date_pubS, Date_pubS);
            Services.StageService su = new StageService();
            su.ajouter_Offe_Stage(SS);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout confirmé");
            alert.setHeaderText("Confirmation");
            alert.setContentText("le code de votre publication est:***"/*+SS.getId_Stage()*/);
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

}
