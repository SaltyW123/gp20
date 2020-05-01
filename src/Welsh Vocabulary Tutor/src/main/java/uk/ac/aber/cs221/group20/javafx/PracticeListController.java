/**
 * @(#) PracticeListController.java 0.2 2020/05/01
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;

import java.util.ArrayList;
import java.util.Comparator;

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
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development.
 * @see DictionaryEntry
 * @see Application
 */
public class PracticeListController extends SharedCodeController {

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

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

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Method to switch the language used to sort the dictionary list.
    * <p>
    * If currently sorted by English, this will change the sort to by Welsh.
    * If currently sorted by Welsh, this will change the sort to by English.
    */
   @FXML
   private void switchLangSort() {
      if (isSortedByEnglish) {
         if (welsh.getSortType().equals(TableColumn.SortType.ASCENDING)) {
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
         } else if (welsh.getSortType().equals(TableColumn.SortType.DESCENDING)) {
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
         }
         langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-welsh-50.png"));
         table.getSortOrder().clear();
         table.getSortOrder().add(welsh);
         isSortedByEnglish = false;
      } else {
         if (english.getSortType().equals(TableColumn.SortType.ASCENDING)) {
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
         } else if (english.getSortType().equals(TableColumn.SortType.DESCENDING)) {
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
         }

         langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-eng-50.png"));
         table.getSortOrder().clear();
         table.getSortOrder().add(english);
         isSortedByEnglish = true;
      }
      table.sort();
      searchBox.textProperty().setValue(searchBox.textProperty().getValue() + " ");
      searchBox.textProperty().setValue(searchBox.textProperty().getValue().substring(0, searchBox.textProperty().getValue().length() - 1));
      searchBox.positionCaret(searchBox.textProperty().getValue().length());
   }

