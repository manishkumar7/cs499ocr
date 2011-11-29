package ocr.service;

import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Devin
 */
public class PatternRecognizerTest
{
   public PatternRecognizerTest()
   {
   }

   @BeforeClass
   public static void setUpClass()
      throws Exception
   {
   }

   @AfterClass
   public static void tearDownClass()
      throws Exception
   {
   }

   @Before
   public void setUp()
   {
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of getCharacter method, of class PatternRecognizer.
    */
   @Test
   public void testGetCharacter()
   {
      System.out.println("getCharacter");
      PatternRecognizer instance = new MockPatternRecognizer(null);
      String expResult = "zed";
      String result = instance.getCharacter();
      assertEquals(expResult, result);
   }

   /**
    * Test of run method, of class PatternRecognizer.
    */
   @Test
   public void testRun()
   {
      System.out.println("run");
      MockPatternRecognizer instance = new MockPatternRecognizer(null);
      instance.run();
      assertEquals(1, instance.test);
   }
}

class MockPatternRecognizer
   extends PatternRecognizer

{
   public static int test = 0;
   public MockPatternRecognizer(Collection<Double> pFeaturePoint)
   {
      super(pFeaturePoint);
      mCharacter = "zed";
   }

   public void run()
   {
      test++;;
   }
}
