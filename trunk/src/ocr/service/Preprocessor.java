package ocr.service;

import java.awt.Image;
import java.util.Collection;
import ocr.desktop.ImageDisplayer;
import ocr.system.ImageProcessingLibrary;

/**
 * Converts an image into an array of character images.
 * 
 * @author Devin
 */
public class Preprocessor
{
   /**
    * Use the methods of the ImageProcessingLibrary to preprocess the image,
    * locate the characters, and return them in an array of Images.
    *
    * @param pImage
    * @return
    */
   public static Collection<Image> preprocess(Image pImage)
   {
      //Convert to a binary image
      Image document = ImageProcessingLibrary.threshold(pImage);
      document = ImageProcessingLibrary.correctSkew(document);
      document = ImageProcessingLibrary.trim(document);
      ImageDisplayer.displayImage(document);
      return null;
   }
}
