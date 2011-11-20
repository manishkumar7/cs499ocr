package ocr.service;

import ocr.system.ImageRetriever;
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
public class OpticalCharacterRecognizerTest
{
   public OpticalCharacterRecognizerTest()
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
    * Test of extractString method, of class OpticalCharacterRecognizer.
    */
   @Test
   public void testExtractString()
   {
      System.out.println("extractString");
      File img = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\"
           + "Doman Domain\\Classes\\Senior Project\\Test\\test.jpg");
      Image pImage = new ImageRetriever(img).readImage();
      String expResult = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
      String result = OpticalCharacterRecognizer.extractString(pImage);
      assertEquals(expResult, result);
   }
}
