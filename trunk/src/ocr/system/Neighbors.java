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
   private int[] mNeighbors;
   private Set<Integer> mNeighborValues;
   private int mSmallestValue;

   public Neighbors(int[][] pImage, int pWidth, int pHeight, int pRow, int pCol)
   {
      mNeighbors = new int[8];
      mSmallestValue = 999999999;
      mNeighborValues = new HashSet<Integer>();

      if (pRow > 0)
      {
         //North
         int north = pImage[pRow - 1][pCol];
         mNeighbors[1] = north;
         mNeighborValues.add(north);

         if (north < mSmallestValue)
         {
            mSmallestValue = north;
         }

         if (pCol < (pWidth - 1))
         {
            //North East
            int northEast = pImage[pRow - 1][pCol + 1];
            mNeighbors[2] = northEast;
            mNeighborValues.add(northEast);

            if (northEast < mSmallestValue)
            {
               mSmallestValue = northEast;
            }
         }
      }

      if (pCol < (pWidth - 1))
      {
         //East
         int east = pImage[pRow][pCol + 1];
         mNeighbors[4] = east;
         mNeighborValues.add(east);

         if (east < mSmallestValue)
         {
            mSmallestValue = east;
         }
         
         if (pRow < (pHeight - 1))
         {
            //South East
            int southEast = pImage[pRow + 1][pCol + 1];
            mNeighbors[7] = southEast;
            mNeighborValues.add(southEast);

            if (southEast < mSmallestValue)
            {
               mSmallestValue = southEast;
            }
         }
      }

      if (pRow < (pHeight - 1))
      {
         //South
         int south = pImage[pRow + 1][pCol];
         mNeighbors[6] = south;
         mNeighborValues.add(south);

         if (south < mSmallestValue)
         {
            mSmallestValue = south;
         }

         if (pCol > (pWidth - 1))
         {
            //South West
            int southWest = pImage[pRow + 1][pCol - 1];
            mNeighbors[5] = southWest;
            mNeighborValues.add(southWest);

            if (southWest < mSmallestValue)
            {
               mSmallestValue = southWest;
            }
         }
      }

      if (pCol > (pWidth - 1))
      {
         //West
         int west = pImage[pRow][pCol - 1];
         mNeighbors[3] = west;
         mNeighborValues.add(west);

         if (west < mSmallestValue)
         {
            mSmallestValue = west;
         }

         if (pRow > (pHeight - 1))
         {
            //North West
            int northWest = pImage[pRow - 1][pCol - 1];
            mNeighbors[0] = northWest;
            mNeighborValues.add(northWest);

            if (northWest < mSmallestValue)
            {
               mSmallestValue = northWest;
            }
         }
      }
   }

   public int[] getNeighbors()
   {
      return mNeighbors;
   }

   public int getSmallestValue()
   {
      return mSmallestValue;
   }

   public Set<Integer> getNeighborValues()
   {
      return mNeighborValues;
   }
}
