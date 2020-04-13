package uk.ac.aber.cs22120.group20;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Random;


/**
 * Placeholder Controller
 */
public class PrimaryController {
    ArrayList<WelshDictionary> words = new ArrayList<>();
    WelshDictionary word1 = new WelshDictionary("english1","welsh1", "type1");
    WelshDictionary word2 = new WelshDictionary("english2","welsh2", "type1");
    WelshDictionary word3 = new WelshDictionary("english3","welsh3", "type1");
    WelshDictionary word4 = new WelshDictionary("english4","welsh4", "type1");
    WelshDictionary word5 = new WelshDictionary("english5","welsh5", "type1");
    ArrayList<Integer> numbersUsed = new ArrayList<Integer>();
    int correctGuessesInt = 0;
    int incorrectGuessesInt = 0;

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
    private Button submitButton;
    Random rand = new Random();

    boolean englishOrWelsh = false; // False means English to Welsh, true means Welsh to English



    @FXML
    private void initialize(){

        words.add(word1);
        words.add(word2);
        words.add(word3);
        words.add(word4);
        words.add(word5);


        chosenWord = (rand.nextInt(5));
        numbersUsed.add(chosenWord);

        englishOrWelsh = rand.nextBoolean();

        correctGuesses.setText("Correct Guesses: 0");
        incorrectGuesses.setText("Incorrect Guesses: 0");

        if(englishOrWelsh){
            wordToTranslate.setText(words.get(chosenWord).getEnglish());
        }
        else{
            wordToTranslate.setText(words.get(chosenWord).getWelsh());
        }









    }



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }




    @FXML
    void translateWord() {


        if(englishOrWelsh) {
            if (translationBox.getText().equals(words.get(chosenWord).getWelsh())) {
                correctGuessesInt++;
            } else {
                incorrectGuessesInt++;
            }
        }
        else{
            if (translationBox.getText().equals(words.get(chosenWord).getEnglish())) {
                correctGuessesInt++;
            } else {
                incorrectGuessesInt++;
            }
        }


        correctGuesses.setText("Correct Guesses: " + correctGuessesInt);
        incorrectGuesses.setText("Incorrect Guesses: " + incorrectGuessesInt);





        do{
            chosenWord = (rand.nextInt(5));
        }while((numbersUsed.contains(chosenWord)) && numbersUsed.size() < 5);

        numbersUsed.add(chosenWord);

        if(numbersUsed.size() > 5){
            wordToTranslate.setText("Test Complete");
            submitButton.setVisible(false);
        }

        if(englishOrWelsh){
            wordToTranslate.setText(words.get(chosenWord).getEnglish());
        }
        else{
            wordToTranslate.setText(words.get(chosenWord).getWelsh());
        }

        if(numbersUsed.size() > 5){
            wordToTranslate.setText("Test Complete");
        }




    }
}
