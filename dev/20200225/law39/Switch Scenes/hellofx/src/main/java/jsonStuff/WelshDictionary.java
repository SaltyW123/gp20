package jsonStuff;

import java.util.Objects;

public class WelshDictionary {
    private String english;
    private String welsh;
    private String wordType;

    public WelshDictionary(){}



    public WelshDictionary(String english, String welsh, String wordType) {
        this.english = english;
        this.welsh = welsh;
        this.wordType = wordType;
    }

    public WelshDictionary(String english, String welsh){
        this.english = english;
        this.welsh = welsh;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WelshDictionary that = (WelshDictionary) o;
        return english.equals(that.english) &&
                welsh.equals(that.welsh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(english, welsh, wordType);
    }
}
