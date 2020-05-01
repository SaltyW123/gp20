package uk.ac.aber.cs221.group20.selfassessment;

import uk.ac.aber.cs221.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class used to generate a MatchTheMeaning Question.
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
public class MatchTheMeaningQuestion extends Question {
   private final ArrayList<DictionaryEntry> correctAnswer = new ArrayList<>();

   /**
    * Default constructer which loads ArrayList into correctAnswer field variable.
    * @param correctAnswer the ArrayList of DictionaryEntry objects
    */
   public MatchTheMeaningQuestion(DictionaryEntry[] correctAnswer){
      this.correctAnswer.addAll(Arrays.asList(correctAnswer));
   }

   /**
    * @return ArrayList of DictionaryEntry objects storing correctAnswers
    */
   public ArrayList<DictionaryEntry> getCorrectAnswer() {
      return correctAnswer;
   }
}
