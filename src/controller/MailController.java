/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.URL;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import service.Mail;  

/**
 * FXML Controller class
 *
 * @author asus
 */
public class MailController implements Initializable {

    @FXML
    private TextField emailToField;
    @FXML
    private TextField emailFromField;
    @FXML
    private TextField emailPasswordField;
    @FXML
    private TextField emailSubjectField;
    @FXML
    private TextField emailMessageField;
    @FXML
    private Button send;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         send.setOnAction(event -> {
            
            Mail.sendEmail(emailToField.getText(),emailFromField.getText(),emailPasswordField.getText(),emailSubjectField.getText(),emailMessageField.getText());
            
        });
    }    
    
  

   

               

   
}