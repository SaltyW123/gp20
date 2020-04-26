/**
 * @(#) App.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.json.JsonProcessing;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * A class that launches the Welsh Vocabulary tutor Application.
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
 * @version 0.1 Initial development
 */
public class Application extends javafx.application.Application {
    private static Scene scene;

    private JsonProcessing jsonProcessing = new JsonProcessing();
    private Scanner scanner = new Scanner(System.in);

    public static LinkedList<DictionaryEntry> dictionary = new LinkedList<>();

    /**
     *
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        File jsonFileLocation = null;

        while(jsonFileLocation ==null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json Files", "*.json"));
            fileChooser.setTitle("Open Json File");
            jsonFileLocation = fileChooser.showOpenDialog(stage);
        }

        final File jsonFileFinalLocation = jsonFileLocation;
        dictionary = jsonProcessing.readInJson(jsonFileFinalLocation);
//        dictionary.add(new DictionaryEntry("abbey", "abaty", "nm", false));
//        dictionary.add(new DictionaryEntry("believe", "credu", "verb", true));
//        dictionary.add(new DictionaryEntry("concert", "cyngerdd", "nm", false));
//        dictionary.add(new DictionaryEntry("disease", "clefyd", "nm", true));
//        dictionary.add(new DictionaryEntry("extremely", "dros ben", "other", false));
//        dictionary.add(new DictionaryEntry("flu", "ffliw", "nm", false));
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
//        stage.setOnCloseRequest(e -> {
//            jsonProcessing.writeOutJson(jsonFileLocation, dictionary);
//            Platform.exit();
//            System.exit(0);
//        });
        stage.show();
    }

    /**
     *
     * @param fxml
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     *
     * @param fxml
     * @return
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}