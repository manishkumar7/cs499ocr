package ocr.system;

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
   ocr.system.TrainingDataTest.class, ocr.system.DistanceCharacterPairTest.class, ocr.system.CharacterPrompterTest.class, ocr.system.CharacterFeaturePairTest.class, ocr.system.ImageProcessingLibraryTest.class, ocr.system.BoundingBoxTest.class, ocr.system.PixelHistogramTest.class, ocr.system.NeighborsTest.class, ocr.system.IntegerCharacterPairTest.class, ocr.system.ValueComparatorTest.class, ocr.system.ImageRetrieverTest.class
})
public class SystemSuite
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
