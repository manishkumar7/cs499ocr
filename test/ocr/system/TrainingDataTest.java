package ocr.system;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import junit.framework.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
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
   private static final String cBackupFile = "train.bk";
   public TrainingDataTest()
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
    * Test of getInstance method, of class TrainingData.
    */
   @Test
   public void testGetInstance()
   {
      System.out.println("getInstance");
      TrainingData expResult = null;

      try
      {
         File file = new File(TrainingData.cFileName);
         if (file.exists())
         {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            expResult = (TrainingData) ois.readObject();
            ois.close();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      if (expResult == null)
      {
         expResult = TrainingData.getInstance();
      }

      TrainingData result = TrainingData.getInstance();
      isEqual(expResult, result);
   }

   /**
    * Determine if two TrainingData objects are equal. They are considered
    * equal if they contain the same data values.
    * 
    * @param expResult The expected training data
    * @param result The training data to compare with
    * @return True if the training data values are the same
    */
   private boolean isEqual(TrainingData expResult, TrainingData result)
   {
      boolean isEqual = true;

      int i = 0;
      ArrayList<CharacterFeaturePair> rData;
      rData = (ArrayList<CharacterFeaturePair>)result.getData();
      for (CharacterFeaturePair exp : expResult.getData())
      {
         CharacterFeaturePair res = rData.get(i);
         if ((!exp.getCharacter().equals(res.getCharacter())) ||
            (exp.getFeaturePoint() != exp.getFeaturePoint()))
         {
            isEqual = false;
            break;
         }
         i++;
      }

      if (!isEqual)
      {
         Assert.failNotEquals("Training data does not match.", expResult, result);
      }

      return isEqual;
   }

   /**
    * Test of insert method, of class TrainingData.
    */
   @Test
   public void testInsert()
   {
      System.out.println("insert");
      CharacterFeaturePair pData = new CharacterFeaturePair("test", null);
      TrainingData instance = TrainingData.getInstance();
      instance.insert(pData);

      ArrayList<CharacterFeaturePair> data;
      data = (ArrayList<CharacterFeaturePair>) instance.getData();
      assertTrue(data.contains(pData));
   }

   /**
    * Test of getData method, of class TrainingData.
    */
   @Test
   public void testGetData()
   {
      System.out.println("getData");
      TrainingData instance = TrainingData.getInstance();
      Collection result = instance.getData();
      assertFalse(result.isEmpty());
   }
}
