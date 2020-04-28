package uk.ac.aber.cs22120.group20.selfassessment;

public class SixMeaningsQuestion {
   private static SixMeaningsQuestion ourInstance = new SixMeaningsQuestion();

   public static SixMeaningsQuestion getInstance() {
      return ourInstance;
   }

   private SixMeaningsQuestion() {
   }
}
