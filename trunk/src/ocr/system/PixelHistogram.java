package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Creates various histograms from a binary image.
 * 
 * @author Devin
 */
public class PixelHistogram
{
   /**
    * The number of ON pixels in the image
    */
   private Double mArea;
   /**
    * The number of ON pixels for each column of the image
    */
   private Collection<Double> mColumnHistogram;
   /**
    * The number of ON pixels for each row of the image
    */
   private Collection<Double> mRowHistogram;
   /**
    * The image to generate histograms from
    */
   private Image mImage;

   /**
    * Constructor for PixelHistogram
    *
    * @param pImage The image to generate histograms from
    */
   public PixelHistogram(Image pImage)
   {
      mImage = pImage;
      mColumnHistogram = new ArrayList<Double>();
      mRowHistogram = new ArrayList<Double>();
      mArea = 0.0;

      initialize();
   }

   /**
    * Makes the necessary calculations to make the histograms.
    */
   private void initialize()
   {
      BufferedImage image = (BufferedImage) mImage;
      int width = image.getWidth();
      int height = image.getHeight();

      ArrayList<Double> colHistogram = (ArrayList<Double>) mColumnHistogram;
      ArrayList<Double> rowHistogram = (ArrayList<Double>) mRowHistogram;

      //Perform all the calculations with one scan of the image
      for (int row = 0; row < height; row++)
      {
         //Count the number of black pixels in each row
         double rowCount = 0;
         for (int col = 0; col < width; col++)
         {
            if (row == 0)
            {
               colHistogram.add(0.0);
            }

            if (image.getRGB(col, row) == ImageProcessingLibrary.ONBLACK)
            {
               rowCount++;

               //Count the number of black pixels in each column
               double colCount = colHistogram.get(col) + 1;
               colHistogram.set(col, colCount);

               mArea++;
            }
         }
         rowHistogram.add(rowCount);
      }
   }

   /**
    * Returns the number of ON pixels in the image.
    *
    * @return The area of the image
    */
   public Double getArea()
   {
      return mArea;
   }

   /**
    * Returns the number of ON pixels for each column.
    *
    * @return The column histogram
    */
   public Collection<Double> getColumnHistogram()
   {
      return mColumnHistogram;
   }

   /**
    * Returns the number of ON pixels for each row.
    *
    * @return The row histogram
    */
   public Collection<Double> getRowHistogram()
   {
      return mRowHistogram;
   }
}
