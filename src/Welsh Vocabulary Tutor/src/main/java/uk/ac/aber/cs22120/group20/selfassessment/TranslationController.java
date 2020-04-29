package uk.ac.aber.cs22120.group20.selfassessment;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Random;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.javafx.Application;



/**
 * Controller for the translationTest fxml file.
 *
 * @author Brad Corbett brc9
 * @version 0.9
 *
 */
public class TranslationController extends Question {
    ArrayList<DictionaryEntry> practiceList = new ArrayList<>();

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

        submitButton.setImage(new Image ("file:src/main/resources/assets/icons/black_icons/50px/right-50.png"));

        practiceList.addAll(Application.practiseList);


        chosenWord = (rand.nextInt(practiceList.size()));

        correctGuesses.setText("Correct Guesses: " + correctAnswers);
        incorrectGuesses.setText("Incorrect Guesses: " + wrongAnswers);

        if(AssessmentGenerator.isEnglish){
            wordToTranslate.setText(practiceList.get(chosenWord).getWelsh());
        }
        else{
            wordToTranslate.setText(practiceList.get(chosenWord).getEnglish());
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
        correctTranslation.add(practiceList.get(chosenWord));

        checkAnswer(correctTranslation, usersInput, AssessmentGenerator.isEnglish);


    }
}
