package ocr;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import ocr.system.ImageRetriever;
import ocr.system.TrainingData;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Devin
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
{
   ocr.service.ServiceSuite.class, ocr.desktop.DesktopSuite.class, ocr.system.SystemSuite.class
})
public class OcrSuite
{
   public static final String cBackupFile = "train.bk";

   public static Image cCharImage;
   public static Image cTextImage;
   public static Image cExtractImage;

   static
   {
      File imgFile = new File(".\\test\\res\\char.jpg");
      cCharImage = new ImageRetriever(imgFile).readImage();

      imgFile = new File(".\\test\\res\\text.jpg");
      cTextImage = new ImageRetriever(imgFile).readImage();

      imgFile = new File(".\\test\\res\\extract.jpg");
      cExtractImage = new ImageRetriever(imgFile).readImage();
   }

   @BeforeClass
   public static void setUpClass()
      throws Exception
   {
   }

   @AfterClass
   public static void tearDownClass()
      throws Exception
   {
   }

   @Before
   public void setUp()
      throws Exception
   {
   }

   @After
   public void tearDown()
      throws Exception
   {
   }

   public static void backupTraining()
   {
      File file = new File(TrainingData.cFileName);
      File bck = new File(cBackupFile);
      if (file.exists())
      {
         try
         {
            InputStream in = new FileInputStream(file);
            OutputStream out = new FileOutputStream(bck);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
               out.write(buf, 0, len);
            }
            in.close();
            out.close();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   public static void restoreTraining()
   {
      File file = new File(TrainingData.cFileName);
      File bck = new File(cBackupFile);
      if (bck.exists())
      {
         try
         {
            InputStream in = new FileInputStream(bck);
            OutputStream out = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
               out.write(buf, 0, len);
            }
            in.close();
            out.close();
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
}
