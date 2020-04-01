package org.openjfx.javaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jsonStuff.JsonProcessing;
import jsonStuff.WelshDictionary;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {

    public static LinkedList<WelshDictionary> words = new LinkedList<>();
    private static Scene scene;
    private JsonProcessing jsonProcessing = new JsonProcessing();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("add.fxml"));
        Parent firstPane = firstPaneLoader.load();
        Scene firstScene = new Scene(firstPane, 1000, 750);

        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("remove.fxml"));
        Parent secondPane = secondPageLoader.load();
        Scene secondScene = new Scene(secondPane, 1000, 750);



        AddController firstPaneController = firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);

        RemoveController secondPaneController = secondPageLoader.getController();
        secondPaneController.setFirstScene(firstScene);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(firstScene);
        primaryStage.show();

        File jsonFileLocation = null;

        while(jsonFileLocation ==null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json Files", "*.json"));
            fileChooser.setTitle("Open Json File");
            jsonFileLocation = fileChooser.showOpenDialog(primaryStage);
        }

        final File jsonFileFinalLocation = jsonFileLocation;

        words = jsonProcessing.readInJson(jsonFileFinalLocation);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                jsonProcessing.writeOutJson(jsonFileFinalLocation,words);
                Platform.exit();
                System.exit(0);
            }
        });
    }

}