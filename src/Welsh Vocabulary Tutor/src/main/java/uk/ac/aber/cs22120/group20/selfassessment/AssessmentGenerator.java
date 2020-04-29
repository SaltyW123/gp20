package uk.ac.aber.cs22120.group20.selfassessment;

import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.javafx.ScreenSwitch;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.Arrays;
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
   static LinkedList<Question> listOfAssessment = new LinkedList<>();
   static int currentAssessment = 0;

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



      //int wordToTranslatePlace;

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
      AssessmentGenerator.listOfAssessment = listOfAssessment;
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
      LinkedList<DictionaryEntry> answerList = new LinkedList<>();

      int successfulAnswersSelected = 0;
      while(successfulAnswersSelected<4){
         DictionaryEntry selectedAnswer;
         selectedAnswer = practiceList.get(rand.nextInt(practiceList.size()-1));
         if (answerList.contains(selectedAnswer)){
            continue;
         }
         answerList.add(selectedAnswer);
         successfulAnswersSelected++;
      }

      Question generatedQuestion = new MatchTheMeaningQuestion(answerList.toArray(DictionaryEntry[]::new));
      return generatedQuestion;
   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘6 Meanings’, using the dictionary's practice
    * words as the parameter.
    * @return
    */
   public static Question generateSixMeanings(LinkedList<DictionaryEntry> practiseList){
      Question returnValue;
      ArrayList<DictionaryEntry> listOfAnswers = new ArrayList<>();
      Random rand = new Random();
      DictionaryEntry wordToTranslate = practiseList.get(rand.nextInt(practiseList.size() - 1));
      SixMeaningsQuestion generatedQuestion = new SixMeaningsQuestion(wordToTranslate, Application.dictionary);
      return generatedQuestion;
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

      Question currentQuestion = listOfAssessment.get(currentAssessment);

      if(currentQuestion instanceof MatchTheMeaningQuestion){
         MatchTheMeaningController.answer = (ArrayList<DictionaryEntry>) Arrays.asList(((MatchTheMeaningQuestion) currentQuestion).getCorrectAnswer());
         ScreenSwitch.swap(ScreenSwitch.SceneEnum.matchMeaningScene);
      }else if (currentQuestion instanceof SixMeaningsQuestion){
         SixMeaningsController.allQuestions = ((SixMeaningsQuestion) currentQuestion).getCorrectAnswer();
         ScreenSwitch.swap(ScreenSwitch.SceneEnum.sixMeaningScene);
      }else if (currentQuestion instanceof TranslationQuestion){
         TranslationController.answer = ((TranslationQuestion) currentQuestion).getCorrectAnswer();
         ScreenSwitch.swap(ScreenSwitch.SceneEnum.translationScene);
      }else{
         System.err.print("The question has not been recognised");
         System.err.println(currentQuestion);
      }


   }

}
