package ocr.service;

import java.util.Collection;
import ocr.system.CharacterFeaturePair;
import ocr.system.TrainingData;

/**
 * Store and retrieve the training data on behalf of other system components.
 * 
 * @author Devin
 */
public class TrainingDataProxy
{
   TrainingData mTrainingBase;

   public TrainingDataProxy()
   {
      mTrainingBase = TrainingData.getInstance();
   }
   
   /**
    * Inserts the CharacterFeaturePair into the training data store.
    * 
    * @param pData The character-feature pair to store
    */
   public void insertTrainingData(CharacterFeaturePair pData)
   {
      mTrainingBase.insert(pData);
   }

   /**
    * Retrieves the training data from its storage location.
    *
    * @return The training data
    */
   public Collection<CharacterFeaturePair> getTrainingData()
   {
      return mTrainingBase.getData();
   }
}
