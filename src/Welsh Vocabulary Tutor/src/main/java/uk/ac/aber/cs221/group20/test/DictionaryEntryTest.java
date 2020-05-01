package uk.ac.aber.cs221.group20.test;

import org.junit.jupiter.api.Test;

import uk.ac.aber.cs221.group20.json.DictionaryEntry;
import uk.ac.aber.cs221.group20.json.JsonProcessing;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test class for various tests regarding DictionaryEntry.
 * @Author Kab74
 */
class DictionaryEntryTest {

    LinkedList<DictionaryEntry> testList;

    /**
     * Tests whether the default constructor sets isPracticeWord to false upon declaration of a new DictionaryEntry.
     */
    @Test
    void testPracticeWordFalse(){
        DictionaryEntry testDefaultConstructor = new DictionaryEntry();
        assertFalse(testDefaultConstructor.isPracticeWord());
    }

    /**
     * Tests whether the setters and getters of the DictionaryEntry class work as intended.
     */
    @Test
    void testAllSettersAndGetters() {
    String english = "abbey";
    String welsh = "abaty";
    wordTypeEnum wordType = wordTypeEnum.nm;

    DictionaryEntry testSettersAndGetters = new DictionaryEntry();
    testSettersAndGetters.setEnglish(english);
    testSettersAndGetters.setWelsh(welsh);
    testSettersAndGetters.setWordType(wordType);
    assertTrue(testSettersAndGetters.getEnglish().equals(english) &&
            testSettersAndGetters.getWelsh().equals(welsh) &&
            testSettersAndGetters.getWordType().equals(wordType));
}

    /**
     * A true-positive test for the equals method in DictionaryEntry.
     */
    @Test
    public void testEqualsTruePossitive() {
        String english = "abbey";
        String welsh = "abaty";
        wordTypeEnum wordType = wordTypeEnum.nm;
        testList = new LinkedList<>(Arrays.asList(new DictionaryEntry(english,welsh,wordType),new DictionaryEntry(english,welsh,wordType)));
        assertTrue(testList.get(0).equals(testList.get(1)));
    }

    /**
     * A true-negative test for the equals method in DictionaryEntry.
     */
    @Test
    public void testEqualsTrueNegative(){
        testList = new LinkedList<>(Arrays.asList(new DictionaryEntry("abbey","abaty", wordTypeEnum.nm),new DictionaryEntry("above","dramor",wordTypeEnum.other)));
        assertFalse(testList.get(0).equals(testList.get(1)));
    }



}