package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class QuizHomeScreenController implements Initializable {

    @FXML
    private Label brain;
    @FXML
    private Button ajouterQuizTabb;
    @FXML
    private Button modifierQuizTabb;
    @FXML
    private Button supprimerQuizTabb;

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }    

    @FXML
    private void ajouterQuizTabb(ActionEvent event) {
        try {
            Parent node = FXMLLoader.load(getClass().getResource("/view/AjouterQuiz.fxml"));          
                Stage stage = (Stage) ajouterQuizTabb.getScene().getWindow();
                Scene scene = new Scene(node); 
                stage.setScene(scene);
                            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    @FXML
    private void modifierQuizTabb(ActionEvent event) {
    }

    @FXML
    private void supprimerQuizTabb(ActionEvent event) {
    }
    
}
