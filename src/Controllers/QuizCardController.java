package Controllers;

import com.jfoenix.controls.JFXButton;
import constants.NewScreenListener;
import entity.Quizz;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;


public class QuizCardController implements Initializable {

    @FXML
    private Label nomQuiz;

    public void setNomQuiz(Label nomQuiz) {
        this.nomQuiz = nomQuiz;
    }
    @FXML
    private Label nbquestions;
    @FXML
    private JFXButton startButton;
    
    private Quizz quiz;

    public void setQuiz(Quizz quiz) {
        this.quiz = quiz;
        this.nomQuiz.setText(this.quiz.getNom());
    }
    
    private NewScreenListener screenListener;

    public void setScreenListener(NewScreenListener screenListener) {
        this.screenListener = screenListener;
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void setNbq(String value){
        this.nbquestions.setText(value);
    }
     

    @FXML
    private void startQuiz(ActionEvent event) {
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/QuestionScreen.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuestionScreenController questionScreenController  = fxmlLoader.getController();
                questionScreenController.setQuiz(this.quiz);
                this.screenListener.ChangeScreen(node);
                        
            }

            catch (IOException e){
                e.printStackTrace();
            }
    }

    
    
}
