package ocr.system;

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
public class BoundingBoxTest
{
   public BoundingBoxTest()
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
    * Test of setRow method, of class BoundingBox.
    */
   @Test
   public void testSetRow()
   {
      System.out.println("setRow");
      int pRow = 0;
      BoundingBox instance = new BoundingBox();
      instance.setRow(pRow);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of setCol method, of class BoundingBox.
    */
   @Test
   public void testSetCol()
   {
      System.out.println("setCol");
      int pCol = 0;
      BoundingBox instance = new BoundingBox();
      instance.setCol(pCol);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getMinRow method, of class BoundingBox.
    */
   @Test
   public void testGetMinRow()
   {
      System.out.println("getMinRow");
      BoundingBox instance = new BoundingBox();
      int expResult = 0;
      int result = instance.getMinRow();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getMaxRow method, of class BoundingBox.
    */
   @Test
   public void testGetMaxRow()
   {
      System.out.println("getMaxRow");
      BoundingBox instance = new BoundingBox();
      int expResult = 0;
      int result = instance.getMaxRow();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getMinCol method, of class BoundingBox.
    */
   @Test
   public void testGetMinCol()
   {
      System.out.println("getMinCol");
      BoundingBox instance = new BoundingBox();
      int expResult = 0;
      int result = instance.getMinCol();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getMaxCol method, of class BoundingBox.
    */
   @Test
   public void testGetMaxCol()
   {
      System.out.println("getMaxCol");
      BoundingBox instance = new BoundingBox();
      int expResult = 0;
      int result = instance.getMaxCol();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
