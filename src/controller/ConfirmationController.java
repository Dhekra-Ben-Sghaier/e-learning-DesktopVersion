/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.PubDao;
import service.fct;
import entity.Pub;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author hp
 */
public class ConfirmationController implements Initializable {

    @FXML
    private Button retour;
    @FXML
    private Button contrat;
    @FXML
    private Button valider;
    @FXML
    private TextField prx;
   
    private Pub pub;
    private FileInputStream input;
    @FXML
    private Label first;
    @FXML
    private Label second;
    @FXML
    private Label three;
    @FXML
    private Label four;
    @FXML
    private Label five;
    @FXML
    private Label six;
    /**
     * Initializes the controller class.
     */
     
     private PreparedStatement store;
     private String openst="UPDATE publicite SET image= ? WHERE id=?";
   
    @FXML
    private Label seven;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
           Connection conn;
             try {
                
               PubDao pdao = PubDao.getInstance();
                conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            store=conn.prepareStatement(openst);
            
             
              
        valider.setOnAction((javafx.event.ActionEvent event) -> {
            
               pdao.insert(pub, Integer.parseInt(prx.getText()));
               fct f=new fct();
               int id=f.recId(pub,Integer.parseInt(prx.getText()));
              
               
              
               System.out.println(id);
               System.out.println(input);
               
               
              try {
                  
               store.setBinaryStream(1, input);
               store.setInt(2, id);
               store.execute(); 
           } catch (SQLException ex) {
               Logger.getLogger(ConfirmationController.class.getName()).log(Level.SEVERE, null, ex);
           }
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        
           alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
         alert.setContentText("Pub est insérée");
        alert.show();
//        String lie = f.reclien(id);
            });                 
        } catch (Exception e) {
            e.printStackTrace();
            
        }
             
             
             
          String tilte ="Confirmation d'ajout";
          String message =first.getText();
          TrayNotification tray = new TrayNotification();
          AnimationType type = AnimationType.POPUP;
          tray.setAnimationType(type);
          tray.setTitle(tilte);
          tray.setMessage(tilte);
          tray.setNotificationType(NotificationType.SUCCESS);
          tray.showAndDismiss(Duration.millis(4000));
       
        retour.setOnAction((javafx.event.ActionEvent event) -> {
            
             try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AjoutPub.fxml"));
      
             Parent parent = (Parent)loader.load();
          
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
                            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        });
        contrat.setOnAction((javafx.event.ActionEvent event) -> {
           
             try {
                 
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/contrat.fxml"));
      
             Parent parent = (Parent)loader.load();
          ContratController con = loader.<ContratController>getController();
          con.setPrix(Integer.parseInt(six.getText()));
          con.setPub(pub);
            Scene scene = new Scene(parent); 
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
                            
        }catch (IOException ex) {
            Logger.getLogger(ConfirmationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
        
        });
    }    
      public void setPrix(int p){
        prx.setText(""+p);
        six.setText(""+p);
    } 
    public void setPub(Pub a)
    {   this.pub=a;
        pub.setNom(a.getNom());
        pub.setPrenom(a.getPrenom());
        pub.setEmail(a.getEmail());
        pub.setDomaine(a.getDomaine());
        pub.setAffichage(a.getAffichage());
        pub.setLien(a.getLien());
        first.setText(a.getNom());
        second.setText(a.getPrenom());
        three.setText(a.getEmail());
        four.setText(a.getDomaine());
        five.setText(a.getAffichage());
        seven.setText(a.getLien());
    }   
    public void setIm(FileInputStream is){
        input=is;
    }
    
    
}
