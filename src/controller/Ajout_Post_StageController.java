/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import Entite.OffreStage;
import service.StageService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.scene.image.Image;
import javafx.scene.input.DragEvent;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

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
    private TextField Champ_Duree_stage;
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
    @FXML
    private TextField Champ_Titre;
    int id_User = 1;

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
        ObservableList<String> list_Certificat = FXCollections.observableArrayList("Anglais", "Français", "Mecanique", "Electrique", "Informatique", "Office");
        Champ_Certificat.setItems(list_Certificat);
        Champ_Duree_stage.setEditable(false);
        
    }

    @FXML
    private void Retour_Ajout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = Retour_Acceuil_Ajout.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Ajouter_stage(ActionEvent event) throws ParseException {
        boolean test2=false;
        boolean test1=false;
         if((Champ_Date_fin.getValue()!=null)&& (Champ_Date_debut.getValue()!=null))
         {
         if(Champ_Date_fin.getValue().isBefore(Champ_Date_debut.getValue())){
                test1=true;
            }
         }
         
         if ((Champ_Nom_Soc.getText().equals("")) || (Champ_Adresse_Mail.getText().equals("")) || (Champ_Adresse.getText().equals("")) || (Champ_Niveau_Etude.getValue()==null) || (Champ_Certificat.getValue()==null)  || (Champ_Desc.getText().equals("")) || (Champ_Titre.getText().equals("")) || (Champ_Date_fin.getValue()==null) || (Champ_Date_debut.getValue()==null) || ((Champ_Titre.getText().equals("")))){
                test2=true;
               
         
            }
         
         if (test2==true){
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("ERREUR");
             alert.setHeaderText(null);
             alert.setContentText("Merci de remplir tous les champs");
             alert.show();
            
            }
         
         else if (test1==true){
             Alert alert4 = new Alert(Alert.AlertType.INFORMATION);
             alert4.setTitle("ERREUR");
             alert4.setHeaderText(null);
             alert4.setContentText("merci de choisir une date valide");
             alert4.show();
         }
         else if (  test2==false&&test1==false) {
            String Nom_SocS = Champ_Nom_Soc.getText();
            String Adresse_MailS = Champ_Adresse_Mail.getText();
            String AdresseS = Champ_Adresse.getText();
            String Niveau_EtudeS = Champ_Niveau_Etude.getValue();
            String CertificatS = Champ_Certificat.getValue();
            //int Duree_stageS = Integer.parseInt(Champ_Duree_stage.getValue());
            
            String DescS = Champ_Desc.getText();
            LocalDate Date_debutS = Champ_Date_debut.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Champ_Date_fin.getValue();
            //Date Date_finS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_finn);      
            String Date_pubb = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            Date Date_pubS = new SimpleDateFormat("yyyyMMdd_HHmmss").parse(Date_pubb);
            java.sql.Date datedeb = java.sql.Date.valueOf(Date_debutS);
            java.sql.Date datef = java.sql.Date.valueOf(Date_finS);
            String TitreS = Champ_Titre.getText();
            
            /*-----*/
            
            
            /*----*/
            OffreStage SS = new OffreStage(Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS,
                                            Niveau_EtudeS, CertificatS,
                                               Integer.parseInt(Champ_Duree_stage.getText()), 
                                                   datedeb, datef,id_User , TitreS);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Ajout");
             alert.setHeaderText(null);
             alert.setContentText("Vous Voulez Ajouter cet publication ?");
             Optional<ButtonType> result = alert.showAndWait();
             if (result.get() == ButtonType.OK){
            service.StageService su = new StageService();
           su.ajouter_Offe_Stage(SS);
            TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image1.png");
            String text = "Offre de stage ajouté avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
            Champ_Nom_Soc.setText("");
            Champ_Adresse_Mail.setText("");
            Champ_Adresse.setText("");
            Champ_Niveau_Etude.setValue(null);
            Champ_Certificat.setValue(null);
            Champ_Duree_stage.setText("");
            Champ_Desc.setText("");
            Champ_Date_debut.setValue(null);
            Champ_Date_fin.setValue(null);
            Champ_Titre.setText("");
        }}
    }

    @FXML
    private void Change_DureStage_D(ActionEvent event) {
        
        if (Champ_Date_debut.getValue()!=null && Champ_Date_fin.getValue()!=null)
        {
             LocalDate Date_debutS = Champ_Date_debut.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Champ_Date_fin.getValue();
            java.sql.Date datedeb = java.sql.Date.valueOf(Date_debutS);
            java.sql.Date datef = java.sql.Date.valueOf(Date_finS);
            
            long fin = 0;
             long difference_In_Days
                = ((datef.getTime() - datedeb.getTime() )
                   / (1000 * 60 * 60 * 24))
                  % 365;
             
              long difference_In_Years
                = ((datef.getTime() - datedeb.getTime() )
                   / (1000l * 60 * 60 * 24 * 365));
             
             if (difference_In_Years >=1)
             {
                 fin =difference_In_Years * 12 + (difference_In_Days / 30);
             }else
             if (difference_In_Days > 30 && difference_In_Years < 1)
             {
                 fin = difference_In_Days / 30 ;
             }else fin = 1;
             
             Champ_Duree_stage.setText(Long.toString(fin));
        }
            
    }

    @FXML
    private void Change_DureStage_F(ActionEvent event) {
        if (Champ_Date_debut.getValue()!=null && Champ_Date_fin.getValue()!=null)
        {
             LocalDate Date_debutS = Champ_Date_debut.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Champ_Date_fin.getValue();
            java.sql.Date datedeb = java.sql.Date.valueOf(Date_debutS);
            java.sql.Date datef = java.sql.Date.valueOf(Date_finS);
            
            long fin = 0;
             long difference_In_Days
                = ((datef.getTime() - datedeb.getTime() )
                   / (1000 * 60 * 60 * 24))
                  % 365;
             
              long difference_In_Years
                = ((datef.getTime() - datedeb.getTime() )
                   / (1000l * 60 * 60 * 24 * 365));
             
             if (difference_In_Years >=1)
             {
                 fin =difference_In_Years * 12 + (difference_In_Days / 30);
             }else
             if (difference_In_Days > 30 && difference_In_Years < 1)
             {
                 fin = difference_In_Days / 30 ;
             }else fin = 1;
             
             Champ_Duree_stage.setText(Long.toString(fin));
        }
        
    }
    
    
    
    

}
