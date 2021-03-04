/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevusers;

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
 * @author benha
 */
public class PidevUsers extends Application {
   private Parent parentPage;
    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage stage = new Stage(StageStyle.UNDECORATED);
        parentPage = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
        
        Scene scene = new Scene(parentPage);
        stage.setTitle("inscription");
        
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
