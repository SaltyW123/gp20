package uk.ac.aber.cs221.group20.test;

import org.junit.jupiter.api.Test;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;
import uk.ac.aber.cs221.group20.javafx.Application;
import uk.ac.aber.cs221.group20.selfassessment.AssessmentGenerator;
import uk.ac.aber.cs221.group20.selfassessment.Question;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssessmentGeneratorTest extends AssessmentGenerator {

    @Test
    void testNumOfAssessments() {
        LinkedList<Question> listOfAssessments;
        listOfAssessments = generateAssessment(Application.dictionary);

        assertEquals(10,listOfAssessments.size());

    }





}