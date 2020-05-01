/**
 * @(#) SixMeaningsController.java 0,1 2020/04/27
 *
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A class that generate questions and check answers for match the meaning test.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakobik [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see Application
 */

public class SixMeaningsController extends SharedCodeController {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   public static ArrayList<DictionaryEntry> allQuestions = new ArrayList<>();

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

   private final ArrayList<DictionaryEntry> wordSet = new ArrayList<>();
   private final ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
   private String wordCounterpart;
   private final boolean isEnglish = AssessmentGenerator.isEnglish;

   @FXML
   private Label correctAnswer;

   @FXML
   private Label wrongAnswer;

   @FXML
   private Label wordToTranslate;

   @FXML
   private Text possibleAnswer1;

   @FXML
   private Text possibleAnswer2;

   @FXML
   private Text possibleAnswer3;

   @FXML
   private Text possibleAnswer4;

   @FXML
   private Text possibleAnswer5;

   @FXML
   private Text possibleAnswer6;

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Event that runs when the user clicks the first answer from the six options. 
    */
   @FXML
   void answer1() {
      wordCounterpart = possibleAnswer1.getText();
      checkAnswers();
   }

   @FXML
   void answer2() {
      wordCounterpart = possibleAnswer2.getText();
      checkAnswers();
   }

   @FXML
   void answer3() {
      wordCounterpart = possibleAnswer3.getText();
      checkAnswers();
   }

   @FXML
   void answer4() {
      wordCounterpart = possibleAnswer4.getText();
      checkAnswers();
   }

   @FXML
   void answer5() {
      wordCounterpart = possibleAnswer5.getText();
      checkAnswers();
   }

   @FXML
   void answer6() {
      wordCounterpart = possibleAnswer6.getText();
      checkAnswers();
   }


   public void setWords(ArrayList<DictionaryEntry> questions, ArrayList<Integer> orderList) {

      if (isEnglish) {

         wordSet.add(questions.get(0));

         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getEnglish());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         possibleAnswer1.setText(questions.get(orderList.get(0)).getWelsh());
         possibleAnswer2.setText(questions.get(orderList.get(1)).getWelsh());
         possibleAnswer3.setText(questions.get(orderList.get(2)).getWelsh());
         possibleAnswer4.setText(questions.get(orderList.get(3)).getWelsh());
         possibleAnswer5.setText(questions.get(orderList.get(4)).getWelsh());
         possibleAnswer6.setText(questions.get(orderList.get(5)).getWelsh());
      } else {

         wordSet.add(questions.get(0));
         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getWelsh());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         possibleAnswer1.setText(questions.get(orderList.get(0)).getEnglish());
         possibleAnswer2.setText(questions.get(orderList.get(1)).getEnglish());
         possibleAnswer3.setText(questions.get(orderList.get(2)).getEnglish());
         possibleAnswer4.setText(questions.get(orderList.get(3)).getEnglish());
         possibleAnswer5.setText(questions.get(orderList.get(4)).getEnglish());
         possibleAnswer6.setText(questions.get(orderList.get(5)).getEnglish());

      }

   }


   public void checkAnswers() {

      ArrayList<String> answer = new ArrayList<>();

      answer.add(wordCounterpart);

      Question.checkAnswer(wordSet, answer, isEnglish);


      wordSet.clear();

      AssessmentGenerator.goToNextQuestion();

   }


   @FXML
   private void initialize() {
      setup();
      currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
      currentPageText.setText("Study");

      studyIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/pass-fail-50.png"));
      studyText.setFill(Color.BLACK);

      setWords(allQuestions, orderList);

      correctAnswer.setText(": " + Integer.toString(AssessmentGenerator.getTotalCorrectAnswers()));

      wrongAnswer.setText(": " + Integer.toString(AssessmentGenerator.getTotalAnswers()));

   }

}


