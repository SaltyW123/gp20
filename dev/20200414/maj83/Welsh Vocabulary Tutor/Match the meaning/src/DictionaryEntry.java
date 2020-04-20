public class DictionaryEntry {

        private String english;
        private String welsh;
        private String wordType;
        private boolean practiceWord;


        public DictionaryEntry(){
            practiceWord = false;
        }

        public DictionaryEntry(String english, String welsh, String wordType ){
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


        public boolean isPracticeWord() {
            return practiceWord;
        }


        public void setPracticeWord(boolean practiceWord) {
            this.practiceWord = practiceWord;
        }


        @Override
        public String toString() {
            return "english='" + english + "'\t" +
                    "welsh='" + welsh + "'\t" +
                    "wordType='" + wordType + "'" +
                    "practiceWord = " + practiceWord;
        }

}

