package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import entity.Question;
import entity.Quizz;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import service.QuizzDao;

public class QuestionScreenController implements Initializable {

    @FXML
    private Label nomQuiz;
    @FXML
    private Label duree;
    @FXML
    private Label Question;
    @FXML
    private JFXRadioButton option1;
    @FXML
    private ToggleGroup Options;
    @FXML
    private JFXRadioButton option2;
    @FXML
    private JFXRadioButton option3;
    @FXML
    private JFXRadioButton option4;
    @FXML
    private JFXButton questionSuivante;
    @FXML
    private JFXButton valider;
    @FXML
    private Label QuizProgress;
    
    private Quizz quiz;

        public void setQuiz(Quizz quiz) {
            this.quiz = quiz;
            this.nomQuiz.setText(this.quiz.getNom());
            this.getData();
        }

    private List<Question> questionList;
    private Question questionCourante;
    int indexCourant = 0;
    
    
    private void getData(){
        if(quiz != null){
            this.questionList=  quiz.getQuestions();    
            Collections.shuffle(this.questionList);
            setquestionSuivante();        
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.showQuestionSuivanteButton();
        this.hideValiderButton();
    }    

    @FXML
    private void questionSuivante(ActionEvent event) {
        this.setquestionSuivante();
    }
    
    private void setquestionSuivante(){
        if(!(indexCourant >= questionList.size())){
            this.questionCourante = this.questionList.get(indexCourant);
            this.Question.setText(this.questionCourante.getQuestion());
            this.option1.setText(this.questionCourante.getOption1());
            this.option2.setText(this.questionCourante.getOption2());
            this.option3.setText(this.questionCourante.getOption3());
            this.option4.setText(this.questionCourante.getOption4());
            indexCourant++;            
        } else {
            showValiderButton();
            hideQuestionSuivanteButton();
            
        }
    }

    @FXML
    private void valider(ActionEvent event) {
        
    }
    
    private void showValiderButton(){
        this.valider.setVisible(true);
    }
    
    private void hideQuestionSuivanteButton(){
        this.questionSuivante.setVisible(false);
    }
    
    private void showQuestionSuivanteButton(){
        this.questionSuivante.setVisible(true);
    }
    
    private void hideValiderButton(){
        this.valider.setVisible(false);
    }
    
    
    
    
    
    
}
