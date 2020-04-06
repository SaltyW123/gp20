package jsonStuff;

public class WelshDictionary {
    private String english;
    private String welsh;
    private String wordType;


    public WelshDictionary() {
    }

    public WelshDictionary(String english, String welsh, String wordType) {
        this.english = english;
        this.welsh = welsh;
        this.wordType = wordType;
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

    @Override
    public String toString() {
        return "WelshDictionary{" +
                "english='" + english + '\'' +
                ", welsh='" + welsh + '\'' +
                ", wordType='" + wordType + '\'' +
                '}';
    }
}
