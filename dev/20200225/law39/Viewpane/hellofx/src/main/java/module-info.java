module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;


    opens org.openjfx.javaFX to javafx.fxml;
    exports org.openjfx.javaFX;

    opens jsonStuff to com.fasterxml.jackson.databind;
    exports jsonStuff;

}