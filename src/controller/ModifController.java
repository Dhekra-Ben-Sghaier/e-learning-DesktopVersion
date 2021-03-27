/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PubDao;
import entity.Pub;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifController implements Initializable {
ObservableList<String> Affichage =FXCollections.observableArrayList("1000","2000","3000","4000");
    @FXML
    private TextField nom_p;
    @FXML
    private TextField prenom_p;
    @FXML
    private TextField email_p;
    @FXML
    private TextField domaine_p;
    @FXML
    private Label id_p;
    private Pub p;
    @FXML
    private ComboBox<String> cb_occ;
    @FXML
    private TextField prix_p;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       cb_occ.setItems(Affichage);
    }    

   public void setPubli(Pub f){
        this.p = f;
        id_p.setText(""+f.getId());
        nom_p.setText(f.getNom());
        prenom_p.setText(""+f.getPrenom());
        email_p.setText(f.getEmail());
        domaine_p.setText(f.getDomaine());
        cb_occ.setValue(f.getAffichage());
        prix_p.setText(""+f.getPrix());
    }
   /*
   @FXML
    private void Modifier(ActionEvent event) {
            Pub f = new Pub (Integer.parseInt(id_p.getText()),nom_p.getText(), prenom_p.getText(), email_p.getText() , domaine_p.getText() , cb_occ.getValue() );
            PubDao fdao = PubDao.getInstance();
            fdao.update(f);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("publicit modifiée avec succés!");
            alert.show();
            nom_p.setText("");
            prenom_p.setText("");
            email_p.setText("");
            domaine_p.setText("");
            
}
*/

    @FXML
    private void Modifier(ActionEvent event) {
    }
}
