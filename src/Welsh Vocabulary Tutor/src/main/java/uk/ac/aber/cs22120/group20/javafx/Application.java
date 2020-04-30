/**
 * @(#) Application.java 0,2 2020/04/30
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20.javafx;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.json.JsonProcessing;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * A class that launches the Welsh Vocabulary tutor Application.
 *
 * @author Kain Bryan-Jones [kab74]
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Marcin Jakob [maj83]
 * @author Tom Perry [top1]
 * @author Oscar Pocock [osp1]
 * @author Waylen Watts [ncw]
 * @author Luke Wybar [law39]
 * @version 0.1 Initial development
 */
public class Application extends javafx.application.Application {

   // Dictionary containing all the words.
   public static LinkedList<DictionaryEntry> dictionary = new LinkedList<>();

   // Practice list containing all the practice words.
   public static LinkedList<DictionaryEntry> practiceList = new LinkedList<>();

   // Json processor to import and export the json dictionary file.
   private JsonProcessing jsonProcessing = new JsonProcessing();

   /**
    * @param args
    */
   public static void main(String[] args) {
      launch();
   }

   /**
    * @param stage
    * @throws IOException
    */
   @Override
   public void start(Stage stage) throws IOException {

      // Prompts the user to load their dictionary json file.
      File jsonFileLocation = null;
      while (jsonFileLocation == null) {
         FileChooser fileChooser = new FileChooser();
         fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json Files", "*.json"));
         fileChooser.setTitle("Open Json File");
         jsonFileLocation = fileChooser.showOpenDialog(stage);
      }
      final File jsonFileFinalLocation = jsonFileLocation;
      dictionary = jsonProcessing.readInJson(jsonFileFinalLocation);

     // Adds all words that are practice words to the practice list.
      for (DictionaryEntry entry : dictionary) {
         if (entry.isPracticeWord()) {
            practiceList.add(entry);
         }
      }
      new ScreenSwitch(stage);
   }
}