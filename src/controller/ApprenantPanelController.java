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
public class ApprenantPanelController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane apMenu;
    @FXML
    private Button consForm;
    @FXML
    private ImageView cons;
    @FXML
    private AnchorPane apConsulter;
    @FXML
    private Button MesForm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consulterFormation(MouseEvent event) {
        loadPage("/view/ApprenantFormation.fxml");
    }

    @FXML
    private void mesFormations(MouseEvent event) {
        loadPage("/view/MesFormations.fxml");
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
