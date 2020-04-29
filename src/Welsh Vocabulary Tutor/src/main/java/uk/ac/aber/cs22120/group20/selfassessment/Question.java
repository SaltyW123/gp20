package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.ArrayList;


/**
 * Abstract class contains the basic information that all the shared information between the
 * types of test questions including the questions’ correct answers and possible answers. All question
 * classes will extend this class.
 * @Author
 * @Version
 * @See
 */
public class Question {

   public static int correctAnswers = 0;
   public static int wrongAnswers =0;

   /**
    *
    * @param listOfCorrectQuestions
    * @param listOfAnswers
    * @param isEnglish
    */
   public static void  checkAnswer(ArrayList<DictionaryEntry> listOfCorrectQuestions, ArrayList<String>listOfAnswers, boolean isEnglish){
      if(isEnglish){
         for(int i=0; i<listOfCorrectQuestions.size();i++){
            if(listOfCorrectQuestions.get(i).getWelsh().equals(listOfAnswers.get(i))){
               correctAnswers++;
            }else wrongAnswers++;
         }
      }else{
         for(int i=0; i<listOfCorrectQuestions.size();i++){
            if(listOfCorrectQuestions.get(i).getEnglish().equals(listOfAnswers.get(i))){
               correctAnswers++;
            }else wrongAnswers++;
         }
      }
   }

      public static void resetScore(){
         correctAnswers = 0;
         wrongAnswers =0;
      }

   }
