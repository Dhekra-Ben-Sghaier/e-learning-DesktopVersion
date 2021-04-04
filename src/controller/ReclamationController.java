/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recnote;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import service.Operation;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button formations;
    @FXML
    private Button autres;
    @FXML
    private AnchorPane contenu;
    @FXML
    private BorderPane bp;
    @FXML
    private Button Notes;
    @FXML
    private Label labid;
    private int id;
    
 

    /**
     * Initializes the controller class.
     */
    @Override
     public void initialize(URL url, ResourceBundle rb) {
  
          
          
          autres.setOnAction(event -> {
Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Autres.fxml"));
              
            parent = (Parent)loader.load();
            
             AutresController cont = loader.<AutresController>getController();
           Operation oper=new Operation();
           String emailuser=oper.recEmailUser(Integer.parseInt(labid.getText()));
            System.out.println("iddautre="+labid.getText());
           cont.setId(Integer.parseInt(labid.getText()));
                 Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        });
//            formations.setOnAction(event -> {
//
//            try {
//                Parent page1 = FXMLLoader.load(getClass().getResource("/view/Recformation.fxml"));
//                Scene scene = new Scene(page1);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//            } catch (IOException ex) {
//                Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
//            }
           
     
   // });  
    
     }
//    private void reclamer(MouseEvent event) {
//               loadPage("/view/Recnote.fxml");
//    }
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
                    
          
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bp.setCenter(root);
            
        }
     private void  loadPageNote(String page,int n){
        
       Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             RecnoteController cont = loader.<RecnoteController>getController();
           Operation oper=new Operation();
           String emailuser=oper.recEmailUser(n);
           cont.setId(n);
            System.out.println("emaailnote="+emailuser);
           cont.setEmail(emailuser);

        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bp.setCenter(parent);
            
        }
     private void  loadPageForm(String page,int n){
        
       Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             RecformationController cont = loader.<RecformationController>getController();
          Operation oper=new Operation();
           String emailuser=oper.recEmailUser(n);
           cont.setId(n);
           cont.setEmail(emailuser);

        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null,ex);
        }
        bp.setCenter(parent);
            
        }


    @FXML
    private void reclamer(javafx.scene.input.MouseEvent event) {
         loadPageNote("/view/Recnote.fxml",Integer.parseInt(labid.getText()));
        
    }




    @FXML
    private void former(javafx.scene.input.MouseEvent event) {
          loadPageForm("/view/Recformation.fxml",Integer.parseInt(labid.getText()));
    }
    
        
   
     public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }


    }


    
