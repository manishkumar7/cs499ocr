package ocr.service;

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
   ocr.service.PatternRecognizerTest.class, ocr.service.TrainerTest.class, ocr.service.PreprocessorTest.class, ocr.service.TrainingDataProxyTest.class, ocr.service.OpticalCharacterRecognizerTest.class, ocr.service.FeatureExtractorTest.class
})
public class ServiceSuite
{
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
}
