package ocr.service;

import ocr.desktop.DesktopPrompter;
import ocr.OcrSuite;
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
      OcrSuite.backupTraining();
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
      OcrSuite.restoreTraining();
   }

   /**
    * Test of train method, of class Trainer.
    */
   @Test
   public void testTrain()
   {
      System.out.println("train");
      TrainingDataProxy proxy = new TrainingDataProxy();
      int size = proxy.getTrainingData().size();
      Trainer instance = new Trainer(new DesktopPrompter(), OcrSuite.cTextImage);
      String expResult = "abcdefghijklmnopqrstuvwxyz";
      String result = instance.train();
      assertEquals(expResult, result);

      Integer expSize = size + 26;
      Integer resultSize = proxy.getTrainingData().size();
      assertEquals(expSize, resultSize);
   }
}
