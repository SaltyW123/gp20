/*
 * @(#) AssessmentGeneratorTest.java 0,1 2020/05/01
 * <p>
 * Copyright (c) 2020 Aberystwyth University.
 * All rights reserved.
 */
package uk.ac.aber.cs221.group20.test;

import org.junit.jupiter.api.Test;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;
import uk.ac.aber.cs221.group20.javafx.Application;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test class for various tests regarding AssessmentGenerator.
 * @author Luke Wybar [law]
 */
public class AssessmentGeneratorTest extends AssessmentGenerator {


   // ////////////// //
   // Class methods. //
   // ////////////// //

   /**
    * Tests to see if the right amount of tests is generated.
    */
   @Test
   void testNumOfAssessments() {
      LinkedList<Question> listOfAssessments;
      listOfAssessments = generateAssessment(Application.dictionary);

      assertEquals(10,listOfAssessments.size());

   }





}