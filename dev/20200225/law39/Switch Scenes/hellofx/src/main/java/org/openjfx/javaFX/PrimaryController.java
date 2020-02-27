package org.openjfx.javaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import jsonStuff.WelshDictionary;

public class PrimaryController {

    @FXML
    private TextField welsh;
    @FXML
    private TextField english;
    @FXML
    private TextField wordType;


    @FXML
    protected void addButtonClick(ActionEvent actionEvent) {
        App.words.add(new WelshDictionary(english.getText(), welsh.getText(), wordType.getText()));
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
}
