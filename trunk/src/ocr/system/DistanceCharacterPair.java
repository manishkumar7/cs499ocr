package ocr.system;

/**
 * Stores the relationship between a character and its distance from
 * the feature point of the unknown character.
 * 
 * @author Devin
 */
public class DistanceCharacterPair
{
   /**
    * The character associated with the distance
    */
   private String mCharacter;
   /**
    * The distance from the character to another feature point
    */
   private double mDistance;

   /**
    * Constructor for DistanceCharacterPair
    *
    * @param pCharacter The character
    * @param pDistance The distance
    */
   public DistanceCharacterPair(String pCharacter, double pDistance)
   {
      mCharacter = pCharacter;
      mDistance = pDistance;
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
    * Returns the distance
    *
    * @return The distance
    */
   public double getDistance()
   {
      return mDistance;
   }
}
