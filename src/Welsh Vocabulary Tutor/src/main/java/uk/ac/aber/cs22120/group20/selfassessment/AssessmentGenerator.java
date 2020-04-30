package uk.ac.aber.cs22120.group20.selfassessment;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import uk.ac.aber.cs22120.group20.javafx.*;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.util.*;


/**
 * Class that contains methods to create a randomised list of questions that will
 * contain a random distribution of question types.
 *
 * @Author
 * @Version
 * @See
 */
public class AssessmentGenerator {
    public static boolean isEnglish;
    static LinkedList<Question> listOfAssessment = new LinkedList<>();
    static int currentAssessment = 0;

    /**
     * Method that will generate a randomized list of questions consisting of random distribution of questions
     * types, using the dictionary’s practice words as the parameter.
     *
     * @param practiseList
     * @return
     */
    public static LinkedList<Question> generateAssessment(LinkedList<DictionaryEntry> practiseList) {
        LinkedList<Question> listOfAssessment = new LinkedList<>();
        Random rand = new Random();

        //int wordToTranslatePlace;

        if (practiseList.size()<5){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not enough words in practice list");
            alert.setResizable(false);
            alert.setContentText("Please add more words to your practice list on the dictionary page before trying to test yourself!");
            alert.showAndWait();
        }else {

            for (int numberToGenerate = 0; numberToGenerate < 10; numberToGenerate++) {
                Question generatedAssessment = null;
                int quizType = rand.nextInt(3);
                switch (quizType) {
                    case (0): //0 Means translation test.
                        //wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
                        //wordToTranslate = Application.practiseList.get(wordToTranslatePlace);
                        if((listOfAssessment.isEmpty()) || !(listOfAssessment.getLast() instanceof TranslationQuestion)){
                            generatedAssessment = generateTranslationTest(practiseList);
                        }else {
                            numberToGenerate--;
                        }
                        break;
                    case (1): //1 Means six meanings test.
                        //wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
                        //wordToTranslate = Application.practiseList.get(wordToTranslatePlace);
                        if(((listOfAssessment.isEmpty())) || !(listOfAssessment.getLast() instanceof SixMeaningsQuestion)){
                            generatedAssessment = generateSixMeanings(practiseList);
                        }else {
                            numberToGenerate--;
                        }
                        break;
                    case (2): //2 Means match meanings test.
//               LinkedList<DictionaryEntry> wordsToTranslate = new LinkedList<>();
//               for (int i = 0; i < 3; i++) {
//                  wordToTranslatePlace = rand.nextInt(Application.practiseList.size());
//                  wordsToTranslate.add(Application.practiseList.get(wordToTranslatePlace));
//                  wordsToTranslate.toArray();
//               }
                        if((listOfAssessment.isEmpty()) || !(listOfAssessment.getLast() instanceof MatchTheMeaningQuestion)){
                            generatedAssessment = generateMatchMeaning(practiseList);
                        }else {
                            numberToGenerate--;
                        }
                        break;
                }
                if(generatedAssessment != null) {
                    listOfAssessment.add(generatedAssessment);
                }
            }
            AssessmentGenerator.listOfAssessment = listOfAssessment;
            goToNextQuestion();
        }
        return listOfAssessment;
    }

    /**
     * Method
     * that will generate a list of questions that are the type ‘Match The Meanings’, using the dictionary's
     * practice words as the parameter.
     *
     * @return
     */
    public static Question generateMatchMeaning(LinkedList<DictionaryEntry> practiceList) {
        Random rand = new Random();
        LinkedList<DictionaryEntry> answerList = new LinkedList<>();

        int successfulAnswersSelected = 0;
        while (successfulAnswersSelected < 4) {
            DictionaryEntry selectedAnswer;
            selectedAnswer = practiceList.get(rand.nextInt(practiceList.size()));
            if (answerList.contains(selectedAnswer)) {
                continue;
            }
            answerList.add(selectedAnswer);
            successfulAnswersSelected++;
        }

        Question generatedQuestion = new MatchTheMeaningQuestion(answerList.toArray(DictionaryEntry[]::new));
        return generatedQuestion;
    }

    /**
     * Method
     * that will generate a list of questions that are the type ‘6 Meanings’, using the dictionary's practice
     * words as the parameter.
     *
     * @return
     */
    public static Question generateSixMeanings(LinkedList<DictionaryEntry> practiseList) {
        Question returnValue;
        ArrayList<DictionaryEntry> listOfAnswers = new ArrayList<>();
        Random rand = new Random();
        DictionaryEntry wordToTranslate = practiseList.get(rand.nextInt(practiseList.size()));
        SixMeaningsQuestion generatedQuestion = new SixMeaningsQuestion(wordToTranslate, Application.dictionary);
        return generatedQuestion;
    }

    /**
     * Method that
     * will generate a list of questions that are the type ‘Translation’, using the dictionary's practice words as
     * the parameter.
     *
     * @return
     */
    public static Question generateTranslationTest(LinkedList<DictionaryEntry> practiceList) {
        Random rand = new Random();
        DictionaryEntry selectedCorrectAnswer;
        selectedCorrectAnswer = practiceList.get(rand.nextInt(practiceList.size()));
        Question generatedQuestion = new TranslationQuestion(selectedCorrectAnswer);
        return generatedQuestion;
    }


    public static void goToNextQuestion() {
        if (currentAssessment < 10) {
            Question currentQuestion = listOfAssessment.get(currentAssessment);

            if (currentQuestion instanceof MatchTheMeaningQuestion) {
                MatchTheMeaningController.answer = ((MatchTheMeaningQuestion) currentQuestion).getCorrectAnswer();
                ScreenSwitch.swap(ScreenSwitch.SceneEnum.matchMeaningScene);
            } else if (currentQuestion instanceof SixMeaningsQuestion) {
                SixMeaningsController.allQuestions = ((SixMeaningsQuestion) currentQuestion).getCorrectAnswer();
                ScreenSwitch.swap(ScreenSwitch.SceneEnum.sixMeaningScene);
            } else if (currentQuestion instanceof TranslationQuestion) {
                TranslationController.answer = ((TranslationQuestion) currentQuestion).getCorrectAnswer();
                ScreenSwitch.swap(ScreenSwitch.SceneEnum.translationScene);
            } else {
                System.err.print("The question has not been recognised");
                System.err.println(currentQuestion);
            }

            currentAssessment++;
        } else {

            StringBuilder sb = new StringBuilder();
            sb.append("You got ")
                    .append(Question.correctAnswers / (Question.correctAnswers + Question.wrongAnswers))
                    .append("%")
                    .append("\n Would you like to test yourself again?");

            ButtonType yesBtn = new ButtonType("Yes");
            ButtonType noBtn = new ButtonType("No");



            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("You finished the tests");
            alert.setHeaderText("You finished the tests\n Well Done!");
            alert.setResizable(false);
            alert.setContentText(sb.toString());
            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(yesBtn, noBtn);

            Optional<ButtonType> result = alert.showAndWait();

            currentAssessment = 0;
            Question.resetScore();

            if (result.isEmpty() || result.get() == noBtn) {
               ScreenSwitch.swap(ScreenSwitch.SceneEnum.dictionaryScene);
            } else {
                generateAssessment(Application.practiceList);
            }
        }
    }
}
