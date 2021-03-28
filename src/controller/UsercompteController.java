/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Operation;
import entity.Personne;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class UsercompteController implements Initializable {

    @FXML
    private Label br;
    @FXML
    private Circle circle;
    @FXML
    private Button nom_user;
    @FXML
    private Label lab_id;
    private int id;
    /**
     * Initializes the controller class.
     */
    private PreparedStatement retrieve,store;
    private String loadst="select image from personnes where id_user =(?)";
    @FXML
    private Button se_deconnecter;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
         
      try {
        
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            retrieve=conn.prepareStatement(loadst);
               
            
               nom_user.setOnAction((ActionEvent event) -> {

           
          
       
                try {
         

FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/usersPanel.fxml"));
Operation infos=new Operation();
Personne p =new Personne();
p=infos.recInfos(nom_user.getText());

Parent parent = (Parent)loader.load();

UsersPanelController cont = loader.<UsersPanelController>getController();


cont.loadcenter("/view/profilUser.fxml",p,Integer.parseInt(lab_id.getText()));
cont.loadheaduser("/view/usercompte.fxml",nom_user.getText(),Integer.parseInt(lab_id.getText()));

Scene scene = new Scene(parent);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setScene(scene);

stage.setTitle("Brainovation");
stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(UsercompteController.class.getName()).log(Level.SEVERE, null, ex);
                }
         
        }); se_deconnecter.setOnAction(event -> {
               Parent page1;
             try {
                page1 = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Brainovation");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
  
        });
            }       catch (SQLException ex) {     
                    Logger.getLogger(UsercompteController.class.getName()).log(Level.SEVERE, null, ex);
                }   
              
     
    }    
     public void setUser(String a){
        
       nom_user.setText(a);
        
    }
     public void setId(int a){
        this.id= a;
        lab_id.setText(a+"");
      
        
    }
     
      public void loadfile() {
        try {
           
            retrieve.setInt(1, Integer.parseInt(lab_id.getText()));
            ResultSet rs=retrieve.executeQuery();
            System.out.print(rs.next());

           if(rs.first()){
            Blob blob=rs.getBlob("image");
             
             if(blob!=null){
            InputStream inputstream =blob.getBinaryStream();
             System.out.print(blob.getBinaryStream());
            Image image=new Image(inputstream);
          
             circle.setFill(new ImagePattern(image));
             }else{
                Image image=new Image("images/profil.png");
          
             circle.setFill(new ImagePattern(image));
                        
            }
        } 
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
