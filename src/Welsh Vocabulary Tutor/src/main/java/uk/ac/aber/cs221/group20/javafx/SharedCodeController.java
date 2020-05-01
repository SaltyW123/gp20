/**
 * @(#) FlashcardController.java 0,1 2020/05/07
 *
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
/**
 * Abstract class that contains all the shared FXML elements between the
 * different controller classes including the sliding menu and the test score counter, to reduce code
 * duplication. This will be extended by all the controller classes.
 *
 * @author Tom Perry [top19]
 * @version 0.2 Documentation.
 * @see Application
 * @see DictionaryEntry
 * @see ScreenSwitch
 * @see AssessmentGenerator
 */
abstract public class SharedCodeController {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   // Static variable that tracks whether the words are currently sorted by english or welsh.
   static boolean isSortedByEnglish = true;
   // Static variable that tracks the current size of the menu's sideBar to keep its size consistent when switching scenes.
   static int sideBarWidth = 50;

   // /////////////////// //
   // Instance Variables. //
   // /////////////////// //

   @FXML
   Rectangle sideBar;

   @FXML
   Text dictionaryText;
   @FXML
   Text practiceListTest;
   @FXML
   Text flashcardsText;
   @FXML
   Text studyText;
   @FXML
   Text addDefinitionText;
   @FXML
   Text currentPageText;

   @FXML
   ImageView expandMenuIcon;
   @FXML
   ImageView dictionaryIcon;
   @FXML
   ImageView practiceListIcon;
   @FXML
   ImageView flashcardIcon;
   @FXML
   ImageView studyIcon;
   @FXML
   ImageView addDefinitionIcon;
   @FXML
   ImageView currentPageIcon;

   // //////// //
   // Methods. //
   // //////// //

   /***
    * Method that sets up the program's menu in each of the controllers, intialising the icons and text.
    */
   public void setup() {
      // Call method to setup the icons and set the menus side bars width to the current value of 'sideBar'.
      initializeIcons();
      sideBar.setWidth(sideBarWidth);

      // If the menus width isnt the default value, the menu is determined to be expanded and the text is initialised.
      if (sideBarWidth != 50)
         initializeMenuText();
   }

   /**
    * Method that sets up all of the menus icons by setting them to the images stored within the resources file.
    */
   private void initializeIcons() {
      expandMenuIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/menu-50.png"));
      dictionaryIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/read-50.png"));
      practiceListIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/rating-50.png"));
      flashcardIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/flashcard-50.png"));
      studyIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
      addDefinitionIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/add-50.png"));
   }

   /**
    * Method that sets up all of the menus text by setting them to their desired text when the menu is expanded.
    */
   private void initializeMenuText() {
      dictionaryText.setText("Dictionary");
      practiceListTest.setText("Practice List");
      flashcardsText.setText("Flashcards");
      studyText.setText("Study");
      addDefinitionText.setText("Add");
   }

   /**
    * Method that disables the menus text when the menu is collapsed by setting their text to nothing.
    */
   private void disableMenuText() {
      dictionaryText.setText("");
      practiceListTest.setText("");
      flashcardsText.setText("");
      studyText.setText("");
      addDefinitionText.setText("");
   }

   /**
    * Event that collapses or expands the menu whenever the 'expandMenuIcon' is clicked by the user. The method determines the menus current state by looking at the value of
    * 'sideBarWidth' and uses to decide whether the menu needs to expand to 230 and initialise the menu text or collapse to 50, disabling menu text.
    */
   @FXML
   private void expandMenuClick() {
      // If sideBar is currently collapsed, expand it and display menu text.
      if(sideBar.getWidth() == 50) {
         sideBar.setWidth(sideBarWidth = 230);
         // Display menu
         initializeMenuText();
      } else {
         // Else collapse the menu and disable its text.
         sideBar.setWidth(sideBarWidth = 50);
         disableMenuText();
      }
   }

   /**
    * Event to switch scenes to 'dictionary.fxml' when the menu's 'dictionaryIcon' icon is clicked.
    *
    * @see ScreenSwitch
    */
   @FXML
   private void dictionaryIconClick() {
      // Use 'ScreenSwitch' to switch to the 'dictionaryScene'.
      ScreenSwitch.swap(ScreenSwitch.SceneType.dictionaryScene);
   }

   /**
    * Event to switch scenes to 'practicelist.fxml' when the menu's 'practiceListIcon' icon is clicked.
    *
    * @see ScreenSwitch
    */
   @FXML
   private void practiceListIconClick() {
      // Use 'ScreenSwitch' to switch to the 'practiceListScene'.
      ScreenSwitch.swap(ScreenSwitch.SceneType.practiceListScene);
   }

   /**
    * Event to switch scenes to 'flashcard.fxml' when the menu's 'practiceListIcon' icon is clicked. This method checks to see if practiceList is empty before switching in order
    * to avoid NullPointerException's in the flashcard scene.
    *
    * @see ScreenSwitch
    * @see Application
    * @see DictionaryEntry
    * @see NullPointerException
    */
   @FXML
   private void flashcardIconClick() {
      // Check to see if there are any practice words before switching scene, throwing an alert notifying them that they can't switch scenes.
      if(Application.practiceList.size() == 0) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Unable to use Flashcard");
         alert.setContentText("The practice list is currently empty, please add some practice words to use the Flashcard feature.");
         alert.showAndWait();
      } else{
         // Switch to flashcard scene if the program has practice words.
         ScreenSwitch.swap(ScreenSwitch.SceneType.flashcardScene);
      }
   }

   /**
    * Event to generate an assessment using AssessmentGenerator when the menu's 'studyIcon' icon is clicked.
    *
    * @see AssessmentGenerator
    * @see Application
    * @see DictionaryEntry
    */
   @FXML
   private void studyIconClick() {
      // Generate a new assessment using the programs practice list.
      AssessmentGenerator.generateAssessment(Application.practiceList);
   }

   /**
    * Event to switch scenes to 'addword.fxml' when the menu's 'addwordIcon' icon is clicked.
    *
    * @see ScreenSwitch
    */
   @FXML
   private void addWordIconClick(){
      // Use 'ScreenSwitch' to switch to the 'addWordScene'.
      ScreenSwitch.swap(ScreenSwitch.SceneType.addWordScene);
   }

}

