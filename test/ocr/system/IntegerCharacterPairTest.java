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
      IntegerCharacterPair instance = new IntegerCharacterPair(4, null, null);
      Integer expResult = 4;
      Integer result = instance.getValue();
      assertEquals(expResult, result);
   }

   /**
    * Test of getCharacterImage method, of class IntegerCharacterPair.
    */
   @Test
   public void testGetCharacterImage()
   {
      System.out.println("getCharacterImage");
      BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
      img.setRGB(0, 0, 0xff000000);
      IntegerCharacterPair instance = new IntegerCharacterPair(null, img, null);
      BufferedImage charImg = (BufferedImage) instance.getCharacterImage();
      Integer expResult = 0xff000000;
      Integer result = charImg.getRGB(0, 0);
      assertEquals(expResult, result);
   }

   /**
    * Test of getBox method, of class IntegerCharacterPair.
    */
   @Test
   public void testGetBox()
   {
      System.out.println("getBox");
      BoundingBox box = new BoundingBox();
      IntegerCharacterPair instance = new IntegerCharacterPair(null, null, box);
      BoundingBox expResult = box;
      BoundingBox result = instance.getBox();
      assertEquals(expResult, result);
   }
}
