/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        
        
       apprenants.setOnMouseClicked(event->{
      
    
    });
       
    }    
   
}
