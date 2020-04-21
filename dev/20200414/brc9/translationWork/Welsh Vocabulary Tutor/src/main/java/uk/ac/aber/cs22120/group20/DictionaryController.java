/**
 * @(#) DictionaryController.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A class that handles the keyboard and mouse input and interaction for the 'Dictionary Page' which is
 * defined by 'dictionary.fxml'
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development.
 * @see DictionaryEntry
 * @see App
 */
public class DictionaryController implements Initializable {
    public static Stage primaryStage = null;

    @FXML
    private TableView<DictionaryEntry> table;
    @FXML
    private TableColumn<DictionaryEntry, String> english = new TableColumn<>();
    @FXML
    private TableColumn<DictionaryEntry, String> welsh = new TableColumn<>();

//    public ObservableList<DictionaryEntry> list = FXCollections.observableArrayList(
//            new DictionaryEntry("abbey", "abaty", "nm", false),
//            new DictionaryEntry("believe", "credu", "verb", true),
//            new DictionaryEntry("concert", "cyngerdd", "nm", false),
//            new DictionaryEntry("disease", "clefyd", "nm", true),
//            new DictionaryEntry("extremely", "dros ben", "other", false),
//            new DictionaryEntry("flu", "ffliw", "nm", false)
//    );

    public ObservableList<DictionaryEntry> list = FXCollections.observableArrayList();

    /**
     * Switches to the primary scene.
     *
     * @throws IOException
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    /**
     * Sets up the table and loads the words into it.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.addAll(App.dictionary);
        table.setRowFactory(tv -> {
            TableRow<DictionaryEntry> row = new TableRow<DictionaryEntry>() {
                @Override
                protected void updateItem(DictionaryEntry dictionaryEntry, boolean b) {
                    super.updateItem(dictionaryEntry, b);
                    if (!isEmpty()) {
                        if (dictionaryEntry.isPracticeWord()) {
                            setStyle("-fx-background-color: gray;");
                        } else {
                            setStyle(" ");
                        }
                    }
                }
            };
            row.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 1 && (!row.isEmpty())) {
                    if (row.getItem().isPracticeWord()) {
                        App.dictionary.get(list.indexOf(row.getItem())).setPracticeWord(false);
//                        row.getItem().setPracticeWord(false);
                    }
                    else if (!row.getItem().isPracticeWord()) {
                        App.dictionary.get(list.indexOf(row.getItem())).setPracticeWord(true);
//                        row.getItem().setPracticeWord(true);
                    }
                    table.getSelectionModel().clearSelection();
                }
            });
        return row;}
        );
        welsh.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DictionaryEntry, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DictionaryEntry, String> dictionaryEntryStringCellDataFeatures) {
                if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("nm")) {
                    return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nm}");
                }
                else if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("nf")) {
                    return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nf}");
                }
                else {
                    return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh());
                }
            }
        });

        english.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<DictionaryEntry, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<DictionaryEntry, String> dictionaryEntryStringCellDataFeatures) {
                if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("verb")) {
                    return new SimpleStringProperty("to " + dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
                }
                else {
                    return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
                }
            }
        });
//        welsh.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("welsh"));
//        english.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("english"));
        table.setItems(list);
    }

}

