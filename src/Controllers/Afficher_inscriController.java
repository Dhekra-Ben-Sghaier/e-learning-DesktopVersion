/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import controller.TableFormController;
import entity.Inscription_certificat;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.Inscription_certificatDao;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
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
    @FXML
    private Button actualiser;
    @FXML
    private Button modifer;
    @FXML
    private Button supprimer;
    @FXML
    private Button ajouter;
    
    private void load(){
        listdata = new ListCertif();
        id_inscri.setCellValueFactory(new PropertyValueFactory<>("id_inscri"));
        nom_utilisateur.setCellValueFactory(new PropertyValueFactory<>("nom_utilisateur"));
        nom_utilisateur.setCellValueFactory(new PropertyValueFactory<>("nom_certificat"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        domaine.setCellValueFactory(new PropertyValueFactory<>("domaine"));
  
        tabInscriCertif.setItems(listdata.getInscriptionCertificat());
        tabInscriCertif.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Modifier_inscri.fxml"));
            Parent parent = (Parent)loader.load();            
            Modifier_inscriController x = loader.<Modifier_inscriController>getController();
            x.setInscriptionCertificat(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableFormController.class.getName()).log(Level.SEVERE, null, ex);
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
            Parent parent = FXMLLoader.load(getClass().getResource("/Views/Insci_certif.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            load();
        } catch (IOException ex) {
            Logger.getLogger(TableFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
