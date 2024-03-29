/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.RecnoteDao;
import entity.Recnote;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class RecnoteController implements Initializable {

    @FXML
    private TextField nomformateur;
    @FXML
    private TextArea description;
    @FXML
    private TextField Examen;
    @FXML
    private Button envoyer;
    @FXML
    private DatePicker champ_date;
    @FXML
    private TextField email;
    @FXML
    private Label labid;
    private int id;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        envoyer.setOnAction(event -> {
            LocalDate Datee = champ_date.getValue();
            java.sql.Date d = java.sql.Date.valueOf(Datee);
            String dd = new SimpleDateFormat("yyyy-MM-dd").format(d);
            
//            deposerbutton.setOnAction((javafx.event.ActionEvent event) -> {
//           if(ControleSaisie.isNull(nom.getText()) || ControleSaisie.isNull(prenom.getText()) || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(domaine.getText()) || ControleSaisie.isNull(email.getText()) || ControleSaisie.isNull(domaine.getText()))
//         { Alert alerts = new Alert(Alert.AlertType.WARNING);
//         alerts.setTitle("Warning");
//        alerts.setHeaderText(null);
//        alerts.setContentText("Veuillez remplir les champs!");
//        alerts.show();
//         } else {
//                           if(ControleSaisie.validemail(email.getText())== false) {
//                           lab_email.setText("Veuillez saisir une adresse email valide !"); }
//                           if( ControleSaisie.validemail(email.getText()) ) {
//
//
//public static boolean validEmail(TextField txt, Label lab , String validation){
//    boolean isEmail=true;
//    String validate=null;
//    if(txt.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
//        isEmail=false;
//        validate=validation;
//        
//    }
                    
          
               Recnote r = new Recnote(email.getText(),Examen.getText(),dd,nomformateur.getText(),description.getText());

           RecnoteDao rdao = RecnoteDao.getInstance();
            rdao.insert(r);
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Réclamation insérée avec succés!");
        alert.show();
       
        });
      
        
    }
 public void setId(int a){
        this.id= a;
        labid.setText(""+a);
      

         
    }
 public void setEmail(String a){
       
        email.setText(a);
      

         
    }



}
      
         
