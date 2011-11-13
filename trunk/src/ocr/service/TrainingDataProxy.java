package ocr.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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

   public void saveTraingData()
   {
      try
      {
         FileOutputStream fos = new FileOutputStream(TrainingData.cFileName);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(mTrainingBase);
         oos.flush();
         oos.close();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public void deleteTrainingData()
   {
      File file = new File(TrainingData.cFileName);
      file.delete();
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
