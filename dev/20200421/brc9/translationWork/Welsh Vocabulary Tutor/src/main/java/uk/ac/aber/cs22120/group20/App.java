package uk.ac.aber.cs22120.group20;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Launch class of the Welsh Vocabulary tutor Application
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 *
 * @version 0.1
 */
public class App extends Application {
    private static Scene scene;



    public static LinkedList<DictionaryEntry> dictionary = new LinkedList<>();



    @Override
    public void start(Stage stage) throws IOException {
        dictionary.add(new DictionaryEntry("abbey", "abaty", "nm", false));
        dictionary.add(new DictionaryEntry("believe", "credu", "verb", true));
        dictionary.add(new DictionaryEntry("concert", "cyngerdd", "nm", false));
        dictionary.add(new DictionaryEntry("disease", "clefyd", "nm", true));
        dictionary.add(new DictionaryEntry("extremely", "dros ben", "other", false));
        scene = new Scene(loadFXML("translationTest"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch();



    }



}