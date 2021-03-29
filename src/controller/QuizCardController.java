package controller;

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
import javafx.scene.layout.AnchorPane;


public class QuizCardController implements Initializable {

    @FXML
    private Label nomQuiz;

    
    @FXML
    private Label nbquestions;
    @FXML
    private JFXButton startButton;
    
    private Quizz quiz;
    @FXML
    private AnchorPane list;
    
    
    public void setNomQuiz(String nomQuiz) {
//        nomQuiz.setText("");
       // (this.nomQuiz).setText(nomQuiz) = nomQuiz;
    }
    
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
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/QuestionScreen.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuestionScreenController questionScreenController  = fxmlLoader.getController();
                questionScreenController.setQuiz(this.quiz);
                //questionScreenController.setUtilisateur(this.utilisateur);
                questionScreenController.setScreenListener(this.screenListener);

                this.screenListener.ChangeScreen(node);

                        
            }

            catch (IOException e){
                e.printStackTrace();
            }
    }

    
    
}
