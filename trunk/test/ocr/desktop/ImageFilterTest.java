package ocr.desktop;

import java.io.File;
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
public class ImageFilterTest
{
   public ImageFilterTest()
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
    * Test of accept method, of class ImageFilter.
    */
   @Test
   public void testAccept()
   {
      System.out.println("accept");
      File f = null;
      ImageFilter instance = new ImageFilter();
      boolean expResult = false;
      boolean result = instance.accept(f);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getDescription method, of class ImageFilter.
    */
   @Test
   public void testGetDescription()
   {
      System.out.println("getDescription");
      ImageFilter instance = new ImageFilter();
      String expResult = "";
      String result = instance.getDescription();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
