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
   Double mArea;
   Collection<Double> mColumnHistogram;
   Collection<Double> mRowHistogram;
   Image mImage;

   public PixelHistogram(Image pImage)
   {
      mImage = pImage;
      mColumnHistogram = new ArrayList<Double>();
      mRowHistogram = new ArrayList<Double>();
      mArea = 0.0;

      initialize();
   }

   private void initialize()
   {
      BufferedImage image = (BufferedImage) mImage;
      int width = image.getWidth();
      int height = image.getHeight();

      ArrayList<Double> colHistogram = (ArrayList<Double>) mColumnHistogram;
      ArrayList<Double> rowHistogram = (ArrayList<Double>) mRowHistogram;

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
   
   public Double getArea()
   {
      return mArea;
   }
   
   public Collection<Double> getColumnHistogram()
   {
      return mColumnHistogram;
   }

   public Collection<Double> getRowHistogram()
   {
      return mRowHistogram;
   }
}
