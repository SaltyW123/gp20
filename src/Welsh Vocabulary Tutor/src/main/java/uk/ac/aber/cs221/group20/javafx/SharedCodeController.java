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
 * @Author top19
 * @Version 0.1 Initial development.
 * @see Application
 * @see DictionaryEntry
 * @see ScreenSwitch
 * @see AssessmentGenerator
 */
abstract public class SharedCodeController {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   static boolean isSortedByEnglish = true;
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
      initializeIcons();
      sideBar.setWidth(sideBarWidth);

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
    * Method that disables the menus text when the menu is collapsed.
    */
   private void disableMenuText() {
      dictionaryText.setText("");
      practiceListTest.setText("");
      flashcardsText.setText("");
      studyText.setText("");
      addDefinitionText.setText("");
   }

   /**
    * Event that expands the menu whenever the menu's 'expandMenuIcon' icon is clicked.
    */
   @FXML
   private void expandMenuClick() {
      if(sideBar.getWidth() == 50) { // If sideBar is currently collapsed, expand it and display menu text.

         sideBar.setWidth(sideBarWidth = 230);
         initializeMenuText(); // Display menu
      } else {
         sideBar.setWidth(sideBarWidth = 50); // Else collapse the menu and disable its text.
         disableMenuText();
      }
   }

   /**
    * Event to switch scenes to 'dictionary.fxml' when the menu's 'dictionaryIcon' icon is clicked.
    * @see ScreenSwitch
    */
   @FXML
   private void dictionaryIconClick() {
      ScreenSwitch.swap(ScreenSwitch.SceneType.dictionaryScene);
   }

   /**
    * Event to switch scenes to 'practicelist.fxml' when the menu's 'practiceListIcon' icon is clicked.
    * @see ScreenSwitch
    */
   @FXML
   private void practiceListIconClick() {
      ScreenSwitch.swap(ScreenSwitch.SceneType.practiceListScene);
   }

   /**
    * Event to switch scenes to 'flashcard.fxml' when the menu's 'practiceListIcon' icon is clicked. This method checks to see if practiceList is empty before switching in order
    * to avoid NullPointerException's in the flashcard scene.
    * @see ScreenSwitch
    * @see Application
    * @see DictionaryEntry
    * @see NullPointerException
    */
   @FXML
   private void flashcardIconClick() {

      if(Application.practiceList.size() == 0) { // Check to see if there are any practice words before switching scene, throwing an alert notifying them that they can't switch scenes.
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Unable to use Flashcard");
         alert.setContentText("The practice list is currently empty, please add some practice words to use the Flashcard feature.");
         alert.showAndWait();
      } else{
         ScreenSwitch.swap(ScreenSwitch.SceneType.flashcardScene); // Switch to flashcard scene if the program has practice words.
      }
   }

   /**
    * Event to generate an assessment using AssessmentGenerator when the menu's 'studyIcon' icon is clicked.
    * @see AssessmentGenerator
    * @see Application
    * @see DictionaryEntry
    */
   @FXML
   private void studyIconClick() {
      AssessmentGenerator.generateAssessment(Application.practiceList);
   }

   /**
    * Event to switch scenes to 'addword.fxml' when the menu's 'addwordIcon' icon is clicked.
    * @see ScreenSwitch
    */
   @FXML
   private void addWordIconClick(){

      ScreenSwitch.swap(ScreenSwitch.SceneType.addWordScene);
   }

}

