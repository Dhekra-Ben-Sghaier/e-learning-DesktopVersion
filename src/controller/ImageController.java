/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */

package controller;

import com.jfoenix.controls.JFXButton;
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
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.fct;

/**
 * FXML Controller class
 *
 * @author hp
 * 
 */

public class ImageController implements Initializable {
    private PreparedStatement retrieve,store;
   
private String loadst="select image from publicite where id =(?)";
   
    @FXML
    private ImageView exit;
    private Button hlink;
    @FXML
    private AnchorPane pane1;
    @FXML
    private AnchorPane pane2;
    @FXML
    private AnchorPane pane3;
    @FXML
    private Label num;
    @FXML
    private Hyperlink lienbtn;
    int idim=3;
    @FXML
    private Hyperlink lienbtn11;
    @FXML
    private Hyperlink lienbtn1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        translateImage(0.5,pane2, 829);
         translateImage(0.5,pane3, 829);
   
        exit.setOnMouseClicked(event -> {
        System.exit(0);});
        try {
        
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            
            retrieve=conn.prepareStatement(loadst);
  
                
                loadfile();
            

        
             
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   
    public void translateImage(double duration,Node node,double width){
        TranslateTransition translate=new  TranslateTransition(Duration.seconds(duration),node);
            translate.setByX(width);
          translate.setInterpolator(Interpolator.EASE_BOTH);

           translate.play();
    }
  
    public void loadfile() {
        try {
            retrieve.setInt(1, 100);
            ResultSet rs=retrieve.executeQuery();
        if(rs.first()){
            Blob blob=rs.getBlob("image");
            InputStream inputstream =blob.getBinaryStream();
             
            Image image=new Image(inputstream);
            System.out.println(image);
           // imageview.setImage(image);       
        }
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    int show=0;
    @FXML
    private void back(ActionEvent event) {
        if(show==1){
           translateImage(0.5,pane2, 829);
           show--;
           num.setText("1/3");
            

        }else if(show==2){
            translateImage(0.5,pane3, 829);
            show--;
           num.setText("2/3");
        }
    }

    @FXML
    private void next(ActionEvent event) {
         if(show==0){
           translateImage(0.5,pane2, -829);
           show++;
           num.setText("2/3");
        }else if(show==1){
            translateImage(0.5,pane3, -829);
            show++;
           num.setText("3/3");
        }
    }
    //lienImage
    public void vistus(int id){
        WebView myWebView = new WebView();
        
        WebEngine engine = myWebView.getEngine();
         fct ft=new fct();
            String lien=ft.recLien(id);
        engine.load(lien);
        VBox root = new VBox();
        root.getChildren().addAll(myWebView);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void visiter(ActionEvent event) {
        vistus(idim);
    }

    @FXML
    private void visiterc(ActionEvent event) {
         
        vistus(1);
    }

    @FXML
    private void visiterm(ActionEvent event) {
      
        vistus(2);
    }


    
}
