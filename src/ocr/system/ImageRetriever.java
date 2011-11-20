package ocr.system;

import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Reads an image from a given location.
 *
 * @author Devin
 */
public class ImageRetriever
{
   /**
    * The file path to the image
    */
   private File mPath;

   /**
    * Constructor for the ImageReader with the path to the image as a parameter.
    *
    * @param pPath The path to the image file on the file system
    */
   public ImageRetriever(String pPath)
   {
      mPath = new File(pPath);
   }

   /**
    * Constructor for the ImageReader with the File to read as a parameter
    *
    * @param pPath The file to read the image from
    */
   public ImageRetriever(File pPath)
   {
      mPath = pPath;
   }

   /**
    * Read the image from the file path given and return the contents in
    * an Image object.
    * 
    * @return The image retrieved from the path given
    */
   public Image readImage()
   {
      Image image = null;
      try
      {
         image = ImageIO.read(mPath);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      return image;
   }
}
