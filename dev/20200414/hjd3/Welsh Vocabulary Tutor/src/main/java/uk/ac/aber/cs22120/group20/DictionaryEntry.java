/**
 * @(#) DictionaryEntry.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs22120.group20;

//import uk.ac.aber.cs22120.group20.DictionaryController;

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
// * @see DictionaryController
 */
public class DictionaryEntry {
    private String english;
    private String welsh;
    private String wordType;
    private Boolean practiceWord;

    @Override
    public String toString() {
        return "DictionaryEntry{" +
                "english='" + english + '\'' +
                ", welsh='" + welsh + '\'' +
                ", wordType='" + wordType + '\'' +
                ", practiceWord=" + practiceWord +
                '}';
    }

    /**
     * Creates new instance of a DictionaryEntry
     *
     * @param english      english translation of the word
     * @param welsh        welsh translation of the word
     * @param wordType     type of word
     * @param practiceWord determines if the entry is in the practice list
     * @see App
//     * @see DictionaryController
     */
    public DictionaryEntry(String english, String welsh, String wordType, Boolean practiceWord) {
        this.english = english;
        this.welsh = welsh;
        this.wordType = wordType;
        this.practiceWord = practiceWord;

    }

// may cause problems
    public boolean equals(DictionaryEntry obj) {

        if(obj.getEnglish().equals(this.getEnglish()) && obj.getWelsh().equals(this.getWelsh()) && obj.getWordType().equals(this.getWordType())){
            return true;
        }
        else{
            return false;
        }
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
