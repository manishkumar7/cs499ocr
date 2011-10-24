package ocr.system;

/**
 * Defines the box surrounding a character.
 *
 * @author Devin
 */
public class BoundingBox
{
   /**
    * The minimum row coordinate of the box
    */
   private int mMinRow;
   /**
    * The maximum row coordinate of the box
    */
   private int mMaxRow;
   /**
    * The minimum column coordinate of the box
    */
   private int mMinCol;
   /**
    * The maximum column coordinate of the box
    */
   private int mMaxCol;

   /**
    * BoundingBox Constructor
    */
   public BoundingBox()
   {
      mMinRow = 999999999;
      mMaxRow = -1;
      mMinCol = 999999999;
      mMaxCol = -1;
   }

   /**
    * Set the minimum and/or maximum row for the bounding box if the given
    * row is less than the minimum and/or more than the maximum.
    *
    * @param pRow The row to set if it meets the min/max criteria
    */
   public void setRow(int pRow)
   {
      if (pRow < mMinRow)
      {
         mMinRow = pRow;
      }

      if (pRow > mMaxRow)
      {
         mMaxRow = pRow;
      }
   }

   /**
    * Set the minimum and/or maximum column for the bounding box if the given
    * column is less than the minimum and/or more than the maximum.
    *
    * @param pCol The column to set if it meets the min/max criteria
    */
   public void setCol(int pCol)
   {
      if (pCol < mMinCol)
      {
         mMinCol = pCol;
      }

      if (pCol > mMaxCol)
      {
         mMaxCol = pCol;
      }
   }

   /**
    * Get the minimum row of the bounding box
    *
    * @return The minimum row
    */
   public int getMinRow()
   {
      return mMinRow;
   }

   /**
    * Get the maximum row of the bounding box
    *
    * @return The maximum row
    */
   public int getMaxRow()
   {
      return mMaxRow;
   }

   /**
    * Get the minimum column of the bounding box
    *
    * @return The minimum column
    */
   public int getMinCol()
   {
      return mMinCol;
   }

   /**
    * Get the maximum column of the bounding box
    *
    * @return The maximum column
    */
   public int getMaxCol()
   {
      return mMaxCol;
   }
}
