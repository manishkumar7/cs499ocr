package ocr.system;

import java.awt.Image;
import java.util.Comparator;

/**
 * Stores the relationship between an integer and a character image
 *
 * @author Devin
 */
public class IntegerCharacterPair
{
   /**
    * The value associated with the character
    */
   private Integer mValue;
   /**
    * The image of the character
    */
   private Image mCharacter;
   /**
    * The box describing the location of the character in the image
    */
   private BoundingBox mBox;

   /**
    * Constructor for IntegerCharacterPair
    *
    * @param pValue The value associated with the character
    * @param pCharacter The image of the character
    * @param pBox The box describing the location of the character
    */
   public IntegerCharacterPair(Integer pValue, Image pCharacter, BoundingBox pBox)
   {
      mValue = pValue;
      mCharacter = pCharacter;
      mBox = pBox;
   }

   /**
    * Returns the value
    *
    * @return The value associated with the character
    */
   public Integer getValue()
   {
      return mValue;
   }

   /**
    * Returns the character image
    *
    * @return The character image
    */
   public Image getCharacterImage()
   {
      return mCharacter;
   }

   /**
    * Returns the box describing the character location
    *
    * @return The bounding box
    */
   public BoundingBox getBox()
   {
      return mBox;
   }
}

/**
 * This class describes the Comparator for the IntegerCharacterPair.
 * This will enable IntegerCharacterPair objects to be compared
 * to each other.
 *
 * @author Devin
 */
class ValueComparator
   implements Comparator
{
   /**
    * Establishes a comparable relationship between IntegerCharacterPair
    * objects.
    *
    * @param o1 The first object to compare
    * @param o2 The second object to compare
    * @return 1 if o1 is greater than o2,
    *         0 if o1 is equal to o2,
    *        -1 if o1 is less than o2
    */
   public int compare(Object o1, Object o2)
   {
      if (o1 instanceof IntegerCharacterPair &&
         o2 instanceof IntegerCharacterPair)
      {
         IntegerCharacterPair p1 = (IntegerCharacterPair) o1;
         IntegerCharacterPair p2 = (IntegerCharacterPair) o2;

         Integer v1 = p1.getValue();
         Integer v2 = p2.getValue();

         return v1.compareTo(v2);
      }
      return 0;
   }
}
