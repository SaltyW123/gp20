package uk.ac.aber.cs22120.group20;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.security.AllPermission;


/**
 * Add Word Controller
 */

public class AddWordController {

    @FXML private TextField welsh;
    @FXML private TextField english;
    @FXML private ComboBox<String> wordType;

    public TextField getWelsh() {
        return welsh;
    }

    public TextField getEnglish() {
        return english;
    }

    @FXML
    private void initialize(){

        wordType.getItems().addAll("Masculine noun", "Feminine noun", "Verb", "Other");
        System.out.println("Test");

    }


    @FXML protected void addButtonClick (ActionEvent actionEvent){
        boolean entryFound = false;
        if (english.getText().equals("") || welsh.getText().equals("")|| wordType.getValue().equals("Type")){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText("Entry Not Saved");
            error.setContentText("One or more fields are blank");

            error.showAndWait();
        }

        else {
            for (DictionaryEntry entry : App.dictionary){
                entryFound = false;
                DictionaryEntry newEntry = new DictionaryEntry(english.getText(),welsh.getText(),wordType.getValue(),false);
                if(entry.equals(newEntry)){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Entry Not Saved");
                    alert.setContentText("This entry already exists");

                    alert.showAndWait();
                    entryFound = true;
                    break;
                }
                else{
                    continue;
                }
            }
            if(!entryFound){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Entry Saved");
                alert.setContentText("Entry Added");

                alert.showAndWait();
                DictionaryEntry dictionaryEntry = new DictionaryEntry(english.getText(), welsh.getText(), wordType.getValue(), false);
                App.dictionary.contains(dictionaryEntry);
                App.dictionary.add(dictionaryEntry);
                System.out.println(App.dictionary.toString());
            }
        }


    }

//    @Override
//    public boolean equals(Object obj) {
//        DictionaryEntry otherObject = (DictionaryEntry) obj;
//        return (this.getEnglish().equals(otherObject.getEnglish()) && this.getWelsh().equals(otherObject.getWelsh()));
//    }


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("Primary");
    }
// add character methods for characters ch, dd, ff, ng, ll, ph, rh, th
    public void addCharch(ActionEvent actionEvent) { welsh.appendText("ch"); }
    public void addChardd(ActionEvent actionEvent) { welsh.appendText("dd"); }
    public void addCharff(ActionEvent actionEvent) { welsh.appendText("ff"); }
    public void addCharng(ActionEvent actionEvent) { welsh.appendText("ng"); }
    public void addCharll(ActionEvent actionEvent) { welsh.appendText("ll"); }
    public void addCharph(ActionEvent actionEvent) { welsh.appendText("ph"); }
    public void addCharrh(ActionEvent actionEvent) { welsh.appendText("rh"); }
    public void addCharth(ActionEvent actionEvent) { welsh.appendText("th"); }

}
