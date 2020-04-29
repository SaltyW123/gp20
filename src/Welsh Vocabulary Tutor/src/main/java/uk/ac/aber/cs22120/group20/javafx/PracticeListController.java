/**
 * @(#) DictionaryController.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
 * @see Application
 */
public class PracticeListController extends SharedCodeController{
    public static Stage primaryStage = null;

    @FXML
    private ImageView alphaSort;
    @FXML
    private ImageView langSort;
    @FXML
    private TextField searchBox;
    @FXML
    private TableView<DictionaryEntry> table;
    @FXML
    private TableColumn<DictionaryEntry, String> english = new TableColumn<>();
    @FXML
    private TableColumn<DictionaryEntry, String> welsh = new TableColumn<>();

    public ObservableList<DictionaryEntry> list = FXCollections.observableArrayList();

    /**
     * Initializes the  table of dictionary entries.
     * <p>
     * An observable list of DictionaryEntries is loaded from the Application class into a local instance of ObservableList.
     * It also sets up Lambda expressions related to live searching functionality and the display of DictionaryEntries.
     *
//     * @param url
//     * @param resourceBundle
     * @see Application
     * @see DictionaryEntry
     */
    public void initialize() {
        setup();
        currentPageIcon.setImage(new Image("file:src/main/resources/assets/icons/white_icons/50px/rating-50.png"));
        currentPageText.setText("Practice List");

        practiceListIcon.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/rating-50.png"));
        practiceListTest.setFill(Color.BLACK);

        alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
        langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-50.png"));

//        list.addAll(Application.dictionary);
        list.addAll(Application.practiseList);
//        for (DictionaryEntry entry : Application.dictionary) {
//            if (entry.isPracticeWord())
//                list.add(entry);
//        }


        FilteredList<DictionaryEntry> filteredList = new FilteredList<>(list, p -> true); // Wrap list in a FilteredList

        searchBox.textProperty().addListener((observable, oldSearchTerm, newSearchTerm) -> {
            filteredList.setPredicate(dictionaryEntry -> { // returns true on a filter match, false if no match
                boolean result = false;

                table.refresh(); // This fixes the table highlighting issue

                if (newSearchTerm == null || newSearchTerm.isEmpty()) { // If filter text is empty, display all dictionary entries
                    result = true;
                } else {
                    // need all same case for compare.
                    final String lowerCaseSearchFilter = newSearchTerm.toLowerCase();
                    if (dictionaryEntry.getWelsh().toLowerCase().contains(lowerCaseSearchFilter)) {
                        result = true; // Filter matches Welsh
                    } else if (dictionaryEntry.getEnglish().toLowerCase().contains(lowerCaseSearchFilter)) {
                        result = true; // Filter matches English
//                    } else if (dictionaryEntry.getWordType().toLowerCase().contains(lowerCaseSearchFilter)) {
//                        result = true; // Filter matches Word Type
                    } else if (dictionaryEntry.getWordType().equals("verb") && ("to " + dictionaryEntry.getEnglish()).toLowerCase().contains(lowerCaseSearchFilter)) {
                        result = true; // Filter matches ['to' + a word] or [a word] if word is a verb
                    }
                }
                return result;
            });
        });

        SortedList<DictionaryEntry> sortedList = new SortedList<>(filteredList); //Wrap the filtered list in a SortedList
        sortedList.comparatorProperty().bind(table.comparatorProperty()); //Bind the sorted list comparator to the table comparator
//        welsh.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("welsh"));
//        english.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("english"));

        table.setPlaceholder(new Label("No practice words found. Please try adding a practice word from the 'Dictionary' page."));
        table.setRowFactory(tv -> {
                    TableRow<DictionaryEntry> row = new TableRow<DictionaryEntry>() {
                        @Override
                        protected void updateItem(DictionaryEntry dictionaryEntry, boolean b) {
                            super.updateItem(dictionaryEntry, b);
                            if (!isEmpty()) {
                                setStyle(" ");
//                                if (dictionaryEntry.isPracticeWord()) {
//                                    setStyle("-fx-background-color: gray;");
//                                } else {
//                                    setStyle(" ");
//                                }
                            }
                        }
                    };
                    row.setOnMouseClicked(mouseEvent -> {
                        if (mouseEvent.getClickCount() == 1 && (!row.isEmpty())) {
                            for (DictionaryEntry entry : Application.dictionary) {
                                if (entry.equals(row.getItem())) {
                                    entry.setPracticeWord(false);
                                    list.remove(row.getItem());
                                    table.refresh();
                                }

                                }

                            ArrayList<DictionaryEntry> toRemove = new ArrayList<DictionaryEntry>();
                            for (DictionaryEntry entry : Application.practiseList) {
                                if (entry.equals(row.getItem())) {
                                    toRemove.add(entry);
                                    list.remove(row.getItem());
                                }
                            }
                            Application.practiseList.removeAll(toRemove);
                            table.getSelectionModel().clearSelection();
                        }
                    });
                    return row;
                }
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
            } else {
                return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
            }
        });

        table.setItems(sortedList);
        table.getSortOrder().add(english);
    }

    @FXML
    private void switchLangSort() {
        if (table.getSortOrder().contains(english)) {
            if (welsh.getSortType().equals(TableColumn.SortType.ASCENDING)) {
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
            }
            else if (welsh.getSortType().equals(TableColumn.SortType.DESCENDING)) {
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
            }
            table.getSortOrder().clear();
            table.getSortOrder().add(welsh);
        }
        else if (table.getSortOrder().contains(welsh)) {
            if (english.getSortType().equals(TableColumn.SortType.ASCENDING)) {
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
            }
            else if (english.getSortType().equals(TableColumn.SortType.DESCENDING)) {
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
            }
            table.getSortOrder().clear();
            table.getSortOrder().add(english);
        }
        table.sort();
    }

    @FXML
    private void switchAlphaSort() {
        if (table.getSortOrder().contains(english)) {
            if (english.getSortType().equals(TableColumn.SortType.ASCENDING)) {
                english.setSortType(TableColumn.SortType.DESCENDING);
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
            } else {
                english.setSortType(TableColumn.SortType.ASCENDING);
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
            }
        } else if (table.getSortOrder().contains(welsh)) {
            if (welsh.getSortType().equals(TableColumn.SortType.ASCENDING)) {
                welsh.setSortType(TableColumn.SortType.DESCENDING);
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
            } else {
                welsh.setSortType(TableColumn.SortType.ASCENDING);
                alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
            }
        }
    }

    /**
     * Switches to the primary scene.
     *
     * @throws IOException
     */
    @FXML
    private void switchToFlashCard() throws IOException {
        ScreenSwitch.swap(ScreenSwitch.SceneEnum.flashcardScene);
    }

}

