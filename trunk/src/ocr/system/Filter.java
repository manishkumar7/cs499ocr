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
   Integer mSouthWest;
   Integer mWest;
   Integer mNorthWest;

   Integer mNeighborValue;
   Integer mTargetValue;
   Integer mNumberNeighbors;
   Integer mNumberOn;

   public Filter(Image pImage, int pRow, int pCol)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      mTargetValue = image.getRGB(pCol, pRow);
      mNumberNeighbors = 0;
      mNumberOn = 0;

      if (pRow > 0)
      {
         mNorth = image.getRGB(pCol, pRow - 1);
         mNeighborValue = mNorth;
         mNumberNeighbors++;

         if (mNorth == ImageProcessingLibrary.ON)
         {
            mNumberOn++;
         }

         if (pCol < (width - 1))
         {
            mNorthEast = image.getRGB(pCol + 1, pRow - 1);
            mNeighborValue = mNorthEast;
            mNumberNeighbors++;

            if (mNorthEast == ImageProcessingLibrary.ON)
            {
               mNumberOn++;
            }
         }
      }

      if (pCol < (width - 1))
      {
         mEast = image.getRGB(pCol + 1, pRow);
         mNeighborValue = mEast;
         mNumberNeighbors++;

         if (mEast == ImageProcessingLibrary.ON)
         {
            mNumberOn++;
         }

         if (pRow < (height - 1))
         {
            mSouthEast = image.getRGB(pCol + 1, pRow + 1);
            mNeighborValue = mSouthEast;
            mNumberNeighbors++;

            if (mSouthEast == ImageProcessingLibrary.ON)
            {
               mNumberOn++;
            }
         }
      }

      if (pRow < (height - 1))
      {
         mSouth = image.getRGB(pCol, pRow + 1);
         mNeighborValue = mSouth;
         mNumberNeighbors++;

         if (mSouth == ImageProcessingLibrary.ON)
         {
            mNumberOn++;
         }

         if (pCol > (width - 1))
         {
            mSouthWest = image.getRGB(pCol - 1, pRow + 1);
            mNeighborValue = mSouthWest;
            mNumberNeighbors++;

            if (mSouthWest == ImageProcessingLibrary.ON)
            {
               mNumberOn++;
            }
         }
      }

      if (pCol > (width - 1))
      {
         mWest = image.getRGB(pCol - 1, pRow);
         mNeighborValue = mWest;
         mNumberNeighbors++;

         if (mWest == ImageProcessingLibrary.ON)
         {
            mNumberOn++;
         }

         if (pRow > (height - 1))
         {
            mNorthWest = image.getRGB(pCol - 1, pRow - 1);
            mNeighborValue = mNorthWest;
            mNumberNeighbors++;

            if (mNorthWest == ImageProcessingLibrary.ON)
            {
               mNumberOn++;
            }
         }
      }
   }

   public Integer getMedian()
   {
      int median = ImageProcessingLibrary.OFF;
      int half =  (int) Math.floor(mNumberNeighbors / 2);

      if (mNumberOn == half)
      {
         median = mTargetValue;
      }
      else if (mNumberOn > half)
      {
         median = ImageProcessingLibrary.ON;
      }
      
      return median;
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
