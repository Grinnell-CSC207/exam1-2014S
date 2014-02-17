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

  // +-----------+---------------------------------------------------------
  // | Constants |
  // +-----------+

  /**
   * The default capacity of a mutable string.
   */
  static final int DEFAULT_CAPACITY = 16;

  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the string.  May include extra capacity to make
   * it simpler to expand the string.
   */
  char contents[];

  /**
   * The actual size of the string.
   */
  int size;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create an empty mutable string.
   */
  public MutableString()
  {
    this.contents = new char[DEFAULT_CAPACITY];
    this.size = 0;
  } // MutableString()

  /**
   * Create a mutable string, initialized to str.
   */
  public MutableString(String str)
  {
    this.size = str.length();
    this.contents = new char[computeCapacity(this.size)];
    for (int i = 0; i < size; i++)
      this.contents[i] = str.charAt(i);
  } // MutableString(String)

  // +---------+-----------------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Compute the first reaonable capacity larger than mincap.
   */
  public int computeCapacity(int mincap)
  {
    // Start at either the default or current capacity
    int capacity = DEFAULT_CAPACITY;
    if (this.contents != null)
      capacity = this.contents.length;

    // Keep increasing until we are large enoug
    while (capacity < mincap)
      {
        capacity *= 2;
      } // while
    
    // And we're done
    return capacity;
  } // computeCapacity(int)

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
    return this.contents[i];
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
    return this.size;
  } // length()

  // +----------+----------------------------------------------------------
  // | Mutators |
  // +----------+

  /**
   * Append str to the end of the string.
   */
  public void append(String str)
  {
    int newsize = this.size + str.length();

    // If there's insufficient capacity, make a new array
    if (newsize >= this.contents.length)
      {
        char[] oldcontents = this.contents;
        this.contents = new char[computeCapacity(newsize)];
        for (int i = 0; i < this.size; i++)
          this.contents[i] = oldcontents[i];
      } // if
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
