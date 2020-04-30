package uk.ac.aber.cs221.group20.test;

import org.junit.jupiter.api.Test;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;
import uk.ac.aber.cs221.group20.selfassessment.TranslationQuestion;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import static uk.ac.aber.cs221.group20.json.DictionaryEntry.wordTypeEnum.verb;

/**
 * Class that contains methods which will be used to test the Question class, and its methods.
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

class QuestionTest {

   /**
    * Tests that the correctAnswers variable increments when a user gets a right answer
    * when doing either a Translation or SixMeanings test.
    */

   @Test
   void testCheckRightAnswerTranslationOrSixMeanings() {
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest = new DictionaryEntry("english1", "welsh1", DictionaryEntry.wordTypeEnum.verb);
      boolean isEnglish = true;

      correctAnswerList.add(wordToTest);
      correctEntryList.add(wordToTest.getWelsh());

      Question question;

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(1, Question.correctAnswers);


   }

   /**
    * Tests that the wrongAnswers variable increments when a user gets a wrong answer
    * when doing either a Translation or SixMeanings test.
    */

   @Test
   void testCheckWrongAnswerTranslationOrSixMeanings() {
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest = new DictionaryEntry("english1", "welsh1", DictionaryEntry.wordTypeEnum.verb);
      boolean isEnglish = true;

      correctAnswerList.add(wordToTest);
      correctEntryList.add("incorrectValue");

      Question question;

      Question.resetScore();

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(1, Question.wrongAnswers);


   }


   /**
    * Tests that the correctAnswers variable increments when a user gets a right answer
    * when doing either a MatchTheMeaning test.
    */

   @Test
   void testCheckRightAnswerMatchMeaning(){
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest1 = new DictionaryEntry("english1", "welsh1", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest2 = new DictionaryEntry("english2", "welsh2", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest3 = new DictionaryEntry("english3", "welsh3", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest4 = new DictionaryEntry("english4", "welsh4", DictionaryEntry.wordTypeEnum.verb);
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

      Question.resetScore();

      Question.checkAnswer(correctAnswerList, correctEntryList, isEnglish);

      assertEquals(4, Question.correctAnswers);
   }

   /**
    * Tests that the wrongAnswers variable increments when a user gets a wrong answer
    * when doing either a MatchTheMeaning test.
    */

   @Test
   void testCheckWrongAnswerMatchMeaning(){
      ArrayList<DictionaryEntry> correctAnswerList = new ArrayList<>();
      ArrayList<String> correctEntryList = new ArrayList<>();
      DictionaryEntry wordToTest1 = new DictionaryEntry("english1", "welsh1", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest2 = new DictionaryEntry("english2", "welsh2", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest3 = new DictionaryEntry("english3", "welsh3", DictionaryEntry.wordTypeEnum.verb);
      DictionaryEntry wordToTest4 = new DictionaryEntry("english4", "welsh4", DictionaryEntry.wordTypeEnum.verb);


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
   void resetScore() {
      Question.wrongAnswers = 5;
      Question.correctAnswers = 5;
      Question.resetScore();

      assertEquals(0, Question.correctAnswers);
      assertEquals(0, Question.wrongAnswers);
   }
}