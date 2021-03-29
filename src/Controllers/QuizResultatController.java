package Controllers;

import Views.ResultatQuestionUniqueController;
import com.jfoenix.controls.JFXButton;
import constants.NewScreenListener;

import entity.Question;
import entity.Quizz;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.QuizzDao;

public class QuizResultatController implements Initializable {

    @FXML
    private PieChart bonnesMauvaisesReponses;
    @FXML
    private VBox questionsContainer;
    @FXML
    private JFXButton ObtenirCertificat;
    @FXML
    private SplitPane maissa;
    
    @FXML
    private AnchorPane list;
    
    //Non FXML
    
    Map<Question, String> utilisateurReponses;
    Integer nombreDeBonnesReponses = 0;
    Quizz quiz;
    List<Question> questionList;    
    private Integer notAttemped = 0;
    private Integer attemped= 0;  
    Map<Quizz, String> quizzes = null;
    private Set<Quizz> keys;
    

        
    public void obtenirCertificat(){
        float x=(float)(this.questionList.size()* 80) / 100;
        System.out.println(this.utilisateurReponses);
        Integer y = nombreDeBonnesReponses;
        System.out.println(x);
        System.out.println(y);
        if(y>x){
            showObtenirCertificatButton();
            
        }
        ScrollPane sp = new ScrollPane();
        sp.setContent(maissa);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        VBox questionsContainer = new VBox();
        questionsContainer.getChildren().add(sp);
    }
    

        
    public void  setValues(Map<Question, String> utilisateurReponses,Integer nombreDeBonnesReponses, Quizz quiz, List<Question> questionList) {
        this.nombreDeBonnesReponses=nombreDeBonnesReponses;
        this.utilisateurReponses = utilisateurReponses;
        this.quiz = quiz;        
        this.questionList = questionList;        
        this.attemped = this.utilisateurReponses.keySet().size();
        this.notAttemped= this.questionList.size() - attemped;
        setValuesToChart();
        renderQuestions();
        obtenirCertificat();

        

       
    }
    
    private void renderQuestions(){
         for (int i = 0; i < this.questionList.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Views/ResultatQuestionUnique.fxml"));
            try{
                Node node = fxmlLoader.load();
                ResultatQuestionUniqueController controller  = fxmlLoader.getController();
                controller.setValues(this.questionList.get(i), this.utilisateurReponses.get(this.questionList.get(i)));
                questionsContainer.getChildren().add(node);         
                                      
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    
    private void setValuesToChart(){      
        ObservableList<PieChart.Data> scoreChartData = this.bonnesMauvaisesReponses.getData();
        
        scoreChartData.add(new PieChart.Data(
                String.format("Bonnes Réponses (%d)",this.nombreDeBonnesReponses), this.nombreDeBonnesReponses));
        scoreChartData.add(new PieChart.Data(
                String.format("Mauvaises Réponses (%d)", this.attemped - this.nombreDeBonnesReponses), this.attemped - this.nombreDeBonnesReponses));
     
    }
    
   
    
    private void showObtenirCertificatButton(){
        this.ObtenirCertificat.setVisible(true);

    }
    
    private void hideObtenirCertificatButton(){
        this.ObtenirCertificat.setVisible(false);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hideObtenirCertificatButton();
        quizzes= QuizzDao.getInstance().retoutnerNom();
        keys = quizzes.keySet();

    } 
    private void setNode(Node node) {
        list.getChildren().clear();
        list.getChildren().add((Node) node);
        FadeTransition ft = new FadeTransition(Duration.seconds(1));//dure de la translation
        ft.setNode(node);
        ft.setFromValue(0.10);//dispartion 
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(true);
        ft.play();
    }
    

    
    @FXML
    private void ObtenirCertificat(ActionEvent event)  {
        FXMLLoader fxmlLoader =  new FXMLLoader(getClass().getResource("/Views/Certificat.fxml"));

        try {
                Parent root = (Parent) fxmlLoader.load();  
                CertificatController qq = fxmlLoader.<CertificatController>getController();
                qq.setNom(quiz.getNom());

                Scene scene = new Scene(root); 
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }catch(IOException ex){
            Logger.getLogger(QuizResultatController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}   

    
     
     
   

    
    

