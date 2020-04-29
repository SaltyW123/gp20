module uk.ac.aber.cs22120.group20 {
   requires javafx.controls;
   requires javafx.fxml;
   requires com.fasterxml.jackson.core;
   requires com.fasterxml.jackson.databind;
   requires junit;
   requires org.junit.jupiter.api;


   opens uk.ac.aber.cs22120.group20.javafx to javafx.fxml;
   opens uk.ac.aber.cs22120.group20 to javafx.fxml;
   opens uk.ac.aber.cs22120.group20.json to com.fasterxml.jackson.databind;

   exports uk.ac.aber.cs22120.group20.json to com.fasterxml.jackson.databind;
   exports uk.ac.aber.cs22120.group20.javafx to javafx.graphics, javafx.fxml;
   exports uk.ac.aber.cs22120.group20.test to junit;
}