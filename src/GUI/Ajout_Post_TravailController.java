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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;


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
    private TextArea Champ_Desc;
    @FXML
    private Button Retour_Acceuil_Ajout;
    @FXML
    private Button Btn_pub_travail;
    @FXML
    private ComboBox<String> Champ_Type_Contrat;
    @FXML
    private TextField Champ_Titre;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = Retour_Acceuil_Ajout.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Ajout_travail(ActionEvent event) throws ParseException {
         if ((Champ_Nom_Soc.getText().equals("")) || (Champ_Adresse_Mail.getText().equals("")) || (Champ_Adresse.getText().equals("")) || (Champ_Niveau_Etude.getValue()==null) || (Champ_Certificat.getValue()==null) ||  (Champ_Desc.getText().equals("")) || (Champ_Type_Contrat.getValue()==null) || (Champ_Titre.getText().equals(""))) {
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
            String TitreS = Champ_Titre.getText();
            int Id_societeS=1;
            OffreTravail SS = new OffreTravail(Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS, Niveau_EtudeS, CertificatS, Type_contratS,Id_societeS, TitreS);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Ajout");
             alert.setHeaderText(null);
             alert.setContentText("Vous Voulez Ajouter cet publication ?");
             Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){
            Services.TravailService su = new TravailService();
            su.ajouter_Offe_Travail(SS);
            TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image1.png");
            String text = "Offre de travail ajouté avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
            Champ_Nom_Soc.setText("");
            Champ_Adresse_Mail.setText("");
            Champ_Adresse.setText("");
            Champ_Niveau_Etude.setValue(null);
            Champ_Certificat.setValue(null);
            Champ_Desc.setText("");
            Champ_Type_Contrat.setValue(null);
            Champ_Titre.setText("");
        }
    }}
    
}
