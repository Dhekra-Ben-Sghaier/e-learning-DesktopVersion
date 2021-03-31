/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class HomeSocController implements Initializable {

    @FXML
    private Button ajouter_travail;
    @FXML
    private Button ajouter_stage;
    @FXML
    private Button update_travail;
    @FXML
    private Button update_stage;
    @FXML
    private Label labid;
    private int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void OAajouter_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Ajout_Post_Travail.fxml")));
        Parent root = loader.load();
               
                Ajout_Post_TravailController cont = loader.<Ajout_Post_TravailController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
                
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
        Ajout_Post_TravailController OATravail = loader.getController();
        
        scene.setRoot(root);
    }

    @FXML
    private void OAajouter_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Ajout_Post_Stage.fxml")));
        Parent root = loader.load();
               
              Ajout_Post_StageController cont = loader.<Ajout_Post_StageController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
                
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
        Ajout_Post_StageController OAStage = loader.getController();
      
        scene.setRoot(root);
    }

    @FXML
    private void OAupdate_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Update_travail_front.fxml")));
       Parent root = loader.load();
         Update_travail_frontController cont = loader.<Update_travail_frontController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
                 cont.loadDataFromDatabase(Integer.parseInt(labid.getText()));
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
        Update_travail_frontController OAStage = loader.getController();
      
        scene.setRoot(root);
    }

    @FXML
    private void OAupdate_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Update_stage_front.fxml")));
        Parent root = loader.load();
          Update_stage_frontController cont = loader.<Update_stage_frontController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
              cont.loadDataFromDatabase(Integer.parseInt(labid.getText()));
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
       Update_stage_frontController OAStage = loader.getController();
      
        scene.setRoot(root);
    }
public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
    
}
