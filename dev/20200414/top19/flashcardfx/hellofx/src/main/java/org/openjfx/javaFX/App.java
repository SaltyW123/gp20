package org.openjfx.javaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jsonStuff.JsonProcessing;
import jsonStuff.WelshDictionary;

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
        System.out.println("Where is the Json file?");
        String jsonFileLocation = scanner.next();
        words = jsonProcessing.readInJson(jsonFileLocation);

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setOnCloseRequest(e -> {
            jsonProcessing.writeOutJson(jsonFileLocation, words);
            Platform.exit();
            System.exit(0);
        });

        primaryStage.show();
    }

}