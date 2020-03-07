package org.openjfx.javaFX;

import javafx.scene.control.ChoiceBox;
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

    // âêîôûŵŷ
    public void addCharâ(ActionEvent actionEvent) {
        welsh.appendText("â");
    }
    public void addCharê(ActionEvent actionEvent) {
        welsh.appendText("ê");
    }
    public void addCharî(ActionEvent actionEvent) {
        welsh.appendText("î");
    }
    public void addCharô(ActionEvent actionEvent) {
        welsh.appendText("ô");
    }
    public void addCharû(ActionEvent actionEvent) {
        welsh.appendText("û");
    }
    public void addCharŵ(ActionEvent actionEvent) {
        welsh.appendText("ŵ");
    }
    public void addCharŷ(ActionEvent actionEvent) {
        welsh.appendText("ŷ");
    }
    // äëïöüẅÿ
    public void addCharä(ActionEvent actionEvent) {
        welsh.appendText("ä");
    }
    public void addCharë(ActionEvent actionEvent) {
        welsh.appendText("ë");
    }
    public void addCharï(ActionEvent actionEvent) {
        welsh.appendText("ï");
    }
    public void addCharö(ActionEvent actionEvent) {
        welsh.appendText("ö");
    }
    public void addCharü(ActionEvent actionEvent) {
        welsh.appendText("ü");
    }
    public void addCharẅ(ActionEvent actionEvent) {
        welsh.appendText("ẅ");
    }
    public void addCharÿ(ActionEvent actionEvent) {
        welsh.appendText("ÿ");
    }
    //    áéíóúẃý
    public void addChará(ActionEvent actionEvent) {
        welsh.appendText("á");
    }
    public void addCharé(ActionEvent actionEvent) {
        welsh.appendText("é");
    }
    public void addCharí(ActionEvent actionEvent) {
        welsh.appendText("í");
    }
    public void addCharó(ActionEvent actionEvent) {
        welsh.appendText("ó");
    }
    public void addCharú(ActionEvent actionEvent) {
        welsh.appendText("ú");
    }
    public void addCharẃ(ActionEvent actionEvent) {
        welsh.appendText("ẃ");
    }
    public void addCharý(ActionEvent actionEvent) {
        welsh.appendText("ý");
    }

    // àèìòùẁỳ
    public void addCharà(ActionEvent actionEvent) {
        welsh.appendText("à");
    }
    public void addCharè(ActionEvent actionEvent) {
        welsh.appendText("è");
    }
    public void addCharì(ActionEvent actionEvent) {
        welsh.appendText("ì");
    }
    public void addCharò(ActionEvent actionEvent) {
        welsh.appendText("ò");
    }
    public void addCharù(ActionEvent actionEvent) {
        welsh.appendText("ù");
    }
    public void addCharẁ(ActionEvent actionEvent) {
        welsh.appendText("ẁ");
    }
    public void addCharỳ(ActionEvent actionEvent) {
        welsh.appendText("ỳ");
    }
    public void setSecondScene(Scene scene) {
        secondScene = scene;
    }
}
