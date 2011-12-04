package ocr.system;

import ocr.OcrSuite;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
      Image pImage = OcrSuite.cCharImage;
      CharacterPrompter instance = new CharacterPrompterImpl();
      String expResult = "a";
      String result = instance.promptUser(pImage);
      assertEquals(expResult, result);
   }

   public class CharacterPrompterImpl implements CharacterPrompter
   {
      public String promptUser(Image pImage)
      {
         ImageIcon icon = new ImageIcon(pImage);
         String userInput = (String) JOptionPane.showInputDialog(
            null,
            "What character(s) do you see?",
            "Character Prompter",
            JOptionPane.PLAIN_MESSAGE,
            icon,
            null,
            null);

         return userInput;
      }
   }
}
