package ocr.desktop;

import java.awt.Image;
import java.io.File;
import javax.swing.JOptionPane;
import ocr.system.ImageRetriever;
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
public class ImageDisplayerTest
{
   public ImageDisplayerTest()
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
    * Test of displayImage method, of class ImageDisplayer.
    */
   @Test
   public void testDisplayImage()
   {
      System.out.println("displayImage");
      File img = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"
         + "desert.jpg");
      Image pImage = new ImageRetriever(img).readImage();
      int expResult = JOptionPane.YES_OPTION;
      ImageDisplayer.displayImage(pImage);
      int result = JOptionPane.showConfirmDialog(
         null,
         "Do you see the image?",
         "Test DisplayImage",
         JOptionPane.YES_NO_OPTION);
      assertEquals(expResult, result);
   }
}
