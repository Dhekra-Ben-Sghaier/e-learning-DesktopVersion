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
public class HomeController implements Initializable {

    @FXML
    private Button consulter_stage;
    @FXML
    private Button consulter_travail;
    @FXML
    private Button ajouter_travail;
    @FXML
    private Button ajouter_stage;
    @FXML
    private Button update_travail;
    @FXML
    private Button update_stage;
    @FXML
    private Button Update_back_stage;
    @FXML
    private Button Update_back_travail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OAconsulter_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Affichage_Stage.fxml")));
        Parent root = loader.load();
        Affichage_StageController OATravail = loader.getController();
        Scene scene = consulter_stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void OAconsulter_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Affichage_travail.fxml")));
        Parent root = loader.load();
        Affichage_travailController OATravail = loader.getController();
        Scene scene = consulter_travail.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void OAajouter_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Ajout_Post_Travail.fxml")));
        Parent root = loader.load();
        Ajout_Post_TravailController OATravail = loader.getController();
        Scene scene = ajouter_travail.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void OAajouter_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Ajout_Post_Stage.fxml")));
        Parent root = loader.load();
        Ajout_Post_StageController OAStage = loader.getController();
        Scene scene = ajouter_stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void OAupdate_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Update_travail_front.fxml")));
        Parent root = loader.load();
        Update_travail_frontController OATravail = loader.getController();
        Scene scene = update_travail.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void OAupdate_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Update_stage_front.fxml")));
        Parent root = loader.load();
        Update_stage_frontController OAStage = loader.getController();
        Scene scene = update_stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Update_back_stage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Update_back_stage.fxml")));
        Parent root = loader.load();
        Update_back_stageController OAUpdate_back_stage = loader.getController();
        Scene scene = Update_back_stage.getScene();
        scene.setRoot(root);
    }

    @FXML
    private void Update_back_travail(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("Update_back_travail.fxml")));
        Parent root = loader.load();
        Update_back_travailController OAUpdate_back_travail = loader.getController();
        Scene scene = Update_back_travail.getScene();
        scene.setRoot(root);
    }
    
}
