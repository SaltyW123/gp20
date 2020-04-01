package org.openjfx.javaFX;

import jsonStuff.WelshDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {

    @FXML private TextField welsh;
    @FXML private TextField english;
    @FXML private TextField wordType;
    private Scene secondScene;


    @FXML protected void addButtonClick(ActionEvent actionEvent) {
        App.words.add(new WelshDictionary(english.getText(),welsh.getText(),wordType.getText()));
        StringBuilder sb = new StringBuilder();
        sb.append("Your Welsh word: ").append(welsh.getText()).append("\n");
        sb.append("With English translation: ").append(english.getText()).append("\n");
        sb.append("Has been added to the dictionary.");

        english.setText("");
        welsh.setText("");
        wordType.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Entry added");
        alert.setContentText(sb.toString());

        alert.showAndWait();

    }

    public void switchScene(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Scene switched");

        alert.showAndWait();

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
    }

    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }
}
