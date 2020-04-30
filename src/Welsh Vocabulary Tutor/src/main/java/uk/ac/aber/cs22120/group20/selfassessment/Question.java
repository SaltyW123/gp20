package uk.ac.aber.cs22120.group20.selfassessment;

import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
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
      StringBuilder sb;
      if(isEnglish){
         for(int i=0; i<listOfCorrectQuestions.size();i++){
            sb = new StringBuilder();
            sb.append(listOfAnswers.get(i)).append(" is the Welsh for ").append(listOfCorrectQuestions.get(i).getEnglish());
            if(listOfCorrectQuestions.get(i).getWelsh().equals(listOfAnswers.get(i))){
               correctAnswers++;
               feedbackAnswer(sb.toString(), true);
            }else{
               wrongAnswers++;
               feedbackAnswer(sb.toString(), false);
            }
         }
      }else{
         for(int i=0; i<listOfCorrectQuestions.size();i++){
            sb = new StringBuilder();
            sb.append(listOfAnswers.get(i)).append(" is the English for ").append(listOfCorrectQuestions.get(i).getWelsh());
            if(listOfCorrectQuestions.get(i).getEnglish().equals(listOfAnswers.get(i))){
               correctAnswers++;
               feedbackAnswer(sb.toString(), true);
            }else{
               wrongAnswers++;
               feedbackAnswer(sb.toString(), false);
            }
         }
      }
   }

   private static void feedbackAnswer(String dialogMessageText, boolean isCorrect){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      if (isCorrect) {
         alert.setTitle("Correct!");
         alert.setHeaderText("You got the right answer!");
      }else{
         alert.setTitle("Incorrect");
         alert.setHeaderText("Sorry, that was incorrect");
      }
      alert.setContentText(dialogMessageText);
      alert.showAndWait();
   }

   public static void resetScore(){
      correctAnswers = 0;
      wrongAnswers =0;
   }

}