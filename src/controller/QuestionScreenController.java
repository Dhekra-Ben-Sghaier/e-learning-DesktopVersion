package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import constants.NewScreenListener;
import entity.Question;
import entity.Quizz;
import entity.ResultatQuiz;
import entity.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class QuestionScreenController implements Initializable {

    
    private class QuestionsObservable{
        Property<String> question = new SimpleStringProperty();
        Property<String> option1 = new SimpleStringProperty();
        Property<String> option2 = new SimpleStringProperty();
        Property<String> option3 = new SimpleStringProperty();
        Property<String> option4 = new SimpleStringProperty();
        Property<String> reponse = new SimpleStringProperty();
        
        public void setQuestion(Question question){
            this.question.setValue(question.getQuestion());
            this.option1.setValue(question.getOption1());
            this.option2.setValue(question.getOption2());
            this.option3.setValue(question.getOption3());
            this.option4.setValue(question.getOption4());
            this.reponse.setValue(question.getReponse());

        }

    }
    //FXML
    @FXML
    private Label nomQuiz;
    @FXML
    private Label duree;
    @FXML
    private Label Question;
    @FXML
    private ToggleGroup Options;
    @FXML
    private JFXRadioButton option1;    
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
    @FXML
    private FlowPane progressPane;
    
   @FXML
    private Label maissa;
    
    //listener
    private NewScreenListener screenListener;

    //NON FXML
    
    private Quizz quiz;
    
    private List<Question> questionList;
    
    private Question questionCourante;
    
    int indexCourant = 0;
    
    private QuestionsObservable questionsObservable;
    
    private Map<Question,String> utilisateurReponses = new HashMap<>();
    
    private Integer nombreDeBonnesReponses = 0 ;
    
    //Timer fields
    
    private long min, sec, hr,totalSec = 0 ;
    private Timer timer;
    private Integer eya;

    
    //Méthodes et constructeurs 
    
        public void setScreenListener(NewScreenListener screenListener){
            this.screenListener=screenListener;
        
        
        }

        public void setQuiz(Quizz quiz) {
            this.quiz = quiz;
            this.nomQuiz.setText(this.quiz.getNom());
            this.getData();
        }
        
        public  String format(long value){
    
        if(value<10){
            return 0+""+value;
        
        }
        return value +"";
    
        }
    
        public  void convertTime(){

            min = TimeUnit.SECONDS.toMinutes(totalSec);
            sec = totalSec - (min * 60);
            hr = TimeUnit.MINUTES.toHours(min);
            min = min -(hr * 60);
            System.out.println(format(hr) + ":" + format(min) + ":" + format(sec) );
            duree.setText(format(hr) + ":" + format(min) + ":" + format(sec) );

            totalSec --;

        }
        
        

        private void setTimer(){
            totalSec = this.questionList.size() * 15;
            this.timer = new Timer();
            TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable(){
                    @Override
                        public void run() {

                            System.out.println("Après une seconde");
                            convertTime();
                            if (totalSec<=0){
                                timer.cancel();
                                duree.setText("00:00:00");
                                Notifications.create()
                                        .title("Error")
                                        .text("Time UP")
                                       
                                        .showError();
                                
                                
                                
                            }
                        }
                });
            }
        };
        
        timer.schedule(timerTask,0,1000 );   
        
        }
       
                              
        private void getData(){
            if(quiz != null){
                this.questionList=  quiz.getQuestions();    
                Collections.shuffle(this.questionList);
                renderProgress();   
                setquestionSuivante(); 
                setTimer();
                
                
            }
        }
        
        private void renderProgress(){
            
        for (int i=0 ; i<this.questionList.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ProgressCercle.fxml"));
            try {
                Node node = fxmlLoader.load();
                ProgressCercleController progressCercleController= fxmlLoader.getController();
                progressCercleController.setNumero(i+1);
                progressCercleController.setCouleurParDefaut();
                progressPane.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(QuestionScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.showQuestionSuivanteButton();
        this.hideValiderButton();
        this.questionsObservable = new QuestionsObservable();
        bindFields();
        this.option1.setSelected(true);
        
    }    
    
    private void bindFields(){
        this.Question.textProperty().bind(this.questionsObservable.question);
        this.option1.textProperty().bind(this.questionsObservable.option1);
        this.option2.textProperty().bind(this.questionsObservable.option2);
        this.option3.textProperty().bind(this.questionsObservable.option3);
        this.option4.textProperty().bind(this.questionsObservable.option4);
        
    }


    @FXML
    private void questionSuivante(ActionEvent event) {
        boolean isRight = false ;
        {
            //Verifier réponses
            JFXRadioButton SelectedButton = (JFXRadioButton)Options.getSelectedToggle();
            String utilisateurReponse = SelectedButton.getText();
            String bonneReponse = this.questionCourante.getReponse();
            
            if(utilisateurReponse.trim().equalsIgnoreCase(bonneReponse.trim())){
                isRight= true;
                this.nombreDeBonnesReponses++;
            }
            
            //Enregistrer réponses dans HashMap
            utilisateurReponses.put(this.questionCourante, utilisateurReponse); 
        }
        
        
        Node circleNode = this.progressPane.getChildren().get(indexCourant-1);
        ProgressCercleController controller = (ProgressCercleController) circleNode.getUserData();
        
        if(isRight){        
            controller.setBonneReponseCouleur();
        }else{
            controller.setMauvaiseReponseCouleur();        
        }
        this.setquestionSuivante();
    }
 
    
    private void setquestionSuivante(){
        if(!(indexCourant >= questionList.size())){
            { 
                //Changer la couleur 
                Node circleNode = this.progressPane.getChildren().get(indexCourant);
                ProgressCercleController controller = (ProgressCercleController) circleNode.getUserData();
                controller.setQuestionCouranteCouleur();
            }
            
            this.questionCourante = this.questionList.get(indexCourant);            
            List<String> options = new ArrayList<>();            
            options.add(this.questionCourante.getOption1());
            options.add(this.questionCourante.getOption2());
            options.add(this.questionCourante.getOption3());
            options.add(this.questionCourante.getOption4());
            Collections.shuffle(options);
            
            this.questionCourante.setOption1(options.get(0));
            this.questionCourante.setOption2(options.get(1));
            this.questionCourante.setOption3(options.get(2));
            this.questionCourante.setOption4(options.get(3));
            

            this.questionsObservable.setQuestion(this.questionCourante);            
            indexCourant++;            
        } else {
            showValiderButton();
            hideQuestionSuivanteButton();
            
        }
    }

    @FXML
    private void valider(ActionEvent event) {
        
        System.out.println(this.utilisateurReponses);
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setID(1);
        
        ResultatQuiz quizResultat = new ResultatQuiz(this.quiz, utilisateur, nombreDeBonnesReponses);
        quizResultat.save(this.utilisateurReponses);
        timer.cancel(); 
        ouvrirResultatQuiz();
       
        
    }
    
    private void ouvrirResultatQuiz(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/QuizResultat.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuizResultatController controller  = fxmlLoader.getController();
                controller.setValues(this.utilisateurReponses, nombreDeBonnesReponses, quiz, questionList);
                this.screenListener.removeTopScreen();
                this.screenListener.ChangeScreen(node);                         
            }
            catch (IOException e){
                e.printStackTrace();
            }
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
