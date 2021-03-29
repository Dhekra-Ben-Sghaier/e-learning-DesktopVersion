import constants.AdminEmailPassword;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password_field;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void boutton_Login(ActionEvent event) {
        String email_Login= email.getText();
        String password_Login= password.getText();
        if(email_Login.trim().equalsIgnoreCase(AdminEmailPassword.email) 
                && password_Login.trim().equalsIgnoreCase(AdminEmailPassword.password)){
            try{
                Parent root= FXMLLoader.load(getClass().getResource("view/QuizHomeScreen.fxml"));
                Stage stage = (Stage) password_field.getScene().getWindow();
                Scene scene = new Scene(root); 
                stage.setScene(scene);
                //stage.setMaximized(true);
               } catch(Exception e){
                   e.printStackTrace();
                   System.exit(0);
               }
            System.out.println("Admin login success");          
        } else {
            System.out.println("Admin login failed");
        }
        
        System.out.println(email_Login + "--->" + password_Login+ "--->");
        System.out.println("LoginController.login()");
    }
    
}
