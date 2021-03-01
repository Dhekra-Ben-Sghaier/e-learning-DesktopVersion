/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField descField;
    @FXML
    private TextField prixField;
    @FXML
    private TextField diffField;
    @FXML
    private TextField certifField;
    @FXML
    private ImageView cons;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            Image consImg = new Image(new FileInputStream("src\\add.png"));
//            ImageView imgView = new ImageView(consImg);
//            imgView.setFitHeight(35);
//            imgView.setFitWidth(35);
//            cons.setImage(consImg);
//                    } catch (FileNotFoundException ex) {
//            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }    
    
}
