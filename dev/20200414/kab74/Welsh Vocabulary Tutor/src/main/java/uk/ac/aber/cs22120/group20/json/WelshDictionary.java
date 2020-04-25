package uk.ac.aber.cs22120.group20.json;

/**
 * Class containing all the fields needed for storing dictionary definitions including
 * Welsh and English translations along with its word type and whether it’s a practice word or not.
 * @Author
 * @Version
 * @See
 */
public class WelshDictionary implements Comparable<WelshDictionary>{

    private String welshWord;
    private String englishWord;
    private String wordType;
    private boolean isPracticeWord;
    private String practiceWord;

    /**
     * Default constructor for WelshDictionary.
     */
    public WelshDictionary(){};

    /**
     *
     * @param englishWord
     * @param welshWord
     * @param wordType
     * @param isPracticeWord
     */
    public WelshDictionary(String englishWord, String welshWord, String wordType, Boolean isPracticeWord){
        
    }

    /**
     *
     * @return
     */
    public String getWelshWord(){
        return welshWord;
    }

    /**
     *
     * @return
     */
    public String getEnglishWord(){
        return englishWord;
    }

    /**
     *
     * @return
     */
    public String getWordType(){
        return wordType;
    }

    /**
     *
     * @return
     */
    public boolean isPracticeWord(){
        return isPracticeWord();
    }

    /**
     *
     * @param welshWord
     */
    public void setWelshWord(String welshWord){
        this.welshWord=welshWord;
    }

    /**
     *
     * @param englishWord
     */
    public void setEnglishWord(String englishWord){
        this.englishWord=englishWord;

    }

    /**
     *
     * @param wordType
     */
    public void setWordType(String wordType){
        this.wordType=wordType;
    }

    /**
     *
     * @param practiceWord
     */
    public void setPracticeWord(String practiceWord){
        this.practiceWord() = practiceWord;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o){

    }

    /**
     *
     * @param welshDictionary
     * @return
     */
    @Override
    public int compareTo(WelshDictionary welshDictionary) {
        return 0;
    }

}
