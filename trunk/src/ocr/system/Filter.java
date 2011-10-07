package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Provides filtering information for a specific pixel in an image.
 *
 * @author Devin
 */
public class Filter
{
   Integer mNorth;
   Integer mNorthEast;
   Integer mEast;
   Integer mSouthEast;
   Integer mSouth;
   Integer mNeighborValue;
   Integer mTargetValue;

   public Filter(Image pImage, int pRow, int pCol)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      mTargetValue = image.getRGB(pCol, pRow);

      if (pRow > 0)
      {
         mNorth = image.getRGB(pCol, pRow - 1);
         mNeighborValue = mNorth;

         if (pCol < (width - 1))
         {
            mNorthEast = image.getRGB(pCol + 1, pRow - 1);
            mNeighborValue = mNorthEast;
         }
      }

      if (pCol < (width - 1))
      {
         mEast = image.getRGB(pCol + 1, pRow);
         mNeighborValue = mEast;

         if (pRow < (height - 1))
         {
            mSouthEast = image.getRGB(pCol + 1, pRow + 1);
            mNeighborValue = mSouthEast;
         }
      }

      if (pRow < (height - 1))
      {
         mSouth = image.getRGB(pCol, pRow + 1);
         mNeighborValue = mSouth;
      }
   }

   public boolean neighborsAreSame()
   {
      //Assume all the neighbors are the same
      boolean neighborsSame = true;

      //See if any are different
      if ((mNorth != null) && (mNorth != mNeighborValue))
      {
         neighborsSame = false;
      }
      else if ((mNorthEast != null) && (mNorthEast != mNeighborValue))
      {
         neighborsSame = false;
      }
      else if ((mEast != null) && (mEast != mNeighborValue))
      {
         neighborsSame = false;
      }
      else if ((mSouthEast != null) && (mSouthEast != mNeighborValue))
      {
         neighborsSame = false;
      }
      else if ((mSouth != null) && (mSouth != mNeighborValue))
      {
         neighborsSame = false;
      }
      return neighborsSame;
   }

   public boolean pixelNeedsChanging()
   {
      //If the neighbors are the same and the neighbor value is different
      return neighborsAreSame() && (mTargetValue != mNeighborValue);
   }
   
   public boolean turnOn()
   {
      boolean turnOn = false;
      boolean neighborsSame = neighborsAreSame();
      if (neighborsSame && (mNeighborValue == ImageProcessingLibrary.ON))
      {
         turnOn = true;
      }
    
      if (!neighborsSame && (mTargetValue == ImageProcessingLibrary.ON))
      {
         turnOn = true;
      }
      return turnOn;
   }

   public Integer getNeighborValue()
   {
      return mNeighborValue;
   }
}
