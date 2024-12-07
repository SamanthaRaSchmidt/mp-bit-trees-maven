package edu.grinnell.csc207.util;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length 
 * sequences of bits and corresponding values.
 *
 * @author Sam Schmidt
 */
public class BitTree {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /*
   * The root of the tree.
   */
  BitTreeNode root;

  /*
   * The amount of levels the tree should have.
   */
  int levels;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Creates a BitTree.
   * 
   * @param n
   *  The number of 
   */
  public BitTree(int n) {
    this.root = null;
    this.levels = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Set the value associated with a key in a subtree rooted at node.  See the
   * top-level get for more details.
   *
   * @param key
   *   The key to set.
   * @param node
   *   The root of the subtree to look through.
   * @param value
   *    The value to set the key to.
   * @return
   *   The corresponding value.
   *
   * @throws IndexOutOfBoundsException
   *   when the key is not in the subtree.
   */
  BitTreeNode set(BitTreeNode node, String bits, String value) throws IndexOutOfBoundsException, Exception {
    BitTreeNode current = node;
    char nextVal;
    for (int i = 0; i < this.levels - 1; i++) {
      nextVal = bits.charAt(i);
      if (nextVal == '0') {
        if (current.left == null) {
          current.left = new BitTreeNode(null);
        } // end if
        current = node.left;
      } else if (nextVal == '1') {
        if (current.right == null) {
          current.right = new BitTreeNode(null);
        } // end if
        current = node.right;
      } else {
        throw new Exception("The bit string contains " + nextVal + " which is not 0 or 1");
      } //end if-block
    } //endfor
    current.value = value;
    return node;
    } // set(BitTreeNode, String, String)

   /**
   * Get the value associated with a key in a subtree rooted at node.  See the
   * top-level get for more details.
   *
   * @param key
   *   The key to search for.
   * @param node
   *   The root of the subtree to look through.
   *
   * @return
   *   The corresponding value.
   *
   * @throws IndexOutOfBoundsException
   *   when the key is not in the subtree.
   */
  String get(String bits, BitTreeNode node) {
    if (bits.length() != this.levels) {
      throw new IndexOutOfBoundsException("Invalid length of bit string");
    } // if
    System.out.println("End val " + node.value);

    char nextVal;
    for (int i = 0; i < this.levels; i++) {
      if (node == null) {
        throw new IndexOutOfBoundsException("No value found here");
      } //endif
      nextVal = bits.charAt(i);
      if (nextVal == 48) {
        node = node.left;
      } else if (nextVal == 49) {
        node = node.right;
      } else {
        throw new IndexOutOfBoundsException("The bit string contains " + nextVal + " which is not 0 or 1");
      } //end if-block
    } //endfor
    return node.value;
  } // get(K, BSTNode<K, V>)

  void dump(BitTreeNode node, PrintWriter pen) {

  } // dump(BitTreeNode, PrintWriter)


  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Traverses the tree based on the bit string, creating new nodes as it goes,
   * and sets the leaf value to the String.
   *
   * @param bits
   *    The string of bits to traverse the tree
   * @param value
   *    The string that will be set in the leaf
   *
   * @throws IndexOutOfBoundsException, Exception
   */
  public void set(String bits, String value) throws IndexOutOfBoundsException, Exception {
    if (bits.length() != this.levels) {
      throw new IndexOutOfBoundsException("Invalid length of bit string");
    } // if
    if(root == null) {
      root = new BitTreeNode(null);
    } //endif
    root = set(root, bits, value);
    return;
  } // set(String, String)

  /**
   * Traverses the bit tree to find the String associated with the bit string.
   *
   * @param bits
   *    The string of bits to traverse the tree with
   *
   * @return the String associated with the bit
   *
   * @throws IndexOutOfBoundsException
   */
  public String get(String bits) throws IndexOutOfBoundsException {
    if (bits.length() != this.levels) {
      throw new IndexOutOfBoundsException();
    } //endif
    return get(bits, root);
  } // get(String, String)

  /**
   *
   */
  public void dump(PrintWriter pen) {
    dump(root, pen);
  } // dump(PrintWriter)

  /**
   *
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTree
