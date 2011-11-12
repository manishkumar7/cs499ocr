package ocr.system;

import java.util.Collection;

/**
 * Stores the relationship between a feature point and a character.
 * 
 * @author Devin
 */
public class CharacterFeaturePair
{
   /**
    * The character(s) associated with the feature point
    */
   private String mCharacter;
   /**
    * The feature point associated with the character
    */
   private Collection<Double> mFeaturePoint;

   /**
    * Constructor for CharacterFeaturePair
    * 
    * @param pCharacter The character
    * @param pFeaturePoint The feature point
    */
   public CharacterFeaturePair(String pCharacter, Collection<Double> pFeaturePoint)
   {
      mCharacter = pCharacter;
      mFeaturePoint = pFeaturePoint;
   }

   /**
    * Returns the character
    *
    * @return The character
    */
   public String getCharacter()
   {
      return mCharacter;
   }

   /**
    * Returns the feature point
    *
    * @return The feature point
    */
   public Collection<Double> getFeaturePoint()
   {
      return mFeaturePoint;
   }
}
