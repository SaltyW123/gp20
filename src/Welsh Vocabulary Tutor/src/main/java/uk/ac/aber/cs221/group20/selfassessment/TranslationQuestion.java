/**
 * @(#) TranslationQuestion.java 0,1 2020/05/01
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.selfassessment;

import uk.ac.aber.cs221.group20.json.DictionaryEntry;

/**
 * Class used to create a MatchTheMeaning Question.
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see Question
 */

public class TranslationQuestion extends Question {
   private final DictionaryEntry correctAnswer;

   /**
    * Default constructor for translation question
    * @param correctAnswer the correct answer of translation guess.
    */
   public TranslationQuestion(DictionaryEntry correctAnswer){
      this.correctAnswer = correctAnswer;
   }

   public DictionaryEntry getCorrectAnswer() {
      return correctAnswer;
   }
}
