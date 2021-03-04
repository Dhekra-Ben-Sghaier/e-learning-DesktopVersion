/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recnote;
import static java.lang.ProcessBuilder.Redirect.from;
import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ConsulterController implements Initializable {

    @FXML
    private TableView<Recnote> table;
    @FXML
    private TableColumn<Recnote,Integer> col_id;
    @FXML
    private TableColumn<Recnote,String> col_ex;
    @FXML
    private TableColumn<Recnote,String> col_nom;
    @FXML
    private TableColumn<Recnote,String> col_des;
    
  
    
    ObservableList<Recnote> oblist = FXCollections.observableArrayList();
     private ListData listdata = new ListData();

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       table.setItems(listdata.gettables());
        col_ex.setCellValueFactory(cell -> cell.
                getValue().getExamProperty());
           col_id.setCellValueFactory(cell -> cell.
                getValue().getId_reclamationProperty().asObject());
        col_nom.setCellValueFactory(cell -> cell.
                getValue().getFormProperty());
        col_des.setCellValueFactory(cell -> cell.
                getValue().getDescProperty());
        
       // TODO
    }    
    
}
