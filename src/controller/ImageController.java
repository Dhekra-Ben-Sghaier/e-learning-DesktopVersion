/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.ConnexionSingleton;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class ImageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private PreparedStatement retrieve,store;
  
    private String loadst="select image from personnes where id_user =(?)";
    private String openst="UPDATE personnes SET image= ? WHERE id_user=?";
    @FXML
    private ImageView imageview;
    @FXML
    private Button load;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button open;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            retrieve=conn.prepareStatement(loadst);
            store=conn.prepareStatement(openst);
            load.setOnAction(event -> {
                
                loadfile();
            

        });
              open.setOnAction(event -> {
                
              openfile();
            

        });
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   
  
    public void loadfile() {
        try {
            retrieve.setInt(1, 32);
            ResultSet rs=retrieve.executeQuery();
        if(rs.first()){
            Blob blob=rs.getBlob("image");
             System.out.println("blob"+blob.toString());
            InputStream inputstream =blob.getBinaryStream();
             System.out.println("input="+inputstream.toString());
            Image image=new Image(inputstream);
            System.out.println(image);
            imageview.setImage(image);
//      blobcom.mysql.jdbc.Blob@2dfcce38
//input=java.io.ByteArrayInputStream@6e91c560
//javafx.scene.image.Image@6ae344d8
        }
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void openfile()  {
        FileChooser filechooser = new FileChooser();
        
     File file = filechooser.showOpenDialog(open.getScene().getWindow());
     
            
        try {
            FileInputStream inputstream=new FileInputStream(file);
        store.setBinaryStream(1, inputstream);
        store.setInt(2, 31);
        store.execute(); 
        Image image=new Image(inputstream);
            System.out.println("image open="+image);
            imageview.setImage(image);
        
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
}
