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
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    @FXML
    private ScrollPane scPane;
    int id;
    public void addFormation(int id, String url ,String description, String title, float price){
        
        VBox v = new VBox();
        File file = new File(url);
        
        Image img = new Image(file.toURI().toString());
        ImageView image = new ImageView(img);
        image.setFitHeight(150);
        image.setFitWidth(170);
        
        
        
        Label titre = new Label(title);
        
        Formation f = new Formation(id, title, url, description, price);
        FormationDao fo =FormationDao.getInstance();
        titre.setStyle("-fx-font-weight: bold; -fx-underline: true;-fx-text-fill: black;");
        titre.setOnMousePressed((mouseEvent) -> {
        titre.setStyle("-fx-font-weight: bold; -fx-underline: true;-fx-text-fill: black;");
        try {
         
        //titre.setStyle("-fx-font-weight: bold; -fx-underline: true;-fx-text-fill: #800080;");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FormationDetails.fxml"));

            Parent parent = (Parent)loader.load();
            FormationDetailsController cont = loader.<FormationDetailsController>getController();
            cont.setFormation(f);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            });
        titre.setFont(Font.font("Calibri", 35));
        titre.setStyle("-fx-font-weight: bold; -fx-underline: true;-fx-text-fill: black;");
        titre.applyCss();
        Label prix = new Label(String.valueOf(price)+" DT");
        prix.setFont(Font.font("Calibri", 18));
        prix.setStyle("-fx-font-weight: bold");
        v.getChildren().add(image);
        v.getChildren().add(titre);
        v.getChildren().add(prix);
        v.setPadding(new Insets(15));
        
        fl.getChildren().add(v);
        fl.setOrientation(Orientation.HORIZONTAL);
        titre.setStyle("-fx-font-weight: bold; -fx-underline: true;-fx-text-fill: black;");
//        scPane.setContent();

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
        search_formation();
        
        
            
    }
    public void search_formation() {     
        FilteredList<Formation> filteredata, ff;
        filteredata = new FilteredList<>(listdata.getForm(), b -> true);
        ff = filteredata;
        cherche.textProperty().addListener((observable, oldValue, newValue) -> {
        
            filteredata.setPredicate(formation -> {
                if (newValue == null){
                    return true;
                }
                fl.getChildren().clear();
                String lowerCaseFilter = newValue.toLowerCase();
                if(formation.getTitle().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }   
                
                    if((""+formation.getPrix()).contains(lowerCaseFilter)){
                    return true;
                
                }
                 else  
                        return false;
            });
            
            
            filteredata.forEach(l ->
                            {
                                     addFormation(l.getId(),l.getPathImg(),l.getDescription(), l.getTitle(), l.getPrix());
                            });
            
        });

        
        
    }
//     public void setId(int a){
//        this.id= a;
//        labid.setText(""+a);
//             
//        
//    }
    
}
