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
public class ValueComparatorTest
{
   public ValueComparatorTest()
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
    * Test of compare method, of class ValueComparator.
    */
   @Test
   public void testCompare()
   {
      System.out.println("compare");
      Object o1 = null;
      Object o2 = null;
      ValueComparator instance = new ValueComparator();
      int expResult = 0;
      int result = instance.compare(o1, o2);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
