/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.fct;
import dao.ControleSaisie;
import dao.PubDao;
import entity.Pub;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AjoutPubController implements Initializable {
    ObservableList<String> occur=FXCollections.observableArrayList("1000","2000","3000","4000");
    @FXML
    private TextField nom ;
    @FXML 
    private TextField prenom ;
    @FXML
    private TextField email ;
    @FXML
    private TextField domaine ;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button deposerbutton;
    @FXML
    private Button provisoire;
    @FXML
    private Label lab_email;
    @FXML
    private ComboBox<String> comb;
    @FXML
    private ImageView impub;
    public String s;
    public  FileInputStream input;
   /**
     * Initializes the controller class.
     */
   
    @FXML
    private Button ch;
     @Override
    public void initialize(URL url, ResourceBundle rb) { 
         
 // TODO
 comb.setItems(occur);

 deposerbutton.setOnAction((javafx.event.ActionEvent event) -> {
           if(ControleSaisie.isNull(nom.getText()) || ControleSaisie.isNull(prenom.getText()) || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(domaine.getText()) )
         { Alert alerts = new Alert(Alert.AlertType.WARNING);
         alerts.setTitle("Warning");
        alerts.setHeaderText(null);
        alerts.setContentText("Veuillez remplir les champs!");
        alerts.show();
         } else {
                           if(ControleSaisie.validemail(email.getText())== false) {
                           lab_email.setText("Veuillez saisir une adresse email valide !"); }
                           if( ControleSaisie.validemail(email.getText()) ) {
                       
            
                      

              
                           
   try {
       
       Pub p = new Pub(nom.getText(),prenom.getText(),email.getText(), domaine.getText(), comb.getValue());

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Confirmation.fxml"));
        
//           
//                    InputStream is;
//                                   is = new FileInputStream(new File(s));
             fct calculp=new fct();
                              int prix=calculp.calculer_prix(Integer.parseInt(comb.getValue()));
                              System.out.println("le prix est : "+prix);
            Parent parent = (Parent)loader.load();
            
            ConfirmationController cont = loader.<ConfirmationController>getController();
            
            cont.setPrix(prix);
            System.out.println("inpuuuuuuuuuut="+input);
            cont.setIm(input);
            cont.setPub(p);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
             stage.setTitle("Confirmation");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjoutPubController.class.getName()).log(Level.SEVERE, null, ex);
        }
                             
           
//       
   
         }
           }
        });
    
    
 // afficher
 provisoire.setOnAction((javafx.event.ActionEvent event) -> {
            
             try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/consulter.fxml"));
      
             Parent parent = (Parent)loader.load();
          
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
                            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        });
 //end afficher
 System.out.println("111="+input);
  } 
  
    @FXML
    private void choose(javafx.event.ActionEvent event) throws IOException {   FileChooser filechooser = new FileChooser();
          
     Stage stage = (Stage) ch.getScene().getWindow();
     File file = filechooser.showOpenDialog(stage);
        FileInputStream inputstream=new FileInputStream(file);
          input=inputstream;
          FileInputStream inputim=new FileInputStream(file);
     if (file !=null)
     { //Desktop desktop = Desktop.getDesktop();
    System.out.println(inputstream);

     System.out.println(input);

        
    Image image=new Image(inputim);
    System.out.println(image);
    impub.setImage(image);
   
     
    }
    }
    public static boolean validEmail(TextField txt, Label lab , String validation){
    boolean isEmail=true;
    String validate=null;
    if(txt.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
        isEmail=false;
        validate=validation;
        
    }
    lab.setText(validate);
    return isEmail;
    }

    

    
}   

    
        
        
    
    

