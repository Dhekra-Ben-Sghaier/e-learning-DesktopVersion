/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.ControleSaisie;
import dao.Operation;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;
import utils.ConnexionSingleton;
import utils.JavaMailUtil;

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
    @FXML
    private TextField txt_mdp;
    @FXML
    private CheckBox check_mdp;
    @FXML
    private Button btn_mdp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         btn_log.setOnAction(event -> {
            
         connecter(user.getText(),pwd.getText());
  
        });
             //aff mdp
       txt_mdp.setVisible(false);
       check_mdp.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_value, Boolean newValue) -> {
       if(check_mdp.isSelected()){
           txt_mdp.setText(pwd.getText());
           txt_mdp.setVisible(true);
           pwd.setVisible(false);
           return;
           
       }
      pwd.setText(txt_mdp.getText());
       pwd.setVisible(true);
       txt_mdp.setVisible(false);
       
       });
       //end aff mdp
       
       //mdp oublié
         btn_mdp.setOnAction(event -> {
               Operation op= new Operation();
               String o = op.recEmail(user.getText());
               int d= op.recId(user.getText());
               System.out.println(o+"  "+ d);
             try {
                 JavaMailUtil.sendMail(o,d);
             } catch (Exception ex) {
                 Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
             }
               System.out.println(o);
              try {
                  FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/codeMdp.fxml"));
        
            Parent parent = (Parent)loader.load();
              CodeMdpController cont = loader.<CodeMdpController>getController();
            cont.setEmail(o);
            cont.setCode(op.envoyerCode(d));
            cont.setId(d);
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Mot de passe oublié ?");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
      
        });
      //end
      
    }    
    private static Connection   connection;
    private static java.sql.PreparedStatement pst;
    public void connecter(String username ,String password){
        ConnexionSingleton cs=ConnexionSingleton.getInstance();
       connection= cs.getCnx();
       System.out.println(connection);
       Operation op=new Operation();
        int d= op.recId(user.getText());
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
            
               if(ControleSaisie.isNull(user.getText()) || ControleSaisie.isNull(pwd.getText()))
           {
             Alert alerts = new Alert(Alert.AlertType.WARNING);
        alerts.setTitle("Warning");
        alerts.setHeaderText(null);
        alerts.setContentText("Veuillez remplir les champs!");
        alerts.show();
           } 
           else {
            if((count==1) && username.equals("admin")){
                          
        
            Parent page1;
                try {
                    page1 = FXMLLoader.load(getClass().getResource("/view/interfaceAdmin.fxml"));
                     Parent parent;
                     
            Scene scene = new Scene(page1);
            Stage stage = (Stage) btn_log.getScene().getWindow();
          
            stage.setScene(scene);
            stage.setTitle("Admin");
            stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else  if(count==1){
                          
        
          
                 try {
                     

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/usersPanel.fxml"));
        
            Parent parent = (Parent)loader.load();
            
          UsersPanelController cont = loader.<UsersPanelController>getController();
      
            cont.loadheaduser("/view/usercompte.fxml",user.getText(),d);
            cont.loadmenu();
            
            
               
            Scene scene = new Scene(parent);
            Stage stage = (Stage) btn_log.getScene().getWindow();
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
                alert.setContentText("username or password is not correct");
                alert.show();
            }
               }  
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
    
}
