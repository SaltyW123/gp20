/**
 * @(#) DictionaryEntry.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20.json;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import uk.ac.aber.cs22120.group20.App;
import uk.ac.aber.cs22120.group20.DictionaryController;

/**
 * A class that demonstrates how a controller works.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top1]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see DictionaryController
 */
public class DictionaryEntry {
    private String english;
    private String welsh;
    private String wordType;
    private Boolean practiceWord;

    /**
     * Creates new instance of a DictionaryEntry
     *
     * @param english      english translation of the word
     * @param welsh        welsh translation of the word
     * @param wordType     type of word
     * @param practiceWord determines if the entry is in the practice list
     * @see App
     * @see DictionaryController
     */
    public DictionaryEntry(String english, String welsh, String wordType, Boolean practiceWord) {
        this.english = english;
        this.welsh = welsh;
        this.wordType = wordType;
        this.practiceWord = practiceWord;

    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getWelsh() {
        return welsh;
    }

    public void setWelsh(String welsh) {
        this.welsh = welsh;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public Boolean isPracticeWord() {
        return practiceWord;
    }

    public void setPracticeWord(Boolean practiceWord) {
        this.practiceWord = practiceWord;
    }
}
