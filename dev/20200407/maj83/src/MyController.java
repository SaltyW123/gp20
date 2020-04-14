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

    @FXML
    private ComboBox<?> word1;

    @FXML
    private ComboBox<?> word2;

    @FXML
    private ComboBox<?> word3;

    @FXML
    private ComboBox<?> word4;

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
            if(setOfQuestions.size()>1){
                for(int i=0;i<setOfQuestions.size();i++){
                    if(setOfQuestions.get(i).equals(pickedQuestion)){
                        break;
                    }else {
                        setOfQuestions.add(pickedQuestion);
                    }
                }
            }else{
                setOfQuestions.add(pickedQuestion);
            }

        }while(setOfQuestions.size()<5);
        return setOfQuestions;
    }

    private void fill(){
        setOfQuestions.add(new DictionaryEntry("abbey", "abaty", "nm"));
        setOfQuestions.add(new DictionaryEntry("believe", "credu", "verb"));
        setOfQuestions.add(new DictionaryEntry("concert", "cyngerdd", "nm"));
        setOfQuestions.add(new DictionaryEntry("disease", "clefyd", "nm"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fill();
        TestLabel(setOfQuestions,temp1);
    }
}
