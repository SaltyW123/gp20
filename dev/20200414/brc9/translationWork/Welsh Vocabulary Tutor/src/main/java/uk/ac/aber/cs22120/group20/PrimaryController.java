package uk.ac.aber.cs22120.group20;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.util.Random;


/**
 * Placeholder Controller
 */
public class PrimaryController {
    ArrayList<DictionaryEntry> practiceList = new ArrayList<>();

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
    private ImageView submitButton;

    Random rand = new Random();


    boolean englishOrWelsh = false; // False means English to Welsh, true means Welsh to English



    @FXML
    private void initialize(){

        submitButton.setImage(new Image (getClass().getResourceAsStream("/assets/right-icon.png")));

        for(DictionaryEntry entry : App.dictionary){
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



    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }




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

        if(numbersUsed.size() > practiceList.size()){
            wordToTranslate.setText("Test Complete");
        }




    }
}
