/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Dao.RecnoteDao;
import entity.Recnote;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField modex;
    @FXML
    private TextField moddat;
    @FXML
    private TextField modfor;
    @FXML
    private TextArea moddes;
    @FXML
    private Button valider;
    @FXML
    private Label idrec;
    private Recnote Recnote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODObt_modif.setOnAction(event -> {
            valider.setOnAction(event -> {
              Recnote f = new Recnote(Integer.parseInt(idrec.getText()),modex.getText(), moddat.getText(), modfor.getText(), moddes.getText());
           RecnoteDao fdao = RecnoteDao.getInstance();
            
            
           fdao.update(f);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Reclamation modifiée avec succés!");
            alert.show();
        });
    }
        public void setRecnote(Recnote a){
        this.Recnote= a;
        idrec.setText(""+a.getId_reclamation());
       modex.setText(a.getExamen());
       moddat.setText(a.getDate());
       modfor.setText(a.getNom_formateur());
       moddes.setText(a.getDescription());
    }    
    
}
