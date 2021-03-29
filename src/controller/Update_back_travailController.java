/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.HomeController;
import Entite.OffreStage;
import Entite.OffreTravail;
import service.StageService;
import service.TravailService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class Update_back_travailController implements Initializable {

    @FXML
    private TableView<OffreTravail> tableview;
    @FXML
    private TableColumn<?, ?> Id_user;
    @FXML
    private TableColumn<?, ?> Nom;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Date_pub;
    @FXML
    private Button supprimer;
    @FXML
    private TextField recherche;
    @FXML
    private Label Nom_soc;
    @FXML
    private Label Adresse_mail;
    @FXML
    private Label champ_Adresse;
    @FXML
    private Label champ_Date_pub;
    @FXML
    private Label Niveau_etude;
    @FXML
    private Label Certificat;
    @FXML
    private Label Titre;
    @FXML
    private Label champ_Id_user;
    @FXML
    private Label Description;
    @FXML
    private Button Valider;
    @FXML
    private TableColumn<?, ?> Id_travail;
    @FXML
    private Label champ_Id_travail;
    @FXML
    private Label Type_contrat;
    private ObservableList<OffreTravail> data;
    @FXML
    private Button Retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       data = FXCollections.observableArrayList();
       setsCllTable();
       loadDataFromDatabase();
       setcellValue();
       search();
    }   
     private void loadDataFromDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/esprit";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM offre_travail");
            while (rs.next()) {
                int id = rs.getInt("Id_travail");
                String nom = rs.getString("Nom_soc");
                String Adr_mail = rs.getString("Adr_mail_soc");
                String adresseE = rs.getString("Adr_soc");
                String description = rs.getString("Description");
                Date date_p = rs.getDate("Date_pub");
                String niv_etude = rs.getString("Niv_etude");
                String certificat = rs.getString("Certificat");
                String Type_contratt = rs.getString("Type_contrat");
                int id_user = rs.getInt("Id_societe");
                String titre = rs.getString("Titre");
               
                data.add(new OffreTravail(id, nom, Adr_mail, adresseE, description, date_p, niv_etude, certificat,Type_contratt ,id_user , titre));
                }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        tableview.setItems(data);
    }
      public void setsCllTable() {

        Id_user.setCellValueFactory(new PropertyValueFactory<>("Id_societe"));
        Id_travail.setCellValueFactory(new PropertyValueFactory<>("Id_Travail"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_soc"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("Adr_soc"));
        Date_pub.setCellValueFactory(new PropertyValueFactory<>("Date_pub"));
    }
      private void setcellValue() {
        tableview.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                OffreTravail ol = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
                champ_Id_travail.setText(Integer.toString(ol.getId_Travail()));
                Nom_soc.setText(ol.getNom_soc());
                Adresse_mail.setText(ol.getAdr_mail_soc());
                champ_Adresse.setText(ol.getAdr_soc());
                Titre.setText(ol.getTitre());
                Certificat.setText(ol.getCertificat());   
                Niveau_etude.setText(ol.getNiv_etude()); 
                Description.setText(ol.getDescription());               
                Type_contrat.setText(ol.getType_contrat());   
                champ_Date_pub.setText(ol.getDate_pub().toString());
                champ_Id_user.setText(Integer.toString(ol.getId_societe()));
                supprimer.setDisable(false);
                Valider.setDisable(false);
            }
        });
    }
       public void search() {
        FilteredList<OffreTravail> filterdata = new FilteredList<>(data, e -> true);
        recherche.setOnKeyReleased(e -> {
            recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterdata.setPredicate((Predicate<? super OffreTravail >) offre -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    if ((offre.getNom_soc().contains(newValue)) || (offre.getNom_soc().toLowerCase().contains(newValue))) {
                        return true;
                    }
                   if ((offre.getAdr_soc().contains(newValue)) || (offre.getAdr_soc().toLowerCase().contains(newValue))) {
                        return true;
                    }
                    return false;
                });
            });
            SortedList<OffreTravail> sorteddata = new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sorteddata);
        });
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idE = Integer.valueOf(champ_Id_travail.getText());
        TravailService.DeletoffreByID(idE);
        champ_Id_travail.setText("");
        Nom_soc.setText("");
        Adresse_mail.setText("");
        champ_Adresse.setText("");
        Niveau_etude.setText("");
        Description.setText("");
        champ_Date_pub.setText("");
        Certificat.setText("");
        Type_contrat.setText("");
        champ_Id_user.setText("");
        Titre.setText("");
        data.clear();
        loadDataFromDatabase();
        TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image2.png");
            String text = "Offre de de stage supprimé avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
    }

    @FXML
    private void Valider(ActionEvent event) {
        int Id_offre = Integer.parseInt(champ_Id_travail.getText());
            String Nom_SocS = Nom_soc.getText();
            String Adresse_MailS = Adresse_mail.getText();
            String AdresseS = champ_Adresse.getText();
            String Niveau_EtudeS = Niveau_etude.getText();
            String CertificatS = Certificat.getText();
            String DescS = Description.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date_pubt = LocalDate.parse(champ_Date_pub.getText(), formatter);
            java.sql.Date Date_pubS = java.sql.Date.valueOf(date_pubt);
            String TitreS = Titre.getText();
            String type_cont = Type_contrat.getText();
            int Id_societeS = Integer.parseInt(champ_Id_user.getText());
            OffreTravail SS = new OffreTravail(Id_offre,Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS, Niveau_EtudeS, CertificatS, type_cont,Id_societeS , TitreS);
            service.TravailService su = new TravailService();
            su.valider_Offe_Travail(SS); 
            TravailService.DeletoffreByID(Id_offre);
            data.clear();
            loadDataFromDatabase();
            TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image1.png");
            String text = "Offre de stage validé avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = Retour.getScene();
        scene.setRoot(root);
    }
    
}
