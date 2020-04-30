package uk.ac.aber.cs22120.group20.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs22120.group20.selfassessment.Question;


/**
 * Controller for the translationTest fxml file.
 *
 * @author Brad Corbett brc9
 * @version 0.1
 *
 */
public class TranslationController  extends SharedCodeController{
    private ArrayList<DictionaryEntry> practiceList = new ArrayList<>();
    public static DictionaryEntry answer = new DictionaryEntry();

    /**
     * Represents the word that will be randomly chosen from the practiceList.
     */
    int chosenWord = 0;
    @FXML
    private TextField translationBox;

    @FXML
    private Text typeOfTest;

    @FXML
    private Text wordToTranslate;

    @FXML
    private Text correctGuesses;

    @FXML
    private Text incorrectGuesses;

    @FXML
    private ImageView submitButton;

    Random rand = new Random();



    /**
     * Loads the test for the first time, filling the practice list with words from the dictionary,
     * deciding if this test will be from English to Welsh or Welsh to English, and generating
     * which is the first word the user will have to translate.
     */
    @FXML
    private void initialize(){
        setup();
        currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
        currentPageText.setText("Study");

        studyIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/pass-fail-50.png"));
        studyText.setFill(Color.BLACK);

        submitButton.setImage(new Image ("file:src/main/resources/assets/icons/black_icons/50px/right-50.png"));

        correctGuesses.setText("Correct Guesses: " + Question.correctAnswers);
        incorrectGuesses.setText("Incorrect Guesses: " + Question.wrongAnswers);



        if(AssessmentGenerator.isEnglish){
            wordToTranslate.setText(answer.getEnglish());
        }
        else{
            wordToTranslate.setText(answer.getWelsh());
        }
    }


    /**
     * Takes the word the user inputs and compares it to the correct answer using
     * the checkAnswer function in the QuestionClass.
     */
    @FXML
    void translateWord() {

        ArrayList<String> usersInput = new ArrayList<>();
        usersInput.add(translationBox.getText());

        ArrayList<DictionaryEntry> correctTranslation = new ArrayList<>();
        correctTranslation.add(answer);

        Question.checkAnswer(correctTranslation, usersInput, AssessmentGenerator.isEnglish);

        AssessmentGenerator.goToNextQuestion();


    }
}
