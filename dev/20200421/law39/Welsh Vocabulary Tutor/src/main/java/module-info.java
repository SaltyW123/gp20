module uk.ac.aber.cs22120.group20 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens uk.ac.aber.cs22120.group20 to javafx.fxml;
    exports uk.ac.aber.cs22120.group20;
}