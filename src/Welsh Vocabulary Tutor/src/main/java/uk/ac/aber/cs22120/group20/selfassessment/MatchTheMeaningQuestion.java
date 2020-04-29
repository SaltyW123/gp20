package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.Arrays;

public class MatchTheMeaningQuestion extends Question {
   private ArrayList<DictionaryEntry> correctAnswer = new ArrayList<>();

   public MatchTheMeaningQuestion(DictionaryEntry[] correctAnswer){
      this.correctAnswer.addAll(Arrays.asList(correctAnswer));
   }

   public ArrayList<DictionaryEntry> getCorrectAnswer() {
      return correctAnswer;
   }
}
