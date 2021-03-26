/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.OffreTravail;
import Services.TravailService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author skander
 */
public class Update_travail_frontController implements Initializable {

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
    private ObservableList<OffreTravail> data;
    FileChooser fc = new FileChooser();
    File selectedFile = new File("");
    @FXML
    private Button retour;
    @FXML
    private ComboBox<String> Type_contrat;
    @FXML
    private ComboBox<String> Certificat;
    @FXML
    private ComboBox<String> Niv_etude;
    @FXML
    private TextArea Desc;
    @FXML
    private TextField date_pub;
    
    @FXML
    private ListView<OffreTravail> list_offreTravail;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        ObservableList<String> list_ne = FXCollections.observableArrayList("Secondaire", "Bac", "Bac+1", "Bac+2", "Bac+3", "bac+4", "Bac+5");
        Niv_etude.setItems(list_ne);
        ObservableList<String> list_Certificat = FXCollections.observableArrayList("Anglais", "Français", "Mecanique", "Electrique", "Informatique", "Office");
        Certificat.setItems(list_Certificat);
        ObservableList<String> list_Duree = FXCollections.observableArrayList("CDI","CDD");
        Type_contrat.setItems(list_Duree);
        
        setcellValue();
        Services.TravailService os = new Services.TravailService();
        loadDataFromDatabase();
        list_offreTravail.setCellFactory(lv -> new Collocation());
        setcellValue();
    } 
    private void setcellValue() {
        list_offreTravail.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                OffreTravail ol = list_offreTravail.getItems().get(list_offreTravail.getSelectionModel().getSelectedIndex());
                id1.setText(Integer.toString(ol.getId_Travail()));
                Nom_soc.setText(ol.getNom_soc());
                Adr_mail_soc.setText(ol.getAdr_mail_soc());
                Adr_soc.setText(ol.getAdr_soc());
                Titre.setText(ol.getTitre());
                Certificat.setValue(ol.getCertificat());   
                Niv_etude.setValue(ol.getNiv_etude());
                Type_contrat.setValue(ol.getType_contrat());
                Desc.setText(ol.getDescription());               
                date_pub.setText(ol.getDate_pub().toString());
                modifier.setDisable(false);
                supprimer.setDisable(false);                  
            }
        });
    }
    private void loadDataFromDatabase() {
        
            try {
            String url = "jdbc:mysql://localhost:3306/base_pi";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM offre_travail WHERE Id_societe=" + 1);
            while (rs.next()) {
                int id = rs.getInt("Id_travail");
                String nom = rs.getString("Nom_soc");
                String Adr_mail = rs.getString("Adr_mail_soc");
                String adresseE = rs.getString("Adr_soc");
                String description = rs.getString("Description");
                Date date_p = rs.getDate("Date_pub");
                String niv_etude = rs.getString("Niv_etude");
                String certificat = rs.getString("Certificat");
                String Type_contratE = rs.getString("Type_contrat");
                String titre = rs.getString("Titre");                                       
                data.add(new OffreTravail(id, nom, Adr_mail, adresseE, description, date_p, niv_etude, certificat, Type_contratE, 1, titre));
                
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        list_offreTravail.setItems(data);
    }
    static public class Collocation extends ListCell<OffreTravail> {

        public Collocation() {

        }

     @Override
        protected void updateItem(OffreTravail item, boolean bln) {
            super.updateItem(item, bln);

            
            if ( item != null) {                
                Label titre = new Label(item.getTitre());
                titre.setStyle("-fx-font-size: 30 arial;");
                VBox vBox = new VBox(titre, new Text("Date publication: " + item.getDate_pub()), new Text("Niveau d'etude demandé:  " + item.getNiv_etude()));

                HBox hBox = new HBox(1, vBox);
                Text t = new Text(item.getDate_pub().toString());
                Text t2 = new Text(String.valueOf(item.getNiv_etude()));
                t.setStyle("-fx-font-size: 18 arial;");
                t2.setStyle("-fx-font-size: 25 arial;");
                hBox.setSpacing(10);
                setGraphic(hBox);
            }
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
        int idE = Integer.valueOf(id1.getText());

        TravailService.DeletoffreByID(idE);
        id1.setText("");
        Nom_soc.setText("");
        Adr_mail_soc.setText("");
        Adr_soc.setText("");
        Niv_etude.setValue(null);
        Desc.setText("");
        date_pub.setText("");
        Certificat.setValue(null);
        Type_contrat.setValue(null);
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
    private void modifier(ActionEvent event) throws ParseException {
        int idE = Integer.parseInt(id1.getText());
        String Nom_SocS = Nom_soc.getText();
        String Adresse_MailS = Adr_mail_soc.getText();
        String AdresseS = Adr_soc.getText();
        String Niveau_EtudeS = Niv_etude.getValue();
        String CertificatS = Certificat.getValue();
        String Type_contratS = Type_contrat.getValue();
        String DescS = Desc.getText();
        Date Date_pubs=new SimpleDateFormat("yyyy-MM-dd").parse(date_pub.getText());       
        String TitreS = Titre.getText();
        int Id_societeS = 1;
        OffreTravail o = new OffreTravail(idE, Nom_SocS, Adresse_MailS, AdresseS, DescS, Date_pubs, Niveau_EtudeS, CertificatS, Type_contratS, Id_societeS, TitreS);
        Services.TravailService ser = new TravailService();
        ser.updateTravail(o);
        data.clear();
        loadDataFromDatabase();
        TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image1.png");
            String text = "Offre de de travail modifié avec succés ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = retour.getScene();
        scene.setRoot(root);
    }
    
}
