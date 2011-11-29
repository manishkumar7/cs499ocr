package ocr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
   protected Collection<Double> mFeaturePoint;
   /**
    * The character determined from the feature point
    */
   protected String mCharacter;
   /**
    * The training data to compare with
    */
   protected Collection<CharacterFeaturePair> mTrainingData;
   /**
    * The calculated distance from the feature point to the training points
    */
   protected Collection<DistanceCharacterPair> mDistances;
   /**
    * Used to obtain the training data
    */
   protected TrainingDataProxy mProxy;

   /**
    * Constructor for the PatternRecognizer with the feature point as
    * a parameter.
    *
    * @param pFeaturePoint The feature point to associate a character with
    */
   public PatternRecognizer(Collection<Double> pFeaturePoint)
   {
      mFeaturePoint = pFeaturePoint;
      mProxy = new TrainingDataProxy();
      mTrainingData = mProxy.getTrainingData();
      mDistances = new ArrayList<DistanceCharacterPair>();
      mCharacter = "";
   }

   /**
    * Calculates the distance between the feature point and the training points.
    * The results are stored in mDistances.
    */
   private void calcDistances()
   {
      //Go through the training data
      for (CharacterFeaturePair train : mTrainingData)
      {
         double distance = distance(mFeaturePoint, train.getFeaturePoint());
         
         //Store the calculated distance
         DistanceCharacterPair pair = new DistanceCharacterPair(train.
            getCharacter(), distance);
         mDistances.add(pair);
      }
   }

   /**
    * Sorts mDistances in ascending order.
    */
   private void sortDistances()
   {
      quickSort(0, mDistances.size() - 1);
   }

   /**
    * The quick sort algorithm for use on mDistances.
    *
    * @param pLowerBound The lowest index to sort from
    * @param pUpperBound The highest index to sort to
    */
   private void quickSort(int pLowerBound, int pUpperBound)
   {
      ArrayList<DistanceCharacterPair> list = (ArrayList<DistanceCharacterPair>) mDistances;
      int i = pLowerBound;
      int j = pUpperBound;
      int size = pUpperBound - pLowerBound;

      //Choose the middle of the list as the pivot
      int pivotIndex = pLowerBound + (size / 2);
      DistanceCharacterPair pivot = list.get(pivotIndex);

      //Make two sublists
      while (i <= j)
      {
         //Find an element that needs to be moved into the second list
         while (list.get(i).getDistance() < pivot.getDistance())
         {
            i++;
         }

         //Find an element to swap into the first list
         while (list.get(j).getDistance() > pivot.getDistance())
         {
            j--;
         }

         //Make sure that the two scanners haven't crossed
         if (i <= j)
         {
            //Swap the elements we found and move on to the next
            swap(i, j);
            i++;
            j--;
         }
      }

      //Recursively sort the two sublists
      if (pLowerBound < j)
      {
         quickSort(pLowerBound, j);
      }
      if (i < pUpperBound)
      {
         quickSort(i, pUpperBound);
      }
   }

   /**
    * Swaps the content of the two indexes indicated.
    *
    * @param i The index of the first value to swap
    * @param j The index of the second value to swap
    */
   private void swap(int i, int j)
   {
      ArrayList<DistanceCharacterPair> list = (ArrayList<DistanceCharacterPair>) mDistances;
      DistanceCharacterPair temp = list.get(i);
      list.set(i, list.get(j));
      list.set(j, temp);
   }

   /**
    * Determines the most frequent character among the k closest training points
    * to the feature point and assigns this to mCharacter.
    *
    * @param k The number of training points to consider
    */
   private void kNearestNeighbor(int k)
   {
      HashMap<String, Integer> near = new HashMap<String, Integer>();
      ArrayList<DistanceCharacterPair> list = (ArrayList<DistanceCharacterPair>) mDistances;

      for (int i = 0; i < k; i++)
      {
         DistanceCharacterPair pair = list.get(i);
         String character = pair.getCharacter();
         Integer count = near.get(character);

         //If the character has not yet been mapped to a count
         if (count == null)
         {
            count = 1;
         }
         else
         {
            count++;
         }

         //Map each character to it's frequency in the k neighbors
         near.put(character, count);
      }

      int greatest = -1;
      for (String key : near.keySet())
      {
         int val = near.get(key);
         if (val > greatest)
         {
            greatest = val;
            mCharacter = key;
         }
      }
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
      double distance = 0;
      double sum = 0;

      Double[] pointB = pPointB.toArray(new Double[pPointB.size()]);

      //Calculate the distance from point a to point b
      int i = 0;
      for (Double pointA : pPointA)
      {
         //(a - b) ^ 2
         sum += Math.pow(pointA - pointB[i], 2);
         i++;
      }
      distance = Math.sqrt(sum);

      return distance;
   }


   /**
    * Returns the character associated with the feature point, as determined
    * by the run() method.
    *
    * @return The character associated with the feature point
    */
   public String getCharacter()
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
      calcDistances();
      sortDistances();
      kNearestNeighbor(5);
   }
}
