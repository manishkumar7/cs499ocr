package ocr.system;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Provide methods that will be needed in various components of the OCR system.
 * 
 * @author Devin
 */
public class HelperLibrary
{
   public static <T extends Comparable<? super T>> List<T> sortList(
      Collection<T> pList)
   {
      List<T> list = new ArrayList<T>(pList);
      Collections.sort(list);
      return list;
   }
}
