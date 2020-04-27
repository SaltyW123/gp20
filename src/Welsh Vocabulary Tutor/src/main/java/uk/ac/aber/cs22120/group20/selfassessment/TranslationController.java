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
     * Represents the words that have already been used, and are no longer to be generated.
     */
    ArrayList<Integer> numbersUsed = new ArrayList<Integer>();
    int correctGuessesInt = 0;
    int incorrectGuessesInt = 0;

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


    boolean englishOrWelsh = false; // False means English to Welsh, true means Welsh to English


    /**
     * Loads the test for the first time, filling the practice list with words from the dictionary,
     * deciding if this test will be from English to Welsh or Welsh to English, and generating
     * which is the first word the user will have to translate.
     */
    @FXML
    private void initialize(){

        submitButton.setImage(new Image ("file:src/main/resources/assets/right-icon.png"));

        for(DictionaryEntry entry : Application.dictionary){
            if(entry.isPracticeWord()){
                practiceList.add(entry);
            }
        }


        chosenWord = (rand.nextInt(practiceList.size()));
        numbersUsed.add(chosenWord);

        englishOrWelsh = rand.nextBoolean();

        correctGuesses.setText("Correct Guesses: 0");
        incorrectGuesses.setText("Incorrect Guesses: 0");

        if(englishOrWelsh){
            wordToTranslate.setText(practiceList.get(chosenWord).getEnglish());
        }
        else{
            wordToTranslate.setText(practiceList.get(chosenWord).getWelsh());
        }
    }


    /**
     * Takes the word that the user has entered as their attempt at translate, compares
     * it to the correct translation, and depending on if it is correct or not, increment how many
     * right or wrong answers they have so far. After checking if the user got it right,
     * it will generate a new word for the user to translate, provided they have words left to translate.
     */
    @FXML
    void translateWord() {


        if(englishOrWelsh) {
            if (translationBox.getText().equals(practiceList.get(chosenWord).getWelsh())) {
                correctGuessesInt++;
            } else {
                incorrectGuessesInt++;
            }
        }
        else{
            if (translationBox.getText().equals(practiceList.get(chosenWord).getEnglish())) {
                correctGuessesInt++;
            } else {
                incorrectGuessesInt++;
            }
        }


        correctGuesses.setText("Correct Guesses: " + correctGuessesInt);
        incorrectGuesses.setText("Incorrect Guesses: " + incorrectGuessesInt);





        do{
            chosenWord = (rand.nextInt(practiceList.size()));
        }while((numbersUsed.contains(chosenWord)) && numbersUsed.size() < practiceList.size());

        numbersUsed.add(chosenWord);

        if(numbersUsed.size() > practiceList.size()){
            wordToTranslate.setText("Test Complete");
            submitButton.setVisible(false);
        }

        if(englishOrWelsh){
            wordToTranslate.setText(practiceList.get(chosenWord).getEnglish());
        }
        else{
            wordToTranslate.setText(practiceList.get(chosenWord).getWelsh());
        }
    }
}
