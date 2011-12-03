package ocr.system;

import java.util.ArrayList;
import java.awt.image.BufferedImage;
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
public class PixelHistogramTest
{
   private Image tImage;
   
   public PixelHistogramTest()
   {
      int height = 3;
      int width = 3;
      tImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      BufferedImage temp = (BufferedImage) tImage;

      //
      // Create the following pattern
      // 1 0 1
      // 0 1 0
      // 0 0 1
      //

      int i = 0;
      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            if ((i % 4) == 0)
            {
               temp.setRGB(col, row, ImageProcessingLibrary.ONBLACK);  
            }
            else
            {
               temp.setRGB(col, row, ImageProcessingLibrary.OFFWHITE); 
            }
            i++;
         }  
      }
      temp.setRGB(2, 0, ImageProcessingLibrary.ONBLACK);
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
    * Test of getArea method, of class PixelHistogram.
    */
   @Test
   public void testGetArea()
   {
      System.out.println("getArea");
      PixelHistogram instance = new PixelHistogram(tImage);
      Double expResult = 4.0;
      Double result = instance.getArea();
      assertEquals(expResult, result);
   }

   /**
    * Test of getColumnHistogram method, of class PixelHistogram.
    */
   @Test
   public void testGetColumnHistogram()
   {
      System.out.println("getColumnHistogram");
      PixelHistogram instance = new PixelHistogram(tImage);
      ArrayList<Double> expResult = new ArrayList<Double>();
      expResult.add(1.0);
      expResult.add(1.0);
      expResult.add(2.0);
      Collection result = instance.getColumnHistogram();
      assertEquals(expResult, result);
   }

   /**
    * Test of getRowHistogram method, of class PixelHistogram.
    */
   @Test
   public void testGetRowHistogram()
   {
      System.out.println("getRowHistogram");
      PixelHistogram instance = new PixelHistogram(tImage);
      ArrayList<Double> expResult = new ArrayList<Double>();
      expResult.add(2.0);
      expResult.add(1.0);
      expResult.add(1.0);
      Collection result = instance.getRowHistogram();
      assertEquals(expResult, result);
   }
}
