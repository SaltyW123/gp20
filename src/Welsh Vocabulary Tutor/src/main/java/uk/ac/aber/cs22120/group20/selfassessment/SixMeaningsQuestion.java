package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

public class SixMeaningsQuestion extends Question{
   private DictionaryEntry correctAnswer;

   private SixMeaningsQuestion(DictionaryEntry correctAnswer) {
      this.correctAnswer = correctAnswer;
   }
}
