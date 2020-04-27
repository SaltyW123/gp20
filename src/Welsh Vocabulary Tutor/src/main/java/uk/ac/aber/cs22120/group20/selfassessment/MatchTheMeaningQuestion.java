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
 * @see Main
 */


public class MatchTheMeaningQuestion implements Initializable {

    private Random rand = new Random();
    private LinkedList<DictionaryEntry> setOfQuestions=new LinkedList<>();
    private ArrayList<Integer> orderList = new ArrayList<>(Arrays.asList(0,1,2,3));
    private int corAns = 0;
    private int wrongAns = 0;


    @FXML
    private ComboBox<String> word1;

    @FXML
    private ComboBox<String> word2;

    @FXML
    private ComboBox<String> word3;

    @FXML
    private ComboBox<String> word4;

    @FXML
    private Label EngWord1;

    @FXML
    private Label EngWord2;

    @FXML
    private Label EngWord3;

    @FXML
    private Label EngWord4;

    @FXML
    private Label WelshWord1;

    @FXML
    private Label WelshWord2;

    @FXML
    private Label WelshWord3;

    @FXML
    private Label WelshWord4;

    @FXML
    private Label CorrectAnswer;

    @FXML
    private Label WrongAnswer;


    /**
     * Pick randomly dictionary entry and add it to question list where are stored questions for this test.
     *
     * @param dictionary main list of dictionary entries with words.
     */
    private void getQuestions(LinkedList<DictionaryEntry> dictionary){

        boolean isDuplicate = false;

        do{
            int rand_q=rand.nextInt(dictionary.size()-1);

            DictionaryEntry pickedQuestion = dictionary.get(rand_q);

            //If size of list is greater than 1 check for duplicates...
            if(setOfQuestions.size()>=1){

                for (DictionaryEntry setOfQuestion : setOfQuestions) {

                    //If it is duplicate change isDuplicate to true and break
                    if (setOfQuestion.equals(pickedQuestion)) {
                        isDuplicate = true;
                        break;
                    }

                }

                //If duplicate wasn't found add entry to the list
                if(!isDuplicate){
                    setOfQuestions.add(pickedQuestion);
                }

            //... otherwise, add entry to the
            }else{
                setOfQuestions.add(pickedQuestion);
            }

            isDuplicate =false;

        }while(setOfQuestions.size()<5);
    }

    /**
     * Set chosen words from dictionary on the scene.
     *
     * @param questions list of dictionary entries chosen for this test.
     * @param orderList list of integers to change way of displaying welsh words.
     */


    private void setWords(LinkedList<DictionaryEntry> questions, ArrayList<Integer> orderList){
        EngWord1.setText(questions.get(0).getEnglish());
        EngWord2.setText(questions.get(1).getEnglish());
        EngWord3.setText(questions.get(2).getEnglish());
        EngWord4.setText(questions.get(3).getEnglish());

        Collections.shuffle(orderList);

        WelshWord1.setText(questions.get(orderList.get(0)).getWelsh());
        WelshWord2.setText(questions.get(orderList.get(1)).getWelsh());
        WelshWord3.setText(questions.get(orderList.get(2)).getWelsh());
        WelshWord4.setText(questions.get(orderList.get(3)).getWelsh());
    }

    /**
     * Check if answers from users are correct.
     */

    public void checkAnswers(){
        int w1 = Integer.parseInt(word1.getValue())-1;
        int w2 = Integer.parseInt(word2.getValue())-1;
        int w3 = Integer.parseInt(word3.getValue())-1;
        int w4 = Integer.parseInt(word4.getValue())-1;

        if(setOfQuestions.get(w1).getWelsh().equals(WelshWord1.getText())){
            corAns++;
        }else wrongAns++;

        if(setOfQuestions.get(w2).getWelsh().equals(WelshWord2.getText())){
            corAns++;
        }else wrongAns++;

        if(setOfQuestions.get(w3).getWelsh().equals(WelshWord3.getText())){
            corAns++;
        }else wrongAns++;

        if(setOfQuestions.get(w4).getWelsh().equals(WelshWord4.getText())){
            corAns++;
        }else wrongAns++;

        CorrectAnswer.setText(Integer.toString(corAns));

        WrongAnswer.setText(Integer.toString(wrongAns));

        setOfQuestions.clear();
        this.prepare();

    }

    /**
     * Method responsible for preparing questions and scene.
     */
    private void prepare(){
        getQuestions(Main.dictionary);
        setWords(setOfQuestions,orderList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.prepare();

    }
}
