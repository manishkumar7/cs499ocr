package ocr.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Stores the character-feature point pairings identified by the user.
 * 
 * @author Devin
 */
public class TrainingData
   implements Serializable
{
   /**
    * Stores the training data
    */
   private Collection<CharacterFeaturePair> mData;

   /**
    * Variable to hold a singleton of TrainingData
    */
   private static final TrainingData cInstance;

   /**
    * Initialize a Server instance
    */
   static
   {
      cInstance = new TrainingData();
   }

   private TrainingData()
   {
      mData = new ArrayList<CharacterFeaturePair>();
   }

   public static TrainingData getInstance()
   {
      return cInstance;
   }

   /**
    * Insert a new character-feature pair into the training data
    *
    * @param pData The character-feature pair to store
    */
   public void insert(CharacterFeaturePair pData)
   {
      mData.add(pData);
   }

   /**
    * Get the training data
    *
    * @return The training data
    */
   public Collection<CharacterFeaturePair> getData()
   {
      return mData;
   }
}
