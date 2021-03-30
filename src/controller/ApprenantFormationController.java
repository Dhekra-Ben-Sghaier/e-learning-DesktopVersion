/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.FormationDao;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ApprenantFormationController implements Initializable {

    @FXML
    private TableView<Formation> tabFormation;
    @FXML
    private TableColumn<Formation, Integer> idCol;
    @FXML
    private TableColumn<Formation, String> titreCol;
    @FXML
    private TableColumn<Formation, String> descripCol;
    @FXML
    private TableColumn<Formation, String> prixCol;
    @FXML
    private TableColumn<Formation, String> nivCol;
    @FXML
    private TableColumn<Formation, String> certifCol;
    @FXML
    private TextField cherche;
    
    private ListData listdata;
    @FXML
    private Button btnInsc;
    @FXML
    private Label IdUser;
    private int id;

    private void load(){
        listdata = new ListData();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titreCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descripCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        nivCol.setCellValueFactory(new PropertyValueFactory<>("difficulte"));
        certifCol.setCellValueFactory(new PropertyValueFactory<>("certifier"));
        certifCol.setCellValueFactory(new PropertyValueFactory<>("cours"));
  
        tabFormation.setItems(listdata.getFormations());
        tabFormation.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        search_formation();
    }    




    
void search_formation() {     
        FilteredList<Formation> filteredata;
        filteredata = new FilteredList<>(listdata.getFormations(), b -> true);
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
                 else if (formation.getDifficulte().toLowerCase().indexOf(lowerCaseFilter) != -1) {
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
    private void acheterFormation(ActionEvent event) {
         
        Formation f = tabFormation.getSelectionModel().getSelectedItem();
        FormationDao fo =FormationDao.getInstance();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Payer.fxml"));
        
            Parent parent = (Parent)loader.load();
            
            PayerController cont = loader.<PayerController>getController();
            cont.setFormation(f);
            cont.setId(Integer.parseInt(IdUser.getText()));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
       public void setId(int a){
        this.id= a;
        IdUser.setText(a+"");
      
        
    }
}
