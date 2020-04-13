/**
 * @(#) DictionaryController.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private TableColumn<DictionaryEntry, String> english;
    @FXML
    private TableColumn<DictionaryEntry, String> welsh;

    public ObservableList<DictionaryEntry> list = FXCollections.observableArrayList(
            new DictionaryEntry("abbey", "abaty", "nm", false),
            new DictionaryEntry("believe", "credu", "verb", false),
            new DictionaryEntry("concert", "cyngerdd", "nm", false),
            new DictionaryEntry("disease", "clefyd", "nm", false),
            new DictionaryEntry("extremely", "dros ben", "other", false),
            new DictionaryEntry("flu", "ffliw", "nm", false)
    );

    /**
     * Switches to the primary scene.
     * @throws IOException
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    /**
     * Sets up the table and loads the words into it.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welsh.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("welsh"));
        english.setCellValueFactory(new PropertyValueFactory<DictionaryEntry, String>("english"));
        table.setItems(list);
    }

}

