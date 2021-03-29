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
        //Parent root= FXMLLoader.load(getClass().getResource("/view/QuestionScreen.fxml"));
        Parent root= FXMLLoader.load(getClass().getResource("/view/MainScreen.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/Insci_certif.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/Afficher_inscri.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/Certificat.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/AjouterQuiz.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/QuizList.fxml"));
        //Parent root= FXMLLoader.load(getClass().getResource("/view/ProgressCercle.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root); 
        stage.setScene(scene);
        stage.show();
         
    } 
    
}

