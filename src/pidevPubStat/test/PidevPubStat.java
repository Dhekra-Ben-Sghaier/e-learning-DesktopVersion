package PidevPubStat.test;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PidevPubStat  extends Application {
 private Parent parentPage;
    @Override
    public void start(Stage stage) throws Exception {
    parentPage = FXMLLoader.load(getClass().getResource("/view/image.fxml"));

        Scene scene = new Scene(parentPage);
        stage.setScene(scene);
        stage.show();
        Stage newWindow = new Stage();
    }
    
}
