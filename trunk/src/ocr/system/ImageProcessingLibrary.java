package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Provide common methods needed to process images.
 *
 * @author Devin
 */
public class ImageProcessingLibrary
{
   static final Integer OFFWHITE = 0xffffffff;//OFF
   static final Integer ONBLACK = 0xff000000;//ON
   static final Integer BLANK = 0xff0000ff;

   /**
    * Convert from gray-scale image to a binary image, separating the
    * foreground from the background.
    *
    * @param pImage The image to process.
    * @return The processed image.
    */
   public static Image threshold(Image pImage)
   {
      int color = 0;
      int totalPixels = 0;
      double totalThreshold = 0;
      double totalMean = 0;
      int backgroundPixels = 0;
      int foregroundPixels = 0;
      double backgroundMeanSum = 0;
      int numPixels = 0;
      double meanDiff = 0;

      double backgroundMean = 0;
      double foregroundMean = 0;
      double backgroundWeight = 0;
      double foregroundWeight = 0;

      double currVariance = 0;
      double betweenClassVariance = 0;
      int threshold = 0;
      
      HashMap<Integer, Integer> histogram = new HashMap<Integer, Integer>();
      
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      BufferedImage binary = new BufferedImage(width, height,
         BufferedImage.TYPE_INT_RGB);

      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            color = image.getRGB(col, row);

            //Only focus on rgb
            color = (color & 0x00ffffff);

            //
            // Create a histogram of the pixel intensities
            //

            //Map pixel intensities to their frequency
            Integer tally = histogram.get(color);

            //If the intensity has not yet been mapped
            if (tally == null)
            {
               histogram.put(color, 1);
            }
            else
            {
               histogram.put(color, tally + 1);
            }

            //Count the total number of pixels
            totalPixels++;
            totalThreshold += color;
         }
      }
      totalMean = totalThreshold / totalPixels;

      List<Integer> keys = HelperLibrary.sortList(histogram.keySet());

      //Loop through each threshold
      for (Integer currThreshold : keys)
      {
         //Calculate background mean and weight
         numPixels = histogram.get(currThreshold);
         backgroundPixels += numPixels;
         backgroundWeight = (double)backgroundPixels / totalPixels;

         backgroundMeanSum += (numPixels * currThreshold);
         backgroundMean = backgroundMeanSum / backgroundPixels;

         //Calculate foreground mean and weight
         foregroundPixels = totalPixels - backgroundPixels;
         foregroundWeight = (double)foregroundPixels / totalPixels;
         foregroundMean = (totalMean - backgroundMean) / foregroundPixels;

         //Calculate the between class variance
         meanDiff = backgroundMean - foregroundMean;
         currVariance = (backgroundWeight * foregroundWeight) * 
            Math.pow(meanDiff, 2);

         //Maximize between class variance
         if (currVariance > betweenClassVariance)
         {
            betweenClassVariance = currVariance;
            threshold = currThreshold;
         }
      }

      //Adjust the threshold
      threshold += 7000000;

      //Use the calculated threshold to binarize the image
      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            color = image.getRGB(col, row);

            //Only focus on rgb
            color = (color & 0x00ffffff);

            if (color > threshold)
            {

               binary.setRGB(col, row, OFFWHITE);
            }
            else
            {
               binary.setRGB(col, row, ONBLACK);
            }
         }
      }

      return binary;
   }

   /**
    * Removes salt-and-pepper noise from the binary image.
    *
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image smoothNoise(Image pImage)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      BufferedImage binary = new BufferedImage(width, height,
         BufferedImage.TYPE_INT_RGB);

      Filter pixelFilter = null;

      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            Integer val = image.getRGB(col, row);
            binary.setRGB(col, row, val);
         }
      }

      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            pixelFilter = new Filter(binary, row, col);
            binary.setRGB(col, row, pixelFilter.getMedian());
         }
      }
      return binary;
   }

   /**
    * Calculates the skew (The angle between horizontal edge of the image
    * and the orientation of the text on the page. aka tilt) of the binary
    * image and rotates to compensate.
    *
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image correctSkew(Image pImage)
   {
      Image correct = null;
      double variance = 0;
      double variance2 = 0;
      double maxVariance = -1;
      double correctAngle = 0;

      //Test for skew from -15 to 15 degrees
      double low = -15;
      double high = 15;
      double testAngle = 1000;
      double testAngle2 = 1;
      double prevTest = 0;
      double diff = 1;

      while (diff > 0.1)
      {
         prevTest = testAngle;
         testAngle = ((low + high) / 2);
         testAngle2 = testAngle + 1;

         Image current = rotate(pImage, testAngle);
         variance = variance(FeatureExtractionLibrary.rowHistogram(current));
         Image current2 = rotate(pImage, testAngle2);
         variance2 = variance(FeatureExtractionLibrary.rowHistogram(current2));

         //Decrease and Conquer! Assumes there is a single maxima.
         if (variance > variance2)
         {
            high = testAngle - 1;

            if (variance > maxVariance)
            {
               maxVariance = variance;
               correct = current;
               correctAngle = testAngle;
            }
         }
         else
         {
            low = testAngle;

            if (variance2 > maxVariance)
            {
               maxVariance = variance2;
               correct = current2;
               correctAngle = testAngle2;
            }
         }
         diff = Math.abs(prevTest - testAngle);
      }

      return correct;
   }

   public static double mean(Collection<Double> pData)
   {
      double sum = 0;
      for (double i : pData)
      {
         sum += i;
      }
      return sum / pData.size();
   }

   public static double variance(Collection<Double> pData)
   {
      double mean = mean(pData);
      double sum = 0;

      for (double i : pData)
      {
         double diff = i - mean;
         sum += Math.pow(diff, 2);
      }

      return sum / pData.size();
   }

   /**
    * Rotates an image by an arbitrary angle (in degrees.)
    *
    * @param pImage The image to rotate
    * @param pAngle The angle to rotate by
    * @return The rotated image
    */
   private static Image rotate(Image pImage, double pAngle)
   {
      double radian = pAngle * (Math.PI / 180);
      double cosAngle = Math.cos(radian);
      double sinAngle = Math.sin(radian);
      double absCosAngle = Math.cos(Math.abs(radian));
      double absSinAngle = Math.sin(Math.abs(radian));

      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      //Calculate the size of the target image
      int targetWidth = (int) Math.abs(Math.ceil((absSinAngle * height)
         + (absCosAngle * width))) + 500;

      int targetHeight = (int) Math.abs(Math.ceil((absCosAngle * height)
         + (absSinAngle * width))) + 500;
      
      BufferedImage target = new BufferedImage(targetWidth, targetHeight,
         BufferedImage.TYPE_INT_RGB);

      //Loop through the target image
      for (int row = 0; row < targetHeight; row++)
      {
         for (int col = 0; col < targetWidth; col++)
         {
            //Adjust the pivot point so the image is rotated near the center
            int x = row - (width / 2) - 300;
            int y = col - (height / 2) - 300;

            //
            // Calculate the source location using the rotation matrix
            //    [x'    =   [ cos(angle)  sin(angle)   *  [x
            //     y']         -sin(angle) cos(angle)]      y]
            //

            int xPrime = (int) ((x * cosAngle) + (y * sinAngle) + (width / 2));
            int yPrime = (int) ((x * -sinAngle) + (y * cosAngle) + (height / 2));

            //If the coordinates exist on the source then map them to the target
            if ((xPrime >= 0) && (xPrime < height)
               && (yPrime >= 0) && (yPrime < width))
            {
               target.setRGB(col, row, image.getRGB(yPrime, xPrime));
            }
            else
            {
               target.setRGB(col, row, BLANK);
            }
         }
      }

      return target;
   }

   public static Image trim(Image pImage)
   {
      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      BufferedImage trimmed = null;

      int minY = 999999999;
      int minX = 999999999;
      int maxY = 0;
      int maxX = 0;
      
      for (int row = 0; row < height; row++)
      {
         for (int col = 0; col < width; col++)
         {
            int color = image.getRGB(col, row);

            if (color == ONBLACK)
            {
               if (row < minY)
               {
                  minY = row;
               }
               if (row > maxY)
               {
                  maxY = row;
               }
               if (col < minX)
               {
                  minX = col;
               }
               if (col > maxX)
               {
                  maxX = col;
               }
            }
         }
      }

      trimmed = image.getSubimage(minX - 5, minY - 5,
         (maxX - minX) + 10, (maxY - minY) + 10);

      return trimmed;
   }

   /**
    * Finds and labels the connected components of the foreground of a binary
    * image.
    *
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image labelConnectedComponents(Image pImage)
   {
      return null;
   }

   /**
    * Normalizes an image to have a fixed height and width.
    *
    * @param pImage The image to process.
    * @return The processed image.
    */
   public static Image normalize(Image pImage)
   {
      return null;
   }

   /**
    * Traces the contour of the foreground and returns the trace of a binary
    * image.
    *
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image traceContour(Image pImage)
   {
      return null;
   }

   /**
    * Thins the foreground pixels or a binary image.
    *
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image thin(Image pImage)
   {
      return null;
   }

   /**
    * Reverses the foreground and background of a binary image.
    * 
    * @param pImage The binary image to process.
    * @return The processed image.
    */
   public static Image invert(Image pImage)
   {
      return null;
   }
}
