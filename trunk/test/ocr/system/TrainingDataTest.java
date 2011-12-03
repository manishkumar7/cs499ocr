package ocr.system;

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
public class TrainingDataTest
{
   public TrainingDataTest()
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
    * Test of getInstance method, of class TrainingData.
    */
   @Test
   public void testGetInstance()
   {
      System.out.println("getInstance");
      TrainingData expResult = null;
      TrainingData result = TrainingData.getInstance();
      assertEquals(expResult, result);
   }

   /**
    * Test of insert method, of class TrainingData.
    */
   @Test
   public void testInsert()
   {
      System.out.println("insert");
      CharacterFeaturePair pData = null;
      TrainingData instance = null;
      instance.insert(pData);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getData method, of class TrainingData.
    */
   @Test
   public void testGetData()
   {
      System.out.println("getData");
      TrainingData instance = null;
      Collection expResult = null;
      Collection result = instance.getData();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
