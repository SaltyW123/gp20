package JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * A Class that provides functionality for saving/loading information to/from JSON files. It uses the jackson library
 * to perform this functionality.
 * @Author kab74
 * @Author top19
 * @Version 0.1
 */
public class JSONProcessor {

    /*
     * A file is then read and loaded into a
     * It loads a list from the JSON file and returns them in the form of a linked list.
     * @Author kab74
     * @Author top19
     * @Version
     * @Param fileDirectoryName the directory of the file to read from.
     * @return all dictionary entries in the form of a LinkedList
     * @See DictionaryEntry
     */
    public LinkedList<DictionaryEntry> readFile (String fileDirectoryName){
        
        LinkedList<DictionaryEntry> result = new LinkedList<>(); //This is the linked list object the method will return.
        ObjectMapper welshDictionaryObjectMapper = new ObjectMapper();
        File dictionaryFile = new File(fileDirectoryName);

        try {

            //This method first uses the ObjectMapper to [MISSING INFORMATION] then converts it to a List, which is all then
            //added to the 'result' LinkedList.
            result.addAll(Arrays.asList(welshDictionaryObjectMapper.readValue(dictionaryFile, DictionaryEntry[].class)));

        } catch (IOException e){

            e.printStackTrace();

        }

        return result;
    }

    /*
     * This method encodes the current session data to the dictionary file.
     * @Author kab474
     * @Author top19
     * @Version
     * @Param originalDictionaryDirectory The file directory to save the data to.
     * @Param dictionary A linked list which stores the DictionaryEntry objects.
     * @See DictionaryEntry
     * @See ObjectMapper
     */
    public void saveFile(String originalDictionaryDirectory, LinkedList<DictionaryEntry> dictionary){
        ObjectMapper welshDictionaryObjectMapper = new ObjectMapper();
        String linkedListDictionaryAsString ="";

        try {
            //Convert the dictionary into a string format through use of ObjectMapper.
            linkedListDictionaryAstring = welshDictionaryObjectMapper.writeValueAsString(dictionary);
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            //Write to the file.
            Files.writeString(Paths.get(originalDictionaryDirectory), linkedListDictionaryAsString);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
