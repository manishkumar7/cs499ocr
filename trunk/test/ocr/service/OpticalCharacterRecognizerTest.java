package ocr.service;

import java.awt.Image;
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
public class OpticalCharacterRecognizerTest
{
   public OpticalCharacterRecognizerTest()
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
    * Test of extractString method, of class OpticalCharacterRecognizer.
    */
   @Test
   public void testExtractString()
   {
      System.out.println("extractString");
      Image pImage = null;
      String expResult = "";
      String result = OpticalCharacterRecognizer.extractString(pImage);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
