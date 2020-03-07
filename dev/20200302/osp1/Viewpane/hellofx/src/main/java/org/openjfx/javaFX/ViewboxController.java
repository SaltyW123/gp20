package org.openjfx.javaFX;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import jsonStuff.WelshDictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.javaFX.App;

public class ViewboxController {

    public ListView<WelshDictionary> EnglishlistView;
    @FXML private TextField welsh;
    @FXML private TextField english;
    private Scene firstScene;
    public static final ObservableList<WelshDictionary> names = FXCollections.observableArrayList();
    public static final ObservableList<WelshDictionary> data = FXCollections.observableArrayList();


    public void initialize(){


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

    public void loadList(ActionEvent actionEvent) {
        EnglishlistView.setOrientation(Orientation.VERTICAL);

        EnglishlistView.setCellFactory(param -> new ListCell<WelshDictionary>() {
            @Override
            protected void updateItem(WelshDictionary item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getEnglish() == null||item.getWelsh() == null || item.getWordType() ==null) {
                    setText(null);
                } else {
                    setText(item.getEnglish() + "           " + item.getWelsh());
                }
            }
        });


        data.addAll(App.words);

        EnglishlistView.setItems(data);

    }
}
