package medium;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Write a function that takes in a Binary Tree and retturns its diameter. The diameter of a binary tree is defined as the length
 * of its liongest path, even if that path doesnt pass through the root of the tree.
 * 
 * A path is a collection of connected nodes in a tree, where no node is connected to more than two other nodes. The length
 * of a pth is the number of edges between the parth's first node and its last node.
 * 
 * Each BinaryTree node has an integer value, a left child node and aright child node. Children nodes can either be BinaryTree nodes themselves 
 * or None / Null.
 * 
 */

import java.util.*;

public class BinaryTreeDiameter {
    public static void main(String[] args) {
        TestBinaryTree input = new TestBinaryTree(1);
        input.insert(new int[] {2, 3, 4, 5, 6, 7}, 0);
        var expected = 4; // answer
        var actual = new BinaryTreeDiameter().binaryTreeDiameter(input);
        System.out.println(expected == actual); // compares returned value with answer; true if equal else false.
    }

    private int res = 0;
    static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
		dfs(tree);
    return res;
  }
	public int dfs(BinaryTree tree) {
		if(tree == null) {
			return 0;
		}
		int left = dfs(tree.left);
		int right = dfs(tree.right);
		res = Math.max(res, left + right);
			
		return 1 + Math.max(left, right);
	}

    static class TestBinaryTree extends BinaryTreeDiameter.BinaryTree {
        public TestBinaryTree(int value) {
          super(value);
        }
    
        public void insert(int[] values, int i) {
          if (i >= values.length) {
            return;
          }
          ArrayDeque<BinaryTreeDiameter.BinaryTree> queue = new ArrayDeque<BinaryTreeDiameter.BinaryTree>();
          queue.addLast(this);
          while (queue.size() > 0) {
            BinaryTreeDiameter.BinaryTree current = queue.pollFirst();
            if (current.left == null) {
              current.left = new BinaryTreeDiameter.BinaryTree(values[i]);
              break;
            }
            queue.addLast(current.left);
            if (current.right == null) {
              current.right = new BinaryTreeDiameter.BinaryTree(values[i]);
              break;
            }
            queue.addLast(current.right);
          }
          insert(values, i + 1);
        }
      }
}
