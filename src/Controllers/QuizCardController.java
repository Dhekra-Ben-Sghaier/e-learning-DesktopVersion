package Controllers;

import com.jfoenix.controls.JFXButton;
import constants.NewScreenListener;
import entity.Inscription_certificat;
import entity.Quizz;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import service.Inscription_certificatDao;


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
    @FXML
    private TableView<Inscription_certificat> tabInscriCertif;
    
    private Inscription_certificat modif;
    
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
        Inscription_certificat f = tabInscriCertif.getSelectionModel().getSelectedItem();
        Inscription_certificatDao fo =Inscription_certificatDao.getInstance();

          
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/QuestionScreen.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuestionScreenController questionScreenController  = fxmlLoader.getController();
                questionScreenController.setQuiz(this.quiz);
                
                //questionScreenController.setUtilisateur(this.utilisateur);
                questionScreenController.setScreenListener(this.screenListener);
                Modifier_inscriController modif = fxmlLoader.getController();
                modif.setNomUtilisateurEtNomQuiz( f ,quiz);

                this.screenListener.ChangeScreen(node);

                        
            }

            catch (IOException e){
                e.printStackTrace();
            }
    }

    
    
}
