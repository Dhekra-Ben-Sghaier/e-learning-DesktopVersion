/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class InscrireApprenantController implements Initializable {
    ObservableList<String> centreInteret=FXCollections.observableArrayList("cv1","cd2","cd3");
    @FXML
    private Button btn_add;
    @FXML
    private ComboBox<String> cd;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private static TextField email;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField nomuser;
    @FXML
    private TextField cin;
    @FXML
    private Button btn_retour;
    @FXML
    private CheckBox check_af;
    @FXML
    private TextField txt_mdp;
    @FXML
    private Label lab_email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cd.setItems(centreInteret);
        //inserer un apprenant
       btn_add.setOnAction(event -> {
            boolean emailvalidation=validEmail(email,lab_email,"format doitt être nom@address.com");
            System.out.println(emailvalidation);
            if(emailvalidation){
            Apprenant p = new Apprenant(cin.getText(),nom.getText(), prenom.getText(),email.getText(),hashPassword(mdp.getText()),nomuser.getText(),cd.getValue(),"apprenant");
           AppDao pdao = AppDao.getInstance();
            pdao.insert(p);
       
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
        cin.setText("");
        nom.setText("");
        prenom.setText("");
        email.setText("");
        mdp.setText("");
        nomuser.setText("");
        cd.setValue("Centres d'intérêt");
            }
        });
       // end inserer
       btn_retour.setOnAction(event -> {
             try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/view/usersPanel.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(InscrireApprenantController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        
  
        });
       //aff mdp
       txt_mdp.setVisible(false);
       check_af.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_value, Boolean newValue) -> {
       if(check_af.isSelected()){
           txt_mdp.setText(mdp.getText());
           txt_mdp.setVisible(true);
           mdp.setVisible(false);
           return;
           
       }
       mdp.setText(txt_mdp.getText());
       mdp.setVisible(true);
       txt_mdp.setVisible(false);
       
       });
       //end aff mdp
            
    }
    //crypt pwd
private static String hashPassword(String txtpassword){
    return BCrypt.hashpw(txtpassword, BCrypt.gensalt());
}   //end crypt 
//validemail
public static boolean validEmail(TextField txt, Label lab , String validation){
   
  /*  Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
   Matcher m =p.matcher(email.getText());
   return false;
    if(m.find() && m.group().equals(email.getText())){
        return true;
        
    }else {
          Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("valider Email");
        alert.setHeaderText(null);
        alert.setContentText("veuillez saisir une adresse e-mail valide");
        alert.show();
        return false;
    }*/
    boolean isEmail=true;
    String validate=null;
    if(txt.getText().matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
        isEmail=false;
        validate=validation;
        
    }
    lab.setText(validate);
    return isEmail;
} //endemail
}
