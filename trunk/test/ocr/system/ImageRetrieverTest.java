package ocr.system;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Image;
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
public class ImageRetrieverTest
{
   public ImageRetrieverTest()
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
    * Test of readImage method, of class ImageRetriever.
    */
   @Test
   public void testReadImage()
   {
      System.out.println("readImage");
      File img = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\"
           + "Doman Domain\\Classes\\Senior Project\\Test\\char.jpg");
      ImageRetriever instance = new ImageRetriever(img);
      Image expResult = null;
      try
      {
         expResult = ImageIO.read(img);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      Image result = instance.readImage();

      ImageAssert.isEqual(expResult, result);
   }
}
