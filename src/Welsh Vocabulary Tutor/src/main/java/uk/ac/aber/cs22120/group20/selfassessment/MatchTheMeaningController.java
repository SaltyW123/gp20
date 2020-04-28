package uk.ac.aber.cs22120.group20.selfassessment;
/**
 * @(#) MyController.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
 * @version 0.4 Initial development
 * @see uk.ac.aber.cs22120.group20.javafx.Application
 */


public class MatchTheMeaningController extends Question implements Initializable{


   private ArrayList<DictionaryEntry> setOfQuestions=new ArrayList<>();
   private ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0,1,2,3));
   private boolean isEnglish;


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


   /**
    * Pick randomly dictionary entry and add it to question list where are stored questions for this test.
    */
   private void getQuestions(){

      setOfQuestions.addAll(AssessmentGenerator.generateWordMatch());

   }

   /**
    * Set chosen words from dictionary on the scene.
    *
    * @param questions list of dictionary entries chosen for this test.
    * @param orderList list of integers to change way of displaying welsh words.
    */


   private void setWords(ArrayList<DictionaryEntry> questions, ArrayList<Integer> orderList){

      if(isEnglish){
         LeftWord1.setText(questions.get(0).getEnglish());
         LeftWord2.setText(questions.get(1).getEnglish());
         LeftWord3.setText(questions.get(2).getEnglish());
         LeftWord4.setText(questions.get(3).getEnglish());

         Collections.shuffle(orderList);

         RightWord1.setText(questions.get(orderList.get(0)).getWelsh());
         RightWord1.setText(questions.get(orderList.get(1)).getWelsh());
         RightWord1.setText(questions.get(orderList.get(2)).getWelsh());
         RightWord1.setText(questions.get(orderList.get(3)).getWelsh());

      }else {
         LeftWord1.setText(questions.get(0).getWelsh());
         LeftWord2.setText(questions.get(1).getWelsh());
         LeftWord3.setText(questions.get(2).getWelsh());
         LeftWord4.setText(questions.get(3).getWelsh());

         Collections.shuffle(orderList);

         RightWord1.setText(questions.get(orderList.get(0)).getEnglish());
         RightWord1.setText(questions.get(orderList.get(1)).getEnglish());
         RightWord1.setText(questions.get(orderList.get(2)).getEnglish());
         RightWord1.setText(questions.get(orderList.get(3)).getEnglish());
      }

   }

   /**
    * Check if answers from users are correct.
    */

   public void checkAnswers(){
      ArrayList<String> listOfAnswers = new ArrayList<>();
      if(isEnglish){
         listOfAnswers.add(RightWord1.getText());
         listOfAnswers.add(RightWord2.getText());
         listOfAnswers.add(RightWord3.getText());
         listOfAnswers.add(RightWord4.getText());
      }else {
         listOfAnswers.add(LeftWord1.getText());
         listOfAnswers.add(LeftWord2.getText());
         listOfAnswers.add(LeftWord3.getText());
         listOfAnswers.add(LeftWord4.getText());
      }

      checkAnswer(setOfQuestions,listOfAnswers,isEnglish);

      CorrectAnswer.setText(Integer.toString(correctAnswers));
      WrongAnswer.setText(Integer.toString(wrongAnswers));

      setOfQuestions.clear();
      this.prepare();

   }

   /**
    * Method responsible for preparing questions and scene.
    */
   private void prepare(){
      getQuestions();
      setWords(setOfQuestions,orderList);
   }

   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {

      this.prepare();

   }
}