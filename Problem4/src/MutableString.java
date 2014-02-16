/**
 * Mutable strings.  An alternative to string buffers when you want
 * something like a string that you can change.
 *
 * @author Cher
 * @author Ray
 * @author Your Name Here
 */
public class MutableString
{
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the string.
   */
  char contents[];

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty mutable string.
   */
  public MutableString()
  {
    // STUB
  } // MutableString()

  /**
   * Create a mutable string, initialized to str.
   */
  public MutableString(String str)
  {
    // STUB
  } // MutableString(String)

  // +-------------------------+-------------------------------------------
  // | Standard Object Methods |
  // +-------------------------+

  /**
   * Determine if we are the same as another object.
   */
  public boolean equals(Object other)
  {
    return (other instanceof MutableString) && equals((MutableString) other);
  } // equals(Object)

  /**
   * Convert to a string.
   */
  public String toString()
  {
    return "";  // STUB
  } // toString()

  // +-----------+---------------------------------------------------------
  // | Observers |
  // +-----------+

  /**
   * Get the ith character of this string.
   *
   * @pre 0 <= i < this.length()
   */
  public char charAt(int i)
  {
    return ' '; // STUB
  } // charAt(int)

  /**
   * Determine if we are the same as another mutable string.
   */
  public boolean equals(MutableString other)
  {
    return this.toString().equals(other.toString());
  } // equals(MutableString)

  /**
   * Get the length of this mutable string.
   */
  public int length()
  {
    return 0;   // STUB
  } // length()

  // +----------+----------------------------------------------------------
  // | Mutators |
  // +----------+

  /**
   * Append str to the end of the string.
   */
  public void append(String str)
  {
    // STUB
  } // append(String)

  /**
   * Insert str immediately before the ith character of
   * the current string.
   *
   * @pre
   *   0 <= i < this.length()
  /**
   * Prepend str to the beginning of the string.
   */
  public void prepend(String str)
  {
    // STUB
  } // prepend(String)

  /**
   * Remove the characters starting at start and finishing 
   * immediately before end.
   */
  public void remove(int start, int end)
  {
    // STUB
  } // remove(int, int)

  /**
   * Replace all copies of pattern with replacement.
   */
  public void replace(String pattern, String replacement)
  {
    // STUB
  } // replace(String, String)
} // class MutableString
