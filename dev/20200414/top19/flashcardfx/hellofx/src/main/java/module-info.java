module hellofx {

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.javaFX to javafx.fxml;
    exports org.openjfx.javaFX;

    opens jsonStuff to com.fasterxml.jackson.databind;
    exports jsonStuff;
}