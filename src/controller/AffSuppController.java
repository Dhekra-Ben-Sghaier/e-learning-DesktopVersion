/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import utils.ConnexionSingleton;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AffSuppController implements Initializable {

    @FXML
    private TableColumn<Apprenant, String> iduser;
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
    private TableView<Apprenant> apprenants;
    @FXML
    private Button btn_aff;
   
    /**
     * Initializes the controller class.
     */
       ObservableList<Apprenant>  ApprenantList = FXCollections.observableArrayList();
        private ListDet listdata = new ListDet();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       apprenants.setItems(listdata.getPersonsapp());
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
      /*  btn_aff.setOnAction(event -> {
            
               AppDao affdao = AppDao.getInstance();
            ObservableList<Apprenant>  ApptList = FXCollections.observableArrayList();

              ApprenantList=affdao.displaylist();
              apprenants.setItems(ApprenantList);
              
              for(int i=0;i<ApprenantList.size();i++){
                  System.out.println(i);
                  
              }
        
     
        });*/
               

      /*  try {
              Connection con=ConnexionSingleton.getCnx();
            ResultSet rs=con.createStatement().executeQuery("select * from personnes");
            while(rs.next()){
                ApprenantList.add(new Apprenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AffSuppController.class.getName()).log(Level.SEVERE, null, ex);
        }
        iduser.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomp.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomp.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        emailp.setCellValueFactory(new PropertyValueFactory<>("email"));
        nomuserp.setCellValueFactory(new PropertyValueFactory<>("login"));
        cdp.setCellValueFactory(new PropertyValueFactory<>("cd"));
         apprenants.setItems(ApprenantList);
*/
        
    } 
        
    
        
        
    
}
