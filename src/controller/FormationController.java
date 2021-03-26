/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import service.FormationDao;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormationController implements Initializable {

    Stage stage;
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
    private Button btnAjout;
    @FXML
    private Button btnCours;
    private ListView listC;
    @FXML
    private TextField cours;
    @FXML
    private Button btnImgCours;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajouterFormation(ActionEvent event) {
        
        btnAjout.setOnAction((ActionEvent event1) -> {
            try {
            File pdfFile = new File(cours.getText());
            FileInputStream fis = new FileInputStream(pdfFile);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] pd = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(pd)) != -1) {
                           bos.write(pd);
                    }
            byte[] bytes = bos.toByteArray();

            Formation f = new Formation(Integer.parseInt(idField.getText()), titleField.getText(), descField.getText(), Float.parseFloat(prixField.getText()), diffField.getText(), cours.getText(), image.getText());
            FormationDao fdao = FormationDao.getInstance();
            fdao.insert(f);
            
            } catch (Exception e) {
        }
          
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Formation insérée avec succés!");
            alert.show();
            titleField.setText("");
            descField.setText("");
            idField.setText("");
            prixField.setText("");
            diffField.setText("");
            
            TrayNotification tray =new TrayNotification();
            tray.setTitle("Succès");
            tray.setMessage("Formation ajoutée avec succé !");
            tray.setAnimationType(AnimationType.POPUP);
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.showAndWait();
            
        });
    }

    @FXML
    private void ajoutPdf(ActionEvent event) {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File selectedFile = fc.getSelectedFile();
        String fileName = selectedFile.getAbsolutePath().replace("\\", "/");
        if (selectedFile != null){
            cours.setText(fileName);
        } else {
            System.out.println("file not valid");
        }
        
        
    }

    @FXML
    private void ajoutImage(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        String imgName = selectedFile.getAbsolutePath().replace("\\", "\\\\");
        if (selectedFile != null) {
            image.setText(imgName);
//            Image image1 = new Image(selectedFile.toURI().toString());
            
        }
        else {
            System.out.println("file not valid");
        }
    }

    @FXML
    private void cancelAjout(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

  
    

    
}
