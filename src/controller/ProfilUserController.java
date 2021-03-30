/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import static controller.InscrireApprenantController.hashPassword;
import service.Operation;
import entity.Personne;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.awt.Image;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.ImageIcon;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ProfilUserController implements Initializable {

    @FXML
    private Tab compte;
    @FXML
    private Tab photo;
    @FXML
    private JFXTabPane profilUser;
    
    private Personne personne;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField prenom;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField nomUser;
    @FXML
    private JFXPasswordField mdp_act;
    @FXML
    private JFXPasswordField mdp_new;
    @FXML
    private JFXPasswordField mdp_conf;
    @FXML
    private Button btn_sauv;
    @FXML
    private Button btn_info;
    
    private int id;
    private Label lab_id;
    @FXML
    private Label lab_user;
    @FXML
    private Label lab_mdp;
    @FXML
    private JFXButton btn_im;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private ImageView imageview;
    
    public String s;
    @FXML
    private Button btn_sauvim;
    
    //requete pour insert image
    private PreparedStatement store;
     private String openst="UPDATE personnes SET image= ? WHERE id_user=?";
    @FXML
    private Tab mesform;
    @FXML
    private Label labb_id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 Connection conn;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            store=conn.prepareStatement(openst);
               //sauvegarder image 
        btn_sauvim.setOnAction(event -> {


                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Information Dialog");
                  alert.setHeaderText(null);
                  alert.setContentText("Image sauvegardée!");
                  alert.show();
          
         
            
            
        });
        } catch (SQLException ex) {
            Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
  btn_info.setOnAction(event -> {

            Operation info=new Operation();
            
            info.updateInfo(nom.getText(), prenom.getText(), email.getText(), nomUser.getText(), Integer.parseInt(labb_id.getText()));
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Informations sauvegardés!");
            alert.show();
        });
   btn_sauv.setOnAction(event -> {

            Operation info=new Operation();
            int count=0;
           String password=info.isPassword(lab_user.getText());
                if(BCrypt.checkpw(mdp_act.getText(),password)){
                    count=1;
                }
                 if (mdp_new.getText().equals(mdp_conf.getText()) && count ==1){
                   Operation o =new Operation();
                   o.update(hashPassword(mdp_new.getText()), Integer.parseInt(labb_id.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Votre mdp a été changé avec succés!");
        alert.show();
              
               
                 } if(count != 1){
                      lab_mdp.setText("Mot de passe incorrect");
                 } if (mdp_new.getText().equals(mdp_conf.getText())==false) {
                  Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Ces mots de passe ne correspondent pas. Veuillez réessayer.!");
        alert.show();
             }
           
        });

        
    }   
    //choisir une image
    @FXML
       private void choose(javafx.event.ActionEvent event) throws IOException { {  FileChooser filechooser = new FileChooser();
          
     Stage stage = (Stage) btn_im.getScene().getWindow();
     File file = filechooser.showOpenDialog(stage);
        FileInputStream inputstream=new FileInputStream(file);
         FileInputStream input=new FileInputStream(file);
     if (file !=null)
     { //Desktop desktop = Desktop.getDesktop();
    System.out.println(inputstream);
           try {
               store.setBinaryStream(1, inputstream);
               store.setInt(2, Integer.parseInt(labb_id.getText()));
               store.execute(); 
           } catch (SQLException ex) {
               Logger.getLogger(ProfilUserController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    Image image=new Image(input);
    System.out.println(image);
    imageview.setImage(image);
   
     }
    }
       }
  
     //rec infos user
     public void setPersonne(Personne a){
        this.personne= a;
       lab_user.setText(a.getLogin());
       nom.setText(a.getNom());
       prenom.setText(a.getPrenom());
       email.setText(a.getEmail());
       nomUser.setText(a.getLogin());
        
    }
      public void setId(int a){
        this.id= a;
        labb_id.setText(a+"");
      
        
    }
      
        
    public void  loadPage(String page){
        Parent parent = null;
        System.out.println("page => "+page+"  id=  "+Integer.parseInt(labb_id.getText()));
        try {
             
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
           MesFormationsController cont = loader.<MesFormationsController>getController();
            cont.setId(Integer.parseInt(labb_id.getText()));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
       
         }
        
                    mesform.setContent(parent);
    }   

    @FXML
    private void mesform(Event event) {
        System.out.println("iiiid="+labb_id.getText());
   loadPage("/view/MesFormations.fxml");
    }
}
