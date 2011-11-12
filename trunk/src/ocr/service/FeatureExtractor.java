package ocr.service;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collection;
import ocr.system.ImageProcessingLibrary;
import ocr.system.PixelHistogram;

/**
 * Converts a character image into a collection of features, a feature point.
 * 
 * @author Devin
 */
public class FeatureExtractor
   implements Runnable
{
   /**
    * The (normalized) character image to extract features from
    */
   private Image mCharacter;
   /**
    * The contour of the character
    */
   private Image mContour;
   /**
    * The character thinned
    */
   private Image mThin;
   /**
    * The collection of features extracted from the character
    */
   private Collection<Double> mFeaturePoint;

   /**
    * Constructor for the FeatureExtractor with the character image
    * as a parameter.
    *
    * @param pCharacter The character image to extract features from
    */
   public FeatureExtractor(Image pCharacter)
   {
      mFeaturePoint = new ArrayList<Double>();
      mCharacter = pCharacter;
      mContour = ImageProcessingLibrary.traceContour(pCharacter);
      mThin = ImageProcessingLibrary.thin(pCharacter);
   }

   /**
    * Returns the feature point calculated by the run() method for the
    * character image.
    *
    * @return The feature point for the character image
    */
   public Collection<Double> getFeaturePoint()
   {
      return mFeaturePoint;
   }

   /**
    * Use the ImageProcessingLibrary methods to normalize the character image,
    * provide a character contour, and a thinned character.  Use the
    * FeatureExtractionLibrary to calculate and assemble a feature point for
    * the character given.
    */
   public void run()
   {
      PixelHistogram hist = new PixelHistogram(mCharacter);

      mFeaturePoint.add(hist.getArea());

      for (double i : hist.getColumnHistogram())
      {
         mFeaturePoint.add(i);
      }
      for (double i : hist.getRowHistogram())
      {
         mFeaturePoint.add(i);
      }
   }
}