   /**
    * Method to switch the alphabetical order used to sort the dictionary list.
    * <p>
    * If currently sorted by A-Z, this will change the sort to by Z-A.
    * If currently sorted by Z-A, this will change the sort to by A-Z.
    */
   @FXML
   private void switchAlphaSort() {
      if (isSortedByEnglish) {
         if (english.getSortType().equals(TableColumn.SortType.ASCENDING)) {
            english.setSortType(TableColumn.SortType.DESCENDING);
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-reversed-50.png"));
         } else {
            english.setSortType(TableColumn.SortType.ASCENDING);
            alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
         }
      } else {
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
    * Initializes the table of dictionary entries.
    * <p>
    * An observable list of DictionaryEntries is loaded from the Application class into a local instance of ObservableList.
    * It also sets up Lambda expressions related to live searching functionality and the display of DictionaryEntries.
    *
    * @see Application
    * @see DictionaryEntry
    */
   public void initialize() {
      setup();

      // Hide TableViewHeader
      table.widthProperty().addListener(new ChangeListener<Number>() {
         @Override
         public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
            Pane tableHeader = (Pane) table.lookup("TableHeaderRow");
            if (tableHeader != null && tableHeader.isVisible()) {
               tableHeader.setMaxHeight(0);
               tableHeader.setMinHeight(0);
               tableHeader.setPrefHeight(0);
               tableHeader.setVisible(false);
               tableHeader.setManaged(false);
            }
         }
      });

      // Compare words while ignoring the "to"
      english.setComparator(new Comparator<String>() {
         @Override
         public int compare(String s, String t1) {
            s = s.toLowerCase();
            t1 = t1.toLowerCase();
            if (s.startsWith("to ")) {
               return s.substring(3).compareTo(t1);
            }
            if (t1.startsWith("to ")) {
               return s.compareTo(t1.substring(3));
            }
            return s.compareTo(t1);
         }
      });

      currentPageIcon.setImage(new Image(getClass().getResourceAsStream("/assets/icons/white_icons/50px/rating-50.png")));
      currentPageText.setText("Practice List");

      alphaSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-alpha-up-50.png"));
      langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-eng-50.png"));

      practiceListIcon.setImage(new Image(getClass().getResourceAsStream("/assets/icons/black_icons/50px/rating-50.png")));
      practiceListTest.setFill(Color.BLACK);
      list.addAll(Application.practiceList);

      table.setPlaceholder(new Label("No practice words found. Please try adding a practice word from the 'Dictionary' page."));

      table.setRowFactory(tv -> {
                 TableRow<DictionaryEntry> row = new TableRow<DictionaryEntry>() {
                    @Override
                    protected void updateItem(DictionaryEntry dictionaryEntry, boolean b) {
                       super.updateItem(dictionaryEntry, b);
                       if (!isEmpty()) {
                          setStyle(" ");
                       }
                    }
                 };

         // Remove practice word when they are clicked on
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
               for (DictionaryEntry entry : Application.practiceList) {
                  if (entry.equals(row.getItem())) {
                     toRemove.add(entry);
                     list.remove(row.getItem());
                  }
               }
               Application.practiceList.removeAll(toRemove);
               table.getSelectionModel().clearSelection();
            }
         }
         );
            return row;
              }
      );

      // Render Welsh nouns as "[masculine noun] {nm}" and "[feminine noun] {nm}" respectively.
      welsh.setCellValueFactory(dictionaryEntryStringCellDataFeatures -> {
         if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals(DictionaryEntry.wordTypeEnum.nm)) {
            return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nm}");
         } else if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals(DictionaryEntry.wordTypeEnum.nf)) {
            return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh() + " {nf}");
         } else {
            return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getWelsh());
         }
      });

      // Render English verbs as "to [verb]"
      english.setCellValueFactory(dictionaryEntryStringCellDataFeatures -> {
         if (dictionaryEntryStringCellDataFeatures.getValue().getWordType().equals(DictionaryEntry.wordTypeEnum.verb)) {
            return new SimpleStringProperty("to " + dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
         } else {
            return new SimpleStringProperty(dictionaryEntryStringCellDataFeatures.getValue().getEnglish());
         }
      });

      // Wrap list in a FilteredList
      FilteredList<DictionaryEntry> filteredList = new FilteredList<>(list, p -> true);

      searchBox.textProperty().addListener((observable, oldSearchTerm, newSearchTerm) -> {

         // Returns true on a filter match, false if no match
         filteredList.setPredicate(dictionaryEntry -> {
            boolean result = false;

            // This fixes the table highlighting issue
            table.refresh();

            // If filter text is empty, display all dictionary entries
            if (newSearchTerm == null || newSearchTerm.isEmpty()) {
               result = true;
            } else {

               // need all same case for compare.
               final String lowerCaseSearchFilter = newSearchTerm.toLowerCase();
               if (isSortedByEnglish) {
                  if (dictionaryEntry.getEnglish().toLowerCase().startsWith(lowerCaseSearchFilter)) {

                     // Filter matches English
                     result = true;
                  } else if (lowerCaseSearchFilter.startsWith("to ")) {
                     if (dictionaryEntry.getWordType().equals(DictionaryEntry.wordTypeEnum.verb) && ("to " + dictionaryEntry.getEnglish()).toLowerCase().startsWith(lowerCaseSearchFilter)) {

                        // Filter matches ['to' + a word] or [a word] if word is a verb
                        result = true;
                     }
                  }
               } else {
                  if (dictionaryEntry.getWelsh().toLowerCase().startsWith(lowerCaseSearchFilter)) {

                     // Filter matches Welsh
                     result = true;
                  }
               }
            }
            return result;
         });
      });

      // Wrap the filtered list in a SortedList
      SortedList<DictionaryEntry> sortedList = new SortedList<>(filteredList);

      // Bind the sorted list comparator to the table comparator
      sortedList.comparatorProperty().bind(table.comparatorProperty());

      table.setItems(sortedList);

      // Change Table sorting based on boolean value
      if (isSortedByEnglish) {
         table.getSortOrder().add(english);
         langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-eng-50.png"));
      } else {
         table.getSortOrder().add(welsh);
         langSort.setImage(new Image("file:src/main/resources/assets/icons/black_icons/50px/sort-lang-welsh-50.png"));
      }
   }

}

