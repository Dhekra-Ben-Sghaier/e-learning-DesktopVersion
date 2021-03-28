/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.OffreStage;
import Entity.OffreTravail;
import Entity.Postuler_stage;
import Entity.Postuler_travail;
import Services.StageService;
import Services.TravailService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;
/**
 * FXML Controller class
 *
 * @author skander
 */
public class Affichage_travailController implements Initializable {

    @FXML
    private ListView<OffreTravail> list;
    private ObservableList<OffreTravail> data;
    @FXML
    private Label Id_titre;
    @FXML
    private Button Postuler;
    @FXML
    private TextField mail_user;
    @FXML
    private TextArea mail_body;
    @FXML
    private Label champ_nom;
    @FXML
    private Label champ_adresse;
    @FXML
    private Label champ_adressemail;
    @FXML
    private Label champ_datep;
    @FXML
    private Label champ_niveau;
    @FXML
    private Label champ_certificat;
    @FXML
    private Label champ_type_contrat;
    @FXML
    private Label champ_description;
    @FXML
    private Button Retour;
    @FXML
    private Label Id_stage;
    @FXML
    private Label Id_user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Services.TravailService os = new Services.TravailService();

        data = FXCollections.observableArrayList();

        data = FXCollections.observableArrayList();
        loadDataFromDatabase();
        list.setCellFactory(lv -> new Affichage_travailController.Collocation());
        setcellValue();
    }
 static public class Collocation extends ListCell<OffreTravail> {

        public Collocation() {

        }

        @Override
        protected void updateItem(OffreTravail item, boolean bln) {
            super.updateItem(item, bln);

            if (item != null) {
                Label Titre = new Label(item.getTitre());
                Titre.setStyle("-fx-font-size: 30 arial;");
                VBox vBox = new VBox(Titre, new Text("Adresse: " + item.getAdr_soc()), new Text("Date publication:  " + item.getDate_pub()), new Text("Type de contrat:  " + item.getType_contrat()), new Text("Description :  " + item.getDescription()));
                HBox hBox = new HBox(1, vBox);

                Text t = new Text(item.getAdr_soc());
                Text t2 = new Text(String.valueOf(item.getDate_pub()));
                Text t3 = new Text(item.getType_contrat());         
                Text t4 = new Text(item.getDescription());
                t.setStyle("-fx-font-size: 25 arial;");
                t2.setStyle("-fx-font-size: 20 arial;");
                t3.setStyle("-fx-font-size: 20 arial;");
                t4.setStyle("-fx-font-size: 20 arial;");
                hBox.setSpacing(10);
                setGraphic(hBox);
            }
        }
    } 
  private void loadDataFromDatabase() {
        
            try {
            String url = "jdbc:mysql://localhost:3306/base_pi";
            Connection con = DriverManager.getConnection(url, "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM offre_travail_valide WHERE Id_societe=" + 1);
            while (rs.next()) {
                int id = rs.getInt("Id_travail");
                String nom = rs.getString("Nom_soc");
                String Adr_mail = rs.getString("Adr_mail_soc");
                String adresseE = rs.getString("Adr_soc");
                String description = rs.getString("Description");
                Date date_p = rs.getDate("Date_pub");
                String niv_etude = rs.getString("Niv_etude");
                String certificat = rs.getString("Certificat");
                String titre = rs.getString("Titre");
                String type_contrat = rs.getString("Type_contrat");
                int id_user = 1;
                data.add(new OffreTravail(id, nom, Adr_mail, adresseE, description, date_p, niv_etude, certificat, type_contrat, id_user, titre));
                
            }
            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        list.setItems(data);
    }
   private void setcellValue() {
        list.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                OffreTravail ol = list.getItems().get(list.getSelectionModel().getSelectedIndex());
                Id_stage.setText(Integer.toString(ol.getId_Travail()));
                champ_nom.setText(ol.getNom_soc());
                champ_adressemail.setText(ol.getAdr_mail_soc());
                champ_adresse.setText(ol.getAdr_soc());
                Id_titre.setText(ol.getTitre());
                champ_certificat.setText(ol.getCertificat());   
                champ_niveau.setText(ol.getNiv_etude()); 
                champ_description.setText(ol.getDescription());               
                champ_datep.setText(ol.getDate_pub().toString());
                champ_type_contrat.setText(ol.getType_contrat());
                Id_user.setText(Integer.toString(ol.getId_societe()));
                                
            }
        });
    }

    @FXML
    private void OApostuler(ActionEvent event) throws Exception {
        if ((mail_user.getText().equals("")) || (mail_body.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de Saisie");
            alert.setHeaderText("Erreur");
            alert.setContentText("S'il vous plait rempli tous les champs");
            Optional<ButtonType> result = alert.showAndWait();
        } else {
            String Adresse_mail_user = mail_user.getText();
            //String Mail_Body = mail_body.getText();
            OffreTravail ol = list.getItems().get(list.getSelectionModel().getSelectedIndex());
            int id_travail =  ol.getId_Travail();
            int id_user = ol.getId_societe();
            Postuler_travail PS = new Postuler_travail(id_travail, id_user);
            Services.TravailService su = new TravailService();
            su.ajouter_Postuler_Travail(PS);
            sendMail(Adresse_mail_user);
           TrayNotification tray = new TrayNotification();
            Image whatsAppImg = new Image("/image/image2.png");
            String text = "Un mail est envoyé vers la societé avec vos coordonnées. ";

            tray.setTray("welcome", text + " ", whatsAppImg, Paint.valueOf("#2A9A84"), AnimationType.SLIDE);

            tray.showAndDismiss(Duration.seconds(10));
        
    }
    }
    public  void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "brainovation21@gmail.com";
        //Your gmail password
        String password = "brainovation$$$";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
               return new javax.mail.PasswordAuthentication(myAccountEmail, password);
            }
            
            
});
           

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }
    private  Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
           OffreTravail ol = list.getItems().get(list.getSelectionModel().getSelectedIndex());
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Recrutment pour l'offre"+ol.getTitre());
            message.setText(mail_body.getText());
            return message;
        } catch (Exception ex) {
            Logger.getLogger(Affichage_travailController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @FXML
    private void OAretour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Home.fxml")));
        Parent root = loader.load();
        HomeController OAStage = loader.getController();
        Scene scene = Retour.getScene();
        scene.setRoot(root);
    }
    
}
