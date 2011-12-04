package ocr.desktop;

import ocr.OcrSuite;
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
public class DesktopPrompterTest
{
   public DesktopPrompterTest()
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
    * Test of promptUser method, of class DesktopPrompter.
    */
   @Test
   public void testPromptUser()
   {
      System.out.println("promptUser");
      Image pImage = OcrSuite.cCharImage;
      DesktopPrompter instance = new DesktopPrompter();
      String expResult = "a";
      String result = instance.promptUser(pImage);
      assertEquals(expResult, result);
   }
}
