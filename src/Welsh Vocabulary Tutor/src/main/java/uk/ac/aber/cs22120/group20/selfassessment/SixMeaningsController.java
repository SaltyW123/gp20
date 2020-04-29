package uk.ac.aber.cs22120.group20.selfassessment;
/**
 * @(#) SixMeaningsController.java 0,1 2020/04/27
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.net.URL;
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
 * @version 0.1 Initial development
 * @see uk.ac.aber.cs22120.group20.javafx.Application
 */

public class SixMeaningsController implements Initializable {

   private ArrayList<DictionaryEntry> wordSet = new ArrayList<>();
   public static ArrayList<DictionaryEntry> allQuestions = new ArrayList<>();
   private ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5));
   private String wordCounterpart;
   private boolean isEnglish = AssessmentGenerator.isEnglish;


   @FXML
   private Text correctAnswer;

   @FXML
   private Text wrongAnswer;

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

   @FXML
   void answer1(MouseEvent event) {
      wordCounterpart = possibleAnswer1.getText();
      checkAnswers();
   }
   @FXML
   void answer2(MouseEvent event) {
      wordCounterpart = possibleAnswer2.getText();
      checkAnswers();
   }
   @FXML
   void answer3(MouseEvent event) {
      wordCounterpart = possibleAnswer3.getText();
      checkAnswers();
   }
   @FXML
   void answer4(MouseEvent event) {
      wordCounterpart = possibleAnswer4.getText();
      checkAnswers();
   }
   @FXML
   void answer5(MouseEvent event) {
      wordCounterpart = possibleAnswer5.getText();
      checkAnswers();
   }
   @FXML
   void answer6(MouseEvent event) {
      wordCounterpart = possibleAnswer6.getText();
      checkAnswers();
   }


   private void getWords() {

      wordSet = AssessmentGenerator.generateSixMeanings();

   }



   private void setWords(boolean isEnglish){
      if(isEnglish){

         wordSet.add(allQuestions.get(0));

         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getEnglish());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         possibleAnswer1.setText(allQuestions.get(orderList.get(0)).getWelsh());
         possibleAnswer2.setText(allQuestions.get(orderList.get(1)).getWelsh());
         possibleAnswer3.setText(allQuestions.get(orderList.get(2)).getWelsh());
         possibleAnswer4.setText(allQuestions.get(orderList.get(3)).getWelsh());
         possibleAnswer5.setText(allQuestions.get(orderList.get(4)).getWelsh());
         possibleAnswer6.setText(allQuestions.get(orderList.get(5)).getWelsh());
      }else {

         wordSet.add(allQuestions.get(0));
         //WelshWord1 Is the question word and as a result is always right.
         wordToTranslate.setText(wordSet.get(0).getWelsh());
         //This stores the correct answer for the english word.

         Collections.shuffle(orderList);

         possibleAnswer1.setText(allQuestions.get(orderList.get(0)).getEnglish());
         possibleAnswer2.setText(allQuestions.get(orderList.get(1)).getEnglish());
         possibleAnswer3.setText(allQuestions.get(orderList.get(2)).getEnglish());
         possibleAnswer4.setText(allQuestions.get(orderList.get(3)).getEnglish());
         possibleAnswer5.setText(allQuestions.get(orderList.get(4)).getEnglish());
         possibleAnswer6.setText(allQuestions.get(orderList.get(5)).getEnglish());

      }

   }



   private void checkAnswers() {

      ArrayList<String> answer = new ArrayList<>();

      answer.add(wordCounterpart);

      Question.checkAnswer(wordSet,answer,isEnglish);

      correctAnswer.setText(Integer.toString(Question.correctAnswers));

      wrongAnswer.setText(Integer.toString(Question.wrongAnswers));

      wordSet.clear();

      AssessmentGenerator.goToNextQuestion();

   }


   private void prepare() {
      getWords();
      Random rd = new Random();
      System.out.println(rd.nextBoolean());
      setWords(AssessmentGenerator.isEnglish);
   }


   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      this.prepare();

   }

}


