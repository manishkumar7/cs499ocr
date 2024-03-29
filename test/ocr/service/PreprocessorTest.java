package ocr.service;

import ocr.system.ImageAssert;
import java.util.ArrayList;
import ocr.system.ImageProcessingLibrary;
import java.awt.Image;
import ocr.OcrSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
      try
      {
         Image pImage = OcrSuite.cCharImage;
         Image document = ImageProcessingLibrary.threshold(pImage);
         document = ImageProcessingLibrary.correctSkew(document);
         document = ImageProcessingLibrary.trim(document);

         ArrayList<Image> expResult;
         expResult = (ArrayList<Image>) ImageProcessingLibrary.extractCharacters(
            document);
         ArrayList<Image> result;
         result = (ArrayList<Image>) Preprocessor.preprocess(pImage);

         int i = 0;
         for (Image exp : expResult)
         {
            Image res = null;
            if (i < result.size())
            {
               res = result.get(i);
            }
            ImageAssert.isEqual(exp, res);
            i++;
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
}
