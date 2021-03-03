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
import entity.Quiz;
import entity.Quizz;
import java.net.URL;
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
import service.QuizDao;
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
    
    private ToggleGroup radioGroup;
    
    @FXML
    private Button setQuizTitleButton;
    
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
            nomQuiz.setEditable(false);
            System.err.println("Enregistrement du  nom");
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
        if(valid){
            //enregistrer
            System.out.println("Sauvgarder question");
        }
        else{
        }
       
    }

    @FXML
    private void validerQuizButton(ActionEvent event) {
        validerQuiz.setOnAction((ActionEvent event1) -> {
            Quizz f = new Quizz (nomQuiz.getText());
            QuizzDao Q = QuizzDao.getInstance();
            Q.insert(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Personne insérée avec succés!");
            alert.show();
            //titleField.setText("");
            nomQuiz.setText("");
            System.out.println("ok");
        });
        
    }
    
}
