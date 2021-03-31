package controller;

import com.itextpdf.text.DocumentException;
import entity.Inscription_certificat;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.Inscription_certificatDao;

public class Afficher_inscriController implements Initializable {

    @FXML
    private TableView<Inscription_certificat> tabInscriCertif;
    @FXML
    private TableColumn<Inscription_certificat, String> id_inscri;    
    @FXML
    private TableColumn<Inscription_certificat, String> nom_utilisateur;
    @FXML
    private TableColumn<Inscription_certificat, String> nom_certificat;
    @FXML
    private TableColumn<Inscription_certificat, String> description;
    @FXML
    private TableColumn<Inscription_certificat, String> domaine;
        
    private ListCertif listdata;
    ObservableList<Inscription_certificat>  RechercheList = FXCollections.observableArrayList();
    @FXML
    private Button actualiser;
    @FXML
    private Button modifer;
    @FXML
    private Button supprimer;
    @FXML
    private Button ajouter;
    @FXML
    private TextField txt_search;
    @FXML
    private Button imprimer;
     @FXML
    private Label yarab;
    
    private void load(){
        listdata = new ListCertif();
        id_inscri.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom_utilisateur.setCellValueFactory(new PropertyValueFactory<>("nomUtilisateur"));
        nom_certificat.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
  
        tabInscriCertif.setItems(listdata.getInscriptionCertificat());
        tabInscriCertif.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        RechercheList.addAll(listdata.getInscriptionCertificat());
        FilteredList<Inscription_certificat> filtereddata= new FilteredList<>(RechercheList, b->true);
        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
            txt_search.textProperty().addListener((observables, oldVal, newVal) -> {
		filtereddata.setPredicate(personne -> {
                    // If filter text is empty, display all persons.					
                    if (newVal == null || newVal.isEmpty()) {
                        return true;
                    }
				
                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();
				
                    if (personne.getNomUtilisateur().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
			return true; // Filter matches cin.
                    } else if (personne.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
			return true; // Filter matches nom.
                    }                              
                    else  
			return false; // Does not match.
                    });
		});
             });
        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Inscription_certificat> sortedData = new SortedList<>(filtereddata);
        // 4. Bind the SortedList comparator to the TableView comparator.
	// 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tabInscriCertif.comparatorProperty());
        // 5. Add sorted (and filtered) data to the table.
	tabInscriCertif.setItems(sortedData);
    }    

    @FXML
    private void actualiser(ActionEvent event) {
        
        load();
        
    }

    @FXML
    private void modifer(ActionEvent event) {
        Inscription_certificat f = tabInscriCertif.getSelectionModel().getSelectedItem();
        Inscription_certificatDao fo =Inscription_certificatDao.getInstance();

          
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Modifier_inscri.fxml"));
            Parent parent = (Parent)loader.load();            
            Modifier_inscriController x = loader.<Modifier_inscriController>getController();
            x.setInscriptionCertificat(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(Afficher_inscriController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }

    @FXML
    private void supprimer(ActionEvent event) {
          Inscription_certificat f = tabInscriCertif.getSelectionModel().getSelectedItem();
          Inscription_certificatDao fo =Inscription_certificatDao.getInstance();
          fo.delete(f);
          tabInscriCertif.getItems().removeAll(tabInscriCertif.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void ajouter(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/Insci_certif.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            load();
        } catch (IOException ex) {
            Logger.getLogger(Afficher_inscriController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void imprimer(ActionEvent event)   
         
    
   {
       Inscription_certificatDao S = new Inscription_certificatDao();
       try {
           S.FacturePdf();
       } catch (SQLException ex) {
           Logger.getLogger(Afficher_inscriController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (DocumentException ex) {
           Logger.getLogger(Afficher_inscriController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Afficher_inscriController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    

    
    
}
