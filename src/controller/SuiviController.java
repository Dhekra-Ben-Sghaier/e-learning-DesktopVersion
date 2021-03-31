/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recnote;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SuiviController implements Initializable {

    @FXML
    private TableView<Recnote> tab;
    @FXML
    private TableColumn<Recnote, Integer> id_rec;
    @FXML
    private TableColumn<Recnote, String> exam;
    @FXML
    private TableColumn<Recnote, String> nomf;
    @FXML
    private TableColumn<Recnote, String> desc;
private ListRecUser listdata;
private String email;
    @FXML
    private Label labemail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }    
  
        public void load(String em) {
            System.out.println("emaaaail="+em);
        listdata = new ListRecUser();
        id_rec.setCellValueFactory(new PropertyValueFactory<>("id_reclamation"));
        exam.setCellValueFactory(new PropertyValueFactory<>("examen"));
         nomf.setCellValueFactory(new PropertyValueFactory<>("nom_formateur"));
          desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        tab.setItems(listdata.getFormAch(em));
    }
          public void setEmail(String a){
       
    this.email=a;
    

         
    }
}
