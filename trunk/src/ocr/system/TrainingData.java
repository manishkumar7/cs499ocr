package ocr.system;

import java.io.Serializable;
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
    * Insert a new character-feature pair into the training data
    *
    * @param pData The character-feature pair to store
    */
   public void insert(CharacterFeaturePair pData)
   {

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
