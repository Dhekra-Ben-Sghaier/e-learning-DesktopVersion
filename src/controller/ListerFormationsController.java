/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class ListerFormationsController implements Initializable {
    
    HBox hbox;
    private ListData listdata;
    @FXML
    private FlowPane fl;
    @FXML
    private TextField cherche;

    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
//        sortedData.comparatorProperty().bind(tabFormation.comparatorProperty());  
//        tabFormation.setItems(sortedData);
        fl.setUserData(sortedData);
        
    }
    
}
