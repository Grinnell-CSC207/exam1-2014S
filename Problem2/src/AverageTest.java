import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

/**
 * A test of the average method.
 */
public class AverageTest
{
  // +---------+-----------------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Run a test on an array, with an expected value, printing an appropriate
   * error message if it fails.
   */
  void checkAverage(long expected, long values[])
  {    
    try
      {
        long result = MathUtils.average(values);
        if (result != expected)
          {
            fail("For average(" + Arrays.toString(values) + ") expected "
                 + expected + " received " + result);
          } // if (result != expected)
      } // try
    catch (Exception e)
      {
        fail("average(" + Arrays.toString(values) 
             + ") threw exception " + e);
      } // catch (Exception)
  } // checkAverage(long, values[])

  // +-------+-------------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A few basic tests.
   */
  @Test
  public void test0()
  {
    checkAverage(0, new long[] { 0 });
  } // test0
} // class AverageTest
