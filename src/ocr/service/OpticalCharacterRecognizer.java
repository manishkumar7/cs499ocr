package ocr.service;

import java.awt.Image;
import java.util.Collection;
import ocr.desktop.ImageDisplayer;

/**
 * Extract characters from an image and convert to a String.
 * 
 * @author Devin
 */
public class OpticalCharacterRecognizer
{
   /**
    * Extract the characters from the image provided and
    * return them as a string.
    *
    * @param pImage The image containing characters.
    * @return The characters extracted from the image.
    */
   public static String extractString(Image pImage)
   {
      Collection<Image> characters = Preprocessor.preprocess(pImage);



      return "Recognized Test";
   }
}
