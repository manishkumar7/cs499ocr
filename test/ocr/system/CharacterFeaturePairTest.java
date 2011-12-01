package ocr.system;

import java.util.ArrayList;
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
      CharacterFeaturePair instance = new CharacterFeaturePair("zed", null);
      String expResult = "zed";
      String result = instance.getCharacter();
      assertEquals(expResult, result);
   }

   /**
    * Test of getFeaturePoint method, of class CharacterFeaturePair.
    */
   @Test
   public void testGetFeaturePoint()
   {
      System.out.println("getFeaturePoint");
      ArrayList<Double> list = new ArrayList<Double>();
      list.add(2.0);
      CharacterFeaturePair instance = new CharacterFeaturePair(null, list);
      Collection expResult = list;
      Collection result = instance.getFeaturePoint();
      assertEquals(expResult, result);
   }
}
