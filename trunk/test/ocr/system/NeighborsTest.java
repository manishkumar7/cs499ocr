package ocr.system;

import java.util.HashSet;
import java.util.Set;
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
public class NeighborsTest
{
   public NeighborsTest()
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
    * Test of getNeighborValues method, of class Neighbors.
    */
   @Test
   public void testGetNeighborValues()
   {
      System.out.println("getNeighborValues");
      int[][] img = {
         {0, 1, 5},
         {3, 4, 3},
         {5, 7, 8},
      };
      
      Neighbors instance = new Neighbors(img, 3, 3, 1, 1);
      Set expResult = new HashSet<Integer>();
      expResult.add(0);
      expResult.add(1);
      expResult.add(5);
      expResult.add(3);
      expResult.add(7);
      expResult.add(8);
      Set result = instance.getNeighborValues();
      assertEquals(expResult, result);
   }
}
