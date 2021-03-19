/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
import javafx.scene.layout.FlowPane;
import service.QuizzDao;

public class QuizListController implements Initializable {

    @FXML
    private FlowPane quizListContainer;
    Map<Quizz, Integer> quizzes = null;
    @FXML
    private NewScreenListener screenListener;
    private Set<Quizz> keys;
    
    
    public void setScreenListener(NewScreenListener screenListener){
        this.screenListener= screenListener;  
        setCards();
    
    }
    private void setCards(){
        for (Quizz quiz: keys){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/QuizCard.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuizCardController QuizCardController = fxmlLoader.getController();
                QuizCardController.setQuiz(quiz);

                //QuizCardController.setNom(quiz.getNom());
                QuizCardController.setNbq(quizzes.get(quiz) + "");
                QuizCardController.setScreenListener(this.screenListener);
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
}
