package ocr.service;

import ocr.OcrSuite;
import java.util.ArrayList;
import ocr.system.PixelHistogram;
import java.awt.Image;
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

      Image pImage = OcrSuite.cCharImage;
      FeatureExtractor instance = new FeatureExtractor(pImage);
      instance.run();
      PixelHistogram hist = new PixelHistogram(pImage);
      Collection expResult = new ArrayList<Double>();
      expResult.add(hist.getArea());
      for (double i : hist.getColumnHistogram())
      {
         expResult.add(i);
      }
      for (double i : hist.getRowHistogram())
      {
         expResult.add(i);
      }
      
      Collection result = instance.getFeaturePoint();
      assertEquals(expResult, result);
   }

   /**
    * Test of run method, of class FeatureExtractor.
    */
   @Test
   public void testRun()
   {
      System.out.println("run");

      Image pImage = OcrSuite.cCharImage;
      FeatureExtractor instance = new FeatureExtractor(pImage);
      instance.run();

      PixelHistogram hist = new PixelHistogram(pImage);
      Collection expResult = new ArrayList<Double>();
      expResult.add(hist.getArea());
      for (double i : hist.getColumnHistogram())
      {
         expResult.add(i);
      }
      for (double i : hist.getRowHistogram())
      {
         expResult.add(i);
      }

      Collection result = instance.getFeaturePoint();
      assertEquals(expResult, result);
   }
}
