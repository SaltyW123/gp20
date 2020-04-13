package JSONStuff;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class JSONProcessor {

    public LinkedList<DictionaryEntry> readFile (String path){
        LinkedList<DictionaryEntry> result = new LinkedList<>();
        ObjectMapper mapper = new ObjectMapper();
        File dictionary = new File(path);

        try {
            result.addAll(Arrays.asList(mapper.readValue(dictionary, DictionaryEntry[].class)));
        } catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    public void saveFile(String path, LinkedList<DictionaryEntry> dictionary){
        ObjectMapper mapper = new ObjectMapper();
        String dictionaryString ="";

        try {
            dictionaryString = mapper.writeValueAsString(dictionary);

        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            Files.writeString(Paths.get(path), dictionaryString);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
