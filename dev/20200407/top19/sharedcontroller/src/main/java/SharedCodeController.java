import javafx.fxml.FXML;

import javax.xml.soap.Text;
import java.awt.*;

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
    Image dictionaryIcon;
    @FXML
    Image practiceListIcon;
    @FXML
    Image flashcardIcon;
    @FXML
    Image studyIcon;

}
