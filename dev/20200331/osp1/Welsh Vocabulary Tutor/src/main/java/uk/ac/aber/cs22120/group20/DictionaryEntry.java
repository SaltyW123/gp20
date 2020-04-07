/**
 * @(#) DictionaryEntry.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

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
    private SimpleStringProperty english;
    private SimpleStringProperty welsh;
    private SimpleStringProperty wordType;
    private SimpleBooleanProperty practiceWord;

    /**
     * Creates new instance of a DictionaryEntry
     *
     * @param english english translation of the word
     * @param welsh welsh translation of the word
     * @param wordType type of word
     * @param practiceWord determines if the entry is in the practice list
     * @see App
     * @see DictionaryController
     */
    public DictionaryEntry(String english, String welsh, String wordType, Boolean practiceWord) {
        this.english = new SimpleStringProperty(english);
        this.welsh = new SimpleStringProperty(welsh);
        this.wordType = new SimpleStringProperty(wordType);
        this.practiceWord = new SimpleBooleanProperty(practiceWord);

    }

    /**
     * @return the plain text English word in the entry.
     */
    public String getEnglish() {
        return english.get();
    }

    /**
     *
     * @return the SimpleStringProperty of the English word in the entry.
     */
    public SimpleStringProperty englishProperty() {
        return english;
    }

    /**
     * Sets the English word in the entry.
     * @param english the English word you want to set/change.
     */
    public void setEnglish(String english) {
        this.english.set(english);
    }

    /**
     *
     * @return the plain text Welsh word in the entry.
     */
    public String getWelsh() {
        return welsh.get();
    }

    /**
     *
     * @return the SimpleStringProperty of the Welsh word in the entry.
     */
    public SimpleStringProperty welshProperty() {
        return welsh;
    }

    /**
     * Sets the Welsh word in the entry.
     * @param welsh
     */
    public void setWelsh(String welsh) {
        this.welsh.set(welsh);
    }

    /**
     *
     * @return
     */
    public String getWordType() {
        return wordType.get();
    }

    /**
     *
     * @return
     */
    public SimpleStringProperty wordTypeProperty() {
        return wordType;
    }

    /**
     *
     * @param wordType
     */
    public void setWordType(String wordType) {
        this.wordType.set(wordType);
    }

    /**
     *
     * @return
     */
    public boolean isPracticeWord() {
        return practiceWord.get();
    }

    /**
     *
     * @return
     */
    public SimpleBooleanProperty practiceWordProperty() {
        return practiceWord;
    }

    /**
     *
     * @param practiceWord
     */
    public void setPracticeWord(boolean practiceWord) {
        this.practiceWord.set(practiceWord);
    }
}
