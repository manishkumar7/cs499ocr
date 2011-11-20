package ocr.system;

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
public class IntegerCharacterPairTest
{
   public IntegerCharacterPairTest()
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
    * Test of getValue method, of class IntegerCharacterPair.
    */
   @Test
   public void testGetValue()
   {
      System.out.println("getValue");
      IntegerCharacterPair instance = null;
      Integer expResult = null;
      Integer result = instance.getValue();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getCharacterImage method, of class IntegerCharacterPair.
    */
   @Test
   public void testGetCharacterImage()
   {
      System.out.println("getCharacterImage");
      IntegerCharacterPair instance = null;
      Image expResult = null;
      Image result = instance.getCharacterImage();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getBox method, of class IntegerCharacterPair.
    */
   @Test
   public void testGetBox()
   {
      System.out.println("getBox");
      IntegerCharacterPair instance = null;
      BoundingBox expResult = null;
      BoundingBox result = instance.getBox();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
