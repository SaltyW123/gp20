import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{

    public static void main(String[] args) {


        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane mainPane = FXMLLoader.load(Main.class.getResource("MatchTheMeaning.fxml"));
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
     }
}
