/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entity.Pub;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class ContratController implements Initializable {

    private Pub pub;
    private InputStream input;
    @FXML
    private Label lastname;
    @FXML
    private Label name;
    @FXML
    private Label mail;
    @FXML
    private Label pri;
    @FXML
    private Button imprimer;
    @FXML
    private Label domain;
    @FXML
    private Label affiche;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    public void setPrix(int p){
        pri.setText(""+p);
    }
       public void setPub(Pub a)
       { this.pub=a;
         lastname.setText(a.getNom());
         name.setText(a.getPrenom());
         mail.setText(a.getEmail());
         domain.setText(a.getDomaine());
         affiche.setText(a.getAffichage());
         
        
    } 
    // recuperer les champs
//    public void setPrix(int p){
//        pri.setText(""+p);
//    }
//    public void setPub(Pub a)
//    {   this.pub=a;
//        pub.setNom(a.getNom());
//        pub.setPrenom(a.getPrenom());
//        pub.setEmail(a.getEmail());
//        pub.setDomaine(a.getDomaine());
//        pub.setAffichage(a.getAffichage());
//        
//    }   
//    public void setIm(InputStream is){
//        input=is;
//    }

    @FXML
    private void imprimer () throws IOException
    {   Document doc = new Document(); 
            try {
       PdfWriter.getInstance(doc, new FileOutputStream("contrat.pdf"));
       doc.open();
       com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("C:\\Users\\hp\\OneDrive\\Documents\\NetBeansProjects\\PidevPubStat\\src\\image\\contrat.png");
       img.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
       img.scaleToFit(400, 900);
       
       doc.add(img);
       doc.add(new Paragraph("Le contrat suivant est réalisé avec l'annonceur dont les coordonnées ci dessous : "
                             + "\nNom annonceur : "+lastname.getText()+""
                             + "\nPrenom annonceur : "+name.getText()+""
                             + "\nEmail : "+mail.getText()+""
                             + "\nDomaine de la publicité : "+domain.getText()+""
                             + "\nLe nombre des occurences et affichages de cette publicité par clic sur le site est de l'ordre de : "+affiche.getText()+""
                             + "\nComme le mentionne le contrat suivant, le paiment sera en fonction de l'affichage des publicités :" +pri.getText()+""
                             + "\n",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.ITALIC,BaseColor.BLACK)
       ))
               
                             ;
       
                             
       
       doc.close();
       Desktop.getDesktop().open(new File("contrat.pdf"));
            } catch (FileNotFoundException | DocumentException e ) {
    }
    }
}

