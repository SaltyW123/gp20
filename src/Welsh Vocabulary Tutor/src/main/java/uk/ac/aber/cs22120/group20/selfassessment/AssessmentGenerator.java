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
public class AssessmentGenerator {
   static boolean isEnglish;


   /**
    * Method that will generate a randomized list of questions consisting of random distribution of questions
    * types, using the dictionary’s practice words as the parameter.
    * @param wordList
    * @return
    */
   public static LinkedList<Question> generateAssessment(LinkedList<DictionaryEntry> wordList){
      LinkedList<Question> listOfAssessment = new LinkedList<>();
      LinkedList<DictionaryEntry> practiseList = Application.practiseList;
      Random rand = new Random();



      int wordToTranslatePlace;

      for (int numberToGenerate = 0; numberToGenerate < 10; numberToGenerate++) {
         Question generatedAssessment = null;
         int quizType = rand.nextInt(3);
         switch (quizType) {
            case (0): //0 Means translation test.
               //wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
               //wordToTranslate = Application.practiseList.get(wordToTranslatePlace);

               generatedAssessment = generateTranslationTest(practiseList);
               break;
            case (1): //1 Means six meanings test.
               //wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
               //wordToTranslate = Application.practiseList.get(wordToTranslatePlace);

               generatedAssessment = generateSixMeanings(practiseList);
               break;
            case (2): //2 Means match meanings test.
//               LinkedList<DictionaryEntry> wordsToTranslate = new LinkedList<>();
//               for (int i = 0; i < 3; i++) {
//                  wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
//                  wordsToTranslate.add(Application.practiseList.get(wordToTranslatePlace));
//                  wordsToTranslate.toArray();
//               }

               generatedAssessment = generateMatchMeaning(practiseList);
               break;
         }
         listOfAssessment.add(generatedAssessment);
      }

      return listOfAssessment;
   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘Match The Meanings’, using the dictionary's
    * practice words as the parameter.
    * @return
    */
   public static Question generateMatchMeaning(LinkedList<DictionaryEntry> practiceList){
      Random rand = new Random();
      DictionaryEntry selectedCorrectAnswer;
      selectedCorrectAnswer = practiceList.get(rand.nextInt(practiceList.size()-1));
      Question generatedQuestion = new TranslationQuestion(selectedCorrectAnswer);
      return generatedQuestion;

   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘6 Meanings’, using the dictionary's practice
    * words as the parameter.
    * @return
    */
   public static Question generateSixMeanings(LinkedList<DictionaryEntry> practiseList){

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
   public static Question generateTranslationTest(LinkedList<DictionaryEntry> practiceList){
      Random rand = new Random();
      DictionaryEntry selectedCorrectAnswer;
      selectedCorrectAnswer = practiceList.get(rand.nextInt(practiceList.size()-1));
      Question generatedQuestion = new TranslationQuestion(selectedCorrectAnswer);
      return generatedQuestion;
   }


   public static void goToNextQuestion(){
      
   }

}
