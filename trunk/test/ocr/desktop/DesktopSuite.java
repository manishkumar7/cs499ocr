package ocr.desktop;

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
   ocr.desktop.ImageDisplayerTest.class, ocr.desktop.DesktopOCRTest.class, ocr.desktop.ImageFilterTest.class, ocr.desktop.DesktopPrompterTest.class
})
public class DesktopSuite
{
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
