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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private TextField email;
    @FXML
    private PasswordField mdp;
    @FXML
    private TextField nomuser;
    @FXML
    private TextField cin;
    @FXML
    private Button btn_retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cd.setItems(centreInteret);
       btn_add.setOnAction(event -> {
            
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
        });
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
    }
private static String hashPassword(String txtpassword){
    return BCrypt.hashpw(txtpassword, BCrypt.gensalt());
}    
 
}
