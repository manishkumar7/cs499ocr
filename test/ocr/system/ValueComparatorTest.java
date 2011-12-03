package ocr.system;

import java.awt.image.BufferedImage;
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
      BoundingBox box = new BoundingBox();
      BufferedImage temp = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
      temp.setRGB(0, 0, ImageProcessingLibrary.ONBLACK);
      Object o1 = new IntegerCharacterPair(3, temp, box);
      Object o2 = new IntegerCharacterPair(3, temp, box);
      ValueComparator instance = new ValueComparator();
      int expResult = 0;
      int result = instance.compare(o1, o2);
      assertEquals(expResult, result);
   }
}
