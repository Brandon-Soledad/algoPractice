package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth.
 * Write a function that takes in a Binary Tree and returns the sum of its nodes' depths.
 * 
 * Each BinaryTree node has an integer value, a left child node, and a right child node. 
 * Children nodes can either be BinaryTree nodes themselves or None / Null.
 * 
 * Sample Input:
 *                1
 *              /   \
 *             2     3
 *            / \   / \
 *           4   5 6   7
 *          / \
 *         8   9
 * 
 * Answer: 16
 * Nodes with value 2 and 3 has depth 1.
 * Nodes with  values 4, 5, 6, 7 have depth 2.
 * Nodes with values 8 and 9 have depth 3.
 * 1+1+2+2+2+2+3+3 = 16.  
 */

import java.util.*;

public class NodeDepths {
    public static void main(String[] args) {
        var root = new NodeDepths.BinaryTree(1);
        root.left = new NodeDepths.BinaryTree(2);
        root.left.left = new NodeDepths.BinaryTree(4);
        root.left.left.left = new NodeDepths.BinaryTree(8);
        root.left.left.right = new NodeDepths.BinaryTree(9);
        root.left.right = new NodeDepths.BinaryTree(5);
        root.right = new NodeDepths.BinaryTree(3);
        root.right.left = new NodeDepths.BinaryTree(6);
        root.right.right = new NodeDepths.BinaryTree(7);
        int actual = NodeDepths.nodeDepths(root);
        System.out.println(actual); // 16
    }
    // Time: O(n) Space: O(h) where n is the number of nodes in the Binary Tree and h is the height of the tree. (Assuming tree is balanced)
    public static int nodeDepths(BinaryTree root) {
        return helper(root, 0);
        
      }
        public static int helper(BinaryTree node, int depth){
            if(node == null) return 0;
            System.out.println("Tree Depth: " + depth + " Node Value: " + node.value );
            return depth + helper(node.left, depth + 1) + helper(node.right, depth + 1);
            
        }
    
      static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    
        public BinaryTree(int value) {
          this.value = value;
          left = null;
          right = null;
        }
      }
}
