package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost
 * branch sum to rightmost branch sum
 * 
 * A branch sum is the sum of all values in a Binary Tree Search. A Binary Tree branch is a path of nodes in 
 * a tree that starts at the root node and ends at any leaf node. 
 * 
 * Each BinaryTree node has an integer value, a left child node adn a right child node. Children nodes can either
 * be BinaryTree nodes themselves or None / Null.
 */

import java.util.*;

public class BranchSums {
    public static void main(String[] args) {
        TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        System.out.println(BranchSums.branchSums(tree).equals(expected));
    }
    // Time: O(n) Space: O(n) where n is the number of nodes in the Binary Tree.
    public static class TestBinaryTree extends BranchSums.BinaryTree {
        TestBinaryTree(int value) {
          super(value);
        }
    
        TestBinaryTree insert(List<Integer> values) {
          return insert(values, 0);
        }
    
        TestBinaryTree insert(List<Integer> values, int i) {
          if (i >= values.size()) return null;
    
          List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
          queue.add(this);
          while (queue.size() > 0) {
            TestBinaryTree current = queue.get(0);
            queue.remove(0);
            if (current.left == null) {
              current.left = new TestBinaryTree(values.get(i));
              break;
            }
            queue.add((TestBinaryTree) current.left);
            if (current.right == null) {
              current.right = new TestBinaryTree(values.get(i));
              break;
            }
            queue.add((TestBinaryTree) current.right);
          }
          insert(values, i + 1);
          return this;
        }
      }
    
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    
        BinaryTree(int value) {
          this.value = value;
          this.left = null;
          this.right = null;
        }
      }
    
      public static List<Integer> branchSums(BinaryTree root) {
        ArrayList<Integer> total = new ArrayList<>();
            sums(root, 0, total);
            return total;
            
            
        
      }
        public static void sums(BinaryTree node, int sum, List<Integer> list){
            if(node == null) return;
            
            int newSum = sum + node.value;
            if(node.left == null && node.right == null){
                list.add(newSum);
                return;
            }
            sums(node.left,newSum,list);
            sums(node.right,newSum,list);
        }
}
