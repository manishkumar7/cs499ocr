package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;

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
    * @param pLeft The image in the left parameter to compare
    * @param pRight The image in the right parameter to compare
    * @return True if the images are equal
    */
   public static boolean isEqual(Image pLeft, Image pRight)
   {
      //Assume they are equal
      boolean isEqual = true;
      BufferedImage left = (BufferedImage) pLeft;
      BufferedImage right = (BufferedImage) pRight;

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
                  isEqual = false;
                  break;
               }

            }
         }
      }
      else
      {
         isEqual = false;
      }

      return isEqual;
   }
}
