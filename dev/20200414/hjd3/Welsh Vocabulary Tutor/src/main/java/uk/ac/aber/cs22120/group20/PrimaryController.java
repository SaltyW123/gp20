package uk.ac.aber.cs22120.group20;

        import java.io.IOException;
        import javafx.fxml.FXML;
/**
 * Placeholder Controller
 */
public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
