package uk.ac.aber.cs221.group20.test;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.ac.aber.cs221.group20.javafx.AddWordController;
import uk.ac.aber.cs221.group20.javafx.AddWordController;

import static org.junit.jupiter.api.Assertions.*;

class AddWordControllerTest {
   AddWordController testController = new AddWordController();

   @BeforeEach
   void setUp() {


   }

   @AfterEach
   void tearDown() {
   }

   @Test
   void addButtonClick() {
      testController.getEnglish();
//      assertEquals();*
   }


   @Test
   void testSpecialCharacters(ActionEvent actionEvent) {
      testController.addCharch(actionEvent);
      testController.addChardd(actionEvent);
      testController.addCharff(actionEvent);
      testController.addCharng(actionEvent);
      testController.addCharll(actionEvent);
      testController.addCharph(actionEvent);
      testController.addCharrh(actionEvent);
      testController.addCharth(actionEvent);

      String allChars = "chddffngllphrhth";

      assertEquals(allChars,testController.getWelsh().getText());


   }


}