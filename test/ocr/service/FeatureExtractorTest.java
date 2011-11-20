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
public class FeatureExtractorTest
{
   public FeatureExtractorTest()
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
    * Test of getFeaturePoint method, of class FeatureExtractor.
    */
   @Test
   public void testGetFeaturePoint()
   {
      System.out.println("getFeaturePoint");
      FeatureExtractor instance = null;
      Collection expResult = null;
      Collection result = instance.getFeaturePoint();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of run method, of class FeatureExtractor.
    */
   @Test
   public void testRun()
   {
      System.out.println("run");
      FeatureExtractor instance = null;
      instance.run();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
