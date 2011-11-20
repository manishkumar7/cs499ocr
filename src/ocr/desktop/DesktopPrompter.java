package ocr.desktop;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import ocr.system.CharacterPrompter;

/**
 * Prompt the desktop user for a character with an image.
 * 
 * @author Devin
 */
public class DesktopPrompter
   implements CharacterPrompter
{
   /**
    * Show the image to the user and prompt them for a character.
    *
    * @param pImage The image to display
    * @return The character retrieved from the user
    */
   public String promptUser(Image pImage)
   {      
      ImageIcon icon = new ImageIcon(pImage);
      String userInput = (String)JOptionPane.showInputDialog(
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
