package uk.ac.aber.cs221.group20.selfassessment;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;

import java.util.ArrayList;


/**
 * Abstract class contains the basic information that all the shared information between the
 * types of test questions including the questions’ correct answers and possible answers. All question
 * classes will extend this class.
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 */
public class Question {

   public static int correctAnswers = 0;
   public static int wrongAnswers =0;
   public static StringBuilder sb = new StringBuilder();

   /** Function that checks the answers of
    *
    * @param listOfCorrectQuestions List of the right answers to the question.
    * @param listOfAnswers List of the answers the user input.
    * @param isEnglish Boolean for if the test is English To Welsh or Welsh To English
    */
   public static void  checkAnswer(ArrayList<DictionaryEntry> listOfCorrectQuestions, ArrayList<String>listOfAnswers, boolean isEnglish){

      if(isEnglish){
         for(int i=0; i<listOfCorrectQuestions.size();i++){

            sb
                    .append("'").append(listOfCorrectQuestions.get(i).getEnglish()).append("'")
                    .append(" is the English for ")
                    .append("'").append(listOfCorrectQuestions.get(i).getWelsh()).append("'")
                    .append(". ");
            if(listOfCorrectQuestions.get(i).getWelsh().equalsIgnoreCase(listOfAnswers.get(i))){
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

            if(listOfCorrectQuestions.get(i).getEnglish().equalsIgnoreCase(listOfAnswers.get(i))){
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
   /**
    * Function for giving user positive or negative feedback for when they answer a question during an assessment.
    */

   static void showFeedback(){
      Alert alert = new Alert(Alert.AlertType.INFORMATION);

      alert.setTitle("You finished this part of the assessment!");
      alert.setHeaderText("You finished this part of the assessment!");
      String sb = "You got " + correctAnswers + " out of " + (correctAnswers + wrongAnswers) + "\n" +
              Question.sb.toString();
      Label label = new Label(sb);
      label.setWrapText(true);
      alert.getDialogPane().setContent(label);
      alert.showAndWait();
      Question.sb = new StringBuilder();

      AssessmentGenerator.totalCorrectAnswers += correctAnswers;
      AssessmentGenerator.totalAnswers += (wrongAnswers + correctAnswers);

      resetScore();
   }

   /**
    * Resets the score to 0 for the next test.
    */
   private static void resetScore(){
      correctAnswers = 0;
      wrongAnswers =0;
   }

}