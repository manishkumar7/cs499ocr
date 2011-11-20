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
   private Integer mNorth;
   /**
    * The north east neighbor pixel value
    */
   private Integer mNorthEast;
   /**
    * The east neighbor pixel value
    */
   private Integer mEast;
   /**
    * The south east neighbor pixel value
    */
   private Integer mSouthEast;
   /**
    * The south neighbor pixel value
    */
   private Integer mSouth;
   /**
    * The south west neighbor pixel value
    */
   private Integer mSouthWest;
   /**
    * The west neighbor pixel value
    */
   private Integer mWest;
   /**
    * The north west neighbor pixel value
    */
   private Integer mNorthWest;

   /**
    * A set containing the values of the neighbors
    */
   private Set<Integer> mNeighborValues;

   /**
    * Constructor for Neighbors
    *
    * @param pImage The image to get the neighbors from
    * @param pWidth The width of the image
    * @param pHeight The height of the image
    * @param pRow The row location of the target pixel
    * @param pCol The column location of the target pixel
    */
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

   /**
    * Returns the set containing the value of the neighboring pixels
    *
    * @return The set of values of the neighbor pixels
    */
   public Set<Integer> getNeighborValues()
   {
      return mNeighborValues;
   }
}
