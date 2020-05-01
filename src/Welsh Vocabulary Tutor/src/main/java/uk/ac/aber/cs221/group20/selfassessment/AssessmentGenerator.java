package uk.ac.aber.cs221.group20.selfassessment;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import uk.ac.aber.cs221.group20.javafx.*;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;

import java.text.DecimalFormat;
import java.util.*;


/**
 * Class that contains methods to create a randomised list of questions that will
 * contain a random distribution of question types.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see Question
 * @see SixMeaningsQuestion
 * @see TranslationQuestion
 * @see MatchTheMeaningQuestion
 * @see ScreenSwitch
 * @see SixMeaningsController
 * @see TranslationController
 * @see MatchTheMeaningController
 */
public class AssessmentGenerator {
   public static boolean isEnglishList;
   static LinkedList<Question> listOfAssessment = new LinkedList<>();
   static int currentAssessment = 0;
   static int totalCorrectAnswers = 0;
   static int totalAnswers = 0;

   /**
    * Method that will generate a randomized list of questions consisting of random distribution of questions
    * types, using the dictionary’s practice words as the parameter.
    *
    * @param practiseList
    * @return
    */
   public static LinkedList<Question> generateAssessment(LinkedList<DictionaryEntry> practiseList) {
      LinkedList<Question> listOfAssessment = new LinkedList<>();
      Random rand = new Random();


      reset();
      if (practiseList.size()==0){
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Not enough words in practice list");
         alert.setResizable(false);
         alert.setContentText("Please add at least 1 word to your practice!");
         alert.showAndWait();
      }else {

         for (int numberToGenerate = 0; numberToGenerate < 10; numberToGenerate++) {
            Question generatedAssessment = null;
            int quizType = rand.nextInt(3);
            switch (quizType) {
               case (0): //0 Means translation test.
                  if((listOfAssessment.isEmpty()) || !(listOfAssessment.getLast() instanceof TranslationQuestion)){
                     generatedAssessment = generateTranslationTest(practiseList);
                  }else {
                     numberToGenerate--;
                  }
                  break;
               case (1): //1 Means six meanings test.
                  if(((listOfAssessment.isEmpty())) || !(listOfAssessment.getLast() instanceof SixMeaningsQuestion)){
                     generatedAssessment = generateSixMeanings(practiseList);
                  }else {
                     numberToGenerate--;
                  }
                  break;
               case (2): //2 Means match meanings test.
                  if(practiseList.size() > 3) {
                     if (((listOfAssessment.isEmpty()) || !(listOfAssessment.getLast() instanceof MatchTheMeaningQuestion))) {
                        generatedAssessment = generateMatchMeaning(practiseList);
                        break;
                     }
                  }
                  numberToGenerate--;
                  break;
            }
            if(generatedAssessment != null) {
               listOfAssessment.add(generatedAssessment);
            }
         }
         AssessmentGenerator.listOfAssessment = listOfAssessment;
         goToNextQuestion();
      }
      return listOfAssessment;
   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘Match The Meanings’, using the dictionary's
    * practice words as the parameter.
    *
    * @return
    */
   public static Question generateMatchMeaning(LinkedList<DictionaryEntry> practiceList) {
      Random rand = new Random();
      LinkedList<DictionaryEntry> answerList = new LinkedList<>();

      int successfulAnswersSelected = 0;
      while (successfulAnswersSelected < 4) {
         DictionaryEntry selectedAnswer;
         selectedAnswer = practiceList.get(rand.nextInt(practiceList.size()));
         if (answerList.contains(selectedAnswer)) {
            continue;
         }
         answerList.add(selectedAnswer);
         successfulAnswersSelected++;
      }

      return new MatchTheMeaningQuestion(answerList.toArray(DictionaryEntry[]::new));
   }

   /**
    * Method
    * that will generate a list of questions that are the type ‘6 Meanings’, using the dictionary's practice
    * words as the parameter.
    *
    * @return
    */
   public static Question generateSixMeanings(LinkedList<DictionaryEntry> practiseList) {
      Random rand = new Random();
      DictionaryEntry wordToTranslate = practiseList.get(rand.nextInt(practiseList.size()));
      return new SixMeaningsQuestion(wordToTranslate, Application.dictionary);
   }

   /**
    * Method that
    * will generate a list of questions that are the type ‘Translation’, using the dictionary's practice words as
    * the parameter.
    *
    * @return
    */
   public static Question generateTranslationTest(LinkedList<DictionaryEntry> practiceList) {
      Random rand = new Random();
      DictionaryEntry selectedCorrectAnswer;
      selectedCorrectAnswer = practiceList.get(rand.nextInt(practiceList.size()));
      return new TranslationQuestion(selectedCorrectAnswer);
   }


   /**
    * Method uses currentAssessment as pointer to go to next question in assessment list.
    * Uses a switch case statement to choose the appropriate type of question.
    */
   public static void goToNextQuestion() {
      if (currentAssessment > 0){
         Question.showFeedback();
      }
      if (currentAssessment < 10) {

         Question currentQuestion = listOfAssessment.get(currentAssessment);

         if (currentQuestion instanceof MatchTheMeaningQuestion) {
            MatchTheMeaningController.answer = ((MatchTheMeaningQuestion) currentQuestion).getCorrectAnswer();
            ScreenSwitch.swap(ScreenSwitch.SceneType.matchMeaningScene);
         } else if (currentQuestion instanceof SixMeaningsQuestion) {
            SixMeaningsController.allQuestions = ((SixMeaningsQuestion) currentQuestion).getCorrectAnswer();
            ScreenSwitch.swap(ScreenSwitch.SceneType.sixMeaningScene);
         } else if (currentQuestion instanceof TranslationQuestion) {
            TranslationController.answer = ((TranslationQuestion) currentQuestion).getCorrectAnswer();
            ScreenSwitch.swap(ScreenSwitch.SceneType.translationScene);
         } else {
            System.err.print("The question has not been recognised");
            System.err.println(currentQuestion);
         }
         currentAssessment++;

      } else {

         ButtonType yesBtn = new ButtonType("Yes");
         ButtonType noBtn = new ButtonType("No");



         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setTitle("You finished the tests");
         alert.setHeaderText("You finished the tests\n Well Done!");
         alert.setResizable(false);
         String sb = "You got " +
                 new DecimalFormat("#").format(((double) (totalCorrectAnswers * 100) / (double) totalAnswers)) +
                 "%" +
                 "\n Would you like to test yourself again?";
         alert.setContentText(sb);
         alert.getButtonTypes().clear();
         alert.getButtonTypes().addAll(yesBtn, noBtn);

         Optional<ButtonType> result = alert.showAndWait();

         currentAssessment = 0;

         reset();
         if (result.isEmpty() || result.get() == noBtn) {
            ScreenSwitch.swap(ScreenSwitch.SceneType.dictionaryScene);
         } else {
            generateAssessment(Application.practiceList);
         }
      }
   }

   public static int getTotalCorrectAnswers() {
      return totalCorrectAnswers;
   }

   public static int getTotalAnswers() {
      return totalAnswers;
   }

   public static boolean isEnglish() {
      return isEnglishList;
   }

   /**
    * Method for resetting assessment to default state.
    */
   public static void reset(){
      totalCorrectAnswers = 0;
      totalAnswers =0;
      listOfAssessment = new LinkedList<>();
      currentAssessment = 0;
   }
}
