package code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;




public class SharedCodeController {
    static int correctAnswers;

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
    ImageView addDefinition;
    @FXML
    ImageView currentPageIcon;

    @FXML
    public void initialize() {
         sideBar.setWidth(50);
         initializeIcons();
         currentPageText.setText("Dictionary");
       /* initializeMenuText(); */
    }

    private void initializeIcons() {
        expandMenuIcon.setImage(new Image(getClass().getResourceAsStream("/assets/expand-menu.png")));
        dictionaryIcon.setImage(new Image(getClass().getResourceAsStream("/assets/black-dictionary.png")));
        practiceListIcon.setImage(new Image(getClass().getResourceAsStream("/assets/white-practice-list.png")));
        flashcardIcon.setImage(new Image(getClass().getResourceAsStream("/assets/white-flashcard.png")));
        studyIcon.setImage(new Image(getClass().getResourceAsStream("/assets/white-study.png")));
        currentPageIcon.setImage(new Image(getClass().getResourceAsStream("/assets/white-dictionary.png")));
        addDefinition.setImage(new Image(getClass().getResourceAsStream("/assets/white-add.png")));
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
            sideBar.setWidth(150);
            initializeMenuText();
        } else {
            sideBar.setWidth(50);
            disableMenuText();
        }
    }

    @FXML
    private void dictionaryIconClick(ActionEvent actionEvent) {

    }

    @FXML
    private void practiceListIconClick(ActionEvent actionEvent) {

    }

    @FXML
    private void flashcardIconClick(ActionEvent actionEvent) {

    }

    @FXML
    private void studyIconClick(ActionEvent actionEvent) {

    }

    @FXML
    private void addWordIconClick(ActionEvent actionEvent) {

    }

    @FXML
    private void exitProgramClick(ActionEvent actionEvent) {

    }

    private void initializeMenuText() {
        dictionaryText.setText("Dictionary");
        practiceListTest.setText("Practice List");
        flashcardsText.setText("Flashcards");
        studyText.setText("Study");
        addDefinitionText.setText("Add");
    }


}
