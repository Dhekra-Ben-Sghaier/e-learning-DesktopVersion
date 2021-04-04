/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MesFormationDetailsController implements Initializable {

 Stage stage;
    @FXML
    private Label titreLab;
    @FXML
    private Label prixLab;
    private Formation formation;
    @FXML
    private ImageView coursImg;
    @FXML
    private Text descText;
    @FXML
    private Button consultCoursbtn;
    @FXML
    private Button btnDownload;
    @FXML
    private Button retourbtn11;
   int id;
    private BorderPane bprating;
    @FXML
    private Button avis;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setFormation(Formation f){
        this.formation = f;
        System.out.println("88888 => "+f.getPathImg());
        File imgCours = new File(f.getPathImg());
      
        Image img = new Image(imgCours.toURI().toString());
        coursImg.setImage(img);      
        titreLab.setText(f.getTitle());
        descText.setText(f.getDescription());
        prixLab.setText(""+f.getPrix()+" DT ");
      
    }

    @FXML
    private void exit(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void consulterCours(ActionEvent event) {
        FormationDao fo =FormationDao.getInstance();
        System.out.println(formation);
        fo.affFormation(formation.getId());
    }

    @FXML
    private void download(ActionEvent event) {
        
        FormationDao fo =FormationDao.getInstance();
        System.out.println(formation);
        fo.saveFormation(formation.getId());
    }
       
    public void setId(int a){
        this.id= a;
      
      
        
    }
    public void  loadPageRec(){
         FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/view/rating.fxml"));

        try {
               
                Parent root = (Parent) fxmlLoader.load();  
                
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch(IOException ex){
            Logger.getLogger(QuizResultatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @FXML
    private void donneravis(ActionEvent event) {
              FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/view/rating.fxml"));

        try {
               
                Parent root = (Parent) fxmlLoader.load();  
                
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }catch(IOException ex){
            Logger.getLogger(MesFormationDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
