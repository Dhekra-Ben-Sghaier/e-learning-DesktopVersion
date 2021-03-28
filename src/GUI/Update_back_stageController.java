/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.OffreStage;
import Services.StageService;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
public class Update_back_stageController implements Initializable {

    @FXML
    private TableView<OffreStage> tableview;
    @FXML
    private Button supprimer;
    @FXML
    private TextField recherche;
    @FXML
    private TableColumn<?, ?> Id_user;
    @FXML
    private TableColumn<?, ?> Id_stage;
    @FXML
    private TableColumn<?, ?> Nom;
    @FXML
    private TableColumn<?, ?> Adresse;
    @FXML
    private TableColumn<?, ?> Date_pub;
    @FXML
    private Label Nom_soc;
    @FXML
    private Label Adresse_mail;
    @FXML
    private Label Date_debut;
    @FXML
    private Label Date_fin;
    @FXML
    private Label Niveau_etude;
    @FXML
    private Label Certificat;
    @FXML
    private Label Duree;
    @FXML
    private Label Titre;
    @FXML
    private Label Description;
    @FXML
    private Button Valider;
    private ObservableList<OffreStage> data;
    @FXML
    private Label champ_Id_stage;
    @FXML
    private Label champ_Id_user;
    @FXML
    private Label champ_Adresse;
    @FXML
    private Label champ_Date_pub;
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
            String url = "jdbc:mysql://localhost:3306/base_pi";
            Connection conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM offre_stage");
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
                int id_user = rs.getInt("Id_societe");
                data.add(new OffreStage(id, nom, Adr_mail, adresseE, description, date_p, niv_etude, certificat, duree, date_d, date_f,id_user , titre));
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
        Id_stage.setCellValueFactory(new PropertyValueFactory<>("Id_Stage"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("Nom_soc"));
        Adresse.setCellValueFactory(new PropertyValueFactory<>("Adr_soc"));
        Date_pub.setCellValueFactory(new PropertyValueFactory<>("Date_pub"));
    }
     private void setcellValue() {
        tableview.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                OffreStage ol = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
                champ_Id_stage.setText(Integer.toString(ol.getId_Stage()));
                Nom_soc.setText(ol.getNom_soc());
                Adresse_mail.setText(ol.getAdr_mail_soc());
                champ_Adresse.setText(ol.getAdr_soc());
                Titre.setText(ol.getTitre());
                Certificat.setText(ol.getCertificat());   
                Niveau_etude.setText(ol.getNiv_etude()); 
                Description.setText(ol.getDescription());               
                Date_fin.setText(ol.getDate_fin().toString());
                Date_debut.setText(ol.getDate_debut().toString());
                Duree.setText(Integer.toString(ol.getDuree()));
                champ_Date_pub.setText(ol.getDate_pub().toString());
                champ_Id_user.setText(Integer.toString(ol.getId_societe()));
                supprimer.setDisable(false);
                Valider.setDisable(false);
            }
        });
    }
     public void search() {
        FilteredList<OffreStage> filterdata = new FilteredList<>(data, e -> true);
        recherche.setOnKeyReleased(e -> {
            recherche.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterdata.setPredicate((Predicate<? super OffreStage >) offre -> {
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
            SortedList<OffreStage> sorteddata = new SortedList<>(filterdata);
            sorteddata.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sorteddata);
        });
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idE = Integer.valueOf(champ_Id_stage.getText());
        StageService.DeletoffreByID(idE);
        champ_Id_stage.setText("");
        Nom_soc.setText("");
        Adresse_mail.setText("");
        champ_Adresse.setText("");
        Niveau_etude.setText("");
        Description.setText("");
        Date_fin.setText("");
        Date_debut.setText("");
        champ_Date_pub.setText("");
        Certificat.setText("");
        Duree.setText("");
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
    private void Valider(ActionEvent event) throws ParseException {
            int Id_offre = Integer.parseInt(champ_Id_stage.getText());
            String Nom_SocS = Nom_soc.getText();
            String Adresse_MailS = Adresse_mail.getText();
            String AdresseS = champ_Adresse.getText();
            String Niveau_EtudeS = Niveau_etude.getText();
            String CertificatS = Certificat.getText();
            int Duree_stageS = Integer.parseInt(Duree.getText());
            String DescS = Description.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date_debutt = LocalDate.parse(Date_debut.getText(), formatter);
            LocalDate date_fint = LocalDate.parse(Date_fin.getText(), formatter);   
            LocalDate date_pubt = LocalDate.parse(champ_Date_pub.getText(), formatter);
            java.sql.Date datedeb = java.sql.Date.valueOf(date_debutt);
            java.sql.Date datef = java.sql.Date.valueOf(date_fint);
             java.sql.Date Date_pubS = java.sql.Date.valueOf(date_pubt);
            String TitreS = Titre.getText();
            int Id_societeS = Integer.parseInt(champ_Id_user.getText());
            OffreStage SS = new OffreStage(Id_offre,Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubS, Niveau_EtudeS, CertificatS, Duree_stageS, datedeb, datef,Id_societeS , TitreS);
            Services.StageService su = new StageService();
            su.valider_Offe_Stage(SS); 
            StageService.DeletoffreByID(Id_offre);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = Retour.getScene();
        scene.setRoot(root);
    }

   
    
}
