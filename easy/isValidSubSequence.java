package easy;

/**
 * @author Brandon Soledad
 * 
 * Algorithms Practice
 * 
 * Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.
 */

import java.util.*;

public class isValidSubSequence {
    public static void main(String[] arg) {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(1, 6, -1, 10); // True
        var array2 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence2 = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10, 12); // False

        System.out.println(isValidSubsequence(array, sequence));
        System.out.println(isValidSubsequence(array2, sequence2));
    }
    
    // Time: O(n) Space: O(1) where n is the length of the array.
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
		int index1 = 0;
		int index2 = 0;
		while(index1 < array.size() && index2 < sequence.size()) {
			if(array.get(index1).equals(sequence.get(index2))){
				index2++;
			}
			index1++;
		}
    return index2 == sequence.size();
  }
}

