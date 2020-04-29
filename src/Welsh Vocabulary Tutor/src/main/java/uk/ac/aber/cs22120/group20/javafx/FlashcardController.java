package uk.ac.aber.cs22120.group20.javafx;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.selfassessment.AssessmentGenerator;

import java.io.IOException;

public class FlashcardController {
   int index = 0;
   Node card;

   @FXML
   private Text counter;
   @FXML
   private Text wordType;
   @FXML
   private Rectangle flashcard;
   @FXML
   private Text testWord;

   @FXML
   private ImageView left_arrow;
   @FXML
   private ImageView right_arrow;

   @FXML
   private void initialize() {
      testWord.setText(Application.practiseList.getFirst().getWelsh());
      wordType.setText("Welsh");

      updateCounter();
      card = flashcard;

      Image left = new Image("file:src/main/resources/assets/icons/black_icons/50px/left-50.png");
      Image right = new Image("file:src/main/resources/assets/icons/black_icons/50px/right-50.png");

      left_arrow.setImage(left);
      right_arrow.setImage(right);
   }

   @FXML
   private void handleFlashcardClick() {
      RotateTransition rotator = RotateCard(card);
      rotator.play();
   }

   @FXML
   private void handlePreviousCard() {

      if (index > 0) {
         index--;
      }
      updateCounter();
      testWord.setText(Application.practiseList.get(index).getWelsh());
      wordType.setText("Welsh");
   }

   @FXML
   private void handleNextCard() {
      if (index < Application.practiseList.size()-1) {
         index++;
      }
      updateCounter();

      testWord.setText(Application.practiseList.get(index).getWelsh());
      wordType.setText("Welsh");
   }

   private void updateCounter() {
      counter.setText((index + 1) + "/" + Application.practiseList.size());
   }

   private RotateTransition RotateCard(Node card) {

      RotateTransition rotate = new RotateTransition(Duration.millis(1000), card);
      testWord.setVisible(false);
      wordType.setVisible(false);

      rotate.setAxis(Rotate.Y_AXIS);
      rotate.setFromAngle(0);
      rotate.setToAngle(180);
      rotate.setInterpolator(Interpolator.LINEAR);
      rotate.setCycleCount(1);
      rotate.setOnFinished(event -> {

         testWord.setText("Welsh word: \t" + Application.practiseList.get(index).getWelsh());
         if (wordType.getText().equals("Welsh")) {
            testWord.setText(Application.practiseList.get(index).getEnglish());
            wordType.setText("English");
         } else {
            testWord.setText(Application.practiseList.get(index).getWelsh());
            wordType.setText("Welsh");
         }
         testWord.setVisible(true);
         wordType.setVisible(true);
      });
      return rotate;

   }

   @FXML
   private void switchToAddWord() throws IOException {
      AssessmentGenerator.generateAssessment(Application.practiseList);
   }

}
