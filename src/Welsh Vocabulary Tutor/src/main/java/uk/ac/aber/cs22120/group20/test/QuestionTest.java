package uk.ac.aber.cs22120.group20.test;

import org.junit.jupiter.api.Test;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs22120.group20.selfassessment.Question;
import uk.ac.aber.cs22120.group20.selfassessment.TranslationQuestion;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

   @Test
   void testCheckRightAnswerTranslation() {
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest = new DictionaryEntry("english1", "welsh1","verb");
      boolean isEnglish = true;

      correctAnswerList.add(wordToTest);
      correctEntryList.add(wordToTest.getWelsh());

      Question question;

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(1, Question.correctAnswers);


   }

   @Test
   void testCheckWrongAnswerTranslation() {
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest = new DictionaryEntry("english1", "welsh1","verb");
      boolean isEnglish = true;

      correctAnswerList.add(wordToTest);
      correctEntryList.add("incorrectValue");

      Question question;

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(1, Question.wrongAnswers);


   }

   @Test
   void testCheckRightAnswerMatchMeaning(){
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest1 = new DictionaryEntry("english1", "welsh1","verb");
      DictionaryEntry wordToTest2 = new DictionaryEntry("english2", "welsh2","verb");
      DictionaryEntry wordToTest3 = new DictionaryEntry("english3", "welsh3","verb");
      DictionaryEntry wordToTest4 = new DictionaryEntry("english4", "welsh4","verb");
      boolean isEnglish = true;

      correctAnswerList.add(wordToTest1);
      correctAnswerList.add(wordToTest2);
      correctAnswerList.add(wordToTest3);
      correctAnswerList.add(wordToTest4);
      correctEntryList.add("welsh1");
      correctEntryList.add("welsh2");
      correctEntryList.add("welsh3");
      correctEntryList.add("welsh4");

      AssessmentGenerator.isEnglish = true;

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(4, Question.correctAnswers);
   }

   @Test
   void testCheckWrongAnswerMatchMeaning(){
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest1 = new DictionaryEntry("english1", "welsh1","verb");
      DictionaryEntry wordToTest2 = new DictionaryEntry("english2", "welsh2","verb");
      DictionaryEntry wordToTest3 = new DictionaryEntry("english3", "welsh3","verb");
      DictionaryEntry wordToTest4 = new DictionaryEntry("english4", "welsh4","verb");


      correctAnswerList.add(wordToTest1);
      correctAnswerList.add(wordToTest2);
      correctAnswerList.add(wordToTest3);
      correctAnswerList.add(wordToTest4);
      correctEntryList.add("");
      correctEntryList.add("");
      correctEntryList.add("");
      correctEntryList.add("");

      boolean isEnglish = true;

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);



      assertEquals(4, Question.wrongAnswers);
   }

   @Test
   void testCheckRightAnswerSixMeanings(){

   }

   @Test
   void testCheckWrongAnswerSixMeanings(){

   }

   @Test
   void resetScore() {
   }
}