/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.avis;

import controller.ListData;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author asus
 */
public class PidevAvis extends Application {
    private Parent parentPage;

    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage stage = new Stage(StageStyle.UNDECORATED);
        parentPage = FXMLLoader.load(getClass().getResource("/view/reclamation.fxml"));
        
        Scene scene = new Scene(parentPage);
        stage.setTitle("Reclamation");
        
//        pour configurer les dimensions de stage 
//        stage.setWidth(500);
//        stage.setHeight(500);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
