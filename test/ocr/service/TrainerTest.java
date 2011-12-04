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
public class TrainerTest
{
   public TrainerTest()
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
    * Test of train method, of class Trainer.
    */
   @Test
   public void testTrain()
   {
      System.out.println("train");
      Trainer instance = null;
      String expResult = "";
      String result = instance.train();
      assertEquals(expResult, result);
   }
}
