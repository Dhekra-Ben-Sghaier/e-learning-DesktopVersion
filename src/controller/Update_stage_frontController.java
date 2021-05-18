/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.HomeController;
import Entite.OffreStage;
import service.StageService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.util.Date;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author skander
 */
public class Update_stage_frontController implements Initializable {

    @FXML
    private TextField id1;
    @FXML
    private TextField Nom_soc;
    @FXML
    private TextField Adr_mail_soc;
    @FXML
    private TextField Adr_soc;
    @FXML
    private TextField Titre;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private ListView<OffreStage> list_offreStage;
    private ObservableList<OffreStage> data;
    private Button retour;
    @FXML
    private DatePicker  Date_f;
    @FXML
    private DatePicker Date_d;
    @FXML
    private TextField Duree;
    @FXML
    private ComboBox<String> Certificat;
    @FXML
    private ComboBox<String> Niv_etude;
    @FXML
    private TextArea Desc;
    @FXML
    private TextField date_pub;
    int id_User ;
    @FXML
    private Label Valide;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        ObservableList<String> list_ne = FXCollections.observableArrayList("Secondaire", "Bac", "Bac+1", "Bac+2", "Bac+3", "bac+4", "Bac+5");
        Niv_etude.setItems(list_ne);
        ObservableList<String> list_Certificat = FXCollections.observableArrayList("Anglais", "Français", "Mecanique", "Electrique", "Informatique", "Office");
        Certificat.setItems(list_Certificat);
        Duree.setEditable(false);
        
        
        
