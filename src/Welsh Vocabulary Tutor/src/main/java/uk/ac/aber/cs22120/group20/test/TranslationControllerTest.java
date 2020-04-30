package uk.ac.aber.cs22120.group20.test;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs22120.group20.selfassessment.Question;
import uk.ac.aber.cs22120.group20.selfassessment.TranslationController;

import java.util.LinkedList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TranslationControllerTest {
   LinkedList<DictionaryEntry> practiceList;
   DictionaryEntry word1 = new DictionaryEntry("english1", "welsh1", "verb");
   DictionaryEntry word2 = new DictionaryEntry("english2", "welsh2", "verb");
   DictionaryEntry word3 = new DictionaryEntry("english3", "welsh3", "verb");
   Random rand = new Random();
   int chosenWord;

   TranslationController controllerToTest = new TranslationController();


   @Before
   public void fillList(){

      practiceList.add(word1);
      practiceList.add(word2);
      practiceList.add(word3);
      chosenWord = rand.nextInt(practiceList.size());
      TranslationController.answer = practiceList.get(chosenWord);

      if(AssessmentGenerator.isEnglish){
         controllerToTest.wordToTranslate.setText(TranslationController.answer.getEnglish());
      }
      else{
         controllerToTest.wordToTranslate.setText(TranslationController.answer.getWelsh());
      }


   }

   @Test
   public void testText(){
      if(AssessmentGenerator.isEnglish){
         assertEquals(practiceList.get(chosenWord).getEnglish(),TranslationController.answer.getEnglish());
      }
      else{
         
      }

   }


}