package JSONStuff;

import java.util.LinkedList;
import java.util.Scanner;

public class App {
    private Scanner input;
    private LinkedList<DictionaryEntry> dictionary;
    private JSONProcessor processor;

    public App(){
        input = new Scanner(System.in);
        dictionary = new LinkedList<DictionaryEntry>();
        processor = new JSONProcessor();
    }

    public static void main(String[] args) {
        App testApp = new App();
        testApp.runProgram();
    }

    public void runProgram(){
        String directory;

        System.out.println("Please enter the file you wish to load: ");
        directory = input.next();
        dictionary = processor.readFile(directory);

        int choice = 0;

        do {
            System.out.println("Please select an option: \n1 - Display all words. \n2 - Display all practice words. \n3 - Add a new word" +
                    "\n4 - Add a new practice word. \n5 - Save to file.");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displayDictionary();
                    break;
                case 2:
                    displayPracticeWords();
                    break;
                case 3:
                    addWord();
                    break;
                case 4:
                    addPracticeWord();
                    break;
                case 5:
                    processor.saveFile(directory, dictionary);
                    break;
                    default:
                        System.out.println("Error - Please only choose one of the specified options.");
            }
        }while (choice != 5);
    }

    public void displayDictionary() {
        for (DictionaryEntry entry : dictionary) {
            System.out.println(entry.toString());
        }
    }

    public void displayPracticeWords(){
            for (DictionaryEntry entry: dictionary){
                if(entry.isPracticeWord())
                    System.out.println(entry.toString());
        }
    }

    public void addWord(){
        DictionaryEntry newWord = new DictionaryEntry();
        System.out.println("Please enter the english definition:");
        newWord.setEnglish(input.next());

        System.out.println("Please enter the welsh definition:");
        newWord.setWelsh(input.next());

        System.out.println("Please enter the word type:");
        newWord.setWordType(input.next());

        dictionary.add(newWord);
    }

    public void addPracticeWord(){
        DictionaryEntry practiceWord = new DictionaryEntry();
        int tempIndex;

        System.out.println("Please enter the english definition:");
        practiceWord.setEnglish(input.next());

        System.out.println("Please enter the welsh definition:");
        practiceWord.setWelsh(input.next());

        tempIndex = dictionary.indexOf(practiceWord);

        if(tempIndex != -1){
            dictionary.get(tempIndex).setPracticeWord(true);
        }else{
            System.out.println("Error - Please only choose words currently in the dictionary.");
        }


    }
}

