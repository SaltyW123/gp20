package org.openjfx.javaFX;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class PrimaryController {
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
        testWord.setText(App.words.getFirst().getWelsh());
        wordType.setText("Welsh");

        updateCounter();
        card = flashcard;

        Image left = new Image(getClass().getResource("/assets/docs_ui_spec_presentation_src_img_Icons_icons8-left-50.png").toExternalForm());
        Image right = new Image(getClass().getResourceAsStream("/assets/docs_ui_spec_presentation_src_img_Icons_icons8-right-50.png"));

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
        testWord.setText(App.words.get(index).getWelsh());
        wordType.setText("Welsh");
    }

    @FXML
    private void handleNextCard() {
        if (index < App.words.size()) {
            index++;
        }
        updateCounter();

        testWord.setText(App.words.get(index).getWelsh());
        wordType.setText("Welsh");
    }

    private void updateCounter() {
        counter.setText((index + 1) + "/" + App.words.size());
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

            testWord.setText("Welsh word: \t" + App.words.get(index).getWelsh());
            if (wordType.getText().equals("Welsh")) {
                testWord.setText(App.words.get(index).getEnglish());
                wordType.setText("English");
            } else {
                testWord.setText(App.words.get(index).getWelsh());
                wordType.setText("Welsh");
            }
            testWord.setVisible(true);
            wordType.setVisible(true);
        });
        return rotate;

    }


}
