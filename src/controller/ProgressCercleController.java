package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class ProgressCercleController implements Initializable {

    @FXML
    private Circle cercle;
    @FXML
    private Label numero;
    
        public void setNumero(Integer numero) {
            this.numero.setText(numero.toString());
        }
    
        public void setCouleurParDefaut(){

            cercle.setFill(Color.web("DAE0E2"));
            numero.setTextFill(Color.valueOf("black"));
        }
        
        public void setQuestionCouranteCouleur(){
            cercle.setFill(Color.web("0ABDE3"));
            numero.setTextFill(Color.valueOf("white"));        
        }
        public void setMauvaiseReponseCouleur(){
            cercle.setFill(Color.web("EC4849"));
            numero.setTextFill(Color.valueOf("white"));        
        }
        
        public void setBonneReponseCouleur(){
            cercle.setFill(Color.web("75DA8B"));
            numero.setTextFill(Color.valueOf("white"));        
        }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
