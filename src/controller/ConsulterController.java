/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Recformation;
import service.RecnoteDao;
import entity.Recnote;
import java.io.IOException;
import static java.lang.ProcessBuilder.Redirect.from;
import java.net.URL;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.RecformationDao;

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
     private ListDataRec listdata = new ListDataRec();
     
     ObservableList<Recformation> olist = FXCollections.observableArrayList();
     private ListRec listrec = new ListRec();
     
    @FXML
    private Button modif;
    @FXML
    private Button supprimer;
    @FXML
    private TextField recherche;
    @FXML
    private TableView<Recformation> tabfr;
    @FXML
    private TableColumn<Recformation,String> colfor;
    @FXML
    private TableColumn<Recformation,String> colnom;
    @FXML
    private TableColumn<Recformation,String> cold;
    @FXML
    private TextField cherche;
    @FXML
    private Button modifier;
    @FXML
    private Button suppr;
    @FXML
    private TableColumn<Recformation, Integer> idfor;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabfr.setItems(listrec.gettables());
        idfor.setCellValueFactory(cell -> cell.
                getValue().getId_formationProperty().asObject());
        colfor.setCellValueFactory(cell -> cell.
                getValue().getFormationProperty());
        colnom.setCellValueFactory(cell -> cell.
                getValue().getNomformateurProperty());
        cold.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());
        
     
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
       
      supprimer.setOnAction(event -> {
            
   Recnote p = table.getSelectionModel().getSelectedItem();
          RecnoteDao fo =RecnoteDao.getInstance().getInstance();
          fo.delete(p);
          table.getSelectionModel().getSelectedItems().forEach(this.oblist::remove);
          //table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("reclamation supprimée!");
        alert.show();
        
   
        });
      
      suppr.setOnAction(event -> {
            
   Recformation p = tabfr.getSelectionModel().getSelectedItem();
          RecformationDao fo =RecformationDao.getInstance().getInstance();
          fo.delete(p);
          tabfr.getSelectionModel().getSelectedItems().forEach(this.oblist::remove);
          //table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("reclamation supprimée!");
        alert.show();
        
   
        });
      
       modif.setOnAction(event -> {

             Recnote f = table.getSelectionModel().getSelectedItem();
        RecnoteDao fo =RecnoteDao.getInstance().getInstance();
          
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Modifier.fxml"));
        
           
                   
            
            Parent parent = (Parent)loader.load();
            
            ModifierController cont = loader.<ModifierController>getController();
            cont.setRecnote(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
       
       modifier.setOnAction(event -> {

             Recformation f = tabfr.getSelectionModel().getSelectedItem();
        RecformationDao fo =RecformationDao.getInstance().getInstance();
          
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Modiffor.fxml"));
        
           
                   
            
            Parent parent = (Parent)loader.load();
            
            ModifforController cont = loader.<ModifforController>getController();
            cont.setRecnote(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
       
   oblist.addAll(listdata.gettables());
         FilteredList<Recnote> filtereddata= new FilteredList<>(oblist, b->true);
         
         recherche.textProperty().addListener((observable, oldValue, newValue) -> {
             recherche.textProperty().addListener((observables, oldVal, newVal) -> {
			filtereddata.setPredicate(rec -> {
				// If filter text is empty, display all persons.
								
				if (newVal == null || newVal.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (rec.getExamen().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches cin.
				} else if (rec.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}else if (rec.getNom_formateur().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}
				else if (rec.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1)
				     return true;
                                
				     else  
				    	 return false; // Does not match.
			});
		});

    });
         olist.addAll(listrec.gettables());
         FilteredList<Recformation> filteredrec= new FilteredList<>(olist, b->true);
         
         cherche.textProperty().addListener((observable, oldValue, newValue) -> {
             cherche.textProperty().addListener((observables, oldVal, newVal) -> {
			filteredrec.setPredicate(rec -> {
				// If filter text is empty, display all persons.
								
				if (newVal == null || newVal.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (rec.getFormation().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches cin.
				
				}else if (rec.getNom_formateur().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}
				else if (rec.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1)
				     return true;
                                
				     else  
				    	 return false; // Does not match.
			});
		});

    });
          // 3. Wrap the FilteredList in a SortedList. 
         SortedList<Recformation> sortedrec = new SortedList<>(filteredrec);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedrec.comparatorProperty().bind(tabfr.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabfr.setItems(sortedrec);
         
         
         
         // 3. Wrap the FilteredList in a SortedList. 
         SortedList<Recnote> sortedData = new SortedList<>(filtereddata);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);

    }}

