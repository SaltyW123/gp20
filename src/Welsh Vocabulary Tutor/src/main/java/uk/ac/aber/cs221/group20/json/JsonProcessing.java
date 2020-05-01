package uk.ac.aber.cs221.group20.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

public class JsonProcessing {

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
