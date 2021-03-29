
package Views;

import entity.Question;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class ResultatQuestionUniqueController implements Initializable {

    @FXML
    private Label question;
    @FXML
    private Label option1;
    @FXML
    private Label option2;
    @FXML
    private Label option3;
    @FXML
    private Label option4;
    
    private Question questionObject;
    private String utilisateurReponses;

    public void setValues(Question questionObject, String utilisateurReponses) {
        this.questionObject = questionObject;
        this.utilisateurReponses = utilisateurReponses;
        setText();
    }
    
    public void setText(){
        this.question.setText(this.questionObject.getQuestion());
        this.option1.setText(this.questionObject.getOption1());
        this.option2.setText(this.questionObject.getOption2());
        this.option3.setText(this.questionObject.getOption3());
        this.option4.setText(this.questionObject.getOption4());
        
        if(option1.getText().trim().equalsIgnoreCase(this.questionObject.getReponse())){
            option1.setTextFill(Color.web("#26ae60"));
        } else if(option2.getText().trim().equalsIgnoreCase(this.questionObject.getReponse())){
            option2.setTextFill(Color.web("#26ae60"));
        }else if(option3.getText().trim().equalsIgnoreCase(this.questionObject.getReponse())){
            option3.setTextFill(Color.web("#26ae60"));
        }else if(option4.getText().trim().equalsIgnoreCase(this.questionObject.getReponse())){
            option4.setTextFill(Color.web("#26ae60"));
        }
        
        
        
        if(!utilisateurReponses.trim().equalsIgnoreCase(this.questionObject.getReponse().trim())){
            if(option1.getText().trim().equalsIgnoreCase(this.utilisateurReponses)){
                   option1.setTextFill(Color.web("#B83227"));
            } else if(option2.getText().trim().equalsIgnoreCase(this.utilisateurReponses)){
                   option2.setTextFill(Color.web("#B83227"));
            }else if(option3.getText().trim().equalsIgnoreCase(this.utilisateurReponses)){
                   option3.setTextFill(Color.web("#B83227"));
            }else if(option4.getText().trim().equalsIgnoreCase(this.utilisateurReponses)){
                   option4.setTextFill(Color.web("#B83227"));
            }

        }  
             
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
