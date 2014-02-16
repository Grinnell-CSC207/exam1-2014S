import static org.junit.Assert.*;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * A variety of tests of the stringify method.
 * 
 * @author Samuel A. Rebelsky
 */
public class StringifyTest
{
  // +-----------+-------------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The name of the file used for storing temporary output.
   */
  static final String TEMPFILE = "/tmp/stringifytest.txt"; 

  // +-----------+---------------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Read just the first line of a file.  Prints the exception and
   * returns the empty string if I/O fails.  (Printing exceptions is
   * generally not a good idea.  We do it here because it seems useful
   * for testing.)
   */
  static String firstLine(String fname)
  {
    try
      {
        BufferedReader feyes = new BufferedReader(new FileReader(fname));
        String result = feyes.readLine();
        feyes.close();
        return result;
      } // try
    catch (Exception e)
      {
        System.err.println(e);
        return "";
      } // catch (Exception)
  } // firstLine

  /**
   * Check whether stringify produces output identical to that 
   * stored in expected when called on infile.  
   */
  static void checkStringify(String infile, String expected)
      throws Exception
  {
    TextUtils.stringify(infile, TEMPFILE);
    String actual = firstLine(TEMPFILE);
    String expect = firstLine(expected);
    if (! actual.equals(expect)) 
      {
        fail("In converting '" + infile + "' got '" + actual +
             "' and expected '" + expect + "'");
      } // if (! actual.equals(expect))
  } // checkStringify

  // +-------+-------------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A few simple tests.
   */
  @Test
  public void test()
      throws Exception
  {
    checkStringify("examples/in01.txt", "examples/out01.txt");
    checkStringify("examples/in02.txt", "examples/out02.txt");
    checkStringify("examples/in03.txt", "examples/out03.txt");
    checkStringify("examples/in04.txt", "examples/out04.txt");
  } // test()

} // class StringifyTest
