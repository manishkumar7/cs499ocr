package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;
import junit.framework.Assert;

/**
 * Used to compare Image objects in test cases.
 *
 * @author Devin
 */
public class ImageAssert
{
   /**
    * Returns true if the the images provided are equal. They are considered
    * equal if the pixels at each coordinate have the same value and they
    * have the same size.
    * 
    * @param expResult The image that we expect to find
    * @param result The image to compare to the expected image
    * @return True if the images are equal
    */
   public static boolean isEqual(Image expResult, Image result)
   {
      //Assume they are equal
      boolean isEqual = true;

      if ((expResult != null) && (result != null))
      {
         BufferedImage left = (BufferedImage) expResult;
         BufferedImage right = (BufferedImage) result;

         int leftWidth = left.getWidth();
         int leftHeight = left.getHeight();

         int rightWidth = right.getWidth();
         int rightHeight = right.getHeight();

         if ((leftWidth == rightWidth) && (leftHeight == rightHeight))
         {
            for (int row = 0; row < leftHeight; row++)
            {
               for (int col = 0; col < leftWidth; col++)
               {
                  int leftColor = left.getRGB(col, row);
                  int rightColor = right.getRGB(col, row);

                  //If any of the pixels are not the same
                  if (leftColor != rightColor)
                  {
                     Assert.failNotEquals(
                        "Images do not have same colors for each pixel.",
                        expResult, result);
                     isEqual = false;
                     break;
                  }
               }
            }
         }
         else
         {
            Assert.failNotEquals("Images not same size.", expResult, result);
            isEqual = false;
         }
      }
      else
      {
         Assert.failNotEquals("Null image.", expResult, result);
         isEqual = false;
      }

      return isEqual;
   }
}
