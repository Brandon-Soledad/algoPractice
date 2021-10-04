package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Write a function that takes in a Binary Search Tree (BST) and a target integer value and returns
 * the closest value to that target value contained in the BST.
 * 
 * You can assume that there will only be one closest value.
 * 
 * Each BST node has an integer value, a left child node, and a right child node. A node is said to be
 * a valid BST node if and only if it satisfies the BST property. It's value is strictly greater than 
 * the values of every node to it's left; its value is less than or equal to the values of every node to
 * it's right; and it's children nodes are either valid BST nodes themselves or None / null.
 */

import java.util.*;

public class closestValueInBst {
    public static void main(String[] args) {
        var root = new BST(10);
    root.left = new BST(5);
    root.left.left = new BST(2);
    root.left.left.left = new BST(1);
    root.left.right = new BST(5);
    root.right = new BST(15);
    root.right.left = new BST(13);
    root.right.left.right = new BST(14);
    root.right.right = new BST(22);

    var expected = 13;
    var actual = findClosestValueInBst(root, 12);
    System.out.println("Expected: " + expected + " " + "Actual: " + actual);
    }
    // Average: Time O(logn) | Space O(1) where n is the nodes in the BST
    // Worst: Time O(n) | Space O(1) where n is the nodes in the BST
    public static int findClosestValueInBst(BST tree, int target) {
        BST currentNode = tree;
            int closest = tree.value;
            while(currentNode != null) {
                if(Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                    closest = currentNode.value;
                }
                if(target < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (target > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    break;
                }
            }
        return closest;
      }

      static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
          this.value = value;
        }
      }
}
