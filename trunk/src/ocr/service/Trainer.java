package ocr.service;

import java.awt.Image;
import ocr.system.CharacterPrompter;

/**
 * Allows a user to supply knowledge base of feature point-character pairs.
 * 
 * @author Devin
 */
public class Trainer
{
   /**
    * Used to prompt the user for a character with an image
    */
   private CharacterPrompter mPrompter;
   /**
    * Used to set the training data
    */
   private TrainingDataProxy mProxy;
   /**
    * The image to train with
    */
   private Image mTrainingImage;

   /**
    * Constructor for the Trainer with a CharacterPrompter and a training
    * image as parameters.
    * 
    * @param pPrompter The CharacterPrompter to use with the user
    * @param pImage The image to train with
    */
   public Trainer(CharacterPrompter pPrompter, Image pImage)
   {

   }

   /**
    * Use the Preprocessor and FeatureExtractor objects to obtain the array of
    * character images and their respective feature points from the training
    * image. Loop through each character image and prompt the user for a
    * character to identify the image. Store the character with the feature
    * point in the training data.
    *
    * @return The string of characters that have been entered by the user.
    */
   public String train()
   {
      return "Training test";
   }
}
