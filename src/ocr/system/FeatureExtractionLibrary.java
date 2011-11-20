package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Provide common methods needed to extract features.
 *
 * @author Devin
 */
public class FeatureExtractionLibrary
{   
   /**
    * Calculates the area (number of foreground pixels) of the image.
    * 
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double area(Image pImage)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      double count = 0;

      //Count the number of black pixels in the image
      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            if (image.getRGB(col, row) == ImageProcessingLibrary.ONBLACK)
            {
               count++;
            }
         }
      }

      return count;
   }

   /**
    * Calculates the frequency of foreground pixels along the x-axis.
    *
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> columnHistogram(Image pImage)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();
      ArrayList<Double> histogram = new ArrayList<Double>(width);
      
      for (int row = 0; row < height; row++)
      {
         //Count the number of black pixels in each column
         for (int col = 0; col < width; col++)
         {
            if (row == 0)
            {
               histogram.add(0.0);
            }

            if (image.getRGB(col, row) == ImageProcessingLibrary.ONBLACK)
            {
               double count = histogram.get(col) + 1;
               histogram.set(col, count);
            }
         }
      }
      return histogram;
   }
   
   /**
    * Calculates the frequency of foreground pixels along the y-axis.
    * 
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> rowHistogram(Image pImage)
   {
      ArrayList<Double> histogram = new ArrayList<Double>();
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      double count = 0;

      for (int row = 0; row < height; row++)
      {
         //Count the number of black pixels in each row
         count = 0;
         for (int col = 0; col < width; col++)
         {
            if (image.getRGB(col, row) == ImageProcessingLibrary.ONBLACK)
            {
               count++;
            }
         }
         histogram.add(count);
      }
      return histogram;
   }
}
