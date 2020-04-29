package uk.ac.aber.cs22120.group20.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import uk.ac.aber.cs22120.group20.json.DictionaryEntry;
import uk.ac.aber.cs22120.group20.json.JsonProcessing;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class that contains methods which will be used to test that the JSON package classes are
 * correctly loading and saving to and from the JSON file.
 * @Author
 * @Version
 * @See
 */
public class JSONTest {
    LinkedList<DictionaryEntry> testList;
    LinkedList<DictionaryEntry> loadedList;
    File testFile;
    JsonProcessing processor = new JsonProcessing();


    @Before
    public void setupTest() {

        // Populate a test list with DictionaryEntrys that is to be used for the loading/saving tests.
        testList = new LinkedList<>(Arrays.asList(new DictionaryEntry("abbey","abaty","nm"), new DictionaryEntry("about to", "ar fin", "other"),
                new DictionaryEntry("above","uwchben","other"), new DictionaryEntry("abroad","dramor","other"),
                new DictionaryEntry("abstract","haniaethol","other")));

        // Create a JSON test file in the test package
        testFile = new File("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json");

        // Save the testList to the testFile.
        processor.writeOutJson("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json", testList);
    }

    /**
     * JUnit test to check that the JSON file has been correctly loaded.
     */
    @Test
    public void testLoad(){

        // Load the DictionaryEntry's from testFile and check if the loaded list matches the test list.
        loadedList = processor.readInJson(testFile);
        Assert.assertArrayEquals(testList.toArray(),loadedList.toArray());
    }

    /**
     * JUnit test to check that any changes to the list of definitions are
     * updated and saved to the JSON file accordingly.
     */
    @Test public void testSave(){
        // Add an additional word to the testList and save it to jsontest.
        testList.add(new DictionaryEntry("beer", "cwrw", "nm"));
        processor.writeOutJson("src/main/java/uk/ac/aber/cs22120/group20/test/jsontest.json", testList);

        // Load the DictionaryEntry's back from the file and check that they match the testList.
        loadedList = processor.readInJson(testFile);
        Assert.assertArrayEquals(testList.toArray(), loadedList.toArray());
    }

    @After
    public void deleteFile() {
        testFile.delete();
    }

}
