package uk.ac.aber.cs22120.group20.selfassessment;
/**
 * @(#) SixMeaningsController.java 0,1 2020/04/27
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.net.URL;
import java.util.*;

/**
 * A class that generate questions and check answers for match the meaning test.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakobik [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see uk.ac.aber.cs22120.group20.javafx.Application
 */

public class SixMeaningsController extends TranslationController implements Initializable {

   private Random rand = new Random();
   private LinkedList<DictionaryEntry> wordSet = new LinkedList<>();
   private ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
   private int correct = 0;
   private int incorrect = 0;
   private String englishCounterpart;

   @FXML
   private Text correctAnswer;

   @FXML
   private Text wrongAnswer;

   @FXML
   private Label wordToTranslate;

   @FXML
   private Text possibleAnswer1;

   @FXML
   private Text possibleAnswer2;

   @FXML
   private Text possibleAnswer3;

   @FXML
   private Text possibleAnswer4;

   @FXML
   private Text possibleAnswer5;

   @FXML
   private Text possibleAnswer6;

   @FXML
   void temp(MouseEvent event) {
      checkAnswers();
   }


   private void getWords(LinkedList<DictionaryEntry> practiceList) {
      boolean isDuplicate = false;
      do {
         int word = rand.nextInt(practiceList.size() - 1);
         DictionaryEntry chosenWord = practiceList.get(word);

         if (wordSet.size() >= 1) {

            for (DictionaryEntry setOfQuestion : wordSet) {

               if (setOfQuestion.equals(chosenWord)) {
                  isDuplicate = true;
                  break;
               }
            }


            //If duplicate wasn't found add entry to the list
            if (!isDuplicate) {
               wordSet.add(chosenWord);
            }

            //... otherwise, add entry to the
         } else {
            wordSet.add(chosenWord);
         }

         isDuplicate = false;

      } while (wordSet.size() < 6);

   }


   private void setWords(LinkedList<DictionaryEntry> questions, ArrayList<Integer> orderList) {
      //WelshWord1 Is the question word and as a result is always right.
      wordToTranslate.setText(questions.get(0).getWelsh());
      //This stores the correct answer for the english word.
      englishCounterpart = questions.get(0).getEnglish();


      possibleAnswer1.setText(questions.get(orderList.get(0)).getEnglish());
      possibleAnswer2.setText(questions.get(orderList.get(1)).getEnglish());
      possibleAnswer3.setText(questions.get(orderList.get(2)).getEnglish());
      possibleAnswer4.setText(questions.get(orderList.get(3)).getEnglish());
      possibleAnswer5.setText(questions.get(orderList.get(4)).getEnglish());
      possibleAnswer6.setText(questions.get(orderList.get(5)).getEnglish());

      Collections.shuffle(orderList); //I know that this does not belong here it was moved here for debug purposes. It lives five lines up.

   }


   public void checkAnswers() {
      String option1 = possibleAnswer1.toString();
      String option2 = possibleAnswer2.toString();
      String option3 = possibleAnswer3.toString();
      String option4 = possibleAnswer4.toString();
      String option5 = possibleAnswer5.toString();
      String option6 = possibleAnswer6.toString();

      if (option1 == englishCounterpart) {
         correct++;
      } else incorrect++;

      if (option2 == englishCounterpart) {
         correct++;
      } else incorrect++;

      if (option3 == englishCounterpart) {
         correct++;
      } else incorrect++;

      if (option4 == englishCounterpart) {
         correct++;
      } else incorrect++;

      if (option5 == englishCounterpart) {
         correct++;
      } else incorrect++;

      if (option6 == englishCounterpart) {
         correct++;
      } else incorrect++;

      correctAnswer.setText(Integer.toString(correct));

      wrongAnswer.setText(Integer.toString(incorrect));

      wordSet.clear();
      this.prepare();

   }


   private void prepare() {
      getWords(Application.dictionary);
      setWords(wordSet, orderList);

   }


   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      this.prepare();

   }
}
