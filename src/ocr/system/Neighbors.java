package ocr.system;

import java.util.HashSet;
import java.util.Set;

/**
 * Provides the neighbors of a given pixel in an image.
 *
 * @author Devin
 */
public class Neighbors
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
    * A set containing the values of the neighbors
    */
   private Set<Integer> mNeighborValues;

   public Neighbors(int[][] pImage, int pWidth, int pHeight, int pRow, int pCol)
   {
      mNeighborValues = new HashSet<Integer>();

      if (pRow > 0)
      {
         //North
         mNorth = pImage[pRow - 1][pCol];
         mNeighborValues.add(mNorth);

         if (pCol < (pWidth - 1))
         {
            //North East
            mNorthEast = pImage[pRow - 1][pCol + 1];
            mNeighborValues.add(mNorthEast);
         }
      }

      if (pCol < (pWidth - 1))
      {
         //East
         mEast = pImage[pRow][pCol + 1];
         mNeighborValues.add(mEast);
         
         if (pRow < (pHeight - 1))
         {
            //South East
            mSouthEast = pImage[pRow + 1][pCol + 1];
            mNeighborValues.add(mSouthEast);
         }
      }

      if (pRow < (pHeight - 1))
      {
         //South
         mSouth = pImage[pRow + 1][pCol];
         mNeighborValues.add(mSouth);

         if (pCol > 0)
         {
            //South West
            mSouthWest = pImage[pRow + 1][pCol - 1];
            mNeighborValues.add(mSouthWest);
         }
      }

      if (pCol > 0)
      {
         //West
         mWest = pImage[pRow][pCol - 1];
         mNeighborValues.add(mWest);

         if (pRow > 0)
         {
            //North West
            mNorthWest = pImage[pRow - 1][pCol - 1];
            mNeighborValues.add(mNorthWest);
         }
      }
   }


   public Set<Integer> getNeighborValues()
   {
      return mNeighborValues;
   }
}
