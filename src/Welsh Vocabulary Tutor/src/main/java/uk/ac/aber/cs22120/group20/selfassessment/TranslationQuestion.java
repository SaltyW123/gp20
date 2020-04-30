package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.LinkedList;

/**
 * Class used to create a MatchTheMeaning Question.
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @See Question
 */

public class TranslationQuestion extends Question {
   private DictionaryEntry correctAnswer;

   public TranslationQuestion(DictionaryEntry correctAnswer){
      this.correctAnswer = correctAnswer;
   }

   public DictionaryEntry getCorrectAnswer() {
      return correctAnswer;
   }
}
