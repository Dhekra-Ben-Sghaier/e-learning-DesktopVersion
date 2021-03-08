/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
public class TableFormController implements Initializable {

    @FXML
    private TableView<?> apprenants;
    @FXML
    private TableColumn<?, ?> iduser;
    @FXML
    private TableColumn<?, ?> cinuser;
    @FXML
    private TableColumn<?, ?> nomp;
    @FXML
    private TableColumn<?, ?> prenomp;
    @FXML
    private TableColumn<?, ?> emailp;
    @FXML
    private TableColumn<?, ?> passwordp;
    @FXML
    private TableColumn<?, ?> nomuserp;
    @FXML
    private TableColumn<?, ?> cdp;
    @FXML
    private Button btn_supp;
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
    }    

    
}
