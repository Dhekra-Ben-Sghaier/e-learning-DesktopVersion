package controller;

import com.jfoenix.controls.JFXTextField;
import entity.Quizz;
import entity.Utilisateur;
import java.awt.Dimension;
import java.awt.AWTException; 
import java.awt.Rectangle; 
import java.awt.Toolkit; 
import java.awt.Robot; 
import java.awt.image.BufferedImage; 
import java.awt.image.RenderedImage;
import java.io.File; 
import javax.imageio.ImageIO; 

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import service.QuizzDao;
public class CertificatController implements Initializable {
    
    //FXML
        @FXML
        private JFXTextField NomPrenom;
        @FXML
        private Label nomQuiz;
        @FXML
        private Button pdf;
        @FXML
        private AnchorPane printPane;
        @FXML
        private Button mail;
        @FXML
        private Button cap;
    //Non FXML

        CertificatController certificatController;
        private static QuizzDao instance;
        private Statement st;
        private ResultSet rs;
        private String url = "jdbc:mysql://127.0.0.1/esprit";
        private String login = "root";
        private String pwd = "";
        private Quizz quiz;
        Quizz q; 
        static String message1 = "Félicitations, vous avez obtenur votre certification";
        private FileChooser fc = new FileChooser();
        Stage stage;
        Utilisateur utili;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    //------------------------------------------------//
    public void setNom(String value) {

        this.nomQuiz.setText(value);

    }
    //------------------------------------------------//
    public void setUtlisateur(String value) {

        this.NomPrenom.setText(value);

    }
    //------------------------------------------------//
    public void setInscriptionCertificat(Quizz q) {

        this.quiz = q;
        nomQuiz.setText(q.getNom());
        Quizz f = new Quizz(nomQuiz.getText());
        nomQuiz.setText("");
    }
    //------------------------------------------------//
    public static void envoyerMail(String recepient) throws MessagingException, IOException {
        System.out.println("Envoi en cours");
        Properties prop = new Properties();
         //Enable authentication
        prop.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        prop.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        prop.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        prop.put("mail.smtp.port", "587");
        
        String monCompte = "maissa.loussaief@esprit.tn";
        String mdp = "203JFT0904";
        Session session = Session.getInstance(prop, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(monCompte, mdp);
            }
        });

        Message message = prepareMessage(session, monCompte, recepient);
        Transport.send(message);
        System.out.println("Mail envoyé avec succés");

    }
    //------------------------------------------------//
    public  RenderedImage createScreenshot(Rectangle selected)
        throws Exception {
      BufferedImage capture = new Robot().createScreenCapture(selected);
      return capture;
    }
    //------------------------------------------------//
    private static Message prepareMessage(Session session, String monCompte, String recepient) throws IOException {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(monCompte));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Certificat");

            // Créer la partie contenu du premier message
            MimeBodyPart mbp1 = new MimeBodyPart();
            mbp1.setText(message1);

            // Créer la partie contenu du second message réservée au fichier joint
            MimeBodyPart mbp2 = new MimeBodyPart();

//          Attacher le fichier à l'email
//          FileDataSource fichier_joint = new FileDataSource("C:\\Users\\Tarek.Loussaief\\Desktop\\11111.pdf");
//          mbp2.setDataHandler(new DataHandler(fichier_joint));
//          mbp2.setFileName(fichier_joint.getName());
                try {
//                    Robot robot = new Robot();
//                    String format = "jpg";
//                    String fileName = "Part." + format;
//                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize(); 
//                    Rectangle captureRect = new Rectangle (0, 0, 739, 569 );
//                    BufferedImage screenFullImage = robot.createScreenCapture(captureRect); 
//                    ImageIO.write(screenFullImage, format, new File(fileName));
                     File file=new File("C:\\Users\\Tarek.Loussaief\\Desktop\\11111.pdf");
                     javafx.scene.image.Image img = new javafx.scene.image.Image(file.toURI().toURL().toString());
             //        imageCadeau.setImage(img);
               //     mbp2.attachFile(img);
                    mbp2.attachFile(file);
                    System.out.println("A partial screenshot saved!");
                } catch (IOException ex) {
                    System.err.println(ex);
                }

           // Créer un conteneur multipart pour les deux contenus
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(mbp1);
            mp.addBodyPart(mbp2);                
           // Ajouter le Multipart au message
            message.setContent(mp);
        return message;
        } catch (MessagingException ex) {
            Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //------------------------------------------------//
    //------------------------------------------------//

    @FXML
    private void cap(ActionEvent event) throws MessagingException, IOException {
         
                   
            try {
                Robot robot = new Robot();
                String format = "jpg";
                String fileName = "Part." + format;
                
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize().getSize();
                Rectangle captureRect = new Rectangle(0, 0, 739, 569 );
                BufferedImage screenFullImage = robot.createScreenCapture(captureRect);
                ImageIO.write(screenFullImage, format, new File(fileName));
//                    mbp2.attachFile(fileName);

              System.out.println("A partial screenshot saved!");
            } catch (AWTException ex) {
                Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
            }
//                
    }
    //------------------------------------------------//
    //------------------------------------------------//

    @FXML
    private void pdf(ActionEvent event) {
               
        Printer printer = Printer.getDefaultPrinter();
        
        javafx.print.PageLayout pageLayout = printer.createPageLayout(javafx.print.Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job != null && job.showPrintDialog(printPane.getScene().getWindow())) {
            
            boolean success = job.printPage(pageLayout, printPane);
            if (success) {
                job.showPrintDialog(stage);
                job.endJob();
                
            }
        }  
    }
    //------------------------------------------------//
    //------------------------------------------------//
    @FXML
    private void mail(ActionEvent event) throws IOException {
        try {
            this.certificatController.envoyerMail("maissa.loussaief@esprit.tn");
        } catch (MessagingException ex) {
            Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
