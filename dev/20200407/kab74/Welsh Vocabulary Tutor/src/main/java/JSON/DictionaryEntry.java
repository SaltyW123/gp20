package JSON;

/*
 * This class stores information on dictionary entries. A dictionary entries consists of
 * a pair of words, that is the English and Welsh version of the same word. It also
 * stores the type of word it is, that is 'verb' or 'noun' etc. It also marks whether or not this entry
 * is a 'practice word'.
 * @Author kab74
 * @Author top19
 * @Version 0.1
 */
public class DictionaryEntry {

    private String englishWord;
    private String welshWord;
    private String wordType;
    private boolean isPracticeWord;

    /*
     * Default constructor for DictionaryEntry. By default the entry is NOT a practice word.
     */
    public DictionaryEntry(){
        isPracticeWord = false;
    }

    /*
     * This method is the constructor which allows the user to enter all the field values of the class
     * except for isPracticeWord.
     * @Param englishWord The English translation of the word
     * @Param welshWord The Welsh translation of the word
     * @Param wordType The type of word
     */
    public DictionaryEntry(String englishWord, String welshWord, String wordType ){
        this.englishWord = englishWord;
        this.welshWord = welshWord;
        this.wordType = wordType;
    }

    /*
     * @return englishWord the English translation of the word as a String.
     */
    public String getEnglishWord() {
        return englishWord;
    }

    /*
     * @return englishWord the English translation of the word as a String.
     */
    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    /*
     * @return englishWord the English translation of the word as a String.
     */
    public String getWelshWord() {
        return welshWord;
    }

    /*
     * @Param welshWord The word to set this Dictionary Entry's welsh word to.
     */
    public void setWelshWord(String welshWord) {
        this.welshWord = welshWord;
    }


    /*
     * @Return The word type of the dictionary entry.
     */
    public String getWordType() {
        return wordType;
    }

    /*
     *Sets the word type.
     * @Param word type to be set to.
     */
    public void setWordType(String wordType) {
        this.wordType = wordType;
    }


    /*
     *@return whether the word is a practice word or not.
     */
    public boolean isPracticeWord() {
        return isPracticeWord;
    }


    /*
     * @Param the boolean value of whether or not this entry is a practice word.
     */
    public void setPracticeWord(boolean practiceWord) {
        this.isPracticeWord = practiceWord;
    }


    @Override
    public String toString() {
        return "english='" + englishWord + "'\t" +
                "welsh='" + welshWord + "'\t" +
                "wordType='" + wordType + "'" +
                "practiceWord = " + isPracticeWord;
    }

}
