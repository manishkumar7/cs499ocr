package ocr.system;

/**
 * Defines an exception to be thrown when in input photo is rejected by
 * the system.
 * 
 * @author Devin
 */
public class InvalidImageException
   extends Exception
{
   /**
    * Constructor for InvalidImageException
    *
    * @param msg The message to show
    */
   public InvalidImageException(String msg)
   {
      super("Image rejected: " + msg);
   }

   /**
    * Constructor for InvalidImageException
    *
    * @param msg The message to show
    * @param t A object thrown with the exception
    */
   public InvalidImageException(String msg, Throwable t)
   {
      super("Image rejected: " + msg, t);
   }
}
