module uk.ac.aber.cs221.group20 {
   requires javafx.controls;
   requires javafx.fxml;
   requires com.fasterxml.jackson.core;
   requires com.fasterxml.jackson.databind;
   requires org.junit.jupiter;
   requires org.testfx;
   requires org.junit.jupiter.api;


   opens uk.ac.aber.cs221.group20.javafx to javafx.fxml;
   opens uk.ac.aber.cs221.group20.json to com.fasterxml.jackson.databind;

   opens uk.ac.aber.cs221.group20.selfassessment to javafx.fxml;


   exports uk.ac.aber.cs221.group20.json to com.fasterxml.jackson.databind;
   exports uk.ac.aber.cs221.group20.javafx to javafx.graphics, javafx.fxml;
 //  exports uk.ac.aber.cs221.group20.test to org.junit.jupiter, org.testfx;
}