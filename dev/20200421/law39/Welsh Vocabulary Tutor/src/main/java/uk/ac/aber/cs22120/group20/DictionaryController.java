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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

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
    private TextField searchBox;
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
        welsh.setCellValueFactory(dictionaryEntryStringCellDataFeatures -> {
            if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("nm")) {
                return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nm}");
            } else if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("nf")) {
                return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nf}");
            } else {
                return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh());
            }
        });

        english.setCellValueFactory(dictionaryEntryStringCellDataFeatures -> {
            if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals("verb")) {
                return new SimpleStringProperty("to " + dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
            }
            else {
                return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
            }
        });


        FilteredList<DictionaryEntry> filteredList = new FilteredList<>(list, p -> true); // Wrap list in a FilteredList


        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(dictionaryEntry -> {

                table.refresh(); // This fixes the table highlighting issue
                                
                if (newValue == null || newValue.isEmpty()) { // If filter text is empty, display all dictionary entries
                    return true;
                }

                // need all same case for compare.
                String lowerCaseFilter = newValue.toLowerCase();



                if (dictionaryEntry.getWelsh().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches Welsh
                } else if (dictionaryEntry.getEnglish().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches English
                }else if (dictionaryEntry.getWordType().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches Word Type
                }

                return false; // No match

            });
        });

        SortedList<DictionaryEntry> sortedList = new SortedList<>(filteredList); //Wrap the filtered list in a SortedList
        sortedList.comparatorProperty().bind(table.comparatorProperty()); //Bind the sorted list comparator to the table comparator
//        welsh.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("welsh"));
//        english.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("english"));

        table.setItems(sortedList);
    }

}

