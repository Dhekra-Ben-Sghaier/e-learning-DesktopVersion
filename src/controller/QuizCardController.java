package controller;

import com.jfoenix.controls.JFXButton;
import constants.NewScreenListener;
import entity.Inscription_certificat;
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
import service.Inscription_certificatDao;
import service.Operation;


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
    private int id;
    @FXML
    private Label labid;
    
    
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
                Inscription_certificatDao certif=new Inscription_certificatDao();
                  Operation operation =new Operation();
                String nom=operation.recNom(Integer.parseInt(labid.getText()));
                String prenom=operation.recPrenom(Integer.parseInt(labid.getText()));
                String nomUser=nom+" "+prenom;
               
                Inscription_certificat o=new Inscription_certificat(nomUser, nomQuiz.getText());
                certif.insert(o);
                //questionScreenController.setUtilisateur(this.utilisateur);
                questionScreenController.setScreenListener(this.screenListener);
                questionScreenController.setId(Integer.parseInt(labid.getText()));

                this.screenListener.ChangeScreen(node);

                        
            }

            catch (IOException e){
                e.printStackTrace();
            }
    }

    
       public void setId(int a){
        this.id= a;
        labid.setText(a+"");
      
        
    }
    
}