        setcellValue();
        service.StageService os = new service.StageService();
        //loadDataFromDatabase();
        list_offreStage.setCellFactory(lv -> new Collocation() );
        setcellValue();
        
    }  
    private void setcellValue() {
        list_offreStage.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                OffreStage ol = list_offreStage.getItems().get(list_offreStage.getSelectionModel().getSelectedIndex());
                id1.setText(Integer.toString(ol.getId_Stage()));
                Nom_soc.setText(ol.getNom_soc());
                Adr_mail_soc.setText(ol.getAdr_mail_soc());
                Adr_soc.setText(ol.getAdr_soc());
                Titre.setText(ol.getTitre());
                Certificat.setValue(ol.getCertificat());   
                Niv_etude.setValue(ol.getNiv_etude()); 
                Desc.setText(ol.getDescription());               
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(ol.getDate_fin().toString(), formatter);
                Date_f.setValue( localDate);
                LocalDate localDate1 = LocalDate.parse(ol.getDate_debut().toString(), formatter);
                Date_d.setValue(localDate1 );                
                Duree.setText(Integer.toString(ol.getDuree()) );
                date_pub.setText(ol.getDate_pub().toString());
                Valide.setText(Integer.toString(ol.getValide()));
                modifier.setDisable(false);
                supprimer.setDisable(false);                  
            }
        });
    }
    public void loadDataFromDatabase(int iduser) {
        
            try {
            String url = "jdbc:mysql://localhost:3306/esprit";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM offre_stage WHERE Id_societe=" + iduser);
            while (rs.next()) {
                int id = rs.getInt("Id_Stage");
                String nom = rs.getString("Nom_soc");
                String Adr_mail = rs.getString("Adr_mail_soc");
                String adresseE = rs.getString("Adr_soc");
                String description = rs.getString("Description");
                Date date_p = rs.getDate("Date_pub");
                String niv_etude = rs.getString("Niv_etude");
                String certificat = rs.getString("Certificat");
                int duree = rs.getInt("Duree");
                Date date_d = rs.getDate("Date_debut");
                Date date_f = rs.getDate("Date_fin");
                String titre = rs.getString("Titre");
                int Valide = rs.getInt("Valide");
                data.add(new OffreStage(id, nom, Adr_mail, adresseE, description, date_p, niv_etude, certificat, duree, date_d, date_f, id_User , titre, Valide));
                
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        list_offreStage.setItems(data);
    }

    @FXML
    private void Change_DureStage_F(ActionEvent event) {
        
         if (Date_d.getValue()!=null && Date_f.getValue()!=null)
        {
             LocalDate Date_debutS = Date_d.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Date_f.getValue();
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
             
             Duree.setText(Long.toString(fin));
        }
    }

    @FXML
    private void Change_DureStage_D(ActionEvent event) {
         if (Date_d.getValue()!=null && Date_f.getValue()!=null)
        {
             LocalDate Date_debutS = Date_d.getValue();
            //Date Date_debutS=new SimpleDateFormat("dd/MM/yyyy").parse(Date_debutt);  
            LocalDate Date_finS = Date_f.getValue();
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
             
             Duree.setText(Long.toString(fin));
        }
    }
   static public class Collocation extends ListCell<OffreStage> {

        public Collocation() {

        }

     @Override
        protected void updateItem(OffreStage item, boolean bln) {
            super.updateItem(item, bln);

            
            if ( item != null) {                
                Label titre = new Label(item.getTitre());
                titre.setStyle("-fx-font-size: 30 arial;");
                VBox vBox = new VBox(titre, new Text("Date publication: " + item.getDate_pub()), new Text("Date debut:  " + item.getDate_debut()));

                HBox hBox = new HBox(1, vBox);
                Text t = new Text(item.getDate_pub().toString());
                Text t2 = new Text(String.valueOf(item.getDate_debut()));
                t.setStyle("-fx-font-size: 18 arial;");
                t2.setStyle("-fx-font-size: 25 arial;");
                if(item.getDate_debut().compareTo(new Date()) < 0)
                {
                    vBox.setBackground(new Background(new BackgroundFill(Color.rgb(250, 127, 80), CornerRadii.EMPTY, Insets.EMPTY)));
                }
                hBox.setSpacing(10);
                setGraphic(hBox);
                
            }
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
       int idE = Integer.valueOf(id1.getText());

        StageService.DeletoffreByID_valide(idE);
        id1.setText("");
        Nom_soc.setText("");
        Adr_mail_soc.setText("");
        Adr_soc.setText("");
        Niv_etude.setValue(null);
        Desc.setText("");
        Date_f.setValue(null);
        Date_d.setValue(null);
        date_pub.setText("");
        Certificat.setValue(null);
        Duree.setText("");
        Titre.setText("");
        data.clear();
        loadDataFromDatabase(id_User);
        TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image2.png");
            String text = "Offre de de stage supprimé avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
    }

    @FXML
    private void modifier(ActionEvent event) throws ParseException {
        int idE = Integer.parseInt(id1.getText());
        String Nom_SocS = Nom_soc.getText();
        String Adresse_MailS = Adr_mail_soc.getText();
        String AdresseS = Adr_soc.getText();
        String Niveau_EtudeS = Niv_etude.getValue();
        String CertificatS = Certificat.getValue();
        //int Duree_stageS = Integer.parseInt(Duree.getValue());
        String DescS = Desc.getText();
        LocalDate Date_debutS = Date_d.getValue();
        LocalDate Date_finS = Date_f.getValue();
        Date Date_pubs=new SimpleDateFormat("yyyy-MM-dd").parse(date_pub.getText());
        java.sql.Date datedeb = java.sql.Date.valueOf(Date_debutS);
        java.sql.Date datef = java.sql.Date.valueOf(Date_finS);
        String TitreS = Titre.getText();
        int Id_societeS = 1;
        int valide = Integer.parseInt(Valide.getText());
        OffreStage o = new OffreStage(idE, Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubs, Niveau_EtudeS, CertificatS, Integer.parseInt(Duree.getText()), datedeb, datef, Id_societeS, TitreS, valide);
        service.StageService ser = new StageService();
        ser.updateStage(o);
        data.clear();
        Nom_soc.setText("");
        Adr_mail_soc.setText("");
        Adr_soc.setText("");
        Niv_etude.setValue(null);
        Desc.setText("");
        Date_f.setValue(null);
        Date_d.setValue(null);
        date_pub.setText("");
        Certificat.setValue(null);
        Duree.setText("");
        Titre.setText("");
        loadDataFromDatabase(id_User);
       TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image1.png");
            String text = "Offre de de stage modifié avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
    }

   
    public void setId(int a){
        this.id_User= a;

      

         
    }
    
    
}
