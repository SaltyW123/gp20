package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.Random;

public class SixMeaningsQuestion extends Question{
   private DictionaryEntry correctAnswer;
   private LinkedList<DictionaryEntry> dictionary;

   public SixMeaningsQuestion(DictionaryEntry correctAnswer, LinkedList<DictionaryEntry> dictionary) {
      this.correctAnswer = correctAnswer;
      this.dictionary = dictionary;
   }

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
