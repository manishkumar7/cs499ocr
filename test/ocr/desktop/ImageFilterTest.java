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
      File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"
         + "desert.jpg");
      ImageFilter instance = new ImageFilter();
      boolean expResult = true;
      boolean result = instance.accept(f);
      assertEquals(expResult, result);

      f = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\Doman Domain\\"
         + "Classes\\Senior Project\\Design\\systemUML.png");
      expResult = true;
      result = instance.accept(f);
      assertEquals(expResult, result);

      f = new File("C:\\Users\\Sir Devin\\Documents\\My Dropbox\\Doman Domain\\"
         + "Classes\\Senior Project\\Design\\systemUML.uxf");
      expResult = false;
      result = instance.accept(f);
      assertEquals(expResult, result);
   }

   /**
    * Test of getDescription method, of class ImageFilter.
    */
   @Test
   public void testGetDescription()
   {
      System.out.println("getDescription");
      ImageFilter instance = new ImageFilter();
      String expResult = "Image files only";
      String result = instance.getDescription();
      assertEquals(expResult, result);
   }
}
