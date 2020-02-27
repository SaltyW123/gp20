package org.openjfx.javaFX;

import jsonStuff.WelshDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.javaFX.App;

public class RemoveController {

    @FXML private TextField welsh;
    @FXML private TextField english;
    private Scene firstScene;


    @FXML protected void removeButtonClick(ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your Welsh word: ").append(welsh.getText()).append("\n");
        sb.append("With English translation: ").append(english.getText()).append("\n");

        if (App.words.remove(new WelshDictionary(english.getText(), welsh.getText())))
            sb.append("Has been removed from the dictionary.");
        else
            sb.append("Has not been removed from the dictionary.");

        english.setText("");
        welsh.setText("");
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
        primaryStage.setScene(firstScene);
    }

    public void setFirstScene(Scene scene) {
        firstScene = scene;
    }

}
