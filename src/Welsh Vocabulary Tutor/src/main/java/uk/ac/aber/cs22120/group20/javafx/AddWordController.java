package uk.ac.aber.cs22120.group20.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;


/**
 * Add Word Controller
 */

public class AddWordController extends SharedCodeController {

   @FXML
   private TextField welsh;
   @FXML
   private TextField english;
   @FXML
   private ComboBox<String> wordType;

   public TextField getWelsh() {
      return welsh;
   }

   public TextField getEnglish() {
      return english;
   }

   @FXML
   private void initialize() {
      setup();
      currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/add-50.png"));
      currentPageText.setText("Add");

      addDefinitionIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/add-50.png"));
      addDefinitionText.setFill(Color.BLACK);

      wordType.getItems().addAll("Masculine noun", "Feminine noun", "Verb", "Other");
      wordType.setValue("Type");

   }


   @FXML
   protected void addButtonClick(ActionEvent actionEvent) {
      DictionaryEntry.wordTypeEnum trueWordType;
      if (wordType.getValue() == "Masculine noun") {
         trueWordType = DictionaryEntry.wordTypeEnum.nm;
      } else if (wordType.getValue() == "Feminine noun") {
         trueWordType = DictionaryEntry.wordTypeEnum.nf;
      } else if (wordType.getValue() == "Verb") {
         trueWordType = DictionaryEntry.wordTypeEnum.verb;
      } else {
         trueWordType = DictionaryEntry.wordTypeEnum.other;
      }
      boolean entryFound = false;
      // one or more blank fields
      if (english.getText() == null || welsh.getText() == null || wordType.getValue().equals("Type")) {
         Alert error = new Alert(Alert.AlertType.ERROR);
         error.setTitle("Error");
         error.setHeaderText("Entry Not Saved");
         error.setContentText("One or more fields are blank");

         error.showAndWait();
      } else {
         for (DictionaryEntry entry : Application.dictionary) {
            entryFound = false;
            DictionaryEntry newEntry = new DictionaryEntry(english.getText(), welsh.getText(), trueWordType);
            if (entry.equals(newEntry)) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error");
               alert.setHeaderText("Entry Not Saved");
               alert.setContentText("This entry already exists");

               alert.showAndWait();
               entryFound = true;
               break;
            } else {
               continue;
            }
         }
         if (!entryFound) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Entry Saved");
            alert.setContentText("Entry Added - English: " + english.getText() + " Welsh: " + welsh.getText() + " Type: " + wordType.getValue());

            alert.showAndWait();


            DictionaryEntry dictionaryEntry = new DictionaryEntry(english.getText(), welsh.getText(), trueWordType);
            dictionaryEntry.setPracticeWord(true);
            Application.dictionary.contains(dictionaryEntry);
            Application.dictionary.add(dictionaryEntry);
            Application.practiceList.add(dictionaryEntry);

//              output of what was saved for testing
//                System.out.print(english.getText());
//                System.out.print(welsh.getText());
//                System.out.println(wordType.getValue());

//              Resets values to blank for next word to be entered
            english.clear();
            welsh.clear();
            wordType.setValue("Type");
            trueWordType = null;


         }
      }


   }

//    @Override
//    public boolean equals(Object obj) {
//        DictionaryEntry otherObject = (DictionaryEntry) obj;
//        return (this.getEnglish().equals(otherObject.getEnglish()) && this.getWelsh().equals(otherObject.getWelsh()));
//    }


   // add character methods for characters ch, dd, ff, ng, ll, ph, rh, th
   public void addCharch(ActionEvent actionEvent) {
      welsh.appendText("ch");
   }

   public void addChardd(ActionEvent actionEvent) {
      welsh.appendText("dd");
   }

   public void addCharff(ActionEvent actionEvent) {
      welsh.appendText("ff");
   }

   public void addCharng(ActionEvent actionEvent) {
      welsh.appendText("ng");
   }

   public void addCharll(ActionEvent actionEvent) {
      welsh.appendText("ll");
   }

   public void addCharph(ActionEvent actionEvent) {
      welsh.appendText("ph");
   }

   public void addCharrh(ActionEvent actionEvent) {
      welsh.appendText("rh");
   }

   public void addCharth(ActionEvent actionEvent) {
      welsh.appendText("th");
   }

}
