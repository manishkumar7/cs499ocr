package ocr.service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.File;
import ocr.system.TrainingData;
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
    * Test of getTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testGetTrainingData()
   {
      System.out.println("getTrainingData");
      TrainingDataProxy instance = new TrainingDataProxy();
      Collection expResult = null;
      Collection result = instance.getTrainingData();
      assertFalse(result.isEmpty());
   }

   /**
    * Test of insertTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testInsertTrainingData()
   {
      System.out.println("insertTrainingData");
      CharacterFeaturePair pData = new CharacterFeaturePair("test", null);
      TrainingDataProxy instance = new MockTrainingDataProxy();
      instance.insertTrainingData(pData);

      ArrayList<CharacterFeaturePair> data;
      data = (ArrayList<CharacterFeaturePair>) instance.getTrainingData();
      assertTrue(data.contains(pData));
   }

   /**
    * Test of saveTraingData method, of class TrainingDataProxy.
    */
   @Test
   public void testSaveTraingData()
   {
      System.out.println("saveTraingData");
      File file = new File(TrainingData.cFileName);
      TrainingDataProxy instance = new TrainingDataProxy();
      instance.deleteTrainingData();
      instance.saveTraingData();

      boolean result = file.exists();
      boolean expResult = true;
      assertEquals(expResult, result);
   }

   /**
    * Test of deleteTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testDeleteTrainingData()
   {
      System.out.println("deleteTrainingData");
      File file = new File(TrainingData.cFileName);

      TrainingDataProxy instance = new TrainingDataProxy();
      instance.deleteTrainingData();

      boolean result = file.exists();
      boolean expResult = false;
      assertEquals(expResult, result);
      instance.saveTraingData();
   }
}

class MockTrainingDataProxy
   extends TrainingDataProxy

{
   /**
    * The handle on the training data
    */
   private TrainingData mMockTrainingBase;

   /**
    * Stores the training data
    */
   private Collection<CharacterFeaturePair> mMockData;

   public MockTrainingDataProxy()
   {
      try
      {
         File file = new File(TrainingData.cFileName);
         if (file.exists())
         {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            mMockTrainingBase = (TrainingData) ois.readObject();
            ois.close();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      mMockData = new ArrayList<CharacterFeaturePair>();
      for (CharacterFeaturePair pair : mMockTrainingBase.getData())
      {
         mMockData.add(pair);
      }
   }

   @Override
   public void insertTrainingData(CharacterFeaturePair pData)
   {
      mMockData.add(pData);
   }

   @Override
   public Collection<CharacterFeaturePair> getTrainingData()
   {
      return mMockData;
   }
}
