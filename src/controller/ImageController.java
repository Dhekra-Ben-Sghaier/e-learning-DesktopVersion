/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */

package controller;

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

/**
 * FXML Controller class
 *
 * @author hp
 * 
 */

public class ImageController implements Initializable {
    private PreparedStatement retrieve,store;
private String loadst="select image from publicité where id =(?)";
   
    @FXML
    private ImageView imageview;
    @FXML
    private Button load;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        
            Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esprit","root","");
            
            retrieve=conn.prepareStatement(loadst);
  
                
                loadfile();
            

        
             
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }   
  
    public void loadfile() {
        try {
            retrieve.setInt(1, 86);
            ResultSet rs=retrieve.executeQuery();
        if(rs.first()){
            Blob blob=rs.getBlob("image");
            InputStream inputstream =blob.getBinaryStream();
             
            Image image=new Image(inputstream);
            System.out.println(image);
            imageview.setImage(image);        }
        } catch (SQLException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    }
    
}
