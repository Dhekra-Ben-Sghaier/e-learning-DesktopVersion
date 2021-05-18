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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    @FXML
    private Label errorId;
    @FXML
    private Label errorPrice;

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
           
           
            fdao.insert(f);
           
            } catch (Exception e) {
                if("".equals(idField.getText())){
                    idField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(titleField.getText())){
                titleField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(descField.getText())){
                descField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(prixField.getText())){
                prixField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(diffField.getText())){
                diffField.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
                if("".equals(cours.getText())){
                cours.setStyle("-fx-border-width:0 0 2 0;-fx-border-color: red");
                }
               
                if(! "".equals(errorId.getText())){
           
            idField.setText("");
   
           }
           else if(!"".equals(errorPrice.getText())) {
              prixField.setText("");
           }
           else {
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Verifier les champs!");
            alert.show();
           }
               
        }
         
           


           
           
       
    }

    @FXML
    private void ajoutPdf(ActionEvent event) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("PDF (*.pdf)", "pdf"));
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
            FileOutputStream out = new FileOutputStream("C:\\Users\\benha\\Desktop\\PidevWebFinale\\PidevWeb\\public\\uploads\\"+nomImg);
          
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
            image.setText(nomImg);
//            Image image1 = new Image(selectedFile.toURI().toString());"C:\\\\Users\\\\Asus\\\\Desktop\\\\P\\\\webPidevv\\\\PidevWeb\\\\public\\\\uploads\\\\"+
           
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

    @FXML
    private void verifId(MouseEvent event) {
         if (!idField.getText().matches("^[0-9]*$") ) {
                    System.out.println("IDDDD: "+ idField.getText());
                    errorId.setText("L'id doit etre un entier!");
                   
                }
         else {
             errorId.setText("");
         }
    }

    @FXML
    private void verifPrice(MouseEvent event) {
        if (!prixField.getText().matches("^([0-9]+([.][0-9]*)?|[.][0-9]+)*$") ) {
                   System.out.println("IDDDD: "+ prixField.getText());
                    errorPrice.setText("vous devez saisir un prix correcte!");
                   
                }
         else {
             errorPrice.setText("");
         }
    }

 
   

   
}
