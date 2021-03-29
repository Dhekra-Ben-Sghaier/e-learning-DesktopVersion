///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package controller;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.animation.TranslateTransition;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.util.Duration;
//import static javax.swing.Spring.width;
//
///**
// * FXML Controller class
// *
// * @author hp
// */
//public class AnimationController implements Initializable {
//
//    private ImageView exit;
//    @FXML
//    private Label num;
//    @FXML
//    private AnchorPane pane2;
//    @FXML
//    private AnchorPane pane3;
//    @FXML
//    private Button back;
//    @FXML
//    private Button next;
//    @FXML
//    private ImageView close;
//    @FXML
//    private AnchorPane pane1;
//public void translateAnimation (double duration, Node node,   double width){
//TranslateTransition translateTransition= new TranslateTransition(Duration.seconds(duration), node);
//translateTransition.setByX(width);
//translateTransition.play();
//}
//    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        close.setOnMouseClicked(event -> { System.exit(0);
//        });
//     translateAnimation(0.5 ,pane2, 829);
//     translateAnimation(0.5, pane3, 829);
//
//    
//
//       }
//int show = 0;
//void next(ActionEvent event) {
//if(show==0) { 
//    translateAnimation(0.5, pane2, -829);
//    show++;
//    num.setText("2/3");} 
//else if (show==1)
//{
//    translateAnimation(0.5, pane3, -829);
//    show++;
//    num.setText("3/3");
//}
//    }
//void back (ActionEvent event) {
//if(show==1)
//{translateAnimation(0.8, pane2, 829);
//show --;
//num.setText("1/3");
//} 
//else if (show==2) {
//    translateAnimation(0.5,pane3, 829);
//    show--;
//    num.setText("2/3");
//}
//}
//}    

