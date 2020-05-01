/*
 * @(#) SixMeaningsController.java 0,1 2020/05/01
 *
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
   private String wordCounterPart;
   private final boolean isEnglish = AssessmentGenerator.isEnglish();

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
    * Method that intialises 'sixmeanings.fxml' by setting up the menu and also setting the question words onto the screen.
    * This method is called automatically when 'sixmeanings.fxml' runs.
    *
    * @see SharedCodeController
    * @see AssessmentGenerator
    */
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

   /**
    * Event that runs when the user clicks the first answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer1' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer1() {
      wordCounterPart = possibleAnswer1.getText();
      checkAnswers();
   }

   /**
    * Event that runs when the user clicks the second answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer2' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer2() {
      // Set 'wordCounterPart' to the value of 'possibleAnswer2'.
      wordCounterPart = possibleAnswer2.getText();
      checkAnswers();
   }

   /**
    * Event that runs when the user clicks the third answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer3' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer3() {
      // Set 'wordCounterPart' to the value of 'possibleAnswer3'.
      wordCounterPart = possibleAnswer3.getText();
      checkAnswers();
   }

   /**
    * Event that runs when the user clicks the fourth answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer4' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer4() {
      // Set 'wordCounterPart' to the value of 'possibleAnswer4'.
      wordCounterPart = possibleAnswer4.getText();
      checkAnswers();
   }

   /**
    * Event that runs when the user clicks the fifth answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer5' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer5() {
      // Set 'wordCounterPart' to the value of 'possibleAnswer5'.
      wordCounterPart = possibleAnswer5.getText();
      checkAnswers();
   }

   /**
    * Event that runs when the user clicks the sixth answer from the six options. This sets the 'wordCounterPart' to
    * the value in 'possibleAnswer6' before checking the answer.
    *
    * @see Text
    */
   @FXML
   void answer6() {
      // Set 'wordCounterPart' to the value of 'possibleAnswer6'.
      wordCounterPart = possibleAnswer6.getText();
      checkAnswers();
   }

   /**
    * Method that sets up the SIxMeanings question onto the screen. It firstly starts by checking the type of question
    * and displaying the possible answer based off of this.
    *
    * @param questions ArrayList of DictionaryEntry's that contains the definition being tested along with other defintions with the first item being the question.
    * @param orderList ArrayList of integers that 0-5 that is shuffled to randomise the order of possible answers in the question.
    * @see DictionaryEntry
    * @see Integer
    * */
   public void setWords(ArrayList<DictionaryEntry> questions, ArrayList<Integer> orderList) {

      if (isEnglish) {
         // If the question is in english, display the possible answers in the welsh.
         wordSet.add(questions.get(0));

         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getEnglish());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         // Put all of the answers into the FXML Text elements.
         possibleAnswer1.setText(questions.get(orderList.get(0)).getWelsh());
         possibleAnswer2.setText(questions.get(orderList.get(1)).getWelsh());
         possibleAnswer3.setText(questions.get(orderList.get(2)).getWelsh());
         possibleAnswer4.setText(questions.get(orderList.get(3)).getWelsh());
         possibleAnswer5.setText(questions.get(orderList.get(4)).getWelsh());
         possibleAnswer6.setText(questions.get(orderList.get(5)).getWelsh());
      } else {
         // Else display the possible answers in the welsh.
         wordSet.add(questions.get(0));

         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getWelsh());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         // Put all of the answers into the FXML Text elements.
         possibleAnswer1.setText(questions.get(orderList.get(0)).getEnglish());
         possibleAnswer2.setText(questions.get(orderList.get(1)).getEnglish());
         possibleAnswer3.setText(questions.get(orderList.get(2)).getEnglish());
         possibleAnswer4.setText(questions.get(orderList.get(3)).getEnglish());
         possibleAnswer5.setText(questions.get(orderList.get(4)).getEnglish());
         possibleAnswer6.setText(questions.get(orderList.get(5)).getEnglish());

      }

   }

   /**
    * Method checks the answer the user has submitted against the questions correct answer. This works by passing in the users
    * 'wordCounterPart' answer with the correct answer into the Question class which does the checking before moving onto the next question.
    *
    * @see Question
    * @see AssessmentGenerator
    */
   public void checkAnswers() {

      // Add the users answer into an ArrayList.
      ArrayList<String> answer = new ArrayList<>();
      answer.add(wordCounterPart);

      // Call the Question's checkAnswer method to look if the user has selected the correct answer.
      Question.checkAnswer(wordSet, answer, isEnglish);

      // Clear the wordset and move to the next question.
      wordSet.clear();
      AssessmentGenerator.goToNextQuestion();

   }



}


