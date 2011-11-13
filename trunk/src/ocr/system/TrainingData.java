package ocr.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
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

   public final static String cFileName = "train";

   /**
    * Initialize a TrainingData instance
    */
   static
   {
      TrainingData data = null;
      try
      {
         File file = new File(cFileName);
         if (file.exists())
         {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            data = (TrainingData) ois.readObject();
            ois.close();
         }
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }

      if (data == null)
      {
         cInstance = new TrainingData();
      }
      else
      {
         cInstance = data;
      }
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
