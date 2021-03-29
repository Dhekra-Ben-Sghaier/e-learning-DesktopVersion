package PidevPubStat.test;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class PidevPubStat  extends Application {
    double x , y =0;
private Parent parentPage;
    @Override
    public void start(Stage stage) throws Exception {
   parentPage = FXMLLoader.load(getClass().getResource("/view/AjoutPub.fxml"));

        Scene scene = new Scene(parentPage);
        stage.setScene(scene);
        stage.show();
     Stage newWindow = new Stage();
// Parent root = FXMLLoader.load(getClass().getResource("/view/animation.fxml")); 
//  stage.initStyle(StageStyle.UNDECORATED);
//  root.setOnMousePressed(event -> {
//  x = event.getSceneX();
//  y = event.getSceneY();
//  });
//  root.setOnMouseDragged(event -> {
//    stage.setX(event.getScreenX() - x);
//    stage.setY(event.getScreenY() - y);
//    
//    
//});
//    stage.setScene(new Scene(root, 400 , 600));
//    stage.show();
//    }
//    public static void main(String[] args){
//        launch(args);
//    }
//    
    
}
}
