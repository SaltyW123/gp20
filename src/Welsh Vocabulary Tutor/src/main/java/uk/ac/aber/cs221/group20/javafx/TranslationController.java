/**

@(#) TranslationController.java 1.1 2020/05/01


Copyright (c) 2020 Aberystwyth University.
All rights reserved.
*/
package uk.ac.aber.cs221.group20.javafx;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.Image;
        import javafx.scene.image.ImageView;
        import javafx.scene.paint.Color;
        import javafx.scene.text.Text;
        import uk.ac.aber.cs221.group20.json.DictionaryEntry;
        import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
        import uk.ac.aber.cs221.group20.selfassessment.Question;

        import java.util.ArrayList;
        import java.util.Random;


/**
 * Controller for the translationTest fxml file.
 *
 * @author Brad Corbett brc9
 * @version 0.1
 */
public class TranslationController extends SharedCodeController {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   public static DictionaryEntry answer = new DictionaryEntry();

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

   /**
    * Represents the word that will be randomly chosen from the practiceList.
    */
   int chosenWord = 0;
   @FXML
   private TextField translationBox;

   @FXML
   private Text typeOfTest;

   @FXML
   private Text wordToTranslate;

   @FXML
   private Label correctAnswer;

   @FXML
   private Label totalAnswer;

   @FXML
   private ImageView submitButton;

   @FXML
   private ComboBox<String> specialChar3;

   @FXML
   private ComboBox<String> specialChar2;

   @FXML
   private ComboBox<String> specialChar4;

   @FXML
   private ComboBox<String> specialChar1;

   Random rand = new Random();

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Loads the test for the first time, filling the practice list with words from the dictionary,
    * deciding if this test will be from English to Welsh or Welsh to English, and generating
    * which is the first word the user will have to translate.
    */
   @FXML
   private void initialize() {
      setup();

      //Setup of image on screen
      currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/pass-fail-50.png"));
      currentPageText.setText("Study");

      //Setup of image on screen
      studyIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/pass-fail-50.png"));
      studyText.setFill(Color.BLACK);

      //Setup of image on screen
      submitButton.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/right-50.png"));

      //Sets answer counters to correct values
      correctAnswer.setText(": " + AssessmentGenerator.getTotalCorrectAnswers());
      totalAnswer.setText(": " + AssessmentGenerator.getTotalAnswers());


      if (AssessmentGenerator.isEnglish()) {
         wordToTranslate.setText(answer.getEnglish());
      } else {
         wordToTranslate.setText(answer.getWelsh());
      }
   }


   /**
    * Takes the word the user inputs and compares it to the correct answer using
    * the checkAnswer function in the QuestionClass.
    */
   @FXML
   void translateWord() {

      //Creates ArrayList of answers and ArrayList of user answers to check
      ArrayList<String> usersInput = new ArrayList<>();
      usersInput.add(translationBox.getText());
      ArrayList<DictionaryEntry> correctTranslation = new ArrayList<>();
      correctTranslation.add(answer);

      //check user answers against correct answers
      Question.checkAnswer(correctTranslation, usersInput, AssessmentGenerator.isEnglish());

      //Open the next question of the assessment.
      AssessmentGenerator.goToNextQuestion();


   }

   public void specialChar1(ActionEvent actionEvent){
      translationBox.appendText(specialChar1.getValue());
   }

   public void specialChar2(ActionEvent actionEvent) {
      translationBox.appendText(specialChar2.getValue());
   }
   public void specialChar3(ActionEvent actionEvent) {
      translationBox.appendText(specialChar3.getValue());
   }
   public void specialChar4(ActionEvent actionEvent) {
      translationBox.appendText(specialChar4.getValue());
   }
}
