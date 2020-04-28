package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import java.util.LinkedList;
import java.util.Random;

/**
 * Class that contains methods to create a randomised list of questions that will
 * contain a random distribution of question types.
 * @Author
 * @Version
 * @See
 */
public class AssessmentGenerator extends Question {
   /**
    * Method that will generate a randomized list of questions consisting of random distribution of questions
    * types, using the dictionary’s practice words as the parameter.
    * @param wordList
    * @return
    */
   public LinkedList<Question> generateAssessment(LinkedList<DictionaryEntry> wordList){
      LinkedList<Question> returnValue = new LinkedList<>();
      Random rand = new Random();

      int quizType = rand.nextInt(3);
      switch(quizType){
         case(0): //0 Means translation test.
         int wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
         DictionaryEntry wordToTranslate = Application.practiseList.get(wordToTranslatePlace);

         case(1): //1 Means six meanings test.


         case(2): //2 Means match meanings test.


      }

   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘Match The Meanings’, using the dictionary's
    * practice words as the parameter.
    * @return
    */
   public LinkedList<Question> generateWordMatch(LinkedList<DictionaryEntry> a){
      return null;

   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘6 Meanings’, using the dictionary's practice
    * words as the parameter.
    * @return
    */
   public static void generateSixMeanings(LinkedList<DictionaryEntry> practiseList){

      //CHANGE DICTIONARY TO PRACTISE LIST

      Random rand = new Random();


      boolean isDuplicate = false;

      do{
         int rand_q=rand.nextInt(Application.dictionary.size()-1);

         DictionaryEntry pickedQuestion = Application.dictionary.get(rand_q);

         //If size of list is greater than 1 check for duplicates...
         if(MatchTheMeaningQuestion.setOfQuestions.size()>=1){

            for (DictionaryEntry setOfQuestion : MatchTheMeaningQuestion.setOfQuestions) {

               //If it is duplicate change isDuplicate to true and break
               if (setOfQuestion.equals(pickedQuestion)) {
                  isDuplicate = true;
                  break;
               }

            }

            //If duplicate wasn't found add entry to the list
            if(!isDuplicate){
               MatchTheMeaningQuestion.setOfQuestions.add(pickedQuestion);
            }

            //... otherwise, add entry to the
         }else{
            MatchTheMeaningQuestion.setOfQuestions.add(pickedQuestion);
         }

         isDuplicate =false;

      }while(MatchTheMeaningQuestion.setOfQuestions.size()<5);
   }

   /**
    * Method that
    * will generate a list of questions that are the type ‘Translation’, using the dictionary's practice words as
    * the parameter.
    * @return
    */
   public LinkedList<Question> generateWordEnter(LinkedList<DictionaryEntry> a){
      return null;
   }


}
