package controller;

import com.jfoenix.controls.JFXButton;
import constants.NewScreenListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainScreenController implements Initializable {

    @FXML
    private JFXButton backButton;
    @FXML
    private StackPane stackPanel;
    private int id;
    @FXML
    private Label labid;
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         
    } 
    
    private void addScreenToStackPane(Node node){
        this.stackPanel.getChildren().add(node);
    
    }
    
    public void ajouterQuizListScreen( ){
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/QuizList.fxml"));
            try{
                Node node = fxmlLoader.load();
                QuizListController quizListController= fxmlLoader.getController();
                
               QuizListController aa = fxmlLoader.<QuizListController>getController();
                       System.out.println("n="+id);
                  aa.setId(id);

                quizListController.setScreenListener(new NewScreenListener(){
                    
                    @Override
                    public void ChangeScreen(Node node) {
                        addScreenToStackPane(node);
                    }
                    @Override
                    public void removeTopScreen() {
                        
                        stackPanel.getChildren().remove(stackPanel.getChildren().size()-1);
                    }
                    @Override
                    public void handle(Event event) {
                        
                    }
                });
                stackPanel.getChildren().add(node);   
            }

            catch (IOException e){
                e.printStackTrace();
            }
    
    }

    @FXML
    private void retour(ActionEvent event) {
        
        ObservableList<Node> nodes = this.stackPanel.getChildren(); 
        if(nodes.size() == 1){
            return;        
        }
        stackPanel.getChildren().remove(nodes.size()-1 ); 
    }
  
     public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
}
