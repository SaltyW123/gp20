package uk.ac.aber.cs221.group20.selfassessment;

import uk.ac.aber.cs221.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
/**
 * Class used to create a SixMeanings Question.
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see Question
 */

public class SixMeaningsQuestion extends Question{
   private final DictionaryEntry correctAnswer;
   private final LinkedList<DictionaryEntry> dictionary;

   public SixMeaningsQuestion(DictionaryEntry correctAnswer, LinkedList<DictionaryEntry> dictionary) {
      this.correctAnswer = correctAnswer;
      this.dictionary = dictionary;
   }

   /** Function to retrieve the correct answer to a SixMeaningsQuestion.
    *
    * @return Retrieves the correct answer
    */

   public ArrayList<DictionaryEntry> getCorrectAnswer() {
      Random rand = new Random();

      ArrayList<DictionaryEntry> result = new ArrayList<>();

      result.add(correctAnswer);
      int successfulAnswersSelected = 0;
      while(successfulAnswersSelected<5){
         DictionaryEntry selectedAnswer;
         selectedAnswer = dictionary.get(rand.nextInt(dictionary.size()-1));
         if (result.contains(selectedAnswer)){
            continue;
         }
         result.add(selectedAnswer);
         successfulAnswersSelected++;
      }


      return result;
   }
}
