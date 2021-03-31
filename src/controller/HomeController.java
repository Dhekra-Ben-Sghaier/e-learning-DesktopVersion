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
 * @author skander
 */
public class HomeController implements Initializable {

    @FXML
    private Button consulter_stage;
    @FXML
    private Button consulter_travail;
    private Button ajouter_travail;
    private Button ajouter_stage;
    private Button update_travail;
    private Button update_stage;
    private Button Update_back_stage;
    private Button Update_back_travail;
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
    private void OAconsulter_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Affichage_Stage.fxml")));
       Parent root = loader.load();
         
                Affichage_StageController cont = loader.<Affichage_StageController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
            cont.loadDataFromDatabase(Integer.parseInt(labid.getText()));
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
       Affichage_StageController OAStage = loader.getController();
      
        scene.setRoot(root);
    }

    @FXML
    private void OAconsulter_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("/view/Affichage_travail.fxml")));
         Parent root = loader.load();
         
                     Affichage_travailController cont = loader.<Affichage_travailController>getController();
         
           cont.setId(Integer.parseInt(labid.getText()));
            cont.loadDataFromDatabase(Integer.parseInt(labid.getText()));
                Scene scene = new Scene(root); 
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
        Affichage_travailController OAStage = loader.getController();
      
        scene.setRoot(root);
    }


      public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
}
