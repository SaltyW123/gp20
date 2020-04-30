package uk.ac.aber.cs22120.group20.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.javafx.SharedCodeController;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.json.JsonProcessing;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Class that contains methods which will be used to test that the JSON package classes are
 * correctly loading and saving to and from the JSON file.
 * @author Tom Perry [top19]
 * @version 0.1 Initial development.
 * @see JsonProcessing
 * @see DictionaryEntry
 */

public class JSONTest {
    static LinkedList<DictionaryEntry> testList;
    LinkedList<DictionaryEntry> loadedList;
    static File testFile;
    static JsonProcessing processor = new JsonProcessing();


    /**
     * Setup method that is run before all of the tests, setting up a test list of DictionaryEntry's that it saved to a JSON test file.
     * @see JsonProcessing
     * @see DictionaryEntry
     */
    @BeforeAll
    public static void setupTest() {

        // Populate a test list with DictionaryEntrys that is to be used for the loading/saving tests.
        testList = new LinkedList<>(Arrays.asList(new DictionaryEntry("abbey","abaty", DictionaryEntry.wordTypeEnum.other), new DictionaryEntry("about to", "ar fin", DictionaryEntry.wordTypeEnum.other),
                new DictionaryEntry("above","uwchben", DictionaryEntry.wordTypeEnum.other), new DictionaryEntry("abroad","dramor", DictionaryEntry.wordTypeEnum.other),
                new DictionaryEntry("abstract","haniaethol", DictionaryEntry.wordTypeEnum.other)));

        // Create a JSON test file in the test package.
        testFile = new File("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json");

        // Save the testList to the testFile.
        processor.writeOutJson("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json", testList);
    }

    /**
     * JUnit test to check that the JSON file has been correctly loaded.
     * @see JsonProcessing
     * @see DictionaryEntry
     */
    @Test
    public void testLoad(){

        // Load the DictionaryEntry's from testFile and check if the loaded list matches the test list.
        loadedList = processor.readInJson(testFile);
        assertArrayEquals(testList.toArray(),loadedList.toArray());
    }

    /**
     * JUnit test to check that any changes to the list of definitions are
     * updated and saved to the JSON file accordingly.
     * @see JsonProcessing
     * @see DictionaryEntry
     */
    @Test public void testSave(){
        // Add an additional word to the testList and save it to jsontest.
        testList.add(new DictionaryEntry("beer", "cwrw", DictionaryEntry.wordTypeEnum.nm));
        processor.writeOutJson("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json", testList);

        // Load the DictionaryEntry's back from the file and check that they match the testList.
        loadedList = processor.readInJson(testFile);
        assertArrayEquals(testList.toArray(), loadedList.toArray());
    }

    /**
     * Method that is ran after the JUnit tests have finished to remove the JSON test file from program.
     */
    @AfterAll
    public static void deleteFile() {
        testFile.delete();
    }

}
