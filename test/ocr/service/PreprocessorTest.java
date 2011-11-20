package ocr.service;

import java.awt.Image;
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
public class PreprocessorTest
{
   public PreprocessorTest()
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
    * Test of preprocess method, of class Preprocessor.
    */
   @Test
   public void testPreprocess()
   {
      System.out.println("preprocess");
      Image pImage = null;
      Collection expResult = null;
      Collection result = Preprocessor.preprocess(pImage);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
