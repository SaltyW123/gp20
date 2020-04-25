import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.LinkedList;


public class Main extends Application{

    public static LinkedList<DictionaryEntry> dictionary = new LinkedList();

    public static void main(String[] args) {
        dictionary.add(new DictionaryEntry("abbey", "abaty", "nm"));
        dictionary.add(new DictionaryEntry("believe", "credu", "verb"));
        dictionary.add(new DictionaryEntry("concert", "cyngerdd", "nm"));
        dictionary.add(new DictionaryEntry("disease", "clefyd", "nm"));
        dictionary.add(new DictionaryEntry("extremely", "dros ben", "other"));
        dictionary.add(new DictionaryEntry("flu", "ffliw", "nm"));
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane mainPane = FXMLLoader.load(Main.class.getResource("MatchTheMeaning.fxml"));
        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
     }
}
