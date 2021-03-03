/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class AffEtsuppApprenantController implements Initializable {

    @FXML
    private TableView<?> apprenants;
    @FXML
    private TableColumn<?, ?> iduser;
    @FXML
    private TableColumn<?, ?> noma;
    @FXML
    private TableColumn<?, ?> prenoma;
    @FXML
    private TableColumn<?, ?> emaila;
    @FXML
    private TableColumn<?, ?> passworda;
    @FXML
    private TableColumn<?, ?> nomusera;
    @FXML
    private TableColumn<?, ?> cda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
