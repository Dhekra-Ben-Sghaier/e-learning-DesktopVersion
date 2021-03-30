/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class MesFormationsController implements Initializable {

    @FXML
    private TableView<Formation> tabFormation;
    @FXML
    private TableColumn<Formation, String> titreCol;
    @FXML
    private TableColumn<Formation, String> descripCol;
    @FXML
    private TextField cherche;
    
    private ListData listdata;
    @FXML
    private Button btnDownload;
    @FXML
    private Label Idlab;
    private int id;

    /**
     * Initializes the controller class.
     */
    
    public void load() {
        listdata = new ListData();
        titreCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        tabFormation.setItems(listdata.getFormAch(32));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        search_formation();
    }    
    void search_formation() {     
        FilteredList<Formation> filteredata;
        filteredata = new FilteredList<>(listdata.getFormAch(32), b -> true);
        cherche.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filteredata.setPredicate(formation -> {
                if (newValue == null){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(formation.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                } 
                 else if (formation.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                     return true;
                 }
                 else  
          return false;
            
            });
            
        });
        SortedList<Formation> sortedData = new SortedList<>(filteredata);
        sortedData.comparatorProperty().bind(tabFormation.comparatorProperty());  
        tabFormation.setItems(sortedData);
        
    }

    @FXML
    private void download(MouseEvent event) {
        Formation f = tabFormation.getSelectionModel().getSelectedItem();
        FormationDao fo =FormationDao.getInstance();
        System.out.println(f);
        fo.affFormation(f.getId());
    }
       public void setId(int a){
        this.id= a;
        Idlab.setText(a+"");
      
        
    }
}
