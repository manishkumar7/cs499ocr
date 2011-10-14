package ocr.system;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;

/**
 * Provide common methods needed to process images.
 *
 * @author Devin
 */
public class ImageProcessingLibrary
{
   static final Integer ON = 0xffffffff;
   static final Integer OFF = 0x0;

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

               binary.setRGB(col, row, ON);
            }
            else
            {
               binary.setRGB(col, row, OFF);
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

      return rotate(pImage, 35);
   }

   private static Image rotate(Image pImage, double pAngle)
   {
      double radian = pAngle * (Math.PI / 180);
      double cosAngle = Math.cos(radian);
      double sinAngle = Math.sin(radian);
      double cosFourtyFive = Math.cos(Math.PI / 4);

      BufferedImage image = (BufferedImage) pImage;
      int width = image.getWidth();
      int height = image.getHeight();

      int targetWidth = (int) Math.abs(Math.ceil((cosFourtyFive * height)
         + (cosFourtyFive * width))) + 10;

      int targetHeight = (int) Math.abs(Math.ceil((cosFourtyFive * height)
         + (cosFourtyFive * width))) + 10;

      BufferedImage target = new BufferedImage(targetWidth, targetHeight,
         BufferedImage.TYPE_INT_RGB);

      //Loop through the target image
      for (int row = 0; row < targetHeight; row++)
      {
         for (int col = 0; col < targetWidth; col++)
         {
            //Adjust the pivot point so the image is rotated near the center
            int x = row - (width / 2) - 140;
            int y = col - (height / 2) - 220;

            //Calculate the source location using the rotation matrix
            int xPrime = (int) ((x * cosAngle) + (y * sinAngle) + (width / 2));
            int yPrime = (int) ((x * -sinAngle) + (y * cosAngle) + (height / 2));

            if ((xPrime >= 0) && (xPrime < height)
               && (yPrime >= 0) && (yPrime < width))
            {
               target.setRGB(col, row, image.getRGB(yPrime, xPrime));
            }

         }
      }

      return target;
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
