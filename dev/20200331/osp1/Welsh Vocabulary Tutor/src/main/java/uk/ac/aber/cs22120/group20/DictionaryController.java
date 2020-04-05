package uk.ac.aber.cs22120.group20;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Placeholder Controller
 */
public class DictionaryController implements Initializable {
    public static Stage primaryStage = null;

    @FXML private TableView<WelshDictionary> table;
    @FXML private TableColumn<WelshDictionary, String> english;
    @FXML private TableColumn<WelshDictionary, String> welsh;

    private Scene firstScene;

    public ObservableList<WelshDictionary> list = FXCollections.observableArrayList(
            new WelshDictionary("abbey", "abaty", "nm"),
            new WelshDictionary("believe", "credu", "verb"),
            new WelshDictionary("concert", "cyngerdd", "nm"),
            new WelshDictionary("disease", "clefyd", "nm"),
            new WelshDictionary("extremely", "dros ben", "other"),
            new WelshDictionary("flu", "ffliw", "nm")
    );

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welsh.setCellValueFactory(new PropertyValueFactory<WelshDictionary, String>("welsh"));
        english.setCellValueFactory(new PropertyValueFactory<WelshDictionary, String>("english"));
        table.setItems(list);
    }

    }

    //    public void loadList(ActionEvent actionEvent) {
//        // FOR TESTING UNTIL JSON PROCESSOR IS FINISHED: LIST VIEW
//        englishListView.setOrientation(Orientation.VERTICAL);
//        englishListView.setCellFactory(param -> new ListCell<WelshDictionary>() {
//            @Override
//            protected void updateItem(WelshDictionary item, boolean empty) {
//                super.updateItem(item, empty);
//
//                if (empty || item == null || item.getEnglish() == null || item.getWelsh() == null || item.getWordType() ==null) {
//                    setText(null);
//                } else {
//                    setText(item.getEnglish() + "           " + item.getWelsh() + "          " + item.getWordType());
//                }
//            }
//        });
//        //ADDING WORDS MANUALLY TILL JSON PROCESSOR IS DONE
//        data.addAll(new WelshDictionary("englishCar", "welshCar", "testWordType1"),
//                new WelshDictionary("englishCat", "welshCat", "testWordType2"),
//                new WelshDictionary("englishDog", "welshDog", "testWordType3"),
//                new WelshDictionary("englishStick", "welshStick", "testWordType4")
//        );
////        data.addAll(App.words);
//        englishListView.setItems(data);
//    }
//}
