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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private Label lab_id;
    @FXML
    private Label lab_cin;
    @FXML
    private Label lab_nom;
    @FXML
    private Label lab_prenom;
    @FXML
    private Label lab_email;
    @FXML
    private Label lab_password;
    @FXML
    private Label lab_nu;
    @FXML
    private Label lab_cd;
    
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
     setCellValueFromTableToLabel();
       btn_supp.setOnAction(event -> {
            
    int id= Integer.parseInt(lab_id.getText());
    String cin= lab_cin.getText();
    String nom= lab_nom.getText();
    String prenom= lab_prenom.getText();
    String email= lab_email.getText();
    String mdp= lab_password.getText();
    String user= lab_nu.getText();
    String cd= lab_cd.getText();
     Apprenant p = new Apprenant(id,cin,nom, prenom,email,mdp,user,cd);
           AppDao pdao = AppDao.getInstance();
            pdao.delete(p);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Apprenant supprimé!");
        alert.show();
        
   
        });
    }
   private void setCellValueFromTableToLabel(){
       apprenants.setOnMouseClicked(new EventHandler<MouseEvent>(){
           @Override
           public void handle(MouseEvent event) {
               Apprenant ls=apprenants.getItems().get(apprenants.getSelectionModel().getSelectedIndex());
               lab_id.setText(String.valueOf(ls.getId()));
               lab_cin.setText(ls.getCin());
               lab_nom.setText(ls.getNom());
               lab_prenom.setText(ls.getPrenom());
               lab_email.setText(ls.getEmail());
               lab_password.setText(ls.getMdp());
               lab_nu.setText(ls.getLogin());
               lab_cd.setText(ls.getCd());
           }
           
           
           
       });
   }
    public void suppApprenant(){
   
            
}    
   
}
