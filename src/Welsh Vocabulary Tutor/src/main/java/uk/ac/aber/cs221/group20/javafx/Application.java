/**
 * @(#) Application.java 0,2 2020/04/30
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.javafx;

import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.json.JsonProcessing;

import java.io.File;
import java.util.LinkedList;

/**
 * Programs Application class that extends JavaFX's Application class so that it can launch the program's JavaFX's when it starts running.
 *
 * @author Kain Bryan-Jones [kab74]
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Marcin Jakob [maj83]
 * @author Tom Perry [top19]
 * @author Oscar Pocock [osp1]
 * @author Waylen Watts [ncw]
 * @author Luke Wybar [law39]
 * @version 0.2 Documentation stage
 * @see javafx.application.Application
 * @see DictionaryEntry
 * @see Stage
 * @see JsonProcessing
 * @see ScreenSwitch
 */
public class Application extends javafx.application.Application {

   // //////////////// //
   // Class variables. //
   // //////////////// //

   // Dictionary containing all the words.
   public static LinkedList<DictionaryEntry> dictionary = new LinkedList<>();

   // Practice list containing all the practice words.
   public static LinkedList<DictionaryEntry> practiceList = new LinkedList<>();

   // ////////////// //
   // Class methods. //
   // ////////////// //

   /**
    * Applications main method that is first ran when the program is started. This method is responsible for calling JavaFX's launch method that starts the program's JavaFX.
    *
    * @param args Programs arguments.
    */
   public static void main(String[] args) {
      launch();
   }


   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

   private final JsonProcessing jsonProcessing = new JsonProcessing(); // JSON processor to import and export the json dictionary file.

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Overridden JavaFX start method that is called automatically when running the Applications main method. This is responsible for prompting the user to choose
    * the 'dictionary.json' file before loading it to the 'dictionary' variable. Once loaded, the programs stage is to run the first screen.
    *
    * @param stage Top-level JavaFX container that the Scenes will be loaded onto.
    * @see File
    * @see FileChooser
    * @see DictionaryEntry
    * @see JsonProcessing
    * @see Stage
    */
   @Override
   public void start(Stage stage) {

      File jsonFileLocation = null;

      // Keep prompting the user to select if a json file hasn't been selected.
      while (jsonFileLocation == null) {

         // Shows prompt to the user to load their dictionary json file.
         FileChooser fileChooser = new FileChooser();
         fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Json Files", "*.json"));
         fileChooser.setTitle("Open Json File");
         jsonFileLocation = fileChooser.showOpenDialog(stage);
      }
      final File jsonFileFinalLocation = jsonFileLocation;

      // Load the file chosen by the user.
      dictionary = jsonProcessing.readInJson(jsonFileFinalLocation);

      // Adds all words that are practice words to the practice list.
      for (DictionaryEntry entry : dictionary) {
         if (entry.isPracticeWord()) {
            practiceList.add(entry);
         }
      }

      //When the user closes the application, it will automatically write the dictionary to a json file.
      stage.setOnCloseRequest(e -> {
         jsonProcessing.writeOutJson(jsonFileFinalLocation.getAbsolutePath(), Application.dictionary);
         Platform.exit();
         System.exit(0);
      });

      // Initialise the ScreenSwitch class, passing the programs Stage as the parameter in order to display the first screen.
      new ScreenSwitch(stage);
   }
}