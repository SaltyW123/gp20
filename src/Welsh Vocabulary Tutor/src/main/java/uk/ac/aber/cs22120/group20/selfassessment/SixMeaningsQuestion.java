package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.LinkedList;

public class SixMeaningsQuestion extends Question{
   private DictionaryEntry correctAnswer;
   private LinkedList<DictionaryEntry> dictionary;

   public SixMeaningsQuestion(DictionaryEntry correctAnswer, LinkedList<DictionaryEntry> dictionary) {
      this.correctAnswer = correctAnswer;
      this.dictionary = dictionary;
   }

   public DictionaryEntry getCorrectAnswer() {
      return correctAnswer;
   }
}
