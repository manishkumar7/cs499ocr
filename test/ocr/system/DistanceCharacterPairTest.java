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
public class DistanceCharacterPairTest
{
   public DistanceCharacterPairTest()
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
    * Test of getCharacter method, of class DistanceCharacterPair.
    */
   @Test
   public void testGetCharacter()
   {
      System.out.println("getCharacter");
      DistanceCharacterPair instance = new DistanceCharacterPair("zed", 0.0);
      String expResult = "zed";
      String result = instance.getCharacter();
      assertEquals(expResult, result);
   }

   /**
    * Test of getDistance method, of class DistanceCharacterPair.
    */
   @Test
   public void testGetDistance()
   {
      System.out.println("getDistance");
      DistanceCharacterPair instance = new DistanceCharacterPair(null, 3.0);
      double expResult = 3.0;
      double result = instance.getDistance();
      assertEquals(expResult, result, 0.0);
   }
}
