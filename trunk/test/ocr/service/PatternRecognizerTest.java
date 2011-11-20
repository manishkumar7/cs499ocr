package ocr.service;

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
    * Test of quickSort method, of class PatternRecognizer.
    */
   @Test
   public void testQuickSort()
   {
      System.out.println("quickSort");
      int pLowerBound = 0;
      int pUpperBound = 0;
      PatternRecognizer instance = null;
      instance.quickSort(pLowerBound, pUpperBound);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getCharacter method, of class PatternRecognizer.
    */
   @Test
   public void testGetCharacter()
   {
      System.out.println("getCharacter");
      PatternRecognizer instance = null;
      String expResult = "";
      String result = instance.getCharacter();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of run method, of class PatternRecognizer.
    */
   @Test
   public void testRun()
   {
      System.out.println("run");
      PatternRecognizer instance = null;
      instance.run();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
