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
public class CharacterPrompterTest
{
   public CharacterPrompterTest()
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
    * Test of promptUser method, of class CharacterPrompter.
    */
   @Test
   public void testPromptUser()
   {
      System.out.println("promptUser");
      Image pImage = null;
      CharacterPrompter instance = new CharacterPrompterImpl();
      String expResult = "";
      String result = instance.promptUser(pImage);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   public class CharacterPrompterImpl implements CharacterPrompter
   {
      public String promptUser(Image pImage)
      {
         return "";
      }
   }
}
