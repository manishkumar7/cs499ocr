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
   private Set<Integer> mNeighborValues;

   public Neighbors(int[][] pImage, int pWidth, int pHeight, int pRow, int pCol)
   {
      mNeighborValues = new HashSet<Integer>();

      if (pRow > 0)
      {
         //North
         int north = pImage[pRow - 1][pCol];
         mNeighborValues.add(north);

         if (pCol < (pWidth - 1))
         {
            //North East
            int northEast = pImage[pRow - 1][pCol + 1];
            mNeighborValues.add(northEast);
         }
      }

      if (pCol < (pWidth - 1))
      {
         //East
         int east = pImage[pRow][pCol + 1];
         mNeighborValues.add(east);
         
         if (pRow < (pHeight - 1))
         {
            //South East
            int southEast = pImage[pRow + 1][pCol + 1];
            mNeighborValues.add(southEast);
         }
      }

      if (pRow < (pHeight - 1))
      {
         //South
         int south = pImage[pRow + 1][pCol];
         mNeighborValues.add(south);

         if (pCol > (pWidth - 1))
         {
            //South West
            int southWest = pImage[pRow + 1][pCol - 1];
            mNeighborValues.add(southWest);
         }
      }

      if (pCol > (pWidth - 1))
      {
         //West
         int west = pImage[pRow][pCol - 1];
         mNeighborValues.add(west);

         if (pRow > (pHeight - 1))
         {
            //North West
            int northWest = pImage[pRow - 1][pCol - 1];
            mNeighborValues.add(northWest);
         }
      }
   }

   public Set<Integer> getNeighborValues()
   {
      return mNeighborValues;
   }
}
