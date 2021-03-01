/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevformation.test;
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
 * @author Asus
 */
public class PidevFormation extends Application{
    private Parent parentPage;
    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage stage = new Stage(StageStyle.UNDECORATED);
        parentPage = FXMLLoader.load(getClass().getResource("/view/FormationPanel.fxml"));
        
        Scene scene = new Scene(parentPage);
        stage.setTitle("Formation");
        
//        pour configurer les dimensions de stage 
//        stage.setWidth(500);
//        stage.setHeight(500);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
