/**
 * @(#) AddWordController.java 0,1 2020/04/30
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

package uk.ac.aber.cs221.group20.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;


/**
 * A class that handles the keyboard and mouse input and interaction for the 'Add Word Page' which is
 * defined by 'addword.fxml'
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakobik [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development.
 * @see DictionaryEntry
 * @see Application
 */
public class AddWordController extends SharedCodeController {

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //



   @FXML
   private TextField welsh;
   @FXML
   private TextField english;
   @FXML
   private ComboBox<String> wordType;

   @FXML
   private ComboBox<String> specialChar1;

   @FXML
   private ComboBox<String> specialChar2;

   @FXML
   private ComboBox<String> specialChar3;

   @FXML
   private ComboBox<String> specialChar4;


// //////// //
   // Methods. //
   // //////// //

   /**
    * Gets the value from the welsh text field
    *
    * @return welsh
    */
   public TextField getWelsh() {
      return welsh;
   }

   /**
    * Gets the value from the english text field
    *
    * @return english
    */
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

   /**
    * Method that runs when you click the add word button
    *
    * @param actionEvent action event for the button click
    * @see Application
    * @see DictionaryEntry
    */
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

      // test for one or more blank fields and if there is create the correct error dialogue box
      if (english.getText().isBlank() || welsh.getText().isBlank() || wordType.getValue().equals("Type")) {
         Alert error = new Alert(Alert.AlertType.ERROR);
         error.setTitle("Error");
         error.setHeaderText("Entry Not Saved");
         error.setContentText("One or more fields are blank");

         error.showAndWait();
      } else {
         for (DictionaryEntry entry : Application.dictionary) {

            //test if the entry exists in the dictionary and if it does create the correct error dialogue box
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

            //if everything is fine, save the entered values as a dictionary entry in the dictionary
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

            //Resets values to blank for next word to be entered
            english.clear();
            welsh.clear();
            wordType.setValue("Type");
            trueWordType = null;


         }
      }


   }



   /**
    * Method that adds ch to the welsh text field and runs when the user clicks the ch button on the add word screen
    *
    * @param actionEvent action event for the button click
    */

   // add character methods for characters ch, dd, ff, ng, ll, ph, rh, th
   public void addCharch(ActionEvent actionEvent) {
      welsh.appendText("ch");
   }

   /**
    * Method that adds dd to the welsh text field and runs when the user clicks the dd button on the add word screen *
    *
    * @param actionEvent action event for the button click
    */
   public void addChardd(ActionEvent actionEvent) {
      welsh.appendText("dd");
   }

   /**
    * Method that adds ff to the welsh text field and runs when the user clicks the ff button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharff(ActionEvent actionEvent) {
      welsh.appendText("ff");
   }

   /**
    * Method that adds ng to the welsh text field and runs when the user clicks the ng button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharng(ActionEvent actionEvent) {
      welsh.appendText("ng");
   }

   /**
    * Method that adds ll to the welsh text field and runs when the user clicks the ll button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharll(ActionEvent actionEvent) {
      welsh.appendText("ll");
   }

   /**
    * Method that adds ph to the welsh text field and runs when the user clicks the ph button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharph(ActionEvent actionEvent) {
      welsh.appendText("ph");
   }

   /**
    * Method that adds rh to the welsh text field and runs when the user clicks the rh button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharrh(ActionEvent actionEvent) {
      welsh.appendText("rh");
   }

   /**
    * Method that adds th to the welsh text field and runs when the user clicks the th button on the add word screen
    *
    * @param actionEvent action event for the button click
    */
   public void addCharth(ActionEvent actionEvent) {
      welsh.appendText("th");
   }

   public void specialChar1(ActionEvent actionEvent){
      welsh.appendText(specialChar1.getValue());
   }

   public void specialChar2(ActionEvent actionEvent) {
      welsh.appendText(specialChar2.getValue());
   }
   public void specialChar3(ActionEvent actionEvent) {
      welsh.appendText(specialChar3.getValue());
   }
   public void specialChar4(ActionEvent actionEvent) {
      welsh.appendText(specialChar4.getValue());
   }

}