/**
 * @(#) FlashcardController.java 0,1 2020/05/07
 *
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;

/**
 * A class that servers as the controller for the programs Flashcard JavaFX scene, handling all of its events and attributes. This scene is defined as "flashcard.fxml".
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development.
 * @see Application
 * @see DictionaryEntry
 * @see SharedCodeController
 * @see RotateTransition
 */

public class FlashcardController extends SharedCodeController {

   // /////////////////// //
   // Instance Variables. //
   // /////////////////// //

   int index = 0;
   // Node that will be flipped using RotateTransition.
   Node card;

   @FXML
   private Text counter;
   @FXML
   private Text wordType;
   @FXML
   private Text testWord;

   @FXML
   private ImageView flashcard;
   @FXML
   private ImageView leftArrow;
   @FXML
   private ImageView rightArrow;

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Method that initializes 'flashcard.fxml' by setting up the icons and text. This method is called automatically whenever the flashcard scene starts.
    *
    * @see DictionaryEntry
    * @see Image
    */
   @FXML
   private void initialize() {
      // Call method from SharedCodeController to setup the menu screens images.
      setup();
      currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/flashcard-50.png"));
      currentPageText.setText("Flashcard");
      flashcardIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/flashcard-50.png"));
      flashcardsText.setFill(Color.BLACK);

      // If the current language ordering is by english, display the english word first.
      if(isSortedByEnglish){
         testWord.setText(Application.practiceList.getFirst().getEnglish());
         wordType.setText("English");
      } else{
         // Else display the word definition first.
         testWord.setText(Application.practiceList.getFirst().getWelsh());
         wordType.setText("Welsh");
      }

      // Update the on screen counter and setup the flashcards images.
      updateCounter();
      flashcard.setImage(new Image("file:src/main/resources/assets/flashcard/FlashCard.png"));
      leftArrow.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/left-50.png"));
      rightArrow.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/right-50.png"));
   }

   /**
    * Event that rotates the scenes flashcard using RotateTransition whenever the user clicks the flashcard.
    *
    * @see RotateTransition
    */
   @FXML
   private void handleFlashcardClick() {
      card = flashcard;
      // Call method to create the RotateTransition.
      RotateTransition rotator = RotateCard(card);
      // Play the rotate transition.
      rotator.play();
   }

   /**
    * Event that switches to the previous flashcard whenever the user clicks the 'leftArrow' icon.
    *
    * @see Application
    * @see DictionaryEntry
    */
   @FXML
   private void handlePreviousCard() {
      // If statement to check the start of the practiceList hasn't been reached before moving to the previous card.
      if (index > 0) {
         index--;
         updateCounter();

      // If the current language ordering is by english, display the english word first.
         if (isSortedByEnglish) {
            testWord.setText(Application.practiceList.get(index).getEnglish());
            wordType.setText("English");
         } else {
            // Else display the word definition first.
            testWord.setText(Application.practiceList.get(index).getWelsh());
            wordType.setText("Welsh");
         }
      }
   }

   /**
    * Event that switches to the next flashcard whenever the user clicks the 'right-arrow' icon.
    *
    * @see Application
    * @see DictionaryEntry
    */
   @FXML
   private void handleNextCard() {
      // If statement to check the end of the practiceList hasn't been reached before moving to the next card.
      if (index < Application.practiceList.size() - 1) {
         index++;
         updateCounter();

      // If the current language ordering is by english, display the english word first.
         if (isSortedByEnglish) {
            testWord.setText(Application.practiceList.get(index).getEnglish());
            wordType.setText("English");
         } else {
            // Else display the word definition first.
            testWord.setText(Application.practiceList.get(index).getWelsh());
            wordType.setText("Welsh");
         }

      }
   }

   /**
    * Method that updates the onscreen counter of the current flashcard.
    *
    * @see Application
    * @see DictionaryEntry
    */
   private void updateCounter() {
      counter.setText((index + 1) + "/" + Application.practiceList.size());
   }

   /**
    * Method that creates a RotateTransition animation for flipping the flashcard 180 degrees.
    *
    * @param card FXML rectangle element that will be flipped.
    * @return RotateTransition that will flip the rectangle 180 degrees.
    * @see Application
    * @see DictionaryEntry
    * @see RotateTransition
    */
   private RotateTransition RotateCard(Node card) {

      RotateTransition rotate = new RotateTransition(Duration.millis(1000), card);
      // Make the text on the card go invisible whilst the cardFlip is happening.
      testWord.setVisible(false);
      wordType.setVisible(false);

      // Set the axis and angle of the rotation.
      rotate.setAxis(Rotate.Y_AXIS);
      rotate.setFromAngle(0);
      rotate.setToAngle(180);
      rotate.setInterpolator(Interpolator.LINEAR);
      rotate.setCycleCount(1);
      // Once the transition is completed, update the text on the flashcard.
      rotate.setOnFinished(event -> {

         // If the word currently on the flashcard is welsh, display the english translation.
         if (wordType.getText().equals("Welsh")) {
            testWord.setText(Application.practiceList.get(index).getEnglish());
            wordType.setText("English");
         } else {
            // Else display the welsh translation.
            testWord.setText(Application.practiceList.get(index).getWelsh());
            wordType.setText("Welsh");
         }
         testWord.setVisible(true);
         wordType.setVisible(true);
      });
      return rotate;

   }


}
