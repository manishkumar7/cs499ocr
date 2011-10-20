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
    * Calculates the geographical moment of the image.
    *
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double moment(Image pImage)
   {
      return 0.0;
   }
   
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
    * Calculates the height of the character in the image.
    * 
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double height(Image pImage)
   {
      return 0.0;
   }
   
   /**
    * Calculates the width of the character in the image.
    * 
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double width(Image pImage)
   {
      return 0.0;
   }
   
   /**
    * Calculates the perimeter of the image.
    * 
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double perimeter(Image pImage)
   {
      return 0.0;
   }


   /**
    * Calculates compactness given perimeter and area.
    *
    * Compactness = Perimeter^2 / 4 * pi * Area
    * A circle is most compact (C=1).
    * 
    * @param pPerimeter The perimeter of the foreground
    * @param pArea The area of the foreground
    * @return The compactness of the foreground
    */
   public static double compactness(double pPerimeter, double pArea)
   {
      return 0.0;
   }

   /**
    * Calculates the number of holes in the image.
    *
    * @param pImage The character image to extract features from
    * @return The feature extracted
    */
   public static double numberOfHoles(Image pImage)
   {
      return 0.0;
   }

   /**
    * Calculates the (x,y) coordinates of the image centroid.
    *
    * @param pImage The character image to extract features from
    * @param pCentroidX The x position of the centroid
    * @param pCentroidY The y position of the centroid
    */
   public static void centroid(Image pImage, Double pCentroidX,
      Double pCentroidY)
   {

   }

   /**
    * Calculates the number of end points, branch points, and cross points.
    * End points have exactly 1 neighbor, branch points have 3, and
    * cross points have 4.
    *
    * @param pImage The character image to extract features from
    * @param pEndPoints The number of end points
    * @param pBranchPoints The number of branch points
    * @param pCrossPoints The number of cross points
    */
   public static void featurePoints(Image pImage, Double pEndPoints,
      Double pBranchPoints, Double pCrossPoints)
   {
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
   
   /**
    * Calculates a normalized stroke orientation histogram.
    * 
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> strokeOrientation(Image pImage)
   {
      return null;
   }
   
   /**
    * Calculates the location of lines in the image, returning a fixed
    * number of lines.
    * 
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> lines(Image pImage)
   {
      return null;
   }
   
   /**
    * Calculates the location of circles in the image, returning a fixed
    * number of circles.
    * 
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> circles(Image pImage)
   {
      return null;
   }

   /**
    * Calculates the distance from the centroid to a normalized number
    * of foreground pixels.
    *
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> centroidDistance(Image pImage, int pNormal)
   {
      return null;
   }

   /**
    * Calculates the curvature between a normalized number of foreground
    * pixels.
    *
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> curvatureSignature(Image pImage, int pNormal)
   {
      return null;
   }

   /**
    * Performs a discrete Fourier transform on the shape signature provided.
    *
    * @param pImage The character image to extract features from
    * @return The features extracted
    */
   public static Collection<Double> discreteFourierTransform(
      Collection<Double> pSignature, int pNormal)
   {
      return null;
   }
}
