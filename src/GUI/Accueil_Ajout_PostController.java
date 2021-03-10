/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

/**
 * FXML Controller class
 *
 * @author skander
 */
public class Accueil_Ajout_PostController implements Initializable {

    @FXML
    private Button Btn_choix_stage;
    @FXML
    private Button Btn_choix_travail;
    @FXML
    private Button Btn_retour_acc_ajout;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    

    @FXML
    private void Stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Ajout_Post_Stage.fxml")));
        Parent root = loader.load();
        Ajout_Post_StageController OAStage = loader.getController();
        Scene scene = Btn_choix_stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Travail(ActionEvent event)  throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Ajout_Post_Travail.fxml")));
        Parent root = loader.load();
        Ajout_Post_TravailController OATravail = loader.getController();
        Scene scene = Btn_choix_travail.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void retour(ActionEvent event) {
    }
    
}
