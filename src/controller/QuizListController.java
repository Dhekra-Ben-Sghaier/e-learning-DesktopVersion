package controller;

import constants.NewScreenListener;
import entity.Quizz;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import service.QuizzDao;

public class QuizListController implements Initializable {

    @FXML
    private FlowPane quizListContainer;
    Map<Quizz, Integer> quizzes = null;
    private NewScreenListener screenListener;
    private Set<Quizz> keys;
    @FXML
    private Label labid;
    private int id;
    
    
    public void setScreenListener(NewScreenListener screenListener){
        this.screenListener= screenListener;  
        setCards();
    
    }
    private void setCards(){
        for (Quizz quiz: keys){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/QuizCard.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuizCardController QuizCardController = fxmlLoader.getController();
                QuizCardController.setQuiz(quiz);
                 
                QuizCardController.setNomQuiz(quiz.getNom());
                QuizCardController.setNbq(quizzes.get(quiz) + "");
                QuizCardController.setScreenListener(this.screenListener);
                QuizCardController.setId(Integer.parseInt(labid.getText()));
                quizListContainer.getChildren().add(node);              
            }

            catch (IOException e){
                e.printStackTrace();
            }
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
   
        quizzes= QuizzDao.getInstance().compterNombreQuestions();
        keys = quizzes.keySet();
    }
      public void setId(int a){
        this.id= a;
        labid.setText(a+"");
      
        
    }
}
