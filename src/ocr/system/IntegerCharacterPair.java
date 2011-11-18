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
   Integer mValue;
   Image mCharacter;
   BoundingBox mBox;

   public IntegerCharacterPair(Integer pValue, Image pCharacter, BoundingBox pBox)
   {
      mValue = pValue;
      mCharacter = pCharacter;
      mBox = pBox;
   }

   public Integer getValue()
   {
      return mValue;
   }

   public Image getCharacterImage()
   {
      return mCharacter;
   }

   public BoundingBox getBox()
   {
      return mBox;
   }
}

class ValueComparator
   implements Comparator
{
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
