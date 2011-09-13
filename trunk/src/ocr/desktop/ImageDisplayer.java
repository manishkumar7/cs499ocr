package ocr.desktop;

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Displays an Image to the user
 *
 * @author Devin
 */
public class ImageDisplayer
{
   /**
    * Display the image to the user
    *
    * @param pImage The image to display
    */
   public static void displayImage(Image pImage)
   {
      if (pImage != null)
      {
         //Display the image in a label
         JFrame frame = new JFrame();
         JLabel label = new JLabel(new ImageIcon(pImage));

         frame.getContentPane().add(label, BorderLayout.CENTER);
         frame.pack();
         frame.setVisible(true);
      }
      else
      {
         System.err.println("Null image");
      }
   }
}
