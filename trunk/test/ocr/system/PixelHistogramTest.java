package ocr.system;

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
   public PixelHistogramTest()
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
    * Test of getArea method, of class PixelHistogram.
    */
   @Test
   public void testGetArea()
   {
      System.out.println("getArea");
      PixelHistogram instance = null;
      Double expResult = null;
      Double result = instance.getArea();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getColumnHistogram method, of class PixelHistogram.
    */
   @Test
   public void testGetColumnHistogram()
   {
      System.out.println("getColumnHistogram");
      PixelHistogram instance = null;
      Collection expResult = null;
      Collection result = instance.getColumnHistogram();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getRowHistogram method, of class PixelHistogram.
    */
   @Test
   public void testGetRowHistogram()
   {
      System.out.println("getRowHistogram");
      PixelHistogram instance = null;
      Collection expResult = null;
      Collection result = instance.getRowHistogram();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
