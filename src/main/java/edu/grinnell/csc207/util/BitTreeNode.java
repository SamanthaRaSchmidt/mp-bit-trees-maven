package edu.grinnell.csc207.util;

/**
 * Creates a BitTreeNode that is either a child or a leaf.
 *
 * @author Sam Schmidt
 */
public class BitTreeNode {
 // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value in this node.
   */
  String value;

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new binary tree node with specified value, left subtree,
   * and right subtree.
   */
  public BitTreeNode() {
    this.value = null;
    this.left = new BitTreeNode(null);
    this.right = new BitTreeNode(null);
  } // BitTreeNode(T, BitTreeNode, BitTreeNode)

  /**
   * Create a new leaf (a binary tree node with a value, but no subtrees).
   *
   * @param val
   *   The value to store in the node.
   */
  public BitTreeNode(String val) {
    this.value = val;
  } // BitTreeNode(T)
} // class BitTreeNode

