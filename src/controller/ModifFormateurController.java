/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FormDao;
import entity.Formateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ModifFormateurController implements Initializable {

    @FXML
    private TextField txt_cin;
    @FXML
    private TextField txt_nom;
    @FXML
    private TextField txt_user;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_prenom;
    @FXML
    private PasswordField txt_mdp;
    @FXML
    private Button bt_modif;
    @FXML
    private Label id_lab;
    @FXML
    private TextField domaine;
     private Formateur formateur;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           bt_modif.setOnAction(event -> {

             Formateur f = new Formateur(Integer.parseInt(id_lab.getText()), txt_cin.getText(), txt_nom.getText(), txt_prenom.getText(), txt_email.getText(), txt_mdp.getText(), txt_user.getText(), domaine.getText());
           FormDao fdao = FormDao.getInstance();
            
            
           fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Formateur modifiée avec succés!");
            alert.show();
        });
        
    } 
    // recuperer les donnés de la table view apprneants
    public void setFormateur(Formateur a){
        this.formateur= a;
        id_lab.setText(""+a.getId());
       txt_cin.setText(a.getCin());
       txt_nom.setText(a.getNom());
       txt_prenom.setText(a.getPrenom());
       txt_email.setText(a.getEmail());
       txt_mdp.setText(a.getMdp());
       txt_user.setText(a.getLogin());
       domaine.setText(a.getDomaine());
        
    }
}
