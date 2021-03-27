/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Formation;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import service.FormationDao;

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
    String nomImg ;
    int b;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void ajouterFormation(ActionEvent event) {
        
       
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
            fdao.verif(Integer.parseInt(idField.getText()));
                System.out.println("herrre"+fdao.verif(Integer.parseInt(idField.getText())));
            fdao.insert(f);
            
            } catch (Exception e) {
                
        }
          
            
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information Dialog");
//            alert.setHeaderText(null);
//            alert.setContentText("Formation insérée avec succés!");
//            alert.show();
//            titleField.setText("");
//            descField.setText("");
//            idField.setText("");
//            prixField.setText("");
//            diffField.setText("");
//            
//            TrayNotification tray =new TrayNotification();
//            tray.setTitle("Succès");
//            tray.setMessage("Formation ajoutée avec succé !");
//            tray.setAnimationType(AnimationType.POPUP);
//            tray.setNotificationType(NotificationType.INFORMATION);
//          
//            tray.showAndWait();
            
            
       
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

    void putImgServer(String path, String nomImg){
        try {
            FileInputStream in = new FileInputStream(path);
            FileOutputStream out = new FileOutputStream("C:\\xampp\\htdocs\\img\\"+nomImg);
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bou = new BufferedOutputStream(out);
            
            while(b != -1){
                try {
                    b=bin.read();
                    bou.write(b);
                    
                } catch (IOException ex) {
                    Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
                
            }
            try {
                    bin.close();
                    bou.close();
                } catch (IOException ex) {
                    Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void ajoutImage(ActionEvent event) {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File selectedFile = fileChooser.getSelectedFile();
        String imgName = selectedFile.getAbsolutePath().replace("\\", "\\\\");
        String nomImg = selectedFile.getName();
        putImgServer(imgName,nomImg);
        if (selectedFile != null) {
            image.setText("C:\\\\xampp\\\\htdocs\\\\img\\\\"+nomImg);
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
