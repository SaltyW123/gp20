package uk.ac.aber.cs22120.group20.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import uk.ac.aber.cs22120.group20.selfassessment.AssessmentGenerator;

/**
 * Abstract class that contains all the shared FXML elements between the
 * different controller classes including the sliding menu and the test score counter, to reduce code
 * duplication. This will be extended by all the controller classes.
 * @Author
 * @Version
 * @See
 */
abstract public class SharedCodeController {

   static int sideBarWidth = 50;

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
   ImageView searchIcon;
   @FXML
   ImageView addDefinitionIcon;
   @FXML
   ImageView currentPageIcon;

   public void setup() {
      initializeIcons();
      sideBar.setWidth(sideBarWidth);

      if (sideBarWidth != 50)
         initializeMenuText();
   }

   private void initializeIcons() {
      expandMenuIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/menu-50.png"));
      dictionaryIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/read-50.png"));
      practiceListIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/rating-50.png"));
      flashcardIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/flashcard-50.png"));
      studyIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
      addDefinitionIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/add-50.png"));
   }

   private void initializeMenuText() {
      dictionaryText.setText("Dictionary");
      practiceListTest.setText("Practice List");
      flashcardsText.setText("Flashcards");
      studyText.setText("Study");
      addDefinitionText.setText("Add");
   }

   private void disableMenuText() {
      dictionaryText.setText("");
      practiceListTest.setText("");
      flashcardsText.setText("");
      studyText.setText("");
      addDefinitionText.setText("");
   }

   @FXML
   private void expandMenuClick() {
      if(sideBar.getWidth() == 50) {

         sideBar.setWidth(sideBarWidth = 230);
         initializeMenuText();
      } else {
         sideBar.setWidth(sideBarWidth = 50);
         disableMenuText();
      }
   }

   @FXML
   private void dictionaryIconClick() {
      ScreenSwitch.swap(ScreenSwitch.SceneEnum.dictionaryScene);
   }

   @FXML
   private void practiceListIconClick() {
      ScreenSwitch.swap(ScreenSwitch.SceneEnum.practiceListScene);
   }

   @FXML
   private void flashcardIconClick() {

      if(Application.practiseList.size() == 0) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Unable to use Flashcard");
         alert.setContentText("The practice list is currently empty, please add some practice words to use the Flashcard feature.");
         alert.showAndWait();
      } else{
         ScreenSwitch.swap(ScreenSwitch.SceneEnum.flashcardScene);
      }
   }

   @FXML
   private void studyIconClick() {
      AssessmentGenerator.generateAssessment(Application.practiseList);
   }

   @FXML
   private void addWordIconClick(){

      ScreenSwitch.swap(ScreenSwitch.SceneEnum.addWordScene);
   }

}

