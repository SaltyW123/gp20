package uk.ac.aber.cs22120.group20;

import java.io.IOException;
import javafx.fxml.FXML;
/**
 * Placeholder Controller
 */
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}