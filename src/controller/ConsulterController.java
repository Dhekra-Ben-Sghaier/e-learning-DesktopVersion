/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PubDao;
import entity.Pub;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.collections.transformation.SortedList;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static sun.nio.cs.Surrogate.is;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ConsulterController implements Initializable {
 @FXML
    private Button supprimer;
    @FXML
    private TableColumn<Pub, String> nomp;
    @FXML
    private TableColumn<Pub, String> emailp;
    @FXML
    private TableColumn<Pub, String> domainep;
    ObservableList<Pub>  PubList = FXCollections.observableArrayList();
    private ListDet listdata = new ListDet();
    
    
       @FXML
    private TableColumn<Pub, Integer> idp ;
    @FXML
    private TableColumn<Pub, String> prenomp;
    
    @FXML
    private TableView<Pub> pubview;
    @FXML
    private Button modification;
    @FXML
    private TextField txt_search;
    @FXML
    private Button actualiser;
    @FXML
    private TableColumn<Pub, String> affichagep;
    @FXML
    private TableColumn<Pub, Integer> prixp;
    @FXML
    private PieChart piechart1;
   private void load(){
        listdata = new ListDet();
        idp.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomp.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailp.setCellValueFactory(new PropertyValueFactory<>("email"));
        domainep.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        affichagep.setCellValueFactory(new PropertyValueFactory<>("Affichage"));
        prixp.setCellValueFactory(new PropertyValueFactory<>("Prix"));
  
        pubview.setItems(listdata.getPub());
        pubview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         load();
        // TODO
        //aff liste pub
      pubview.setItems(listdata.getPub());
      
       idp.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject());
       nomp.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        prenomp.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
        emailp.setCellValueFactory(cell -> cell.
                getValue().getEmailProperty());
         domainep.setCellValueFactory(cell -> cell.
                getValue().getDomaineProperty());
         affichagep.setCellValueFactory(cell -> cell.
                getValue().getAffichageProperty());
         
         prixp.setCellValueFactory(cell -> cell.
               getValue().getPrixProperty().asObject());
        
    
    
         //suprimer
            supprimer.setOnAction(event -> {
            
   Pub p = pubview.getSelectionModel().getSelectedItem();
          PubDao fo =PubDao.getInstance().getInstance();
          fo.delete(p);
          pubview.getItems().removeAll(pubview.getSelectionModel().getSelectedItem());
          
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Publicité supprimée!");
        alert.show();
        
   
        });
         PubList.addAll(listdata.getPub());
         FilteredList<Pub> filtereddata= new FilteredList<>(PubList, b->true);
         txt_search.textProperty().addListener((observable, oldValue, newValue) -> { 
            txt_search.textProperty().addListener((observables, oldVal, newVal) -> {
               filtereddata.setPredicate(publ -> {
                   if (newVal == null || newVal.isEmpty()){
                   return true; }
                   String lowerCaseFilter = newValue.toLowerCase();
                   if (publ.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
	        }  else if (publ.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
		}  else if (publ.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
		}  else if (publ.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
		}  else  
				    	 return false;
               
               });
                      
            
            });
            
                     
         });
         SortedList<Pub> sortedData = new SortedList<>(filtereddata);
         sortedData.comparatorProperty().bind(pubview.comparatorProperty());
         pubview.setItems(sortedData);
         
    }
    

    @FXML
    private void modification(javafx.event.ActionEvent event) {
        Pub f = pubview.getSelectionModel().getSelectedItem();
        PubDao fo =PubDao.getInstance();

          
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/modif.fxml"));
            Parent parent = (Parent)loader.load();            
               ModifController x = loader.<ModifController>getController();
            x.setPubli(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void actualiser(javafx.event.ActionEvent event) {
         load();
    }

//    void stat() {
//     ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
//     data = FXCollections.observableArrayList();
//     
//    }
    
    
    
}
    

    
    


   
           
           
           
   
     
       

    
    

