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
  // +-------+-------------------------------------------------------------
  // | Notes |
  // +-------+

/*
  We store strings in arrays of characters.  When we need to expand
  the array, we double the size of the array.  That suggests we never
  use more than twice as much is necessary (well, except when we then
  delete characters), but keeps running time relatively good.
 */

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
    return new String(this.contents, 0, this.size);  // STUB
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

    // Copy the characters.
    for (int i = this.size; i < newsize; i++)
      this.contents[i] = str.charAt(i - this.size);

    // Update the size
    this.size = newsize;
  } // append(String)

  /**
   * Insert str immediately before the ith character of
   * the current string.
   *
   * @pre
   *   0 <= i < this.length()
   */
  public void prepend(int i, String str)
  {
    int len = str.length();
    int newsize = this.size + len;

    // If there's insufficient capacity, make a new array,
    // leaving space for the string to be prepended.
    if (newsize >= this.contents.length)
      {
        char[] oldcontents = this.contents;
        this.contents = new char[computeCapacity(newsize)];
        for (int j = 0; j < i; j++)
          this.contents[j] = oldcontents[j];
        for (int j = i; j < this.size; j++)
          this.contents[j + len] = oldcontents[j];
      } // if there's insufficient space

    // Otherwise, there's sufficient capacity, but we need to
    // make a space in the array.
    else
      {
        for (int j = this.size-1; j >= i; j--)
          this.contents[j + len] = this.contents[j];
      } // else

    // There's space.  Put things in
    for (int j = 0; j < len; j++)
      this.contents[i+j] = str.charAt(j);

    // And that's it
    this.size = newsize;
  } // prepend(String)

  /**
   * Remove the characters starting at start and finishing 
   * immediately before end.
   */
  public void remove(int start, int end)
  {
    int offset = end - start;
    for (int i = end; i < this.size; i++)
      this.contents[i - offset] = this.contents[i];
    this.size -= offset;
  } // remove(int, int)

  /**
   * Replace all copies of pattern with replacement.
   */
  public void replace(String pattern, String replacement)
  {
    // STUB
  } // replace(String, String)
} // class MutableString
