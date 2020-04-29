package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

public class MatchTheMeaningQuestion extends Question {
   private DictionaryEntry[] correctAnswer;

   public MatchTheMeaningQuestion(DictionaryEntry[] correctAnswer){
      this.correctAnswer = correctAnswer;
   }

   public DictionaryEntry[] getCorrectAnswer() {
      return correctAnswer;
   }
}
