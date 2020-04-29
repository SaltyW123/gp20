package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.LinkedList;

public class TranslationQuestion extends Question {
   private DictionaryEntry correctAnswer;

   public TranslationQuestion(DictionaryEntry correctAnswer){
      this.correctAnswer = correctAnswer;
   }

   public DictionaryEntry getCorrectAnswer() {
      return correctAnswer;
   }
}