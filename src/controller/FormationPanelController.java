/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationPanelController implements Initializable {

    @FXML
    private ImageView cons;
    @FXML
    private Button consForm;
    @FXML
    private Button ajoutForm;
    @FXML
    private Button modiForm;
    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane apMenu;
    @FXML
    private AnchorPane apConsulter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        loadPage("/view/ListerFormations.fxml"); 
loadPage("/view/TableForm.fxml");
    }    

    @FXML
    private void consulterFormation(MouseEvent event) {
//        bp.setCenter(apConsulter);
        loadPage("/view/TableForm.fxml");
    }

    @FXML
    private void ajouterFormation(MouseEvent event) {
        loadPage("/view/Formation.fxml");
    }

    @FXML
    private void modifierFormation(MouseEvent event) {
//        loadPage("/view/ListerFormations.fxml");
    }
    
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(FormationPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
            
        }
        }
        
        
    

