package uk.ac.aber.cs221.group20.json;
/**
 * @(#) JsonProcessing.java 0,1 2020/04/27
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * A class that handles the import and export of Json-formatted files, following the schema set out in SE.QA.CSRS DC3
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
 */
public class JsonProcessing {


   /**
    * Method to read in a Json file formatted in the schema set out in SE.QA.CSRS DC3
    * <p>
    * @param file Pass in a File object referencing the Json file wish to be read in.
    * @return A LinkedList containing all the valid DictionaryEntry objects stored in the Json File
    * @see DictionaryEntry
    */
   public LinkedList<DictionaryEntry> readInJson(File file) {
      LinkedList<DictionaryEntry> returnVal = new LinkedList<>();
      ObjectMapper objectMapper = new ObjectMapper();

      try {
         returnVal.addAll(Arrays.asList(objectMapper.readValue(file, DictionaryEntry[].class)));
      } catch (IOException e) {
         e.printStackTrace();
      }

      return returnVal;
   }

   /**
    * Method to write out a Json file formatted in the schema set out in SE.QA.CSRS DC3
    * <p>
    * @param directoryAndFile pass in a String containing a fully qualified path name and file name, where the Json file should be output
    * @param words            pass in a LinkedList of DictionaryEntry objects which should be output in the Json file
    */
   public void writeOutJson(String directoryAndFile, LinkedList<DictionaryEntry> words) {
      ObjectMapper objectMapper = new ObjectMapper();
      String JsonString = "";

      try {
         JsonString = objectMapper.writeValueAsString(words);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      try {
         Files.writeString(Paths.get(directoryAndFile), JsonString);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
