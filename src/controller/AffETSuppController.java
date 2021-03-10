/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AffETSuppController implements Initializable {

    @FXML
    private TableView<Apprenant> apprenants;
    @FXML
    private TableColumn<Apprenant, String> nomp;
    @FXML
    private TableColumn<Apprenant, String> prenomp;
    @FXML
    private TableColumn<Apprenant, String> emailp;
    @FXML
    private TableColumn<Apprenant, String> passwordp;
    @FXML
    private TableColumn<Apprenant, String> nomuserp;
    @FXML
    private TableColumn<Apprenant, String> cdp;
    @FXML
    private TableColumn<Apprenant, String> cinuser;
     ObservableList<Apprenant>  ApprenantList = FXCollections.observableArrayList();
        private ListDet listdata = new ListDet();
    @FXML
    private Button btn_supp;
    @FXML
    private TableColumn<Apprenant, Integer> iduser;
    @FXML
    private Button btn_modif;
    @FXML
    private TextField txt_search;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         apprenants.setItems(listdata.getPersonsapp());
         iduser.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject());
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
        cdp.setCellValueFactory(cell -> cell.
                getValue().getCdProperty());
        

     
       //supprimer
     
       btn_supp.setOnAction(event -> {
            
   Apprenant p = apprenants.getSelectionModel().getSelectedItem();
          AppDao fo =AppDao.getInstance().getInstance();
          fo.delete(p);
          apprenants.getItems().removeAll(apprenants.getSelectionModel().getSelectedItem());
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Apprenant supprimé!");
        alert.show();
        
   
        });
       //endSupp
       //modifier
         btn_modif.setOnAction(event -> {

             Apprenant f = apprenants.getSelectionModel().getSelectedItem();
        AppDao fo =AppDao.getInstance().getInstance();
          
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/interfaceModif.fxml"));
        
           
                   
            
            Parent parent = (Parent)loader.load();
            
            InterfaceModifController cont = loader.<InterfaceModifController>getController();
            cont.setApprenant(f);
            
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffETSuppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
         //endModif
         //Rechercher
       

    }

   
}
