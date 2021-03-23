/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.Operation;
import entity.Personne;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Image img= new Image("/images/mimi.jpg");
        circle.setFill(new ImagePattern(img));
        nom_user.setOnAction(event -> {

         
          
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
            Logger.getLogger(GererFormateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    }    
     public void setUser(String a){
        
       nom_user.setText(a);
        
    }
     public void setId(int a){
        this.id= a;
        lab_id.setText(a+"");
      
        
    }
}
