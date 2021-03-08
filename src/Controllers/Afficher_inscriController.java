/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Tarek.Loussaief
 */
public class Afficher_inscriController implements Initializable {

    @FXML
    private TableColumn<?, ?> id_inscri;
    @FXML
    private TableColumn<?, ?> nom_utilisateur;
    @FXML
    private TableColumn<?, ?> nom_certificat;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> domaine;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
