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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.FormationDao;

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

    public void addFormation(int id, String url ,String description, String title, float price){
        
        

    }
 
    public void affForm(){
        listdata = new ListData();
        listdata.getForm().forEach(l ->
        {
            
                 addFormation(l.getId(),l.getPathImg(),l.getDescription(), l.getTitle(), l.getPrix());
//            System.out.println(l.getPathImg());
            
           
        });
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        affForm();
        System.out.println("hello 1");
        
        search_formation();
        
        System.out.println("hello 2");
            
    }
    public void search_formation() {     
        
    
}
