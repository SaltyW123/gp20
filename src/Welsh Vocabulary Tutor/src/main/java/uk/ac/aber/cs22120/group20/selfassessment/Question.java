package uk.ac.aber.cs22120.group20.selfassessment;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
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
   public static StringBuilder sb = new StringBuilder();

   /**
    *
    * @param listOfCorrectQuestions
    * @param listOfAnswers
    * @param isEnglish
    */
   public static void  checkAnswer(ArrayList<DictionaryEntry> listOfCorrectQuestions, ArrayList<String>listOfAnswers, boolean isEnglish){

      if(isEnglish){
         for(int i=0; i<listOfCorrectQuestions.size();i++){

            sb
                    .append("'").append(listOfCorrectQuestions.get(i).getEnglish()).append("'")
                    .append(" is the English for ")
                    .append("'").append(listOfCorrectQuestions.get(i).getWelsh()).append("'")
                    .append(". ");
            if(listOfCorrectQuestions.get(i).getWelsh().equals(listOfAnswers.get(i))){
               sb.append("Correct!");
               correctAnswers++;
            }else{
               sb.append("'").append(listOfAnswers.get(i)).append("'").append(" is incorrect.");
               wrongAnswers++;
            }
            sb.append("\n");
         }
      }else{
         for(int i=0; i<listOfCorrectQuestions.size();i++){
            sb
                    .append("'").append(listOfCorrectQuestions.get(i).getEnglish()).append("'")
                    .append(" is the English for ")
                    .append("'").append(listOfCorrectQuestions.get(i).getWelsh()).append("'")
                    .append(". ");

            if(listOfCorrectQuestions.get(i).getEnglish().equals(listOfAnswers.get(i))){
               sb.append("Correct!");
               correctAnswers++;
            }else{
               sb.append("'").append(listOfAnswers.get(i)).append("'").append(" is incorrect.");
               wrongAnswers++;
            }
            sb.append("\n");
         }

      }


   }

   static void showFeedback(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      StringBuilder sb = new StringBuilder();

      sb.append("You got ").append(correctAnswers).append(" out of ").append(correctAnswers+wrongAnswers).append("\n");
      sb.append(Question.sb.toString());

      alert.setTitle("You finished this part of the assessment!");
      alert.setHeaderText("You finished this part of the assessment!");
      Label label = new Label(sb.toString());
      label.setWrapText(true);
      alert.getDialogPane().setContent(label);
      alert.showAndWait();
      Question.sb = new StringBuilder();

      AssessmentGenerator.totalCorrectAnswers += correctAnswers;
      AssessmentGenerator.totalAnswers += (wrongAnswers + correctAnswers);

      resetScore();
   }

   private static void resetScore(){
      correctAnswers = 0;
      wrongAnswers =0;
   }

}