package uk.ac.aber.cs22120.group20;

import javafx.beans.property.SimpleStringProperty;

public class WelshDictionary {
    private SimpleStringProperty english;
    private SimpleStringProperty welsh;
    private SimpleStringProperty wordType;

    public WelshDictionary(String english, String welsh, String wordType) {
        this.english = new SimpleStringProperty(english);
        this.welsh = new SimpleStringProperty(welsh);
        this.wordType = new SimpleStringProperty(wordType);
    }

    public String getWelsh() {
        return welsh.get();
    }

    public SimpleStringProperty welshProperty() {
        return welsh;
    }

    public String getEnglish() {
        return english.get();
    }

    public SimpleStringProperty englishProperty() {
        return english;
    }

    public String getWordType() {
        return wordType.get();
    }

    public SimpleStringProperty wordTypeProperty() {
        return wordType;
    }
}
