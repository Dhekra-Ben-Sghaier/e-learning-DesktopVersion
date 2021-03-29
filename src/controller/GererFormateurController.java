/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.FormDao;
import entity.Formateur;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class GererFormateurController implements Initializable {

   @FXML
    private TableView<Formateur> formateurs;
    @FXML
    private TableColumn<Formateur, Integer> iduser;
    @FXML
    private TableColumn<Formateur, String> cinuser;
    @FXML
    private TableColumn<Formateur, String> nomp;
    @FXML
    private TableColumn<Formateur, String> prenomp;
    @FXML
    private TableColumn<Formateur, String> emailp;
    @FXML
    private TableColumn<Formateur, String> passwordp;
    @FXML
    private TableColumn<Formateur, String> nomuserp;
    @FXML
    private TableColumn<Formateur, String> domaine;
    @FXML
    private Button btn_supp;
    @FXML
    private Button btn_modif;
    @FXML
    private TextField txt_search;
       ObservableList<Formateur>  FormateurList = FXCollections.observableArrayList();
        private Listform listdata = new Listform();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 formateurs.setItems(listdata.getPersonsform());
      iduser.setCellValueFactory(cell -> cell.getValue().getIdProperty().asObject());
        
       cinuser.setCellValueFactory(cell -> cell.
                getValue().getCinProperty());
       nomp.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        prenomp.setCellValueFactory(cell -> cell.
                getValue().getPrenomProperty());
        emailp.setCellValueFactory(cell -> cell.
                getValue().getEmailProperty());
        passwordp.setCellValueFactory(cell -> cell.
                getValue().getMdpProperty());
        nomuserp.setCellValueFactory(cell -> cell.
                getValue().getLoginProperty());
        domaine.setCellValueFactory(cell -> cell.
                getValue().getDomaineProperty());
        

     
       //supprimer
     
       btn_supp.setOnAction(event -> {
            
Formateur p = formateurs.getSelectionModel().getSelectedItem();
          FormDao fo =FormDao.getInstance().getInstance();
          fo.delete(p);
          formateurs.getSelectionModel().getSelectedItems().forEach(this.FormateurList::remove);
          //apprenants.getItems().removeAll(apprenants.getSelectionModel().getSelectedItem());
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("formateur supprimé!");
        alert.show();
        
   
        });
       //endSupp
       //modifier
         btn_modif.setOnAction(event -> {

             Formateur f = formateurs.getSelectionModel().getSelectedItem();
        FormDao fo =FormDao.getInstance().getInstance();
          
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/modifFormateur.fxml"));
        
           
                   
            
            Parent parent = (Parent)loader.load();
            
            ModifFormateurController cont = loader.<ModifFormateurController>getController();
            cont.setFormateur(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
             stage.setTitle("Modifier Formateur");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(GererFormateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
         //endModif
         //Rechercher
          FormateurList.addAll(listdata.getPersonsform());
         FilteredList<Formateur> filtereddata= new FilteredList<>(FormateurList, b->true);
         
         txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
             txt_search.textProperty().addListener((observables, oldVal, newVal) -> {
			filtereddata.setPredicate(formateur -> {
				// If filter text is empty, display all persons.
								
				if (newVal == null || newVal.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (formateur.getCin().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches cin.
				} else if (formateur.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}else if (formateur.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}else if (formateur.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}else if (formateur.getMdp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}else if (formateur.getLogin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches nom.
				}
				else if (formateur.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1)
				     return true;
                                
				     else  
				    	 return false; // Does not match.
			});
		});

    });
         // 3. Wrap the FilteredList in a SortedList. 
         SortedList<Formateur> sortedData = new SortedList<>(filtereddata);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(formateurs.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		formateurs.setItems(sortedData);


   //end Recherche
    }    
    
}
