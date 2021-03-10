/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppDao;
import entity.Apprenant;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import utils.ConnexionSingleton;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class LoginController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private PasswordField pwd;
    @FXML
    private Button btn_log;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btn_log.setOnAction(event -> {
            
         connecter(user.getText(),pwd.getText());
  
        });
    }    
    private static Connection   connection;
    private static java.sql.PreparedStatement pst;
    public void connecter(String username ,String password){
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
       connection= cs.getCnx();
       System.out.println(connection);
            String req="select * from personnes where nomUtilisateur=?";
             System.out.println(req);
        try {
            
            pst=connection.prepareStatement(req);
            pst.setString(1, username);
            ResultSet rs=pst.executeQuery();
            int count=0;
            while(rs.next()){
                if(BCrypt.checkpw(password, rs.getString("password"))){
                    count=1;
                }
                
            }
            if(count==1){
                          
        
            Parent page1;
                try {
                    page1 = FXMLLoader.load(getClass().getResource("/view/interfaceAdmin.fxml"));
                     Parent parent;
                     
            Scene scene = new Scene(page1);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else
            {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("username and password is not correct");
                alert.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    
}
