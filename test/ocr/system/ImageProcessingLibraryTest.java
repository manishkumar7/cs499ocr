package ocr.system;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
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
public class ImageProcessingLibraryTest
{
   public ImageProcessingLibraryTest()
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
    * Test of threshold method, of class ImageProcessingLibrary.
    */
   @Test
   public void testThreshold()
   {
      System.out.println("threshold");
      BufferedImage pImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
      pImage.setRGB(0, 0, 0xff303030);
      BufferedImage doc = (BufferedImage) ImageProcessingLibrary.threshold(pImage);
      Integer expResult = 0xff000000;
      Integer result = doc.getRGB(0, 0);
      assertEquals(expResult, result);
   }

   /**
    * Test of correctSkew method, of class ImageProcessingLibrary.
    */
   @Test
   public void testCorrectSkew()
   {
      System.out.println("correctSkew");

      int height = 3;
      int width = 10;
      BufferedImage pImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            if (row == 1)
            {
               pImage.setRGB(col, row, ImageProcessingLibrary.ONBLACK);
            }
            else
            {
               pImage.setRGB(col, row, ImageProcessingLibrary.OFFWHITE);
            }
         }
      }

      BufferedImage expResult = new BufferedImage(19, 10, BufferedImage.TYPE_INT_RGB);
      for (int row = 0; row < 10; row++)
      {
         for (int col = 0; col < 19; col++)
         {
            if ((row == 5) && (col > 4) && (col <= 14))
            {
               expResult.setRGB(col, row, ImageProcessingLibrary.ONBLACK);
            }
            else
            {
               expResult.setRGB(col, row, ImageProcessingLibrary.OFFWHITE);
            }
         }
      }
      BufferedImage result = (BufferedImage) ImageProcessingLibrary.correctSkew(pImage);
      result = (BufferedImage) ImageProcessingLibrary.trim(result);
      
      ImageAssert.isEqual(expResult, result);
   }

   /**
    * Test of mean method, of class ImageProcessingLibrary.
    */
   @Test
   public void testMean()
   {
      System.out.println("mean");
      Collection<Double> pData = new ArrayList<Double>();
      pData.add(3.0);
      pData.add(5.0);
      pData.add(212.0);
      double expResult = (3 + 5 + 212) / 3.0;
      double result = ImageProcessingLibrary.mean(pData);
      assertEquals(expResult, result, 0.0);
   }

   /**
    * Test of variance method, of class ImageProcessingLibrary.
    */
   @Test
   public void testVariance()
   {
      System.out.println("variance");
      Collection<Double> pData = new ArrayList<Double>();
      pData.add(3.0);
      pData.add(5.0);
      pData.add(212.0);
      double expResult = 9614.88888888889;
      double result = ImageProcessingLibrary.variance(pData);
      assertEquals(expResult, result, 0.0);
   }

   /**
    * Test of trim method, of class ImageProcessingLibrary.
    */
   @Test
   public void testTrim()
   {
      System.out.println("trim");
      BufferedImage pImage = new BufferedImage(19, 50, BufferedImage.TYPE_INT_RGB);
      for (int row = 0; row < 50; row++)
      {
         for (int col = 0; col < 19; col++)
         {
            if ((row == 5) && (col > 4) && (col <= 14))
            {
               pImage.setRGB(col, row, ImageProcessingLibrary.ONBLACK);
            }
            else
            {
               pImage.setRGB(col, row, ImageProcessingLibrary.OFFWHITE);
            }
         }
      }

      BufferedImage expResult = new BufferedImage(19, 10, BufferedImage.TYPE_INT_RGB);
      for (int row = 0; row < 10; row++)
      {
         for (int col = 0; col < 19; col++)
         {
            if ((row == 5) && (col > 4) && (col <= 14))
            {
               expResult.setRGB(col, row, ImageProcessingLibrary.ONBLACK);
            }
            else
            {
               expResult.setRGB(col, row, ImageProcessingLibrary.OFFWHITE);
            }
         }
      }
      
      Image result = ImageProcessingLibrary.trim(pImage);
      ImageAssert.isEqual(expResult, result);
   }

   /**
    * Test of labelConnectedComponents method, of class ImageProcessingLibrary.
    */
   @Test
   public void testLabelConnectedComponents()
   {
      System.out.println("labelConnectedComponents");
      Image pImage = null;
      int[][] expResult = null;
      int[][] result = ImageProcessingLibrary.labelConnectedComponents(pImage);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of extractCharacters method, of class ImageProcessingLibrary.
    */
   @Test
   public void testExtractCharacters()
   {
      System.out.println("extractCharacters");
      File img = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\"
           + "Doman Domain\\Classes\\Senior Project\\Test\\char.jpg");
      Image pImage = new ImageRetriever(img).readImage();
      pImage = ImageProcessingLibrary.threshold(pImage);
      pImage = ImageProcessingLibrary.correctSkew(pImage);
      pImage = ImageProcessingLibrary.trim(pImage);

      ArrayList<Image> expResult = new ArrayList<Image>();
      img = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\"
           + "Doman Domain\\Classes\\Senior Project\\Test\\extract.jpg");
      Image normal = new ImageRetriever(img).readImage();
      normal = ImageProcessingLibrary.threshold(normal);
      expResult.add(normal);
      Collection extract = ImageProcessingLibrary.extractCharacters(pImage);
      ArrayList<Image> result = (ArrayList<Image>) extract;

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
}
