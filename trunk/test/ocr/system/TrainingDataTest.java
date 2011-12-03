package ocr.system;

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
      TrainingData instance = TrainingData.getInstance();
      Collection expResult = null;
      Collection result = instance.getData();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
