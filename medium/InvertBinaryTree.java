package medium;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Write a function that takes a binary tree and inverts it.
 * 
 *  Input:        1
 *              /   \
 *             2     3
 *            / \   / \
 *           4   5 6   7
 *          / \
 *         8   9
 * 
 * 
 * Output:          1
 *                /   \
 *               3     2
 *              / \   / \
 *             7  6  5   4
 *                      / \
 *                     9   8
 */

import java.util.*;

public class InvertBinaryTree {
    public static void main(String[] args) {
    }
    // Time: O(n) Space: O(d) n is the number of nodes and d is the depth.
    public static void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;
            
        swap(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
      }
        
        public static void swap(BinaryTree tree) {
            BinaryTree left = tree.left;
            tree.left = tree.right;
            tree.right = left;
        }
    
      static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
        }
      }
}
