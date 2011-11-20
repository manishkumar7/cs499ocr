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
public class CharacterFeaturePairTest
{
   public CharacterFeaturePairTest()
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
    * Test of getCharacter method, of class CharacterFeaturePair.
    */
   @Test
   public void testGetCharacter()
   {
      System.out.println("getCharacter");
      CharacterFeaturePair instance = null;
      String expResult = "";
      String result = instance.getCharacter();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getFeaturePoint method, of class CharacterFeaturePair.
    */
   @Test
   public void testGetFeaturePoint()
   {
      System.out.println("getFeaturePoint");
      CharacterFeaturePair instance = null;
      Collection expResult = null;
      Collection result = instance.getFeaturePoint();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
