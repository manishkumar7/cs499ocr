package ocr.service;

import java.util.Collection;
import ocr.system.CharacterFeaturePair;
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
public class TrainingDataProxyTest
{
   public TrainingDataProxyTest()
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
    * Test of insertTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testInsertTrainingData()
   {
      System.out.println("insertTrainingData");
      CharacterFeaturePair pData = null;
      TrainingDataProxy instance = new TrainingDataProxy();
      instance.insertTrainingData(pData);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of saveTraingData method, of class TrainingDataProxy.
    */
   @Test
   public void testSaveTraingData()
   {
      System.out.println("saveTraingData");
      TrainingDataProxy instance = new TrainingDataProxy();
      instance.saveTraingData();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of deleteTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testDeleteTrainingData()
   {
      System.out.println("deleteTrainingData");
      TrainingDataProxy instance = new TrainingDataProxy();
      instance.deleteTrainingData();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testGetTrainingData()
   {
      System.out.println("getTrainingData");
      TrainingDataProxy instance = new TrainingDataProxy();
      Collection expResult = null;
      Collection result = instance.getTrainingData();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
