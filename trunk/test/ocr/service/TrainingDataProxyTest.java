package ocr.service;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
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
   private static final String cBackupFile = "train.bk";
   public TrainingDataProxyTest()
   {
      File file = new File(TrainingData.cFileName);
      File bck = new File(cBackupFile);
      if (file.exists())
      {
         try
         {
            InputStream in = new FileInputStream(file);
            OutputStream out = new FileOutputStream(bck);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
               out.write(buf, 0, len);
            }
            in.close();
            out.close();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
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
      File file = new File(TrainingData.cFileName);
      File bck = new File(cBackupFile);
      if (bck.exists())
      {
         try
         {
            InputStream in = new FileInputStream(bck);
            OutputStream out = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
               out.write(buf, 0, len);
            }
            in.close();
            out.close();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   /**
    * Test of getTrainingData method, of class TrainingDataProxy.
    */
   @Test
   public void testGetTrainingData()
   {
      System.out.println("getTrainingData");
      TrainingDataProxy instance = new TrainingDataProxy();
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
      TrainingDataProxy instance = new TrainingDataProxy();
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
