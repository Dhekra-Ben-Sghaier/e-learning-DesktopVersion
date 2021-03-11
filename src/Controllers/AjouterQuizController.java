/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entity.Question;
import entity.Inscription_certificat;
import entity.Quizz;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import service.QuestionDao;
import service.Inscription_certificatDao;
import service.QuizzDao;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
public class AjouterQuizController implements Initializable {

    @FXML
    private JFXTextField nomQuiz;
    @FXML
    private JFXTextArea question;
    @FXML
    private JFXTextArea quizID;
    @FXML
    private JFXTextField option1;
    @FXML
    private JFXTextField option2;
    @FXML
    private JFXTextField option3;
    @FXML
    private JFXTextField option4;
    @FXML
    private JFXRadioButton option1radio;
    @FXML
    private JFXRadioButton option2radio;
    @FXML
    private JFXRadioButton option3radio;
    @FXML
    private JFXRadioButton option4radio;
    @FXML
    
    private JFXButton ajouterQuestionSuivante;
    @FXML
    private JFXButton validerQuiz;
    
    @FXML
    private Button setQuizTitleButton;
    
    private ToggleGroup radioGroup;
    
    //mes variables
    
    private Quizz quiz = null;
    //private HashMap<String, Object[]> questions= new HashMap<>();
    private ArrayList <Question> questions = new ArrayList<>(); 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButtonSetup();
        
    }    


    private void radioButtonSetup() {
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);
     
        
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        System.out.println("Controllers.AjouterQuizController.setQuizTitle()");
        String nom = nomQuiz.getText();
        if(nom.trim().isEmpty()){
            Notifications.create()
                //.darkStyle()
                .text("Entrer un nom de quiz valide")
                .position(Pos.CENTER)
                .hideAfter(Duration.millis(2000))
                .title("Nom Quiz")
                .showError();
            
        } else {
            //nomQuiz.setEditable(false);
            System.err.println("Enregistrement du  nom");
            this.quiz= new Quizz(nom);
        }
    }
    
    private boolean champsValides(){
        String quest = this.question.getText();
        String opt1 = this.option1.getText();
        String opt2 = this.option2.getText();
        String opt3 = this.option3.getText();
        String opt4 = this.option4.getText();
        Toggle radio_selectionne = radioGroup.getSelectedToggle();
        System.out.println(radio_selectionne);
        
        if( quest.trim().isEmpty()
                || opt1.trim().isEmpty()
                || opt2.trim().isEmpty()
                || opt3.trim().isEmpty()
                || opt4.trim().isEmpty()   
                
          ){
                Notifications.create()
                        .title("Question")
                        //.darkStyle()
                        .position(Pos.CENTER)
                        .text("Remplir tous les champs")
                        .showError();
            
                return false;
           }
        else 
            {
                
                if(radio_selectionne == null)
                    {
                        Notifications.create()
                        .title("Question")
                        //.darkStyle()
                        .position(Pos.CENTER)
                        .text("Veuillez svp choisir une option")
                        .showError();
                        return false;
                    }
                else 
                    {
                      return true;
                    }
            
            }      
    
    }

    @FXML
    private void ajouterQuestionSuivanteButton(ActionEvent event) {
        boolean valid =champsValides();
        Question _question = new Question();
        if(valid)
        {
            //enregistrer            
            _question.setOption1(option1.getText().trim());
            _question.setOption2(option2.getText().trim());
            _question.setOption3(option3.getText().trim());
            _question.setOption4(option4.getText().trim());
            
            Toggle selected = radioGroup.getSelectedToggle();
            String rep = null;
            if (selected == option1radio)
            {
                rep = option1.getText().trim();
            } else if (selected == option1radio)
            {
                rep = option2.getText().trim();
            } else if (selected == option1radio)
            {
                rep = option3.getText().trim();
            }
            else if (selected == option1radio)
            {
                rep = option4.getText().trim();          
            }
            
            //_question.setAnswer(rep);
            _question.setQuestion(this.question.getText().trim());
                        
            this.question.clear();
            option1.clear();
            option2.clear();
            option3.clear();
            option4.clear();
            //Ajout d'une question au niveau de ArrayList de questions
            questions.add(_question);
            
            
            
            System.out.println("Sauvgarder question");
            System.out.println(questions);
            System.out.println(quiz);
             
        }
        else{
        }
       
    }

    @FXML
    private void validerQuizButton(ActionEvent event) {
//        validerQuiz.setOnAction((ActionEvent event1) -> {
//            Quizz q = new Quizz (nomQuiz.getText());
//            QuizzDao Q = QuizzDao.getInstance();
//            Q.insert(q);
//                       
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("Nom Quiz ajouté avec succés!");
//            alert.show();
//            nomQuiz.setText("");
//            
//            System.out.println("ok");
//        });
                
        validerQuiz.setOnAction((ActionEvent event2) -> {
            
            
            
//            //Question f = new Question(question.getText(),option1.getText(),option2.getText(),option3.getText(),option4.getText(),quiz.getQuizID());
//            QuestionDao F = QuestionDao.getInstance();
//            F.insert(f);            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Nom Quiz ajouté avec succés!");
            alert.show();
            
            question.setText("");
            option1.setText("");
            option2.setText("");
            option3.setText("");
            option4.setText("");
            System.out.println("ok");
        });
    }

    
    
}
