package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeView;
import entity.Question;
import entity.Quizz;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import service.QuizzDao;


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
    
    @FXML
    private Button setQuizTitleButton;
    @FXML
    private JFXTreeView treeView1;
    
    
    
    
    private ToggleGroup radioGroup;
    
    //mes variables
    
    private Quizz quiz = null;
    private ArrayList <Question> questions = new ArrayList<>(); 
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioButtonSetup();  
//        renderTreeView();
    }    
    
//    private void renderTreeView(){
//       
//        
//        Map<Quizz, List<Question>> data=  QuizzDao.getInstance().getAll();
//        Set <Quizz> quizzes = data.keySet();
//        TreeItem root = new TreeItem ("Quizzes");
//        
//        for (Quizz q : quizzes )  {
//            TreeItem quizTreeItem = new TreeItem (q);            
//                List<Question> questions = data.get(q);
//                for (Question p : questions){
//                    TreeItem questionTreeItem = new TreeItem(p);
//                    questionTreeItem.getChildren().add(new TreeItem("A :" + p.getOption1()));
//                    questionTreeItem.getChildren().add(new TreeItem("B :" + p.getOption2()));
//                    questionTreeItem.getChildren().add(new TreeItem("C :" + p.getOption3()));
//                    questionTreeItem.getChildren().add(new TreeItem("D :" + p.getOption4()));
//                    questionTreeItem.getChildren().add(new TreeItem("Réponse :" +p.getReponse()));
//                    
//                    quizTreeItem.getChildren().add(questionTreeItem);
//                }
//            quizTreeItem.setExpanded(true);
//            root.getChildren().add(quizTreeItem);
//        } 
//        root.setExpanded(true);
//        this.treeView1.setRoot(root);   
//    }


    private void radioButtonSetup() {
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);      
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
        System.out.println("controller.AjouterQuizController.setQuizTitle()");
        String nom = nomQuiz.getText();
        if(nom.trim().isEmpty()){
            Notifications.create()
                //.darkStyle()
                .text("Entrer un nom de quiz valide")
                .position(Pos.CENTER)
                .hideAfter(Duration.millis(2000))
                .title("Nom Quiz")
                .showError();
                this.quiz= new Quizz(nomQuiz.getText());
            
        } else {
            nomQuiz.setEditable(false);
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
        String reponse = null;
        if(valid)
        {
            //enregistrement         
            _question.setOption1(option1.getText().trim());
            _question.setOption2(option2.getText().trim());
            _question.setOption3(option3.getText().trim());
            _question.setOption4(option4.getText().trim());
            
            Toggle selected = radioGroup.getSelectedToggle();
            
            if (selected == option1radio)
                {
                reponse = option1.getText().trim();
                } else if (selected == option2radio)
                {
                    reponse = option2.getText().trim();
                } else if (selected == option3radio)
                {
                    reponse = option3.getText().trim();
                }
                else if (selected == option4radio)
                {
                    reponse = option4.getText().trim();          
                }
            
            System.out.println("----------------------------------" + reponse);
            
            _question.setReponse(reponse);
            _question.setQuestion(this.question.getText().trim());                        
            this.question.clear();
            option1.clear();
            option2.clear();
            option3.clear();
            option4.clear();            
            
            //Ajout d'une question au niveau de ArrayList de questions
            questions.add(_question);                       
            System.out.println("Questions Sauvgardées");
            for(int i=0;i<questions.size();i++)
                {   
                    System.out.println(" Question : " + questions.get(i).getQuestion());
                    System.out.println(" Option 1 : " + questions.get(i).getOption1());
                    System.out.println(" Option 2 : " + questions.get(i).getOption2());
                    System.out.println(" Option 3 : " + questions.get(i).getOption3());
                    System.out.println(" Option 4 : " + questions.get(i).getOption4());
                    System.out.println(" Réponse : " + questions.get(i).getReponse());
                    System.out.println("+***********************+");
                }          
            System.out.println(quiz);          
        }
        else{
        }
       
    }

    @FXML
    private void validerQuizButton(ActionEvent event) {
        validerQuiz.setOnAction((ActionEvent event2) -> {
            
            //System.out.println(nomQuiz.getText());
            Quizz q = new Quizz (nomQuiz.getText());
            QuizzDao Q = QuizzDao.getInstance();             
            Q.insert(q);
            
            System.out.println(nomQuiz.getText());
            
            int val;           
            val=Q.retoutnerID(q);
            System.out.println(val);
            
                for(int i=0;i<questions.size();i++){
                    Question f = new Question(questions.get(i).getQuestion(),
                                              questions.get(i).getOption1(),
                                              questions.get(i).getOption2(),
                                              questions.get(i).getOption3(),
                                              questions.get(i).getOption4(),
                                              questions.get(i).getReponse(),
                                              val);
                    QuestionDao F = QuestionDao.getInstance();
                    F.insert(f);
                    
                    
                }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Quiz ajouté avec succés!");
            alert.show();
            
            question.setText("");
            option1.setText("");
            option2.setText("");
            option3.setText("");
            option4.setText("");
            //reponse.setText("");
            
            System.out.println("Quiz Ajouté!!");
        });        
    } 
}
