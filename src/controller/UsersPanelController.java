/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import service.AppDao;
import entity.Apprenant;
import entity.Personne;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author benha
 */
public class UsersPanelController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private Label br;
    @FXML
    private Button btn_acc;
    @FXML
    private AnchorPane contenu;
    private Button btn_auth;
    @FXML
    private Button btn_cat;
    @FXML
    private Button btn_os;
    @FXML
    private Button btn_rec;
    @FXML
    private Button btn_pub;
    @FXML
    private Button btn_ct;
    @FXML
    private Button btn_conn;
    @FXML
    private Button btn_insc;
    @FXML
    private Button btn_cert;
    @FXML
    private Label roleLab;
    @FXML
    private Label IdUser;
    private int id;
  
    
    double x,y=0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                  btn_rec.setVisible(false);
          btn_cert.setVisible(false);
        btn_conn.setOnAction(event -> {
              Parent pagelog;
              try {
                pagelog = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
                Scene scene = new Scene(pagelog);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                 stage.setTitle("Login");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
      
        });
      
    }    
    private void goToHome(MouseEvent event) {
        bp.setCenter(contenu);
    }

    @FXML
    private void inscrire(MouseEvent event) {
        loadPage("/view/inscription.fxml");
    }
    private void  loadPage(String page){
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        bp.setCenter(root);
         }
        bp.setCenter(root);
            
        }
    public void  loadheaduser(String page,String nom ,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             UsercompteController cont = loader.<UsercompteController>getController();
             cont.setUser(nom);
             cont.setId(n);
             cont.loadfile();
//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setTop(parent);
            
        }
    public void  loadPageUser(String page ,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             ListerFormationsApprenantController cont = loader.<ListerFormationsApprenantController>getController();
          
             cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }
    public void  loadTable(){
        Parent parent = null;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TableForm.fxml"));
            parent = (Parent)loader.load();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
            
        }

    
    
    public void  loadPageUsr(String page){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             ListerFormationsController cont = loader.<ListerFormationsController>getController();
          
//             cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }
      public void  loadhead(String page ){
        Parent root = null;
   
        try {
             
            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setTop(root);
            
        }
      public void loadmenu (){
          btn_rec.setVisible(true);
          btn_cert.setVisible(true);
      }
      public void  loadcenter(String page ,Personne p,int n){
        Parent root = null;
        
        try {
             FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
          root = (Parent)loader.load();
             ProfilUserController cont = loader.<ProfilUserController>getController();
             cont.setPersonne(p);
             cont.setId(n);
           
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
            
        }
 
           public void  loadPageCertif(String page ,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             AjouterQuizController cont = loader.<AjouterQuizController>getController();
          
             cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }  
         public void  loadPageCertifapp(String page ,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             MainScreenController cont = loader.<MainScreenController>getController();
            System.out.println("idd="+n);
             cont.setId(n);
             cont.ajouterQuizListScreen();

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }  
     public void setRole(String roleUser){
        
       roleLab.setText(roleUser);
       System.out.println(roleLab);
        
    }
         public void setId(int a){
        this.id= a;
      IdUser.setText(a+"");
      
        
    }
    public void  loadPageRec(String page ,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
             ReclamationController cont = loader.<ReclamationController>getController();
          
           cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }
     public void  loadPageHome(String page,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
           HomeController cont = loader.<HomeController>getController();
          
           cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }
       public void  loadPageHomeSoc(String page,int n){
        Parent parent = null;
   
        try {
              FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
              
            parent = (Parent)loader.load();
            
            HomeSocController cont = loader.<  HomeSocController>getController();
          
           cont.setId(n);

//            root = FXMLLoader.load(getClass().getResource(page));
        } catch (IOException ex) {
            Logger.getLogger(UsersPanelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(parent);
    }
         public void  loadPagePub(String page){
        Parent parent = null;
     
     Stage stage=new Stage();
       try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
//             parent = (Parent)loader.load();            
//            
//            
//            Scene scene = new Scene(parent);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
                Stage newWindow = new Stage();
 Parent root = FXMLLoader.load(getClass().getResource(page)); 
  stage.initStyle(StageStyle.UNDECORATED);

  root.setOnMousePressed(event -> {
  x = event.getSceneX();
  y = event.getSceneY();
  });
  root.setOnMouseDragged(event -> {
    stage.setX(event.getScreenX() - x);
    stage.setY(event.getScreenY() - y);
    
    
});
    stage.setScene(new Scene(root, 580 , 400));
    stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ConsulterPubController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @FXML
    private void affform(ActionEvent event) {
        System.out.println("rolelab="+roleLab.getText());
        loadPagePub("/view/image.fxml");
        if("apprenant".equals(roleLab.getText())){
            
             loadPageUser("/view/ListerFormationApprenant.fxml",Integer.parseInt(IdUser.getText()));
        }
        else if("formateur".equals(roleLab.getText())){
                // loadPageUsr("/view/ListerFormations.fxml");
                 loadTable();
        
        } 
          
    }

    @FXML
    private void affcertif(ActionEvent event) {
        if("formateur".equals(roleLab.getText())){
            
             loadPageCertif("/view/AjouterQuiz.fxml",Integer.parseInt(IdUser.getText()));
        }else if("apprenant".equals(roleLab.getText())){
              loadPageCertifapp("/view/MainScreen.fxml",Integer.parseInt(IdUser.getText()));
        
        }
    }

    @FXML
    private void affRec(ActionEvent event) {
        if("apprenant".equals(roleLab.getText())){
            
             loadPageRec("/view/reclamation.fxml",Integer.parseInt(IdUser.getText()));
        }
        
        
    }

    @FXML
    private void affOff(ActionEvent event) {

            
        if("societe".equals(roleLab.getText())){
            
             loadPageHomeSoc("/view/homeSoc.fxml",Integer.parseInt(IdUser.getText()));
        }else {
              loadPageHome("/view/Home.fxml",Integer.parseInt(IdUser.getText()));
        
        }
    }

    @FXML
    private void affpub(ActionEvent event) {
        loadPage("/view/AjoutPub.fxml");
    }

    @FXML
    private void affaccueil(ActionEvent event) {
         loadPageUsr("/view/ListerFormations.fxml");
    }

}
