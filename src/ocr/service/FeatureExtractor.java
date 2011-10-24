package ocr.service;

import java.awt.Image;
import java.util.Collection;

/**
 * Converts a character image into a collection of features, a feature point.
 * 
 * @author Devin
 */
public class FeatureExtractor
   implements Runnable
{
   /**
    * The character image to extract features from
    */
   private Image mCharacter;
   /**
    * The normalized character image
    */
   private Image mNormalized;
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

   }
}
