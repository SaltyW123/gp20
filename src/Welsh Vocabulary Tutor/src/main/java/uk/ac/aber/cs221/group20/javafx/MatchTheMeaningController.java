package uk.ac.aber.cs221.group20.javafx;
/**
 * @(#) MyController.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;

import java.util.*;

/**
 * A class that generate questions and check answers for match the meaning test.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakobik [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.4 Initial development
 * @see Application
 */


public class MatchTheMeaningController extends SharedCodeController {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   public static ArrayList<DictionaryEntry> answer =new ArrayList<>();

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

   private ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0,1,2,3));
   private boolean isEnglish = AssessmentGenerator.isEnglish;

   @FXML
   private ComboBox<String> word1;

   @FXML
   private ComboBox<String> word2;

   @FXML
   private ComboBox<String> word3;

   @FXML
   private ComboBox<String> word4;

   @FXML
   private Label LeftWord1;

   @FXML
   private Label LeftWord2;

   @FXML
   private Label LeftWord3;

   @FXML
   private Label LeftWord4;

   @FXML
   private Label RightWord1;

   @FXML
   private Label RightWord2;

   @FXML
   private Label RightWord3;

   @FXML
   private Label RightWord4;

   @FXML
   private Label CorrectAnswer;

   @FXML
   private Label WrongAnswer;

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Set chosen words from dictionary on the scene.
    *
    * @param questions list of dictionary entries chosen for this test.
    * @param orderList list of integers to change way of displaying welsh words.
    */


   public void setWords(ArrayList<DictionaryEntry> questions, ArrayList<Integer> orderList){


      if(isEnglish){
         LeftWord1.setText(questions.get(0).getEnglish());
         LeftWord2.setText(questions.get(1).getEnglish());
         LeftWord3.setText(questions.get(2).getEnglish());
         LeftWord4.setText(questions.get(3).getEnglish());

         Collections.shuffle(orderList);

         RightWord1.setText(questions.get(orderList.get(0)).getWelsh());
         RightWord2.setText(questions.get(orderList.get(1)).getWelsh());
         RightWord3.setText(questions.get(orderList.get(2)).getWelsh());
         RightWord4.setText(questions.get(orderList.get(3)).getWelsh());

      }else {
         LeftWord1.setText(questions.get(0).getWelsh());
         LeftWord2.setText(questions.get(1).getWelsh());
         LeftWord3.setText(questions.get(2).getWelsh());
         LeftWord4.setText(questions.get(3).getWelsh());

         Collections.shuffle(orderList);

         RightWord1.setText(questions.get(orderList.get(0)).getEnglish());
         RightWord2.setText(questions.get(orderList.get(1)).getEnglish());
         RightWord3.setText(questions.get(orderList.get(2)).getEnglish());
         RightWord4.setText(questions.get(orderList.get(3)).getEnglish());
      }

   }

   /**
    * Check if answers from users are correct.
    */

   public void checkAnswers(){
      ArrayList<DictionaryEntry> answers = new ArrayList<>();
      ArrayList<String> listOfAnswers = new ArrayList<>();

      answers.add(answer.get(Integer.parseInt(word1.getValue())-1));
      answers.add(answer.get(Integer.parseInt(word2.getValue())-1));
      answers.add(answer.get(Integer.parseInt(word3.getValue())-1));
      answers.add(answer.get(Integer.parseInt(word4.getValue())-1));

      if(isEnglish){
         listOfAnswers.add(LeftWord1.getText());
         listOfAnswers.add(LeftWord2.getText());
         listOfAnswers.add(LeftWord3.getText());
         listOfAnswers.add(LeftWord4.getText());


      }else {
         listOfAnswers.add(RightWord1.getText());
         listOfAnswers.add(RightWord2.getText());
         listOfAnswers.add(RightWord3.getText());
         listOfAnswers.add(RightWord4.getText());

      }

      if(checkForDuplicates(answers)){
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Please check answers");
         alert.setContentText("Please ensure you have selected answers for each test word, with no duplicates.");
         alert.showAndWait();
      }else {

         Question.checkAnswer(answers, listOfAnswers, isEnglish);


         answer.clear();
         AssessmentGenerator.goToNextQuestion();
      }
   }
      private boolean checkForDuplicates(ArrayList<DictionaryEntry> wordSet){
         boolean result = false;
         Set<DictionaryEntry> set = new HashSet<>(wordSet);

         if(set.size() < wordSet.size()){
            result = true;
         }
         return result;
      }



      @FXML
   private void initialize() {
      setup();
      currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
      currentPageText.setText("Study");

      studyIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/pass-fail-50.png"));
      studyText.setFill(Color.BLACK);

      setWords(answer,orderList);
      CorrectAnswer.setText(": " + Integer.toString(AssessmentGenerator.getTotalCorrectAnswers()));
      WrongAnswer.setText(": " + Integer.toString(AssessmentGenerator.getTotalAnswers()));

   }
}
