/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevformation.test;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Asus
 */
public class PidevFormation extends Application{
    private Parent parentPage;
    @Override
    public void start(Stage stage) throws Exception {
    
        parentPage = FXMLLoader.load(getClass().getResource("/view/FormationPanel.fxml"));
        
        Scene scene = new Scene(parentPage);
        stage.setTitle("Formation");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
