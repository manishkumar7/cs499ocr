package ocr.service;

import java.awt.Image;
import java.util.Collection;
import ocr.system.ImageProcessingLibrary;

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
      String text = "";

      //TODO: Create a thread pool of size 4
      for (Image character : characters)
      {
         if (character == ImageProcessingLibrary.NEWLINE_MARK)
         {
            text += "\n";
         }
         else
         {
            FeatureExtractor extractor = new FeatureExtractor(character);
            extractor.run();

            PatternRecognizer recognizer = new PatternRecognizer(extractor.
               getFeaturePoint());
            recognizer.run();
            text += recognizer.getCharacter();
         }
      }
      
      return text;
   }
}
