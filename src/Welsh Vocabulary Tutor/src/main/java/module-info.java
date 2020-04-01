module uk.ac.aber.cs22120.group20 {
    requires javafx.controls;
    requires javafx.fxml;

    opens uk.ac.aber.cs22120.group20 to javafx.fxml;
    exports uk.ac.aber.cs22120.group20;
}