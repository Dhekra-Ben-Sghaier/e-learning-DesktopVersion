package test;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application{
    public static void main(String args[]){
            launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root= FXMLLoader.load(getClass().getResource("/Login.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/Views/QuizHomeScreen.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/Views/Insci_certif.fxml"));
        Parent root= FXMLLoader.load(getClass().getResource("/Views/Afficher_inscri.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
         
    } 
    
}

