package ocr;

import java.awt.Image;
import java.io.File;
import ocr.system.ImageRetriever;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Devin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
   ocr.service.ServiceSuite.class, ocr.desktop.DesktopSuite.class, ocr.system.SystemSuite.class
})
public class OcrSuite
{
   public static Image cCharImage;
   public static Image cTextImage;
   public static Image cExtractImage;

   static
   {
      File imgFile = new File(".\\test\\res\\char.jpg");
      cCharImage = new ImageRetriever(imgFile).readImage();

      imgFile = new File(".\\test\\res\\text.jpg");
      cTextImage = new ImageRetriever(imgFile).readImage();

      imgFile = new File(".\\test\\res\\extract.jpg");
      cExtractImage = new ImageRetriever(imgFile).readImage();
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
      throws Exception
   {
   }

   @After
   public void tearDown()
      throws Exception
   {
   }
}
