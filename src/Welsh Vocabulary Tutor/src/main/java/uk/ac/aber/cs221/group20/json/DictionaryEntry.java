/**
 * @(#) DictionaryEntry.java 0,1 2020/04/07
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.json;

import uk.ac.aber.cs221.group20.javafx.DictionaryController;
import uk.ac.aber.cs221.group20.javafx.Application;

/**
 * A class that demonstrates how a controller works.
 *
 * @author Brad Corbett [brc9]
 * @author Henry Dugmore [hjd3]
 * @author Kain Bryan-Jones [kab74]
 * @author Luke Wybar [law39]
 * @author Marcin Jakob [maj83]
 * @author Oscar Pocock [osp1]
 * @author Tom Perry [top19]
 * @author Waylen Watts [ncw]
 * @version 0.1 Initial development
 * @see DictionaryController
 */
public class DictionaryEntry {

   // /////////////////// //
   // Instance variables. //
   // /////////////////// //

   private String english;
   private String welsh;
   public enum wordTypeEnum {
      nm, nf, verb, other
   }
   private wordTypeEnum wordType;
   private Boolean practiceWord;

   // ///////////// //
   // Constructors. //
   // ///////////// //

   /**
    * Default constructor for DictionaryEntry.
    */
   public DictionaryEntry() {
      practiceWord = false;
   }

   /**
    * Constructor that creates an instance of DictionaryEntry when given 'english', 'welsh' and 'wordType' parameters.
    *
    * @param english      english translation of the word
    * @param welsh        welsh translation of the word
    * @param wordType     type of word
    * @see Application
    * @see DictionaryController
    */
   public DictionaryEntry(String english, String welsh, wordTypeEnum wordType) {
      this.english = english;
      this.welsh = welsh;
      this.wordType = wordType;
   }

   // ////////////////////// //
   // Read/Write properties. //
   // ////////////////////// //

   /**
    * Getter method for the 'english variable'.
    *
    * @return Current value of 'english'.
    */
   public String getEnglish() {
      return english;
   }

   /**
    * Setter for the 'english' variable.
    *
    * @param english New String value for 'english'.
    */
   public void setEnglish(String english) {
      this.english = english.trim();
   }

   /**
    * Getter for the 'welsh' variable.
    *
    * @return Current value of 'welsh'.
    */
   public String getWelsh() {
      return welsh;
   }

   /**
    * Setter for the 'welsh' variable.
    *
    * @param welsh New String value for 'welsh'.
    */
   public void setWelsh(String welsh) {
      this.welsh = welsh.trim();
   }

   /**
    * Getter for the 'wordType' enum variable.
    *
    * @return Current value of the 'wordType'.
    * @see wordTypeEnum
    */
   public wordTypeEnum getWordType() {
      return wordType;
   }

   /**
    * Setter for the 'wordType' enum variable.
    *
    * @param wordType New wordTypeEnum value for the 'wordType'.
    * @see wordTypeEnum
    */
   public void setWordType(wordTypeEnum wordType) {
      this.wordType = wordType;
   }

   /**
    * Getter for the 'practiceWord' variable.
    *
    * @return Current value of 'practiceWord'
    */
   public Boolean isPracticeWord() {
      return practiceWord;
   }

   /**
    * Setter for the 'practiceWord' variable.
    *
    * @param practiceWord New boolean value for 'practiceWord'.
    */
   public void setPracticeWord(Boolean practiceWord) {
      this.practiceWord = practiceWord;
   }

   // //////// //
   // Methods. //
   // //////// //

   /**
    * Overidden equals method that checks to see if two Dictionary objects are equal to each other. This work by checking if the objects 'english' or 'welsh' variables are
    * equal with the same 'wordType'.
    *
    * @param entry Object that the DictionaryEntry object is comparing itself to.
    * @return Returns true (if equal) or false (not equal).
    */
   @Override
   public boolean equals(Object entry) {
      DictionaryEntry otherEntry = (DictionaryEntry) entry; // Cast the object to be a DictionaryEntry.

      return ((this.getWelsh().equalsIgnoreCase(otherEntry.getWelsh()) || this.getEnglish().equalsIgnoreCase(otherEntry.getWelsh())) &&
            this.getWordType().equals(otherEntry.getWordType())); // Check it they're equal by looking if they have equal 'welsh' or 'english' with the same 'wordType'.
   }
}
