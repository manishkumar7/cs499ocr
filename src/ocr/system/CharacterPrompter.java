package ocr.system;

import java.awt.Image;

/**
 * Displays an image and prompts the user for a character.
 * 
 * @author Devin
 */
public interface CharacterPrompter
{
   /**
    * Show the image to the user and prompt them for a character.
    *
    * @param pImage The image to display
    * @return The character retrieved from the user
    */
   public abstract char promptUser(Image pImage);
}
