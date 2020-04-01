package jsonStuff;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

public class JsonProcessing {

    public LinkedList<WelshDictionary> readInJson(String directoryAndFile) {
        LinkedList<WelshDictionary> returnVal = new LinkedList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(directoryAndFile);

        try {
            returnVal.addAll(Arrays.asList(objectMapper.readValue(file, WelshDictionary[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnVal;
    }

    public void writeOutJson(String directoryAndFile, LinkedList<WelshDictionary> words) {
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
