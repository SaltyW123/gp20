package uk.ac.aber.cs221.group20.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.javafx.TranslationController;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TranslationControllerTest {
   LinkedList<DictionaryEntry> practiceList = new LinkedList<>();
   DictionaryEntry word1 = new DictionaryEntry("english1", "welsh1", "verb");
   DictionaryEntry word2 = new DictionaryEntry("english2", "welsh2", "verb");
   DictionaryEntry word3 = new DictionaryEntry("english3", "welsh3", "verb");
   Random rand = new Random();
   int chosenWord;

   TranslationController controllerToTest = new TranslationController();


   @BeforeEach
   public void fillList(){

      practiceList.add(word1);
      practiceList.add(word2);
      practiceList.add(word3);
      chosenWord = rand.nextInt(practiceList.size());
      TranslationController.answer = practiceList.get(0);

      System.out.println(controllerToTest.wordToTranslate.getText());



   }

   @Test
   public void testRightWord(){

      if(AssessmentGenerator.isEnglish){
         assertEquals(TranslationController.answer.getEnglish(), controllerToTest.wordToTranslate.getText());
      }
      else{
         assertEquals("welsh1", controllerToTest.wordToTranslate.getText());
      }

   }


}