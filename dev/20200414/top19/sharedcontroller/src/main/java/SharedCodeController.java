import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

abstract public class SharedCodeController {
    static int correctAnswers;

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
    ImageView addDefinition;


    @FXML
    public void initialize() {
        initializeIcons();
        initializeMenuText();
    }

    private void initializeIcons() {

        expandMenuIcon.setImage(new Image(getClass().getResourceAsStream("/assets/expand-menu.png"));
        dictionaryIcon.setImage(new Image(getClass().getResourceAsStream("/assets/add-definition.png")));
        practiceListIcon.setImage(new Image(getClass().getResourceAsStream("/assets/practice-list.png")));
        flashcardIcon.setImage(new Image(getClass().getResourceAsStream("/assets/flashcard.png")));
        studyIcon.setImage(new Image(getClass().getResourceAsStream("/assets/pactice-list.png")));
        addDefinition.setImage(new Image(getClass().getResourceAsStream("/assets/add-definition.png")));

    }

    private void initializeMenuText() {
        dictionaryText.setText("Dictionary");
        practiceListTest.setText("Practice List");
        flashcardsText.setText("Flashcards");
        studyText.setText("Study");
        addDefinitionText.setText("Add");
    }

    @FXML
    public void expandMenuClick(ActionEvent actionEvent) {

    }

    @FXML
    public void dictionaryIconClick(ActionEvent actionEvent) {

    }

    @FXML
    public void practiceListIconClick(ActionEvent actionEvent) {

    }

    @FXML
    public void flashcardIconClick(ActionEvent actionEvent) {

    }

    @FXML
    public void studyIconClick(ActionEvent actionEvent) {

    }

    @FXML
    public void addWordIconClick(ActionEvent actionEvent) {

    }

    @FXML
    public void exitProgramClick(ActionEvent actionEvent) {

    }
}
