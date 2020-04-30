/**
 * @(#) DictionaryEntry.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20.json;

import uk.ac.aber.cs22120.group20.javafx.Application;
import uk.ac.aber.cs22120.group20.javafx.DictionaryController;

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
     * Creates a new instance of a DictionaryEntry
     */
    public DictionaryEntry() {
        practiceWord = false;
    }

    /**
     * Creates new instance of a DictionaryEntry
     *
     * @param english      english translation of the word
     * @param welsh        welsh translation of the word
     * @param wordType     type of word
     * @see Application
     * @see DictionaryController
     */
    public DictionaryEntry(String english, String welsh, String wordType) {
        this.english = english;
        this.welsh = welsh;
        this.wordType = wordType;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english.trim();
    }

    public String getWelsh() {
        return welsh;
    }

    public void setWelsh(String welsh) {
        this.welsh = welsh.trim();
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType.trim();
    }

    public Boolean isPracticeWord() {
        return practiceWord;
    }

    public void setPracticeWord(Boolean practiceWord) {
        this.practiceWord = practiceWord;
    }

    @Override
    public boolean equals(Object entry) {
        DictionaryEntry otherEntry = (DictionaryEntry) entry;
        return otherEntry.getEnglish().equals(this.getEnglish()) && otherEntry.getWelsh().equals(this.getWelsh()) && otherEntry.getWordType().equals(this.getWordType());
    }
}
