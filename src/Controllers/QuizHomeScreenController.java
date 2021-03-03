    package Controllers;

import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class QuizHomeScreenController implements Initializable {

    @FXML
    private Tab ajouterQuizTab;
    @FXML
    private Tab ajoutersssTab;
    @FXML
    private JFXTabPane quiztb;

        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent node = FXMLLoader.load(getClass().getResource("/Views/AjouterQuiz.fxml"));
            ajouterQuizTab.setContent(node);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
      
        
    }    
    
}
