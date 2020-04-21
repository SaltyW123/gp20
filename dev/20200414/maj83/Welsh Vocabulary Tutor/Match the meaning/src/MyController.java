import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class MyController implements Initializable {

    private Random rand = new Random();
    public LinkedList<DictionaryEntry> setOfQuestions=new LinkedList<>();
    private ArrayList<Integer> temp1 = new ArrayList<>(Arrays.asList(0,1,2,3));
    private int corAns = 0;
    private int wrongAns = 0;
    private boolean isDuplicate = false;

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


    private void TestLabel(LinkedList<DictionaryEntry> questions, ArrayList<Integer> randOrder){
        EngWord1.setText(questions.get(0).getEnglish());
        EngWord2.setText(questions.get(1).getEnglish());
        EngWord3.setText(questions.get(2).getEnglish());
        EngWord4.setText(questions.get(3).getEnglish());

        Collections.shuffle(randOrder);

        WelshWord1.setText(questions.get(randOrder.get(0)).getWelsh());
        WelshWord2.setText(questions.get(randOrder.get(1)).getWelsh());
        WelshWord3.setText(questions.get(randOrder.get(2)).getWelsh());
        WelshWord4.setText(questions.get(randOrder.get(3)).getWelsh());
    }

    private LinkedList<DictionaryEntry> getQuestions(LinkedList<DictionaryEntry> dictionary){

        do{
            int rand_q=rand.nextInt(dictionary.size()-1);
            DictionaryEntry pickedQuestion = dictionary.get(rand_q);
            if(setOfQuestions.size()>=1){
                for (DictionaryEntry setOfQuestion : setOfQuestions) {
                    if (setOfQuestion.equals(pickedQuestion)) {
                        isDuplicate = true;
                        break;
                    }
                }
                if(!isDuplicate){
                    setOfQuestions.add(pickedQuestion);
                }
            }else{
                setOfQuestions.add(pickedQuestion);
            }
            isDuplicate =false;
        }while(setOfQuestions.size()<5);
        return setOfQuestions;
    }


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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getQuestions(Main.dictionary);
        TestLabel(setOfQuestions,temp1);
    }
}
