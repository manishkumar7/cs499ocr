package ocr.service;

import java.util.Collection;
import ocr.system.CharacterFeaturePair;
import ocr.system.DistanceCharacterPair;

/**
 * Converts a feature point into a character
 * 
 * @author Devin
 */
public class PatternRecognizer
   implements Runnable
{
   /**
    * The feature point to associate a character with
    */
   private Collection<Double> mFeaturePoint;
   /**
    * The character determined from the feature point
    */
   private char mCharacter;
   /**
    * The training data to compare with
    */
   private Collection<CharacterFeaturePair> mTrainingData;
   /**
    * The calculated distance from the feature point to the training points
    */
   private Collection<DistanceCharacterPair> mDistances;
   /**
    * Used to obtain the training data
    */
   private TrainingDataProxy mProxy;

   /**
    * Constructor for the PatternRecognizer with the feature point as
    * a parameter.
    *
    * @param pFeaturePoint The feature point to associate a character with
    */
   public PatternRecognizer(Collection<Double> pFeaturePoint)
   {

   }

   /**
    * Obtains and sets the training data.
    */
   private void initTrainingData()
   {

   }

   /**
    * Calculates the distance between the feature point and the training points.
    * The results are stored in mDistances.
    */
   private void calcDistances()
   {

   }

   /**
    * Sorts mDistances in ascending order.
    */
   private void sortDistances()
   {

   }

   /**
    * Determines the most frequent character among the k closest training points
    * to the feature point and assigns this to mCharacter.
    *
    * @param k The number of training points to consider
    */
   private void kNearestNeighbor(int k)
   {

   }

   /**
    * Calculates the Euclidean distance between to points
    *
    * @param pPointA Point A
    * @param pPointB Point B
    * @return The distance between point A and point B
    */
   private double distance(Collection<Double> pPointA,
      Collection<Double> pPointB)
   {
      return 0.0;
   }


   /**
    * Returns the character associated with the feature point, as determined
    * by the run() method.
    *
    * @return The character associated with the feature point
    */
   public char getCharacter()
   {
      return mCharacter;
   }

   /**
    * Obtain the training data and calculate the distance between the feature
    * point and the training points. Find the most frequent character among
    * the closest training points and assign this character to the feature point.
    */
   public void run()
   {
   }
}
