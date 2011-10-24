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
   /**
    * The north neighbor pixel value
    */
   Integer mNorth;
   /**
    * The north east neighbor pixel value
    */
   Integer mNorthEast;
   /**
    * The east neighbor pixel value
    */
   Integer mEast;
   /**
    * The south east neighbor pixel value
    */
   Integer mSouthEast;
   /**
    * The south neighbor pixel value
    */
   Integer mSouth;
   /**
    * The south west neighbor pixel value
    */
   Integer mSouthWest;
   /**
    * The west neighbor pixel value
    */
   Integer mWest;
   /**
    * The north west neighbor pixel value
    */
   Integer mNorthWest;

   /**
    * The value of the neighboring pixels (assuming they are all the same)
    */
   Integer mNeighborValue;
   /**
    * The value of the pixel being filtered
    */
   Integer mTargetValue;
   /**
    * The number of neighboring pixels
    */
   Integer mNumberNeighbors;
   /**
    * The number of neighbor pixels with an ON value
    */
   Integer mNumberOn;

   /**
    * Constructor for the Filter.
    *
    * @param pImage The binary image containing the target
    * @param pRow The row location of the target pixel
    * @param pCol The column location of the target pixel
    */
   public Filter(Image pImage, int pRow, int pCol)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      mTargetValue = image.getRGB(pCol, pRow);
      mNumberNeighbors = 0;
      mNumberOn = 0;

      //TODO: Use neighbors object instead of code below

      if (pRow > 0)
      {
         mNorth = image.getRGB(pCol, pRow - 1);
         mNeighborValue = mNorth;
         mNumberNeighbors++;

         if (mNorth == ImageProcessingLibrary.ONBLACK)
         {
            mNumberOn++;
         }

         if (pCol < (width - 1))
         {
            mNorthEast = image.getRGB(pCol + 1, pRow - 1);
            mNeighborValue = mNorthEast;
            mNumberNeighbors++;

            if (mNorthEast == ImageProcessingLibrary.ONBLACK)
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

         if (mEast == ImageProcessingLibrary.ONBLACK)
         {
            mNumberOn++;
         }

         if (pRow < (height - 1))
         {
            mSouthEast = image.getRGB(pCol + 1, pRow + 1);
            mNeighborValue = mSouthEast;
            mNumberNeighbors++;

            if (mSouthEast == ImageProcessingLibrary.ONBLACK)
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

         if (mSouth == ImageProcessingLibrary.ONBLACK)
         {
            mNumberOn++;
         }

         if (pCol > (width - 1))
         {
            mSouthWest = image.getRGB(pCol - 1, pRow + 1);
            mNeighborValue = mSouthWest;
            mNumberNeighbors++;

            if (mSouthWest == ImageProcessingLibrary.ONBLACK)
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

         if (mWest == ImageProcessingLibrary.ONBLACK)
         {
            mNumberOn++;
         }

         if (pRow > (height - 1))
         {
            mNorthWest = image.getRGB(pCol - 1, pRow - 1);
            mNeighborValue = mNorthWest;
            mNumberNeighbors++;

            if (mNorthWest == ImageProcessingLibrary.ONBLACK)
            {
               mNumberOn++;
            }
         }
      }
   }

   /**
    * Returns the median value of the neighbors of the target pixel. If
    * there are just as many ON pixels are there are OFF then the target
    * retains its value.
    *
    * @return The median of the neighbors
    */
   public Integer getMedian()
   {
      int median = ImageProcessingLibrary.OFFWHITE;
      int half =  (int) Math.floor(mNumberNeighbors / 2);

      if (mNumberOn == half)
      {
         median = mTargetValue;
      }
      else if (mNumberOn > half)
      {
         median = ImageProcessingLibrary.ONBLACK;
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

   /**
    * Returns true if the target pixel needs to be changed to the
    * neighbor's value.
    *
    * @return true if the target pixel needs to be changed
    */
   public boolean pixelNeedsChanging()
   {
      //If the neighbors are the same and the neighbor value is different
      return neighborsAreSame() && (mTargetValue != mNeighborValue);
   }

   /**
    * Returns true if the target pixel needs to be turned ON.
    *
    * @return true if the target pixel needs to be turned ON
    */
   public boolean turnOn()
   {
      boolean turnOn = false;
      boolean neighborsSame = neighborsAreSame();
      if (neighborsSame && (mNeighborValue == ImageProcessingLibrary.ONBLACK))
      {
         turnOn = true;
      }
    
      if (!neighborsSame && (mTargetValue == ImageProcessingLibrary.ONBLACK))
      {
         turnOn = true;
      }
      return turnOn;
   }

   /**
    * Returns the value of the neighboring pixels, null if they are not all
    * the same value.
    *
    * @return The value of the neighboring pixels
    */
   public Integer getNeighborValue()
   {
      return mNeighborValue;
   }
}
